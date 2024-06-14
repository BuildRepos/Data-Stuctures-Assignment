import java.util.ArrayList;

//employ array logic with objects that hold generic data
//do this well so you can be really good for your assignment
class Obj<E extends Comparable> implements Comparable {
    E data;
    Obj<E> root;
    E data1;
    E data2;


    public Obj(E data) {
        this.root = root;
        this.data1 = data1;
        this.data2 = data2;

    }

    @Override
    public int compareTo(Object o) {
        return this.data.compareTo(((Obj) o).data);
    }


}

class Heap<E extends Comparable<E>> {
    //default empty heap
    ArrayList<E> Core = new ArrayList<E>();
    //heap with E objects since we're more concerned with the data inside the nodes rather than the nodes themselves.
    ArrayList<E> active = new ArrayList<>();

    public void add(E data) {
        //while loop bubbles up the larger values and the new values are added to the end of the array(tree)
//change method type back to E if need be
        E newbie = data;

        active.add(newbie);
        //starting at the end of the array/heap/tree
        int i = active.size() - 1;
        int pIndex = (i - 1) / 2;

        while (i != 0 && active.get(i).compareTo(active.get(pIndex)) > 0) {
            //if the heap is traversing backwards, it would be i > active.size() - 1(i think) and it would be i--.
            /*check to see if the space in the array is empty. If so,
            add the node to that position, if not, handle the exception and tell the user
            that spot is filled.*/
            //program the upward reheapification.
            //this is where the math starts
            //update pIndex every time you swap
            //update the indices for each swap. check to see if it needs to be swapped

            if (active.get(i).compareTo(active.get(pIndex)) > 0) {
                //newbie swaps places with pIndex
                E temp = active.get(pIndex);
                active.set(pIndex, active.get(i));
                active.set(i, temp);
                i = pIndex;
                pIndex = (i - 1) / 2;
                //figure out why this error is being thrown and get that fixed.


            }


        }

    }


    public E removeRoot(E data) {
        //program the downward reheapification.
        //trying to make the getSize method.
        //throw exception if the tree is empty.
        /*take the first element, swap with last, remove it, and then bubble(swap values) down the smaller values until there are no more swaps(values are equal
        and where they should be) or there are no more children.*/

        //Steps
        //take the value of the root
        //swap the root with the last child(last item in your array). Save the root so you can return it
        //remove the last item(after root)
        //starting at 0, swap the new root down(downwards reheapification) and keep swapping until you cannot swap anymore or until out of range(throw exception)
        //root value is the largest in the tree. swaps new root downward according to the properties if a heap and everything will be good.
        int i = 0;
        int cLIndex = (2 * i) + 1;
        int cRIndex = (2 * i) + 2;

        //this is the swap from the root to the leaf so the root can get removed. the root gets cut off once the swap is complete
        //reheapification is done so that the tree can go back to being a heap once the root is removed.
        E holder = active.get(i);
        E leaf = active.get(active.size() - 1);
        active.set(active.size() - 1, holder);
        active.set(0, leaf);
        active.remove(active.size() - 1);
      /*  E leaf = active.get(active.size() - 1);
        holder = leaf;
        leaf = active.get(i);*/



        while (i < active.size()) {
            E max = active.get(i); //root is at index 0, then it starts shifting to the left
            int maxIndex = i;
            /*function of max: keeps track of the largest element we've come across so far. If an element is bigger
            we swap max to be the bigger element. If nor, it stays as is.
             */

            if (cLIndex < active.size() && max.compareTo(active.get(cLIndex)) < 0) {
                //if left index is in range
                max = active.get(cLIndex);
                maxIndex = cLIndex;


            }


            if (cRIndex < active.size() && max.compareTo(active.get(cRIndex)) < 0) {
                max = active.get(cRIndex);
                maxIndex = cRIndex;

            }

            if (i == maxIndex) {
                break;
            } //prevents infinite loop. we need to stop if the root index is equal to the max child(no swaps need to happen)
            //how to swap
            E temp = active.get(i);
            active.set(i, max);
            active.set(maxIndex, temp);
            //set parent index( the parent index is i) to max child index.
            i = maxIndex;
            cLIndex = (2 * i) + 1;
            cRIndex = (2 * i) + 2;

        }
        return holder;
    }


    //get method not completely necessary, but you for sure need the peek
    //call add and remove methods instead of enqueue and dequeue
    public E peek() {
        return active.get(0);



/*if (active.get(i))
    } else {
        throw new RuntimeException();*/
    }

    public E get(int index) {
       return active.get(index);
        // return active.
    }


    public int getSize(E data) {
        return active.size();
    }
}

public class PracticeHeap {


}

//