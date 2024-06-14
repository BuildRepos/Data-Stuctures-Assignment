import java.util.ArrayList;

//employ array logic with objects that hold generic data
//do this well so you can be really good for your assignment

/*The heap is generic, so the values the heap is working with need to be as such. The Processes will be created in main
 and passed in here.*/
class GenericHeap<E extends Comparable> {
    //default empty heap0
    ArrayList<E> Core = new ArrayList<E>();
    //heap with Processes. we need now to find out how to get the data inside
    ArrayList<E> active = new ArrayList<E>();

    public void add(E leaf) {
        //while loop bubbles up the larger values and the new values are added to the end of the array(tree)
//change method type back to E if need be
        E newbie = leaf;

        active.add(newbie);
        //starting at the end of the array/heap/tree
        int i = active.size() - 1;
        int pIndex = (i - 1) / 2;

        //i != 0 && active.get(i).compareTo(active.get((Integer) get((int)Leaf.index)))> 0) the while condition in case i need it again
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
                active.set(i, temp); //had a problem with temp being generic
                i = pIndex;
                pIndex = (i - 1) / 2;
                //figure out why this error is being thrown and get that fixed.


            }


        }

    }


    public E removeRoot() {
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
       // E holder = active.get(0);
        //did this so that holder could still be returned after the catch block is executed. handling an array out of bounds exception.


               E holder = active.get(i); //need to resolve the type Comparable error(says that the value being stored is of type Comparable)
                //do I need to return data
                E leaf = active.get(active.size() - 1);
                active.set(active.size() - 1, holder);
                active.set(0, leaf);
                active.remove(active.size() - 1);


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
                    E temp = active.get(i); //casted the process to type E
                    active.set(i, max); // casted to type Process(which i named Gprocess)
                    active.set(maxIndex, temp); //same action here
                    //need to make the variables generic though, because type casting here is putting  band-aid on a bullet wound.
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
        return active.get(0); //type casted the data recieved from the process as type (E)



/*if (active.get(i))
    } else {
        throw new RuntimeException();*/
    }

    public E get(int index) {
        return active.get(index); //typecasted the index recieved from the process as (E)
        // return active.
    }


    public int getSize(E data) {
        return active.size();
    }
//get rid of any leftover typecasting


}





