import jdk.swing.interop.SwingInterOpUtils;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
//need to fix the data and Obj errors.
// should I inherit from GenericHeap or Gprocess
public class Gqueue { //need help with the comparable
    //did not need the data variables either


int queueSize = 0;


//create an entirely new heap
static GenericHeap<Gprocess> active = new GenericHeap<Gprocess>();





    public static void enqueue(Gprocess n) {
      //trying to add the Process to arraylist 'active'
        active.add(n);
    }


    public static Gprocess dequeue() {

        return active.removeRoot();
    }

    public static Gprocess Reset_Priority(Gprocess n) {
        n.PriorityNumber = 0;
        return n;
        //sets the priority of the Process being passed in to 0
    }


    public static long Waiting_Time(Gprocess Process) {
        //every Process object needs to be a Generic E object. i.e. E WaitQ = etc.
          /*  Process WaitQ = new Process(ProcessID, PriorityNumber);//trying to cast PriorityNumber as type E so that i the node will take the parameter
            pCollect.add((E) WaitQ.data);
            WaitQ.ProcessArrivalTime = System.nanoTime();*/

        //did not need the if statement

                long SystemTime = System.nanoTime();
                // Enqueue(WaitQ.ProcessID, WaitQ.PriorityNumber);
                double wait = SystemTime - Process.ProcessArrivalTime;
                return (long) wait;



        //no Enqueue. Calculate Time when process arrives in the queue and when it reaches the CPU.

        //return service time

    }
    static ArrayList<Gprocess> deleted = new ArrayList<Gprocess>();
// deleted was originally holding generic values.
    public static void CPU_Running() {
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
        if (active.get(0) == null) {
            throw new IndexOutOfBoundsException();
        }
        Gprocess Process = dequeue();
        long waitTime = Waiting_Time(Process);
            try {
                Thread.sleep((long) Process.ProcessServiceTime);
            } catch (Exception e) {
                System.out.println("Error");
            }
            Process.ProcessWaitTime = waitTime;

            Process.ProcessTotalTime = Time_In(Process);

            deleted.add(Process);

            /*gets the process in temp, since process
           is inside of node, then gets process service time, which is retrieved from process, and then
           adds it to clock, which will give us the time the CPU was running. Tells us the time after
           servicing that process.*/




    }


    public static long Time_In(Gprocess Process) {
        //seems like there is a keyword error going on with the method name
//same as previous method. can use waiting + service or endtime - service time
        //


        double Total_Time = Process.ProcessWaitTime + Process.ProcessServiceTime;
        return (long)Total_Time;

    }

    public static double Statistician() {
        //getting all information from the 'deleted' arraylist
        double Wavg = 0.0;
        double Savg = 0.0;
        double Tavg = 0.0;

        for (int i = 0; i < deleted.size(); i++) {


            Gprocess work = deleted.get(i); //deleted needs to jhold the deleted processes from active
            System.out.println(""); //print all attributes for the processes in the queue defined in the class. print the table
            //take average of waiting time, service time, and total time. adjust calculations. do averages for each time variable

             Wavg += (Waiting_Time(work));
             Savg += (work.ProcessServiceTime);
             Tavg += (work.ProcessTotalTime);

             Time_In(work);


        }
        return Wavg + Savg + Tavg; //or print the averages, make the method void, and calll is in main

//add everything up for each of the times in the for loop and then take the averages of each time variable after the loop.
       /*make sure you have all of your member variables. completion position(what order was the process completed in? i.e.
       1st, 2nd, 3rd, etc.*/
    }
//this is where you create new processes and add them to the queue



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


    public static void main(String[] args) {
        ArrayList<Gprocess> test = new ArrayList<Gprocess>(); /*make an ArrayList of processes to add new complete processes and schedule
             processes in the for loop for the test. */

        Random source = new Random();
        int PriorityNumber = source.nextInt(0, 51); //create a new random for PriorityNumber every time a process is generated
        int ProcessID = 0; //have this be the counter, and everytime a process is generated increment the value
        Gprocess n = new Gprocess(ProcessID);
try {
    while (ProcessID < 50) {

        for (int i = 0; i < 50; i++) {
            Gprocess run = new Gprocess(ProcessID);
            for (int j = new Random().nextInt(2); j < 50; j++) {
                enqueue(run);
                ProcessID++;
                System.out.println(ProcessID);
                System.out.print("ProcessID" + "\n" + ProcessID + "\t");
                System.out.print( "Arrival Time" + "\n" + "\t" + "\t"  + run.ProcessArrivalTime + "\t");
                System.out.print( "Waiting Time" + "\n" + "\t" + "\t" + "\t"  + run.ProcessWaitTime + "\t");
                System.out.print( "Service Time" + "\n" + "\t" + "\t"  + "\t" + "\t"  + "\t" + run.ProcessServiceTime + "\t");
                System.out.print( "Time in System" + "\n" + "\t" + "\t"  + "\t" + "\t" + "\t" + run.ProcessTotalTime + "\t");
                System.out.print( "Completion Order" + "\n" + "\t" + "\t"  + "\t" + "\t" + "\t"  + "\t" + run.cOrder);
            }
            System.out.println("Process ID");

            //System.out.println(ProcessID);
         //   ProcessID++;

        }


    }
} catch (IndexOutOfBoundsException e) {
    System.out.println("Index out of bounds");
}
}
}
