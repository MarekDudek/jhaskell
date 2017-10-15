package jhaskell.data.list;

import static jhaskell.data.list.NonEmpty.pattern;

public enum NonEmptys
{
    ;

    public static <A> A head(final NonEmpty<A> as)
    {
        return pattern(
                as,
                s -> s.single,
                m -> ConsLists.head(m.multiple)
        );
    }

    public static <A> int length(final NonEmpty<A> as)
    {
        if (as instanceof NonEmpty.Single)
            return 1;
        final NonEmpty.Multiple<A> m = (NonEmpty.Multiple<A>) as;
        return ConsLists.length(m.multiple);
    }
}
