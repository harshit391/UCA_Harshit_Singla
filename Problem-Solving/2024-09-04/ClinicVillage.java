import java.util.*;

public class ClinicVillage
{
	public static float solve(int n, int m, int[] population)
	{
		PriorityQueue<Node> maxHeap = new PriorityQueue<>();

		for (int i = 0; i < n; i++)
		{
			maxHeap.add(new Node(population[i], i));
		}

		m -= n;

		while (m > 0)
		{
			Node currHighest = maxHeap.poll();

			System.out.println("Going to Open a Clinic in Village " + currHighest.getVillageId() + " Having Load " + currHighest.getLoad());

			currHighest.openAClinic();

			System.out.println("Updated Load :- " + currHighest.getLoad());

			System.out.println("------------------------------");

			maxHeap.add(currHighest);

			m--;
		}

		return maxHeap.poll().getLoad();
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();

		int[] population = new int[n];

		for (int i = 0; i < n; i++)
		{
			population[i] = scan.nextInt();
		}
		
		scan.close();

		float maxLoad = ClinicVillage.solve(n, m, population);
		
		System.out.println("Max Load After Opening All the Cities = " + maxLoad);	
	}

	public static class Node implements Comparable<Node>
	{
		private final int population;
		private int clinicCount;
		private final int villageId;

		public Node(int population, int villageId)
		{
			this.population = population;
			this.villageId = villageId;
			this.clinicCount = 1;
		}

		public void openAClinic()
		{
			this.clinicCount++;
		}

		public int getVillageId()
		{
			return this.villageId;
		}

		public float getLoad()
		{
			return this.population / this.clinicCount;
		}

		@Override
		public int compareTo(Node node)
		{
			return (int) (node.getLoad() - this.getLoad());
		}
	}
}
