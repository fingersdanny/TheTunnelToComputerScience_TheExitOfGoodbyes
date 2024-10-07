import java.util.*;

class TopologySort{
    private static void TopologySort(int[] indegree, int v, ArrayList<ArrayList<Integer>> graph) {
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i <= v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int now = q.removeFirst();
            result.add(now);
            for (int i = 0; i < graph.get(now).size(); i++) {
                indegree[i]--;
                if (indegree == 0) {
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt(), e = sc.nextInt();
        int[] indegree = new int[v + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            graph.get(a).add(b);
            indegree[b]++;
        }
    }
}