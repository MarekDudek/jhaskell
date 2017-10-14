package jhaskell.list;

import jhaskell.data.list.ConsList;
import jhaskell.data.list.ConsLists;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public final class ConsListTest
{
    @Test
    public void lengths()
    {
        // given
        final ConsList<Integer> nil = ConsList.nil();
        final ConsList<Integer> three = ConsList.cons(3, nil);
        final ConsList<Integer> two = ConsList.cons(2, three);
        final ConsList<Integer> one = ConsList.cons(1, two);
        // then
        assertThat(ConsLists.length(nil), is(0));
        assertThat(ConsLists.length(three), is(1));
        assertThat(ConsLists.length(two), is(2));
        assertThat(ConsLists.length(one), is(3));
    }
}
