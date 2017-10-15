package jhaskell.data.list;

import java.util.function.Function;

public interface ConsList<A>
{

    static <A, B> B pattern
            (
                    final ConsList<A> as,
                    final Function<Nil<A>, B> nil,
                    final Function<Cons<A>, B> cons
            )
    {

        if (as instanceof Nil) {
            final Nil<A> n = (Nil<A>) as;
            return nil.apply(n);
        } else {
            final Cons<A> c = (Cons<A>) as;
            return cons.apply(c);
        }
    }

    @SuppressWarnings("unchecked")
    static <A> ConsList<A> nil()
    {
        return (Nil<A>) NIL;
    }

    Nil NIL = new Nil();

    static <A> ConsList<A> cons(final A head, final ConsList<A> tail)
    {
        return new Cons<>(head, tail);
    }
}

