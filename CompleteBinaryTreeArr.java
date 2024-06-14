import java.util.ArrayList;
public class  CompleteBinaryTreeArr <E extends Comparable> {
    //are we using queue implementation?
    //need help with implementing E
    E data;

    ArrayList<E> Ctree = new ArrayList<E>;

    public void push(E data) {
        Ctree.add(data);
    }

    public E pop(int index) {
        Ctree.remove(index);
    }
    public int search(E data) {
         for(int i = 0; i < Ctree.size(); i++ ) {
             if (Ctree.get(i) == data) {
                 return i;
             }
             }
         return -1;

         }
    }


}

/* BST
1st condition each node can't have more than 2 kids
if using array, use the left and right equations. if using linkedList
follow the pointers.
traverse down the tree and starting at the root, if the node is smaller than the parent, go left
if the node is bigger than the parent, go right. go until you find an empty spot and insert the value.
if you remove from the middle, move the proper kid to the proper parent position that is now empty.
Follow the same parent child conditions enumerated in the second condition.

Use a Binary Search algorithm to search the tree. Review this algorithm and how it is implemented with binary trees.
has an efficiency of Log(n).

 */
