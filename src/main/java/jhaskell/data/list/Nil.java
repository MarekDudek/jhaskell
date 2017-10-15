package jhaskell.data.list;

public final class Nil<A> implements ConsList<A>
{

    @Override
    public Nil asNil()
    {
        return this;
    }

    @Override
    public Cons<A> asCons()
    {
        return null;
    }
}
