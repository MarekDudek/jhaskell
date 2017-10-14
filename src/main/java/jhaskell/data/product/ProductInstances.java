package jhaskell.data.product;

import jhaskell.data.Monoid;
import jhaskell.data.Semigroup;

import java.util.List;
import java.util.stream.IntStream;

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

        @Override
        public Product stimes(int n, Product product)
        {
            return IntStream.rangeClosed(1, n).mapToObj(i -> product).reduce(this::mappend).orElse(product);
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
