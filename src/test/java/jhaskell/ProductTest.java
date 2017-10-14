package jhaskell;

import jhaskell.data.product.Product;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static jhaskell.data.product.ProductInstances.Monoid;
import static jhaskell.data.product.ProductInstances.Semigroup;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class ProductTest
{

    @Test
    public void appending()
    {
        // given
        final Product p1 = new Product(2);
        final Product p2 = new Product(3);
        // when
        final Product p3 = Semigroup.mappend(p1, p2);
        // then
        assertThat(p3, is(new Product(6)));
    }

    @Test
    public void empty()
    {
        // when
        final Product p = Monoid.mempty();
        // then
        assertThat(p, is(new Product(1)));
    }

    @Test
    public void concatenation()
    {
        // when
        final Product p = Monoid.mconcat(asList(new Product(2), new Product(3), new Product(4), new Product(5)));
        // then
        assertThat(p, is(new Product(120)));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void semigroup_concatenation_works()
    {
        // given
        final Product two = new Product(2);
        // then
        assertThat(Semigroup.sconcat(singletonList(two)), is(new Product(2)));
        assertThat(Semigroup.sconcat(asList(two, two)), is(new Product(4)));
        assertThat(Semigroup.sconcat(asList(two, two, two)), is(new Product(8)));
        assertThat(Semigroup.sconcat(asList(two, two, two, two)), is(new Product(16)));
        // except
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.sconcat(emptyList()), anything());
    }

    @Test
    public void multiplication_of_replication()
    {
        // then
        assertThat(Semigroup.stimes(0, new Product(2)), is(new Product(1)));
        assertThat(Semigroup.stimes(1, new Product(2)), is(new Product(2)));
        assertThat(Semigroup.stimes(2, new Product(2)), is(new Product(4)));
        assertThat(Semigroup.stimes(3, new Product(2)), is(new Product(8)));
        assertThat(Semigroup.stimes(4, new Product(2)), is(new Product(16)));
        // except
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.stimes(-1, new Product(2)), anything());
    }
}
