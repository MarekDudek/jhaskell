package jhaskell;

import jhaskell.data.tree.Tree;
import org.junit.Test;

import static jhaskell.data.tree.Tree.*;
import static jhaskell.data.utils.UglyStuff.error;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class TreeTest
{
    @Test
    public void test()
    {
        // given
        final Tree<Integer> e = empty();
        final Tree<Integer> l = leaf(123);
        final Tree<Integer> n = node(e, 456, e);
        // when
        final Integer m1 = match(e,
                empty -> 1,
                leaf -> error(),
                node -> error()
        );
        // then
        assertThat(m1, is(1));
        // when
        final Integer m2 = match(l,
                empty -> error(),
                leaf -> 2,
                node -> error()
        );
        // then
        assertThat(m2, is(2));
        // when
        final Integer m3 = match(n,
                empty -> error(),
                leaf -> error(),
                node -> 3
        );
        // then
        assertThat(m3, is(3));
    }

    @Test
    public void pattern_matching()
    {
    }
}
