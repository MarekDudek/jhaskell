package jhaskell.data;

public class ProductSemigroup implements Semigroup<Product>
{
    @Override
    public Product mappend(final Product x, final Product y)
    {
        return new Product(x.product * y.product);
    }
}
