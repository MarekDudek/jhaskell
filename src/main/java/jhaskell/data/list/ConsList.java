package jhaskell.data.list;

import com.google.common.base.Preconditions;

import static com.google.common.base.Preconditions.checkNotNull;

public interface ConsList<A>
{

    static <A> ConsList<A> nil()
    {
        return Nil.nil();
    }

    static <A> ConsList<A> cons(final A head, final ConsList<A> tail)
    {
        return new Cons<>(head, tail);
    }
}

final class Nil<A> implements ConsList<A>
{
    private static Nil Nil = new Nil();

    @SuppressWarnings("unchecked")
    static <A> Nil<A> nil()
    {
        return (Nil<A>) Nil;
    }
}

final class Cons<A> implements ConsList<A>
{

    public final A head;
    public final ConsList<A> tail;

    Cons(A head, ConsList<A> tail)
    {
        this.head = checkNotNull(head);
        this.tail = checkNotNull(tail);
    }
}