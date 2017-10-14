package jhaskell.product;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static jhaskell.data.Util.list;
import static jhaskell.data.product.Product.Product;
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
        assertThat(Semigroup.mappend(Product(2), Product(3)), is(Product(6)));
    }

    @Test
    public void empty()
    {
        assertThat(Monoid.mempty(), is(Product(1)));
    }

    @Test
    public void monoid_concatenation()
    {
        assertThat(Monoid.mconcat(list(Product(2), Product(3), Product(4), Product(5))), is(Product(120)));
    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void semigroup_concatenation()
    {
        // then
        assertThat(Semigroup.sconcat(list(Product(2))), is(Product(2)));
        assertThat(Semigroup.sconcat(list(Product(2), Product(2))), is(Product(4)));
        assertThat(Semigroup.sconcat(list(Product(2), Product(2), Product(2))), is(Product(8)));
        assertThat(Semigroup.sconcat(list(Product(2), Product(2), Product(2), Product(2))), is(Product(16)));
        // except
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.sconcat(list()), anything());
    }

    @Test
    public void multiplication_of_replication()
    {
        // then
        assertThat(Semigroup.stimes(0, Product(2)), is(Product(1)));
        assertThat(Semigroup.stimes(1, Product(2)), is(Product(2)));
        assertThat(Semigroup.stimes(2, Product(2)), is(Product(4)));
        assertThat(Semigroup.stimes(3, Product(2)), is(Product(8)));
        assertThat(Semigroup.stimes(4, Product(2)), is(Product(16)));
        // except
        exception.expect(IllegalArgumentException.class);
        assertThat(Semigroup.stimes(-1, Product(2)), anything());
    }
}
