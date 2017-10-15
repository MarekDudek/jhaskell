package jhaskell.data.list;

import static com.google.common.base.Preconditions.checkNotNull;

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
