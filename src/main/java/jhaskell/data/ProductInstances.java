package jhaskell.data;

import java.util.List;

public enum ProductInstances
{

    ;

    public static Semigroup<Product> Semigroup = new ProductSemigroup();

    private static class ProductSemigroup implements Semigroup<Product>
    {

        @Override
        public Product mappend(Product x, Product y)
        {
            return new Product(x.product * y.product);
        }

    }

    public static Monoid<Product> Monoid = new ProductMonoid();

    private static class ProductMonoid extends ProductSemigroup implements Monoid<Product>
    {
        private static Product Empty = new Product(0);

        @Override
        public Product mempty()
        {
            return Empty;
        }

        @Override
        public Product mconcat(List<Product> products)
        {
            return products.stream().reduce(Semigroup::mappend).orElse(Empty);
        }
    }
}
