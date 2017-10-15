package jhaskell.data.list;

import java.util.function.Function;

import static jhaskell.data.list.ConsList.*;

public final class ConsLists
{

    public static <A> boolean empty(final ConsList<A> as)
    {
        return pattern(as,
                c -> false,
                n -> true
        );
    }

    public static <A> int length(final ConsList<A> as)
    {
        return pattern(as,
                c -> 1 + length(c.tail),
                n -> 0
        );
    }

    public static <A> boolean equal(final ConsList<A> xs, final ConsList<A> ys)
    {
        return pattern(xs,
                xc -> pattern(ys,
                        yc -> xc.head.equals(yc.head) && equal(xc.tail, yc.tail),
                        yn -> false
                ),
                xn -> pattern(ys,
                        yc -> false,
                        yn -> true
                )
        );
    }

    public static <A, B> ConsList<B> map(final ConsList<A> as, final Function<A, B> f)
    {
        return pattern(as,
                c -> cons(f.apply(c.head), map(c.tail, f)),
                n -> nil()
        );
    }
}


