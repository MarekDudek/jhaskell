package jhaskell.data;

import java.util.List;

public class Sum implements Monoid<Sum>
{
    public final Integer sum;

    public Sum(final Integer sum)
    {
        this.sum = sum;
    }

    public static Sum mempty = new Sum(0);

    @Override
    public Sum mempty()
    {
        return mempty;
    }

    @Override
    public Sum mconcat(List<Sum> sums)
    {
        return null;
    }

    @Override
    public Sum mappend(final Sum x, final Sum y)
    {
        return new Sum(x.sum + y.sum);
    }

    @Override
    public Sum sconcat(List<Sum> sums)
    {
        return null;
    }

    @Override
    public Sum stimes(int i, Sum sum)
    {
        return null;
    }

   /* public static Sum mappend(final Sum x, final Sum y)
    {
        return new Sum(x.sum + y.sum);
    }*/
}
