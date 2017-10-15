package jhaskell.data.list;

public enum NonEmptys
{
    ;

    public static <A> int length(final NonEmpty<A> as)
    {
        if (as instanceof Single)
            return 1;
        final Multiple<A> m = (Multiple<A>) as;
        return ConsLists.length(m.multiple);
    }
}
