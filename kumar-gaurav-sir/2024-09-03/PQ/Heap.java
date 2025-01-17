package PQ;

import java.util.Comparator;

public class Heap<T> {

    private T[] pq;
    private int n;
    private Comparator<T> comparator;

    // Constructor with comparator
    @SuppressWarnings("unchecked")
    public Heap(int capacity, Comparator<T> comparator) {
        pq = (T[]) new Object[capacity + 1];
        this.comparator = comparator;
    }

    private void swap(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(T val) {
        pq[++n] = val;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && compare(pq[k / 2], pq[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    public T peek() {
        if (isEmpty()) return null;
        return pq[1];
    }

    public T poll() {
        if (isEmpty()) return null;

        T res = pq[1];
        swap(1, n--);

        sink(1);

        pq[n + 1] = null; // Prevent loitering
        return res;
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;

            if (j < n && compare(pq[j], pq[j + 1]) < 0) j++;

            if (compare(pq[k], pq[j]) >= 0) break;

            swap(k, j);
            k = j;
        }
    }

    // Helper method to compare two elements
    private int compare(T a, T b) {
        return comparator.compare(a, b);
    }

    public static void main(String[] args) {
        // Max-Heap Example
        Heap<Integer> maxHeap = new Heap<>(10, (a, b) -> {
            return a - b;
        });
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(3);
        maxHeap.insert(4);

        System.out.println("Max-Heap:");
        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }

        // Min-Heap Example
        Heap<Integer> minHeap = new Heap<>(10,(a, b) -> {
            return b - a;
        });
        minHeap.insert(3);
        minHeap.insert(10);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(3);
        minHeap.insert(4);

        System.out.println("Min-Heap:");
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
