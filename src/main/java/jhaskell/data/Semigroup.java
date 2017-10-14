package jhaskell.data;

import java.util.List;

import static java.util.Collections.nCopies;

public interface Semigroup<A>
{
    A mappend(A x, A y);

    A sconcat(List<A> as);

    default A stimes(int n, A a)
    {
        return sconcat(nCopies(n, a));
    }
}
