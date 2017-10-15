package jhaskell.data.utils;

public class UglyStuff
{
    public static <A> A error()
    {
        throw new RuntimeException("error");
    }

}
