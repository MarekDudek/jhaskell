package jhaskell.sum;

import jhaskell.data.Sum;
import org.junit.Test;


public final class SumTest
{
    @Test
    public void test()
    {
        // given
        final Sum s1 = new Sum(2);
        final Sum s2 = new Sum(3);
        // when
        final Sum s3 = s1.mappend(s1, s2);
    }
}
