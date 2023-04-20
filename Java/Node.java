//python에서는 tuple로 사용해!!!!!!!!!
// BFS에서 LinkedList와 같이 써서 구현
// Dijkstra에서는 PriorityQueue와 같이 써서 구현

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int distance

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(Node other) {
        if (this.distance < other.distance) {
            return -1;
        }
        return 1;
    }
}