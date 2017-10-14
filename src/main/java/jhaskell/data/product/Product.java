package jhaskell.data.product;


import com.google.common.base.MoreObjects;

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

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("product", product).toString();
    }
}

