
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Furkan_Güney {
    /**
     * @since 02.12.2020
     * @param args
     */
    public static void main(String[] args) {
        Random r = new Random();
        int upperBound = 100_000_000;
        int n = 10_000;
        System.out.println("N\t\t\tMyPriorityQueue\t\t\tPriorityQueueArrayList\n---------------------------------------------------------------------");
        double[] relativeMyPriorityQueue = new double[19];
        double[] relativePriorityQueueArrayList = new double[19];
        int counter = 0;

        while (n <= 100_000) {

            int[] values = new int[n];

            // create a heap
            for (int i = 0; i < n; i++) {
                int random = r.nextInt(upperBound);
                values[i] = random;
            }



            MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
            PriorityQueueArrayList<Integer> priorityQueueArrayList = new PriorityQueueArrayList<>();
            // insert elements into the heap

            // checking add/remove times
            long startTime = System.nanoTime();
            for (int i = 0; i < n; i++)
                myPriorityQueue.enqueue(values[i]);


            while (!myPriorityQueue.isEmpty())
                myPriorityQueue.dequeue();

            double myPriorityQueueTime = ((System.nanoTime() - startTime) / Math.pow(10, 9));

            startTime = System.nanoTime();

            for (int i = 0; i < n; i++)
                priorityQueueArrayList.enqueue(values[i]);




            while (!priorityQueueArrayList.isEmpty())
                priorityQueueArrayList.dequeue();

            double priorityArrayListQueueTime = ((System.nanoTime() - startTime) / Math.pow(10, 9));

            startTime = System.nanoTime();
            for (int i = 0; i < n; i++)
                priorityQueue.add(values[i]);

            while (!priorityQueue.isEmpty())
                priorityQueue.poll();


            double priorityQueueTime = ((System.nanoTime() - startTime) / Math.pow(10, 9));
            System.out.println(n + "\t\t" + myPriorityQueueTime + "\t\t\t\t" + priorityArrayListQueueTime);

            relativeMyPriorityQueue[counter] = myPriorityQueueTime / priorityQueueTime;
            relativePriorityQueueArrayList[counter] = priorityArrayListQueueTime / priorityQueueTime;


            n += 5_000;
            counter++;

        }
        // printing results
        System.out.println("-------------------------------------------------");

        System.out.println(Arrays.toString(relativeMyPriorityQueue));
        System.out.println(Arrays.toString(relativePriorityQueueArrayList));

    }
}
