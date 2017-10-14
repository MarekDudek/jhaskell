package jhaskell.data;

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
    public Sum mappend(final Sum x, final Sum y)
    {
        return new Sum(x.sum + y.sum);
    }

   /* public static Sum mappend(final Sum x, final Sum y)
    {
        return new Sum(x.sum + y.sum);
    }*/
}
