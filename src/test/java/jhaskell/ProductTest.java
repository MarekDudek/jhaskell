package jhaskell;

import jhaskell.data.Product;
import jhaskell.data.ProductInstances;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class ProductTest
{
    @Test
    public void mappending_works()
    {
        // given
        final Product p1 = new Product(2);
        final Product p2 = new Product(3);
        // when
        final Product p3 = ProductInstances.MONOID.mappend(p1, p2);
        // then
        assertThat(p3, is(new Product(6)));
        assertThat(p3.product, is(6));
    }
}
