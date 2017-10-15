package jhaskell.data.list;

import jhaskell.data.Semigroup;

import static jhaskell.data.list.ConsList.cons;
import static jhaskell.data.list.ConsList.nil;
import static jhaskell.data.list.ConsLists.append;
import static jhaskell.data.list.NonEmpty.multiple;
import static jhaskell.data.list.NonEmpty.match;

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
            return match(as,
                    sa -> match(bs,
                            sb -> multiple(cons(sa.single, cons(sb.single, nil()))),
                            mb -> multiple(append(cons(sa.single, nil()), mb.multiple))
                    ),
                    ma -> match(bs,
                            sb -> multiple(append(ma.multiple, cons(sb.single, nil()))),
                            mb -> multiple(append(ma.multiple, mb.multiple))
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
