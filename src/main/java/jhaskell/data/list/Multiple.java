package jhaskell.data.list;

public final class Multiple<A> implements NonEmpty<A>
{
    public final ConsList<A> multiple;

    public Multiple(ConsList<A> multiple)
    {
        this.multiple = multiple;
    }
}
