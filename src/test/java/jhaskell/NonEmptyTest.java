package jhaskell;

import jhaskell.data.list.ConsList;
import jhaskell.data.list.ConsLists;
import jhaskell.data.list.NonEmpty;
import jhaskell.data.list.NonEmptys;
import org.junit.Test;

import static jhaskell.data.list.ConsList.cons;
import static jhaskell.data.list.ConsList.nil;
import static jhaskell.data.list.NonEmpty.*;
import static jhaskell.data.list.NonEmptys.length;
import static jhaskell.data.utils.UglyStuff.error;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class NonEmptyTest
{
    @Test
    public void constructing_single()
    {
        assertThat(length(single("a")), is(1));
    }

    @Test
    public void constructing_multiple()
    {
        // given
        final ConsList<String> c1 = cons("A", nil());
        final ConsList<String> c2 = cons("B", c1);
        final ConsList<String> c3 = cons("C", c2);
        // when
        final NonEmpty<String> one = multiple(c1);
        final NonEmpty<String> two = multiple(c2);
        final NonEmpty<String> three = multiple(c3);
        // then
        assertThat(length(one), is(1));
        assertThat(length(two), is(2));
        assertThat(length(three), is(3));
    }

    @Test
    public void pattern_matching_on_single()
    {
        // given
        final NonEmpty<String> a = single("a");
        // when
        final Integer length = pattern(
                a,
                s -> 1,
                m -> error()
        );
        // then
        assertThat(length, is(1));
    }

    @Test
    public void pattern_matching_on_multiple()
    {
        // given
        final NonEmpty<String> a = multiple(cons("a", cons("b", cons("c", nil()))));
        // when
        final Integer length = pattern(
                a,
                s -> error(),
                m -> ConsLists.length(m.multiple)
        );
        // then
        assertThat(length, is(3));
    }

    @Test
    public void head_of()
    {
        // given
        final NonEmpty<String> a = multiple(cons("a", cons("b", cons("c", nil()))));
        // when
        final String head = NonEmptys.head(a);
        // then
        assertThat(head, is("a"));
    }
}
