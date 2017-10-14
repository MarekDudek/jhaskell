package jhaskell.data.list;

public final class ConsLists
{
    public static <A> int length(final ConsList<A> as)
    {
        if (as instanceof Nil)
            return 0;

        final Cons<A> cons = (Cons<A>) as;
        return 1 + length(cons.tail);
    }
}
