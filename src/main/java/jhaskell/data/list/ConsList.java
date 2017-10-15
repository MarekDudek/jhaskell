package jhaskell.data.list;

public interface ConsList<A>
{

    Nil asNil();

    Cons<A> asCons();

    @SuppressWarnings("unchecked")
    static <A> ConsList<A> nil()
    {
        return (Nil<A>) NIL;
    }

    static <A> ConsList<A> cons(final A head, final ConsList<A> tail)
    {
        return new Cons<>(head, tail);
    }

    Nil NIL = new Nil();
}

