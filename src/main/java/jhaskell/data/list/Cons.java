package jhaskell.data.list;

import static com.google.common.base.Preconditions.checkNotNull;

public final class Cons<A> implements ConsList<A>
{

    public final A head;
    public final ConsList<A> tail;

    Cons(A head, ConsList<A> tail)
    {
        this.head = checkNotNull(head);
        this.tail = checkNotNull(tail);
    }

    @Override
    public Nil asNil()
    {
        return null;
    }

    @Override
    public Cons<A> asCons()
    {
        return this;
    }
}
