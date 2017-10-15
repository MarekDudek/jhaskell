package jhaskell.data.list;

public interface NonEmpty<A>
{
    static <A> NonEmpty<A> single(A a)
    {
        return new Single<>();
    }

    static <A> NonEmpty<A> multiple(ConsList<A> as)
    {
        return new Multiple<>(as);
    }
}
