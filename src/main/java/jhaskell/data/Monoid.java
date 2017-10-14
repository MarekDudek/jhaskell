package jhaskell.data;

import java.util.List;

public interface Monoid<A> extends Semigroup<A>
{
    A mempty();

    A mconcat(List<A> as);
}
