package jhaskell.data;

public interface Monoid<A> extends Semigroup<A>
{
    A mempty();
}
