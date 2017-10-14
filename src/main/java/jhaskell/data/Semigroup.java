package jhaskell.data;

public interface Semigroup<A>
{
    A mappend(A x, A y);

    A stimes(int i, A a);
}
