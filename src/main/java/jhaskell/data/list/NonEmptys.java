package jhaskell.data.list;

import static jhaskell.data.list.NonEmpty.pattern;

public enum NonEmptys
{
    ;

    public static <A> A head(final NonEmpty<A> as)
    {
        return pattern(
                as,
                s -> null,
                m -> null
        );
    }

    public static <A> int length(final NonEmpty<A> as)
    {
        if (as instanceof Single)
            return 1;
        final Multiple<A> m = (Multiple<A>) as;
        return ConsLists.length(m.multiple);
    }
}
