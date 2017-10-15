package jhaskell.data.tree;

import java.util.function.Function;

import static com.google.common.base.Preconditions.checkNotNull;
import static jhaskell.data.utils.UglyStuff.error;

public interface Tree<A>
{
    final class Empty<A> implements Tree<A>
    {
    }

    final class Leaf<A> implements Tree<A>
    {
        final A leaf;

        Leaf(A a)
        {
            leaf = checkNotNull(a);
        }
    }

    final class Node<A> implements Tree<A>
    {
        private final Tree<A> left;
        private final A node;
        private final Tree<A> right;

        Node(Tree<A> left, A node, Tree<A> right)
        {
            this.left = checkNotNull(left);
            this.node = checkNotNull(node);
            this.right = checkNotNull(right);
        }
    }

    static <A> Tree<A> empty()
    {
        return new Empty<>();
    }

    static <A> Tree<A> leaf(A a)
    {
        return new Leaf<>(a);
    }

    static <A> Tree<A> node(Tree<A> left, A node, Tree<A> right)
    {
        return new Node<>(left, node, right);
    }

    static <A, B> B match
            (
                    final Tree<A> tree,
                    final Function<Empty<A>, B> empty,
                    final Function<Leaf<A>, B> leaf,
                    final Function<Node<A>, B> node
            )
    {
        checkNotNull(tree);
        if (tree instanceof Empty) {
            checkNotNull(empty);
            final Empty<A> t = (Empty<A>) tree;
            return empty.apply(t);
        }
        if (tree instanceof Leaf) {
            checkNotNull(leaf);
            final Leaf<A> t = (Leaf<A>) tree;
            return leaf.apply(t);
        }
        if (tree instanceof Node) {
            checkNotNull(node);
            final Node<A> t = (Node<A>) tree;
            return node.apply(t);
        } else
            return error();
    }
}


