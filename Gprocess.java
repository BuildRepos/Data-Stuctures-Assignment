public class Gprocess implements Comparable {// dont need to be generic.


        int ProcessID;
        int PriorityNumber;
        double ProcessArrivalTime;
        double ProcessServiceTime;

        double ProcessWaitTime;

        double ProcessTotalTime;


        private int queueSize;
        int cOrder;

//Do i even need to create another class here to implement the heap?

        public Gprocess(int ProcessID) {
          /*  this.root = root;
            this.data1 = data1;
            this.data2 = data2;*/

            this.ProcessID = ProcessID;
           //bothe of the below attributes are random numbers
            this.ProcessServiceTime = ProcessServiceTime;

            this.PriorityNumber = PriorityNumber;



        }

        @Override
        public int compareTo(Object o) {
             return this.PriorityNumber - ((Gprocess)o).PriorityNumber;

        }


    }

