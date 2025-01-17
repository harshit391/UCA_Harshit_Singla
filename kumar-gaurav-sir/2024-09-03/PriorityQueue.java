import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private Integer[] pq;
    private int n; // By default, Java initializes to zero

    PriorityQueue(int capacity) {
        this.pq = new Integer[capacity + 1];
    }

    public void insert(int x) {
        this.pq[++n] = x;
        swim(n);
    }

    public Integer delMax() {
        int maxEle = this.pq[1];
        exch(1, n--);
        sink(1);
        this.pq[n + 1] = null; // Avoid loitering
        return maxEle;
    }

    public boolean isEmpty() {
        return this.n == 0;
    }

    public Integer size() {
        return this.n;
    }

    public Integer maxElement() {
        if (isEmpty()) throw new IllegalStateException("Priority Queue is empty");
        return this.pq[1];
    }

    public List<Integer> traverse() {
        List<Integer> elements = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            elements.add(this.pq[i]);
        }
        return elements;
    }

    private void swim(int k) {
        while (k > 1 && pq[k / 2] < pq[k]) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && this.pq[j] < this.pq[j + 1]) {
                j++;
            }
            if (this.pq[k] >= this.pq[j]) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void exch(int i, int j) {
        int temp = this.pq[i];
        this.pq[i] = this.pq[j];
        this.pq[j] = temp;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);

        pq.insert(5);
        pq.insert(11);
        pq.insert(7);

        assert pq.delMax() == 11;
        assert pq.size() == 2;

        pq.insert(15);
        pq.insert(11);
        pq.insert(19);

        assert pq.delMax() == 19;

        System.out.println("Traverse: " + pq.traverse());
        System.out.println("Max Element: " + pq.maxElement());

        System.out.println("All Test Cases Passed");
    }
}
