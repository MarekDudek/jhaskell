package jhaskell.sum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jhaskell.data.Util.list;
import static jhaskell.data.sum.Sum.Sum;
import static jhaskell.data.sum.SumInstances.Monoid;
import static jhaskell.data.sum.SumInstances.Semigroup;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public final class SumTest
{

    @Test
    public void appending()
    {
        assertThat(Semigroup.mappend(Sum(2), Sum(3)), is(Sum(5)));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void semigroup_concatenation()
    {
        // then
        assertThat(Semigroup.sconcat(list(Sum(2))), is(Sum(2)));
        assertThat(Semigroup.sconcat(list(Sum(2), Sum(2))), is(Sum(4)));
        assertThat(Semigroup.sconcat(list(Sum(2), Sum(2), Sum(2))), is(Sum(6)));
        assertThat(Semigroup.sconcat(list(Sum(2), Sum(2), Sum(2), Sum(2))), is(Sum(8)));
        // except
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.sconcat(list()), anything());
    }

    @Test
    public void multiplication_of_replication()
    {
        // then
        assertThat(Semigroup.stimes(0, Sum(2)), is(Sum(0)));
        assertThat(Semigroup.stimes(1, Sum(2)), is(Sum(2)));
        assertThat(Semigroup.stimes(2, Sum(2)), is(Sum(4)));
        assertThat(Semigroup.stimes(3, Sum(2)), is(Sum(6)));
        assertThat(Semigroup.stimes(4, Sum(2)), is(Sum(8)));
        // except
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.stimes(-1, Sum(2)), anything());
    }

    @Test
    public void empty()
    {
        assertThat(Monoid.mempty(), is(Sum(0)));
    }


    @Test
    public void concatenation()
    {
        assertThat(Monoid.mconcat(list(Sum(1), Sum(2), Sum(3), Sum(4), Sum(5))), is(Sum(15)));
    }
}
