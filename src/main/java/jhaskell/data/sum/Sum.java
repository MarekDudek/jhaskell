package jhaskell.data.sum;


import com.google.common.base.MoreObjects;

import java.util.Objects;

public final class Sum
{
    public final Integer sum;

    public static Sum Sum(Integer sum)
    {
        return new Sum(sum);
    }

    public Sum(Integer sum)
    {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object that)
    {
        return Objects.equals(this.sum, ((Sum) that).sum);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(sum);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("product", sum).toString();
    }
}

