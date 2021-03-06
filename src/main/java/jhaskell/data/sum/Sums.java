package jhaskell.data.sum;

import jhaskell.data.Foldable;
import jhaskell.data.Monoid;
import jhaskell.data.Semigroup;

import java.util.function.BiFunction;

import static com.google.common.base.Preconditions.checkArgument;

public enum Sums
{

    ;

    public static Semigroup<Sum> Semigroup = new SumSemigroup();

    public static Monoid<Sum> Monoid = new SumMonoid();

    private static class SumSemigroup implements Semigroup<Sum>
    {
        @Override
        public Sum mappend(Sum x, Sum y)
        {
            return new Sum(x.sum + y.sum);
        }

        @Override
        public Sum stimes(int n, Sum sum)
        {
            checkArgument(n >= 0);
            if (n == 0)
                return Monoid.mempty();
            else {
                Integer s = sum.sum;
                for (int i = 1; i < n; i++)
                    s = s + sum.sum;
                return new Sum(s);
            }
        }

    }

    private static class SumMonoid extends SumSemigroup implements Monoid<Sum>
    {
        private static Sum Empty = new Sum(0);

        @Override
        public Sum mempty()
        {
            return Empty;
        }
    }
}
