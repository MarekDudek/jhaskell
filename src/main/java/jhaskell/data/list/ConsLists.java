package jhaskell.data.list;

import java.util.function.Function;

import static jhaskell.data.list.ConsList.cons;
import static jhaskell.data.list.ConsList.nil;

public final class ConsLists
{

    public static <A> A head(final ConsList<A> as)
    {
        if (empty(as))
            return null;
        final Cons<A> c = (Cons<A>) as;
        return c.head;
    }

    public static <A> ConsList<A> tail(final ConsList<A> as)
    {
        if (empty(as))
            return null;
        final Cons<A> c = (Cons<A>) as;
        return c.tail;
    }

    public static <A> boolean empty(final ConsList<A> as)
    {
        return as instanceof Nil;
    }

    public static <A> int length(final ConsList<A> as)
    {
        return pattern(as,
                c -> 1 + length(c.tail),
                n -> 0
        );
    }

    private static <A, B> B pattern(final ConsList<A> as, final Function<Cons<A>, B> cons, final Function<Nil<A>, B> nil)
    {
        if (empty(as)) {
            final Nil<A> n = (Nil<A>) as;
            return nil.apply(n);
        } else {
            final Cons<A> c = (Cons<A>) as;
            return cons.apply(c);
        }
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
        if (empty(as))
            return nil();
        final Cons<A> c = (Cons<A>) as;
        final B h = f.apply(c.head);
        final ConsList<B> t = map(c.tail, f);
        return cons(h, t);
    }
}


