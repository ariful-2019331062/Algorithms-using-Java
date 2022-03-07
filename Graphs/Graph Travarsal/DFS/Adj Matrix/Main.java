import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<Node> arrayList = new ArrayList<>();
    arrayList.add(new Node("A", 1));
    arrayList.add(new Node("B", 2));
    arrayList.add(new Node("C", 3));
    arrayList.add(new Node("D", 4));
    arrayList.add(new Node("E", 5));
    arrayList.add(new Node("F", 6));
    arrayList.add(new Node("G", 7));

    NodeList graph = new NodeList(arrayList);
    graph.addUndirectedEdge(1, 2);
    graph.addUndirectedEdge(1, 3);
    // graph.addUndirectedEdge(1, 4);
    graph.addUndirectedEdge(5, 6);
    graph.addUndirectedEdge(3, 4);
    graph.addUndirectedEdge(3, 5);
    graph.addUndirectedEdge(2, 7);
    graph.addUndirectedEdge(2, 4);
    graph.addUndirectedEdge(6, 4);
    graph.addUndirectedEdge(6, 7);

    graph.showMatrix();
    graph.DFS(arrayList.get(0));
    graph.DFS();

  }

}
