package jhaskell.data.list;

public interface ConsList<A>
{
    static <A> ConsList<A> nil()
    {
        return Nil.nill();
    }

    static <A> ConsList<A> cons(A head, ConsList<A> tail)
    {
        return new Cons<>(head, tail);
    }

}

class Nil<A> implements ConsList<A>
{
    private static Nil Nil = new Nil();

    @SuppressWarnings("unchecked")
    static <A> Nil<A> nill()
    {
        return (Nil<A>) Nil;
    }
}

class Cons<A> implements ConsList<A>
{

    public final A head;
    public final ConsList<A> tail;

    Cons(A head, ConsList<A> tail)
    {
        this.head = head;
        this.tail = tail;
    }
}
