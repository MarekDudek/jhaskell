package jhaskell.data.list;

import java.util.function.Function;

import static jhaskell.data.list.ConsList.*;
import static jhaskell.data.utils.UglyStuff.error;

public final class ConsLists
{

    public static <A> A head(final ConsList<A> as)
    {
        return pattern(as,
                nil -> error("head empty"),
                cons -> cons.head
        );
    }

    public static <A> boolean empty(final ConsList<A> as)
    {
        return pattern(as,
                n -> true, c -> false
        );
    }

    public static <A> int length(final ConsList<A> as)
    {
        return pattern(as,
                n -> 0, c -> 1 + length(c.tail)
        );
    }

    public static <A> boolean equal(final ConsList<A> a, final ConsList<A> b)
    {
        return pattern(a,
                anil -> pattern(b,
                        bnil -> true,
                        bcons -> false
                ),
                acons -> pattern(b,
                        bnil -> false,
                        bcons -> acons.head.equals(bcons.head) && equal(acons.tail, bcons.tail)
                )
        );
    }

    public static <A, B> ConsList<B> map(final ConsList<A> as, final Function<A, B> f)
    {
        return pattern(as,
                n -> nil(), c -> cons(f.apply(c.head), map(c.tail, f))
        );
    }
}


