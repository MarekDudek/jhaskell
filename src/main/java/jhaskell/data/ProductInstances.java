package jhaskell.data;

public enum ProductInstances
{

    ;

    public static Semigroup<Product> Semigroup = new ProductSemigroup();

    private static class ProductSemigroup implements Semigroup<Product>
    {

        @Override
        public Product mappend(final Product x, final Product y)
        {
            return new Product(x.product * y.product);
        }

    }

    public static Monoid<Product> Monoid = new ProductMonoid();

    private static class ProductMonoid extends ProductSemigroup implements Monoid<Product>
    {

        @Override
        public Product mempty()
        {
            return new Product(0);
        }

    }
}
