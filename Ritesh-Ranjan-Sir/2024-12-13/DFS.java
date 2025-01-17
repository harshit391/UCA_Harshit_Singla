import java.util.Stack;

public class DFS
{
    private boolean[] marked;

    private int[] edgeTo;

    private int s;

    public DFS(
            Graph g,
            int s
    )
    {
        marked = new boolean[g.V()];

        edgeTo = new int[g.V()];

        this.s = s;

        dfs(g, s);
    }

    private void dfs(
            Graph g,
            int v
    )
    {
        marked[v] = true;
        for (int w : g.adj(v))
        {
            if (!marked[w])
            {
                dfs(g, w);
                edgeTo[w] = v;
            }
        }
    }

    public void printPathTo(int v)
    {
        Stack<Integer> path = new Stack<>();

        for (int w = v; w != s; w = edgeTo[w])
        {
            path.push(w);
        }
        path.push(s);

        while (!path.isEmpty())
        {
            System.out.println(path.pop() + " --> " + s);
        }
    }

    public boolean isConnected(int v)
    {
        return marked[v];
    }

    public static void f(Integer... i)
    {
        System.out.println(i[0]);
    }

    public static void main(
            String... args
            // This is called variable arguments
            // String[] args
    )
    {
        int i = 10;

        DFS.f(i);

        // auto widening
        // boxing and unboxing
        // variable arguments

        // How Compiler Finds Overloading Functions
        // Best Fit
        // Var arg get priority over auto widening

        // widening get priority over boxing


    }
}
