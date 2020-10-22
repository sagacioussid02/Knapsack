package algorithms.companies.gs;

import java.util.ArrayList;

public class MinCostToDeliverToEachCity {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}


class Node {
    int id;
    ArrayList<Integer> Edges;
    ArrayList<Integer> costs;
    boolean Visited = false;
    int Dis = 100000000;
    int HeapIndex = 0;

    Node(int id) {
        this.id = id;
        this.Edges = new ArrayList<Integer>();
        this.costs = new ArrayList<Integer>();
    }
}

class Heap {
    int size;
    Node[] arr;

    Heap(int size) {
        this.size = 0;
        this.arr = new Node[size];
    }

    public static int LeftChild(int i) {
        return 2 * i + 1;
    }

    public static int RightChild(int i) {
        return 2 * i + 2;
    }

    public static int Parent(int i) {
        return (i - 1) / 2;
    }

    public void ShiftUp(int i) {
        while (i > 0) {
            int p = Heap.Parent(i);
            // System.out.println(arr[i]+" "+arr[p]);
            if (arr[i].Dis < arr[p].Dis) {
                Node temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                arr[p].HeapIndex = p;
                arr[i].HeapIndex = i;
                i = p;
            } else {
                break;
            }
        }
    }

    public void ShiftDown(int i) {
        int l = Heap.LeftChild(i);
        int r = Heap.RightChild(i);
        int minIndex = i;
        if (l < this.size && arr[l].Dis < arr[minIndex].Dis) {
            minIndex = l;
        }
        if (r < this.size && arr[r].Dis < arr[minIndex].Dis) {
            minIndex = r;
        }
        if (minIndex != i) {
            Node temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            arr[i].HeapIndex = i;
            arr[minIndex].HeapIndex = minIndex;
            this.ShiftDown(minIndex);
        }
    }

    public void Insert(Node node) {
        arr[this.size] = node;
        node.HeapIndex = this.size;
        this.size++;
        this.ShiftUp(this.size - 1);
    }

    public Node ExtractMin() {
        Node res = arr[0];
        arr[0] = arr[this.size - 1];
        this.size -= 1;
        arr[this.size] = null;
        if (this.size != 0) {
            arr[0].HeapIndex = 0;
            this.ShiftDown(0);
        }
        return res;
    }

    public boolean empty() {
        return this.size == 0;
    }
}

class Graph {
    Node[] nodes;
    int size;

    Graph(int n) {
        this.size = n;
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
    }

    public static int min(int a, int b, int c) {
        if (a < 0 && b < 0) {
            return c;
        } else if (a < 0) {
            return b < c ? b : c;
        } else if (b < 0) {
            return a < c ? a : c;
        } else {
            int x = a < b ? a : b;
            return x < c ? x : c;
        }
    }

    public static int min(int a, int b) {
        if (a < 0) {
            return b;
        } else if (b < 0) {
            return a;
        } else {
            return a < b ? a : b;
        }
    }

    public void Add_Edge(int a, int b, int cost) {
        nodes[a].Edges.add(b);
        nodes[a].costs.add(cost);
        nodes[b].Edges.add(a);
        nodes[b].costs.add(cost);
    }

    public void Dijsktra(int k, int[][] dis) {
        Heap H = new Heap(this.size);
        nodes[0].Dis = 0;
        for (int i = 0; i < this.size; i++) {
            H.arr[i] = nodes[i];
            nodes[i].HeapIndex = i;
        }
        H.size = this.size;
        while (!H.empty()) {
            Node n = H.ExtractMin();
            // System.out.println(n.id+ " "+ n.Dis);
            n.Visited = true;
            for (int i = 0; i < n.Edges.size(); i++) {
                int j = n.Edges.get(i);
                if (!nodes[j].Visited) {
                    if (k != 0) {
                        nodes[j].Dis = Graph.min(nodes[j].Dis, dis[n.id][k - 1], n.Dis + n.costs.get(i));
                    } else {
                        nodes[j].Dis = Graph.min(nodes[j].Dis, n.Dis + n.costs.get(i));
                    }
                    H.ShiftUp(nodes[j].HeapIndex);
                }
            }
        }
        for (int i = 0; i < this.size; i++) {
            dis[i][k] = nodes[i].Dis;
            nodes[i].Dis = 100000000;
            nodes[i].Visited = false;
        }
    }

    public void Solve(int K) {
        // System.out.println("Solving");
        int[][] dis = new int[this.size][K + 1];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < K + 1; j++) {
                dis[i][j] = -1;
            }
        }
        for (int k = 0; k < K + 1; k++) {
            Dijsktra(k, dis);
        }
        for (int i = 0; i < this.size; i++) {
            System.out.print(dis[i][K] + " ");
        }
        System.out.println();
    }

}