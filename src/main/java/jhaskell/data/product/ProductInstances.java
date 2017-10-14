package jhaskell.data.product;

import jhaskell.data.Monoid;
import jhaskell.data.Semigroup;

import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

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
        public Product sconcat(final List<Product> products)
        {
            return products.stream().reduce(Semigroup::mappend).orElseThrow(IllegalArgumentException::new);
        }

        @Override
        public Product stimes(int n, Product product)
        {
            checkArgument(n >= 0);
            if (n == 0)
                return Monoid.mempty();
            else {
                Integer p = product.product;
                for (int i = 1; i < n; i++)
                    p = p * product.product;
                return new Product(p);
            }
        }
    }

    public static Monoid<Product> Monoid = new ProductMonoid();

    private static class ProductMonoid extends ProductSemigroup implements Monoid<Product>
    {
        private static Product Empty = new Product(1);

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
