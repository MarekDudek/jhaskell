package jhaskell.data;


import java.util.Objects;

public final class Product
{
    public final Integer product;

    public Product(Integer product)
    {
        this.product = product;
    }

    @Override
    public boolean equals(Object that)
    {
        return Objects.equals(this.product, ((Product) that).product);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(product);
    }
}

