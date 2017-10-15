package jhaskell;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jhaskell.data.all.All.All;
import static jhaskell.data.all.Alls.Monoid;
import static jhaskell.data.all.Alls.Semigroup;
import static jhaskell.data.utils.Util.consList;
import static jhaskell.data.utils.Util.list;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class AllTest
{
    @Test
    public void appending()
    {
        assertThat(Semigroup.mappend(All(true), All(false)), is(All(false)));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void semigroup_concatenation()
    {
        assertThat(Semigroup.sconcat(list(All(true))), is(All(true)));
        assertThat(Semigroup.sconcat(list(All(true), All(false))), is(All(false)));
        assertThat(Semigroup.sconcat(list(All(true), All(true), All(true))), is(All(true)));
        assertThat(Semigroup.sconcat(list(All(false), All(false), All(true), All(false))), is(All(false)));
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.sconcat(list()), anything());
    }


    @Test
    public void multiplication()
    {
        assertThat(Semigroup.stimes(0, All(false)), is(All(true)));
        assertThat(Semigroup.stimes(1, All(true)), is(All(true)));
        assertThat(Semigroup.stimes(2, All(false)), is(All(false)));
        assertThat(Semigroup.stimes(3, All(true)), is(All(true)));
    }

    @Test
    public void empty()
    {
        assertThat(Monoid.mempty(), is(All(true)));
    }

    @Test
    public void concatenation()
    {
        assertThat(Monoid.mconcat(consList(All(false), All(false), All(true), All(false))), is(All(false)));
    }
}
