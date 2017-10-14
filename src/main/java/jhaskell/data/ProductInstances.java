package jhaskell.data;

public enum ProductInstances
{


    ;

    public static Semigroup<Product> SEMIGROUP =
            (x, y) ->
                    new Product(x.product * y.product);

    public static Monoid<Product> MONOID = new Monoid<Product>()
    {
        @Override
        public Product mempty()
        {
            return new Product(0);
        }

        @Override
        public Product mappend(final Product x, final Product y)
        {
            return SEMIGROUP.mappend(x, y);
        }
    };
}
