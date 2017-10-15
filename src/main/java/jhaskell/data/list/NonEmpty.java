package jhaskell.data.list;

import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static jhaskell.data.utils.UglyStuff.error;

public interface NonEmpty<A>
{
    final class Single<A> implements NonEmpty<A>
    {
        public final A single;

        Single(A a)
        {
            single = a;
        }
    }


    final class Multiple<A> implements NonEmpty<A>
    {
        public final ConsList<A> multiple;

        Multiple(ConsList<A> as)
        {
            multiple = checkNotNull(as);
        }
    }

    static <A> NonEmpty<A> single(final A a)
    {
        return new Single<>(a);
    }

    static <A> NonEmpty<A> multiple(final ConsList<A> as)
    {
        return new Multiple<>(as);
    }

    static <A, B> B match
            (
                    final NonEmpty<A> as,
                    final Function<Single<A>, B> single,
                    final Function<Multiple<A>, B> multiple
            )
    {
        checkNotNull(as);
        if (as instanceof Single) {
            checkNotNull(single);
            final Single<A> s = (Single<A>) as;
            return single.apply(s);
        } else if (as instanceof Multiple) {
            checkNotNull(multiple);
            final Multiple<A> m = (Multiple<A>) as;
            return multiple.apply(m);
        } else
            return error();
    }
}


