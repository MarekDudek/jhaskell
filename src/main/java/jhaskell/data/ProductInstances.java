package jhaskell.data;

public enum ProductInstances implements Monoid<Product>
{

    MONOID {
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
    }
}
