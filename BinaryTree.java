//This was a complete Binary Tree. Every method probably is recursive. This will become a Binary Search Tre
class Node <E extends Comparable> {
        //data attribute, Left link and Right link, and Link to their 1 parent since each parent has 2 child nodes.
    E data;
    Node<E> Llink;
    Node<E> Rlink;
    Node<E> ParentLink;

    public Node(E data) {
            Llink = null;
            Rlink = null;
            ParentLink = null;
            this.data = data;

    }


        }


public class BinaryTree <E extends Comparable> {
        //root is what would normally be head
        //root is null until you add your first item
        //check if the left side is empty, then the right side
        //repeat for each level of the tree
        Node<E> root = null;
        public void push(E data) {

                if (root == null) {
                        Node<E> current = new Node<E>(data);
                        root = current;
                } else {
                        Node<E> current = root;
                        //root now has a value
                        while (current == null) {

                                if (current.Llink == null)
                                //check if the left node is empty
                                current.Llink = new Node<E>(data);

                        }
                }
        }

}
