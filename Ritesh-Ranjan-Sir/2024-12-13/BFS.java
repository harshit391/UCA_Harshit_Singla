public class BFS
{
    private final boolean[] marked;
    private final int[] edgeTo;
    private final int s;

    BFS(
            Graph G,
            int s
    )
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        s = s;
        marked[s] = true;
    }


}
