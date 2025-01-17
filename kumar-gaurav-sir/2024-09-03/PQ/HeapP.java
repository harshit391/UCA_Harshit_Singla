package PQ;

import java.util.Comparator;

public class HeapP<T> {

    private T[] pq;
    private int n;
    private Comparator<T> comp;

    @SuppressWarnings("unchecked")
    HeapP(int capacity)
    {
        this(capacity, (Comparator<T>) Comparator.naturalOrder());
    }

    @SuppressWarnings("unchecked")
    HeapP(int capacity, Comparator<T> comp)
    {
        pq = (T[]) new Object[capacity + 1];
        this.comp = comp;
    }

    private void swap(int i, int j)
    {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean isEmpty()
    {
        return this.n == 0;
    }

    public void offer(T val)
    {
        pq[++n] = val;
        swim(n);
    }

    private void swim(int k)
    {
        while (k > 1 && comp.compare(pq[k / 2], pq[k]) < 0) {
            swap(k, k / 2);
            k /= 2;
        }
    }

    public T peek()
    {
        return this.pq[1];
    }

    public T poll()
    {
        T res = this.pq[1];

        swap(1, n--);

        sink(1);

        return res;
    }

    private void sink(int k)
    {
        while (2 * k <= n)
        {
            int j = 2 * k;

            while (j < n && comp.compare(pq[j], pq[j + 1]) < 0) j++;

            if (comp.compare(pq[k], pq[j]) >= 0)  break;

            swap(k, j);
            k = j;
        }
    }

    public static void main(String[] args)
    {
        HeapP<Integer> heap = new HeapP(10);

        heap.offer(1);
        heap.offer(4);
        heap.offer(2);
        heap.offer(9);
        heap.offer(10);
        heap.offer(0);

        while (!heap.isEmpty())
        {
            System.out.println(heap.peek());
            heap.poll();
        }

        System.out.println();

        heap = new HeapP<Integer>(10, (a, b) -> {
            return b - a;
        });

        heap.offer(1);
        heap.offer(4);
        heap.offer(2);
        heap.offer(9);
        heap.offer(10);
        heap.offer(0);

        while (!heap.isEmpty())
        {
            System.out.println(heap.peek());
            heap.poll();
        }

        System.out.println();

        HeapP<Character> heap2 = new HeapP<>(10, Character::compare);

        heap2.offer('1');
        heap2.offer('3');
        heap2.offer('2');
        heap2.offer('9');
        heap2.offer('8');
        heap2.offer('0');

        while (!heap2.isEmpty())
        {
            System.out.println(heap2.peek());
            heap2.poll();
        }
    }
}
