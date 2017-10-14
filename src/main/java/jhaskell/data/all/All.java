package jhaskell.data.all;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public final class All
{
    public final Boolean all;

    public static All All(Boolean any)
    {
        return new All(any);
    }

    public All(Boolean all)
    {
        this.all = all;
    }

    @Override
    public boolean equals(Object that)
    {
        return Objects.equals(this.all, ((All) that).all);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(all);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("all", all).toString();
    }
}
