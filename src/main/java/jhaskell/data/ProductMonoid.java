package jhaskell.data;

public class ProductMonoid extends ProductSemigroup implements Monoid<Product>
{
    @Override
    public Product mempty()
    {
        return new Product(0);
    }
}
