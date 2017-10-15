package jhaskell.data.list;

import jhaskell.data.Semigroup;

import static jhaskell.data.list.ConsList.cons;
import static jhaskell.data.list.ConsList.nil;
import static jhaskell.data.list.NonEmpty.match;
import static jhaskell.data.list.NonEmpty.multiple;

public enum NonEmptys
{
    ;

    public static <A> Semigroup<NonEmpty<A>> Semigroup()
    {
        return new NonEmptySemigroup<A>();
    }

    private static class NonEmptySemigroup<A> implements Semigroup<NonEmpty<A>>
    {

        @Override
        public NonEmpty<A> mappend(final NonEmpty<A> as, final NonEmpty<A> bs)
        {
            final Semigroup<ConsList<A>> S = ConsLists.Semigroup();
            return match(as,
                    a -> match(bs,
                            b -> multiple(cons(a.single, cons(b.single, nil()))),
                            bm -> multiple(S.mappend(cons(a.single, nil()), bm.multiple))
                    ),
                    am -> match(bs,
                            b -> multiple(S.mappend(am.multiple, cons(b.single, nil()))),
                            bm -> multiple(S.mappend(am.multiple, bm.multiple))
                    )
            );
        }
    }

    public static <A> A head(final NonEmpty<A> as)
    {
        return match(
                as,
                s -> s.single,
                m -> ConsLists.head(m.multiple)
        );
    }

    public static <A> int length(final NonEmpty<A> as)
    {
        if (as instanceof NonEmpty.Single)
            return 1;
        final NonEmpty.Multiple<A> m = (NonEmpty.Multiple<A>) as;
        return ConsLists.length(m.multiple);
    }
}
