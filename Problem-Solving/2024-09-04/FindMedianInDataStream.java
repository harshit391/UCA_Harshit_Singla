import java.util.*;


public class FindMedianInDataStream
{
	private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
	private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	public void add(int val)
	{
		if (maxHeap.size() == 0)
		{
			maxHeap.add(val);
		}
		else if (maxHeap.size() > minHeap.size())
		{
			if (val < maxHeap.peek())
			{
				minHeap.add(maxHeap.poll());
				minHeap.add(val);	
			}	
			else
			{
				minHeap.add(val);
			}
		}
		else if (maxHeap.size() < minHeap.size())
		{
			if (val > minHeap.peek())
			{
				maxHeap.add(minHeap.poll());
				minHeap.add(val);
			}
			else
			{
				maxHeap.add(val);
			}
		}
		else if (val < maxHeap.peek())
		{
			maxHeap.add(val);
		}
		else
		{
			minHeap.add(val);
		}
	}

	public double getMedian()
	{
		if (maxHeap.size() > minHeap.size())
		{
			return maxHeap.peek();
		}
		else if (maxHeap.size() < minHeap.size())
		{
			return minHeap.peek();
		}
		
		return maxHeap.size() == 0 ? 0 : (maxHeap.peek() + minHeap.peek()) / 2.0;
	}

	public static void main(String[] args)
	{
		FindMedianInDataStream stream = new FindMedianInDataStream();

		stream.add(1);
		stream.add(2);

		assert(stream.getMedian() == 1.5);

		stream.add(3);

		assert(stream.getMedian() == 2.0);

		System.out.println("All test Cases Passed");
	}
}
