
import java.util.ArrayList;
import java.util.Collections;

public class PriorityQueueArrayList<E extends Comparable<E>> {

    private ArrayList<E> arrayList = new ArrayList<>();

    /**
     * adds item to the array list then sorts it
     *
     * @param newObject
     */
    public void enqueue(E newObject) {
        // binary insertion algorithm
        if (arrayList.size() == 0) {
            arrayList.add(newObject);

        } else if (arrayList.size() == 1) {
            if (newObject.compareTo(arrayList.get(0)) > 0)
                arrayList.add(newObject);
            else
                arrayList.add(0, newObject);
        } else {
            int l = 0, r = arrayList.size() - 1;
            int m = 0;
            boolean flag = false;
            while (l <= r) {
                m = l + (r - l) / 2;

                if (newObject.compareTo(arrayList.get(m)) == 1) {
                    l = m + 1;
                    flag = true;
                } else if (newObject.compareTo(arrayList.get(m)) == -1) {
                    r = m - 1;
                    flag = false;
                } else {
                    break;
                }


            }
            // if flag is true then it will add the new object to the right side
            if (flag)
                arrayList.add(m + 1, newObject);

            else
                arrayList.add(m, newObject);

        }

    }

    public E dequeue() {
        return arrayList.remove(arrayList.size() - 1);
    }


    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public String toString() {
        String str = "";
        for (E value : arrayList) {
            str = str + value + " ";
        }
        return str;
    }

}
