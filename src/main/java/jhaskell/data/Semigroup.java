package jhaskell.data;

import java.util.List;

import static java.util.Collections.nCopies;

public interface Semigroup<A>
{
    A mappend(A x, A y);

    default A sconcat(List<A> as)
    {
        return as.stream().reduce(this::mappend).orElseThrow(IllegalArgumentException::new);
    }

    default A stimes(int n, A a)
    {
        return sconcat(nCopies(n, a));
    }
}
