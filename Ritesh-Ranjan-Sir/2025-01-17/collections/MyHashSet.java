package collections;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements Iterable<E>
{
    private LinkedList<E>[] buckets;
    private int bucketCount;
    private int size = 0;
    private float loadFactor;

    public MyHashSet(int bucketCount, float loadFactor)
    {
        this.bucketCount = bucketCount;
        this.buckets = new LinkedList[bucketCount];
        this.loadFactor = loadFactor;
    }

    public MyHashSet()
    {
        this(8, 0.75f);
    }

    public void insert(E element)
    {
        int hashCode = getBucketNumber(element);
        buckets[hashCode].add(element);
        size++;

        if (buckets[hashCode].contains(element))
        {
            return;
        }

        if (buckets[hashCode].size() > size * loadFactor)
        {
            bucketCount *= 2;
            rebuild();
        }
    }

    public boolean search(E e)
    {
        int hashCode = getBucketNumber(e);
        return buckets[hashCode].contains(e);
    }

    public void delete(E e)
    {
        int hashCode = getBucketNumber(e);

        buckets[hashCode].remove(e);

        if (buckets[hashCode].size() < size / loadFactor)
        {
            bucketCount /= 2;
            rebuild();
        }
    }

    public void rebuild()
    {
        Iterator<E> ite = this.iterator();

        LinkedList<E>[] temp = new LinkedList[bucketCount];

        while (ite.hasNext())
        {
            E element = ite.next();
            int bucketNumber = getBucketNumber(element);
            temp[bucketNumber].add(element);
        }

        this.buckets = temp;
    }

    private int getBucketNumber(E e)
    {
        return e.hashCode() % bucketCount;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new Iterator<E>()
        {
            Iterator<E> ite = null;
            int index = 0;

            @Override
            public boolean hasNext()
            {
                if (ite == null)
                {
                    if (size == 0) return false;
                    this.ite = buckets[index].iterator();
                    return true;
                }

                if (ite.hasNext()) return true;
                index++;
                if (index > bucketCount) return false;

                ite = buckets[index].iterator();
                return true;
            }

            @Override
            public E next()
            {
                return ite.next();
            }
        };
    }
}
