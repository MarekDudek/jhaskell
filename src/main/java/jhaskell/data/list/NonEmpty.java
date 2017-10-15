package jhaskell.data.list;

import java.util.function.Function;

public interface NonEmpty<A>
{
    static <A, B> B pattern
            (
                    final NonEmpty<A> as,
                    final Function<Single<A>, B> single,
                    final Function<Multiple<A>, B> multiple
            )
    {
        if (as instanceof Single) {
            final Single<A> s = (Single<A>) as;
            return single.apply(s);
        } else {
            final Multiple<A> m = (Multiple<A>) as;
            return multiple.apply(m);
        }
    }

    static <A> NonEmpty<A> single(A a)
    {
        return new Single<>();
    }

    static <A> NonEmpty<A> multiple(ConsList<A> as)
    {
        return new Multiple<>(as);
    }
}
