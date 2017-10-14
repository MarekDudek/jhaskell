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
    public boolean equals(final Object that)
    {
        return Objects.equals(this.product, ((Product) that).product);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(product);
    }
}

