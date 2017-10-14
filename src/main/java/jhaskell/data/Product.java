package jhaskell.data;


import java.util.Objects;

public final class Product
{
    public final Integer product;

    public Product(final Integer product)
    {
        this.product = product;
    }

    @Override
    public boolean equals(Object o)
    {
        return Objects.equals(this.product, ((Product)o).product);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(product);
    }

    public static Monoid<Product> PRODUCT = new Monoid<Product>()
    {
        @Override
        public Product mempty()
        {
            return new Product(0);
        }

        @Override
        public Product mappend(final Product x, final Product y)
        {
            return new Product(x.product * y.product);
        }
    };
}
