package jhaskell.data.any;

import com.google.common.base.MoreObjects;

import java.util.Objects;

public final class Any
{
    public final Boolean any;

    public static Any Any(Boolean any)
    {
        return new Any(any);
    }

    public Any(Boolean any)
    {
        this.any = any;
    }

    @Override
    public boolean equals(Object that)
    {
        return Objects.equals(this.any, ((Any) that).any);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(any);
    }

    @Override
    public String toString()
    {
        return MoreObjects.toStringHelper(this).add("any", any).toString();
    }
}
