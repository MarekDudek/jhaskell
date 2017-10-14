package jhaskell.data.any;

import jhaskell.data.Monoid;
import jhaskell.data.Semigroup;

import static com.google.common.base.Preconditions.checkArgument;

public enum Anys
{
    ;

    public static Semigroup<Any> Semigroup = new AnySemigroup();

    private static class AnySemigroup implements Semigroup<Any>
    {

        @Override
        public Any mappend(Any x, Any y)
        {
            return new Any(x.any || y.any);
        }

        @Override
        public Any stimes(int n, Any any)
        {
            checkArgument(n >= 0);
            if (n == 0)
                return Monoid.mempty();
            else {
                boolean a = any.any;
                for (int i = 1; i < n; i++)
                    a = a || any.any;
                return new Any(a);
            }
        }
    }

    public static Monoid<Any> Monoid = new AnyMonoid();

    private static class AnyMonoid extends AnySemigroup implements Monoid<Any>
    {

        private static final Any Empty = new Any(false);

        @Override
        public Any mempty()
        {
            return Empty;
        }
    }
}
