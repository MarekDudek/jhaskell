package jhaskell;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jhaskell.data.any.Any.Any;
import static jhaskell.data.any.Anys.Monoid;
import static jhaskell.data.any.Anys.Semigroup;
import static jhaskell.data.utils.Util.list;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class AnyTest
{
    @Test
    public void appending()
    {
        assertThat(Semigroup.mappend(Any(true), Any(false)), is(Any(true)));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void semigroup_concatenation()
    {
        assertThat(Semigroup.sconcat(list(Any(true))), is(Any(true)));
        assertThat(Semigroup.sconcat(list(Any(true), Any(false))), is(Any(true)));
        assertThat(Semigroup.sconcat(list(Any(false), Any(false), Any(false))), is(Any(false)));
        assertThat(Semigroup.sconcat(list(Any(false), Any(false), Any(true), Any(false))), is(Any(true)));
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.sconcat(list()), anything());
    }


    @Test
    public void multiplication()
    {
        assertThat(Semigroup.stimes(0, Any(true)), is(Any(false)));
        assertThat(Semigroup.stimes(1, Any(true)), is(Any(true)));
        assertThat(Semigroup.stimes(2, Any(false)), is(Any(false)));
        assertThat(Semigroup.stimes(3, Any(true)), is(Any(true)));
    }

    @Test
    public void empty()
    {
        assertThat(Monoid.mempty(), is(Any(false)));
    }

    @Test
    public void concatenation()
    {
        assertThat(Monoid.mconcat(list(Any(false), Any(false), Any(true), Any(false))), is(Any(true)));
    }
}
