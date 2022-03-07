import java.util.ArrayList;
import java.util.LinkedList;

public class NodeList {
  private ArrayList<Node> arrayList;
  private int[][] adjacencyMatrix;

  public NodeList(ArrayList<Node> arrayList) {
    int ListSize = arrayList.size();
    this.arrayList = arrayList;
    adjacencyMatrix = new int[ListSize][ListSize];

  }

  public void addUndirectedEdge(int i, int j) {
    adjacencyMatrix[i - 1][j - 1] = 1;
    adjacencyMatrix[j - 1][i - 1] = 1;
  }

  private ArrayList<Node> getNeighbour(Node node) {
    ArrayList<Node> newlist = new ArrayList<>();
    int nodeIndex = node.getIndex();
    for (int i = 0; i < adjacencyMatrix[nodeIndex - 1].length; i++) {
      if (adjacencyMatrix[nodeIndex - 1][i] == 1) {
        newlist.add(arrayList.get(i));
      }
    }
    return newlist;
  }

  public void showMatrix() {
    System.out.print("   ");
    for (Node value : arrayList) {
      System.out.print(value.getName() + " ");
    }
    System.out.println();
    for (int i = 0; i < arrayList.size(); i++) {
      System.out.print(arrayList.get(i).getName() + ": ");

      for (int j = 0; j < adjacencyMatrix[i].length; j++) {
        System.out.print(adjacencyMatrix[i][j] + " ");
      }
      System.out.println();

    }
  }

  public void DFS(Node node) {
    LinkedList<Node> stack = new LinkedList<>();
    stack.add(node);
    while (!stack.isEmpty()) {
      Node tempNode = stack.removeLast();
      tempNode.isVisited = true;
      System.out.print(tempNode.getName() + " ");
      ArrayList<Node> neighbour = getNeighbour(tempNode);
      for (Node nodes : neighbour) {
        if (nodes.isVisited == false) {
          nodes.isVisited = true;
          stack.add(nodes);
        }
      }
    }
  }

  public void DFS() {
    for (Node nodes : arrayList) {
      if (nodes.isVisited == false) {
        DFS(nodes);
      }
    }
  }
}
