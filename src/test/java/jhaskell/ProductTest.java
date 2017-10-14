package jhaskell;

import jhaskell.data.Product;
import org.junit.Test;

import static jhaskell.data.ProductInstances.Monoid;
import static jhaskell.data.ProductInstances.Semigroup;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class ProductTest
{

    @Test
    public void mappending_works_2()
    {
        // given
        final Product p1 = new Product(2);
        final Product p2 = new Product(3);
        // when
        final Product p3 = Semigroup.mappend(p1, p2);
        // then
        assertThat(p3, is(new Product(6)));
        assertThat(p3.product, is(6));
    }

    @Test
    public void empty_value_works_2()
    {
        // when
        final Product p = Monoid.mempty();
        // then
        assertThat(p, is(new Product(0)));
        assertThat(p.product, is(0));
    }

}
