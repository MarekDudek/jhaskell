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
        if (empty(as))
            return 0;
        final Cons<A> c = (Cons<A>) as;
        return 1 + length(c.tail);
    }

    public static <A> boolean equal(final ConsList<A> xs, final ConsList<A> ys)
    {
        if (empty(xs) && empty(ys))
            return true;
        if ((empty(xs) && !empty(ys)) || (!empty(xs) && empty(ys)))
            return false;
        final Cons<A> cx = (Cons<A>) xs;
        final Cons<A> cy = (Cons<A>) ys;
        return cx.head.equals(cy.head) && equal(cx.tail, cy.tail);
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


