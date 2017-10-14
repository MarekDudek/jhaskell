package jhaskell.data;

import java.util.List;

public interface Monoid<A> extends Semigroup<A>
{
    A mempty();

    default A mconcat(List<A> as)
    {
        return as.stream().reduce(this::mappend).orElse(mempty());
    }
}
