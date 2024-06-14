import java.util.LinkedList;
import java.util.*;
import java.util.Random;

class Node<E> {
    Node<E> link; //link to other nodes
    Node<E> next; /*link to next node. created
        so that added.next would work in enqeue method*/
    int priority; //priority of the node
    E data; //data inside each node

    int index;

    Node(E data, int priority) {

        this.data = data;
        this.priority = priority;
        this.link = null;
    }


}


class Process<E> {
    /*named Homework2 temporarily since that is the name of the file.
    will rename later
     */
//possibly abstract class
//attributes
    int ProcessID;
    int PriorityNumber;
    double ProcessArrivalTime;
    double ProcessServiceTime;

    double ProcessWaitTime;

    double ProcessTotalTime;


    private int queueSize;
    int index;
    E data;

    public Process(int ProcessID, int PriorityNumber) {
        this.ProcessID = ProcessID;
        this.PriorityNumber = PriorityNumber;
        this.ProcessArrivalTime = ProcessArrivalTime;
        this.ProcessServiceTime = ProcessServiceTime;
        this.queueSize = queueSize;
        this.index = index;

    }

    public void run() {

    }

    //Node<E> head;
//Node<E> tail;
    Node<E> next;


     class GenericQueue<E extends Process> implements Runnable {

        @Override
        public void run() {

        }

        int ProcessID;
        int PriorityNumber;
        double ProcessArrivalTime;
        double ProcessServiceTime;
        private int queueSize;
        int index;

        //Node<E> head;
//Node<E> tail;
        Node<E> next;

        LinkedList<E> pCollect = new LinkedList<E>();
        LinkedList<E> Process = new LinkedList<E>();
        // for adding a process to a priority queue data structure


        public void enqueue(E data, int PriorityNumber) {
            //void becuase it doesn't need to return the node being enqueued
// .getFirst() retrieved the data for you.
            if (pCollect.size() == 0) {
                pCollect.addFirst(data);
                return;
            }
            //comparing processes inside the nodes. data is the process. process is stored inside nodes of the built-in LinkedList.
            if (data.PriorityNumber > pCollect.getFirst().PriorityNumber) {

                //  Node<E> temp = new Node<E>(data, PriorityNumber);   //create new node
                pCollect.addFirst(data);
                return;
            }

            //   Node<E> current = new Node<E>(data, PriorityNumber)
            //    pCollect.addFirst(current.data);/* trying to and wondering if I should
            //   create a new node for this part of the enqueue method*/
            int index = 0;
            //need to get the tail index
            //do I need the current node
            int n = pCollect.size();
            while (pCollect.get(index).PriorityNumber >= PriorityNumber) {
                //current = current.link;
                index++;

                if (index > pCollect.size()) {
                    break;
                    //comparing priority. Where to insert based on priority
                    //shifting current to next node
                }

            }
            if (index > pCollect.size()) {
                pCollect.addLast(data);
            } else {
                pCollect.add(index, data);
            }
            // do I even need this?

        }


        public E dequeue() {
            //method type E because it needs to return whatever data could be inside the deleted process
            //adjust parameters to OS specifications. What parameters need to be passed in for this process to work with processes in an Operating System?
            //just removing the process
            if (pCollect.size() == 0) {
                return null;

            } else {
                //  Node<E> temp = head; //holding head while we try to remove it
                //head = head.link; //head is now second node
                return pCollect.removeFirst();
            }
        }

        public E Reset_Priority(int ProcessID, int PriorityNumber) {
            //will make the method type E if necessary

        /* don't use index to find processID. Make sure ProcessID's match for the nodes or indexes.



       // Node<E> temp = head;
        /* find the processID of the process being passed in and then set it
        as the specified priority that is passed in. change the process's
        priority being passed in. It is pretty much a setter method. Check the email for
        more details.*/
            int index = 0;
            if (pCollect.getFirst() == null) {
                throw new RuntimeException();
            }
            //Need to take the process out, change the priority, and then put it back in using Enqueue method!!!!!


            //Using ProcessID to find the index of the process
           /* if (pCollect.indexOf(Process) < 0) {
                throw new RuntimeException();
            }*/
           // Process target = new Process(ProcessID, PriorityNumber);

            for (int i = 0; i < pCollect.size(); i++) {


                //make sure process ids match

            /*choose 1 of the 3 variables to pass into this method to add
            the new process as you  get to testing*/
                if (ProcessID == pCollect.get(i).ProcessID) {

                   // target.PriorityNumber = 0;
                   E removedProcess =  pCollect.remove(i);
                   removedProcess.PriorityNumber = PriorityNumber;
                   enqueue(removedProcess, PriorityNumber);
                   break;

                    //check to make sure the index found is the index passed in
                } else {
                   // System.out.print("The Process is not in the Queue!");
                }

            }
            return null;
        }

        public long Waiting_Time(E Process) {
            //every Process object needs to be a Generic E object. i.e. E WaitQ = etc.
          /*  Process WaitQ = new Process(ProcessID, PriorityNumber);//trying to cast PriorityNumber as type E so that i the node will take the parameter
            pCollect.add((E) WaitQ.data);
            WaitQ.ProcessArrivalTime = System.nanoTime();*/

            for (int i = 0; i < pCollect.size(); i++) {
                if (Process.ProcessID == pCollect.get(i).ProcessID) {
                    long SystemTime = System.nanoTime();
                    // Enqueue(WaitQ.ProcessID, WaitQ.PriorityNumber);
                    double wait = SystemTime - Process.ProcessArrivalTime;
                    return (long) wait;
                }
            }

            //no Enqueue. Calculate Time when process arrives in the queue and when it reaches the CPU.

            //return service time
                return -1;
        }
            LinkedList<E> deleted = new LinkedList<E>();
        public void CPU_Running() {
            //make it return void if needed.
            //are you using the system clock or clock variable to keep time? pick one. then use dequeue method!!!!!!
            //if using system clock, use thread.sleep.!!!!
            //otherwise, add service and keep it pushing.!!!!!

        /*if (head == null) {
            return null;
        } else {
            NodeQ<E> temp = head; //holding head while we try to remove it
            head = head.link; //head is now second node

            if (head == null) {
                tail = null;
            }*/

           // long clock = System.currentTimeMillis(); //tracks current time(e.g. it is now 2:40 p.m.)
            //keep all units the same
           E Process = dequeue();
            long waitTime = Waiting_Time(Process);

            try {
                Thread.sleep((long) Process.ProcessServiceTime);
            } catch(Exception e) {
                System.out.println("Error");
            }
            Process.ProcessWaitTime = waitTime;

            Process.ProcessTotalTime =   Time_In(Process);

            deleted.add(Process);

            /*gets the process in temp, since process
           is inside of node, then gets process service time, which is retrieved from process, and then
           adds it to clock, which will give us the time the CPU was running. Tells us the time after
           servicing that process.*/




        }


        public long Time_In(E Process) {
            //seems like there is a keyword error going on with the method name
//same as previous method. can use waiting + service or endtime - service time
            //


            double Total_Time = Process.ProcessWaitTime + Process.ProcessServiceTime;
            return (long)Total_Time;

        }

   public double Statistician(E Process) {
       double Wavg = 0.0;
       double Savg = 0.0;
       double Tavg = 0.0;
       double svg = 0.0;
       double avg = 0;
       for (int i = 0; i < deleted.size(); i++) {


           Process work = deleted.get(i);
           System.out.println(""); //print all attributes for the processes in the queue defined in the class. print the table
           //take average of waiting time, service time, and total time. adjust calculations. do averages for each time variable

           avg = (Waiting_Time((E) work));

       }
//add everything up for each of the times in the for loop and then take the averages of each time variable after the loop.
       /*make sure you have all of your member variables. completion position(what order was the process completed in? i.e.
       1st, 2nd, 3rd, etc.*/
       return (long) avg;
   }


    }

//should I make these same priority queue fields in my node class

    //commented out so that the main class in Gqueue can run

  /*  public static void main(String[] args) {
        LinkedList<Thread> test = new LinkedList<Thread>(); /*make a linked list of processes to add new complete and schedule
             processes in the for loop for the test. */
/*
        Random source = new Random();
        int PriorityNumber = source.nextInt(0, 51); //create a new random for PriorityNumber every time a process is generated
        int ProcessID = 0; //have this be the counter, and everytime a process is generated increment the value

        Process fresh = new Process(PriorityNumber, ProcessID);
        while(ProcessID < 50) {

                Gprocess run = new Gprocess(ProcessID);
                ProcessID++;
            }
        }*/
//randomly generate 50 processes to add that get inserted randomly and the CPU is supposed to process them

        /* typically happens in a while loop with a for loop to create processes and add them to the queue.
        every iteration of the while loop needs to keep the CPU running(use CPU_Running method) */
        /*for loop for generating processes f is good f, but you need to store them in the queue. add randomization so that different batches of processes
        get added to the queue. Add physical pauses in between processes being enqueued. CPU has to be constantly running until all
        the processes are processed.
        Keep looping until there are no more processes to process and the CPU has no more processes left
        to run. System time for every process is different. Uses. java.rand to generate multiple processes.
        Use your methods to perform the required functions in testing.
         */


    }



/* Create the process, put it in the queue, the cpu pops it off
and services(processes) it, repeat until no more processes
your cpu should always be running. it is either idle and not processing anything, or working
to services new processes. once your out of processes, print out the statistics and show
the averages. this is an iterative process. test cpu running first and all other methods first so
you know they are correct, and then focus on randomizing the way the processes are entered. randomizing iterations.

 */

//DOUBLE CHECK LOGIC ERRORS!!!!!!!!