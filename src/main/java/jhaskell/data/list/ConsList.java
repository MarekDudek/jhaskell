package jhaskell.data.list;

import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static jhaskell.data.utils.UglyStuff.error;

public interface ConsList<A>
{

    final class Nil<A> implements ConsList<A>
    {
    }

    final class Cons<A> implements ConsList<A>
    {
        final A head;
        final ConsList<A> tail;

        Cons(A head, ConsList<A> tail)
        {
            this.head = checkNotNull(head);
            this.tail = checkNotNull(tail);
        }
    }

    static <A> ConsList<A> nil()
    {
        return new Nil<>();
    }

    static <A> ConsList<A> cons(final A head, final ConsList<A> tail)
    {
        return new Cons<>(head, tail);
    }

    static <A, B> B pattern
            (
                    final ConsList<A> as,
                    final Function<Nil<A>, B> nil,
                    final Function<Cons<A>, B> cons
            )
    {
        checkNotNull(as);
        if (as instanceof Nil) {
            checkNotNull(nil);
            final Nil<A> n = (Nil<A>) as;
            return nil.apply(n);
        } else if (as instanceof Cons) {
            checkNotNull(cons);
            final Cons<A> c = (Cons<A>) as;
            return cons.apply(c);
        } else
            return error();
    }
}
