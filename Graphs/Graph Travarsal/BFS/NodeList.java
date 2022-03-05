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

  public void BfsVisit(Node StartNode) {

    System.out.print("Travarsal Starting from Node " + StartNode.getName() + " -> ");
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(StartNode);
    while (!queue.isEmpty()) {
      Node temp = queue.remove(0);
      System.out.print(temp.getName() + " ");
      temp.isVisited = true;
      ArrayList<Node> neighbour = getNeighbour(temp);
      for (int i = 0; i < neighbour.size(); i++) {
        Node nbourNode = neighbour.get(i);
        if (!nbourNode.isVisited) {
          queue.add(nbourNode);
          nbourNode.isVisited = true;
        }
      }
    }

  }

  public void BFS() {
    for (int i = 0; i < arrayList.size(); i++) {
      if (!arrayList.get(i).isVisited) {
        BfsVisit(arrayList.get(i));
      }
    }
  }

}
