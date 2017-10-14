package jhaskell.data.all;

import jhaskell.data.Monoid;
import jhaskell.data.Semigroup;

import static com.google.common.base.Preconditions.checkArgument;

public enum Alls
{
    ;

    public static Semigroup<All> Semigroup = new AllSemigroup();

    private static class AllSemigroup implements Semigroup<All>
    {

        @Override
        public All mappend(All x, All y)
        {
            return new All(x.all && y.all);
        }

        @Override
        public All stimes(int n, All All)
        {
            checkArgument(n >= 0);
            if (n == 0)
                return Monoid.mempty();
            else {
                boolean a = All.all;
                for (int i = 1; i < n; i++)
                    a = a || All.all;
                return new All(a);
            }
        }
    }

    public static Monoid<All> Monoid = new AllMonoid();

    private static class AllMonoid extends AllSemigroup implements Monoid<All>
    {

        private static final All Empty = new All(true);

        @Override
        public All mempty()
        {
            return Empty;
        }
    }
}
