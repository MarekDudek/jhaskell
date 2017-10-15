package jhaskell.data;

import jhaskell.data.list.ConsList;

import static jhaskell.data.list.ConsList.pattern;

public interface Monoid<A> extends Semigroup<A>
{
    A mempty();

    default A mconcat(ConsList<A> as)
    {
        return pattern(as,
                nil -> mempty(),
                cons -> mappend(cons.head, mconcat(cons.tail))
        );
    }
}
