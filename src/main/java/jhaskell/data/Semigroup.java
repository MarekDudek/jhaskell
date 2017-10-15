package jhaskell.data;

import jhaskell.data.list.NonEmpty;

import java.util.List;

import static java.util.Collections.nCopies;
import static jhaskell.data.list.NonEmpty.match;

public interface Semigroup<A>
{
    A mappend(A x, A y);

    default A sconcat(List<A> as)
    {
        /*NonEmpty<A> bs = null;
        A a = match(bs,
                b -> b.single,
                bm -> {

                    return null;
                });*/
        return as.stream().reduce(this::mappend).orElseThrow(IllegalArgumentException::new);
    }

    default A stimes(int n, A a)
    {
        return sconcat(nCopies(n, a));
    }
}
