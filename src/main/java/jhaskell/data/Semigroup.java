package jhaskell.data;

import jhaskell.data.list.ConsList;
import jhaskell.data.list.ConsLists;
import jhaskell.data.list.NonEmpty;
import jhaskell.data.list.NonEmptys;

import java.util.List;

import static java.util.Collections.nCopies;
import static jhaskell.data.list.ConsList.nil;
import static jhaskell.data.list.NonEmpty.match;
import static jhaskell.data.utils.UglyStuff.error;

public interface Semigroup<A>
{
    A mappend(A x, A y);

    default A sconcat(List<A> as)
    {
        /*final Semigroup<NonEmpty<A>> S = NonEmptys.Semigroup();
        final Semigroup<ConsList<A>> S2 = ConsLists.Semigroup();
        final Monoid<ConsList<A>> M2 = ConsLists.Monoid();

        NonEmpty<A> bs = null;
        A a = match(bs,
                b -> b.single,
                bm -> {
                    ConsList.match(bm.multiple,
                            nil -> error(),
                            cons -> {
                                final ConsList<A> cst = bm.multiple;
                                final ConsList<ConsList<A>> as1 = ConsList.cons(cst, nil());
                                return M2.mconcat(as1);
                            }
                    );
                    return null;
                });*/
        return as.stream().reduce(this::mappend).orElseThrow(IllegalArgumentException::new);
    }

    default A stimes(int n, A a)
    {
        return sconcat(nCopies(n, a));
    }
}
