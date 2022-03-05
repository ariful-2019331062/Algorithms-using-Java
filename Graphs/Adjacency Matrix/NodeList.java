import java.util.ArrayList;

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

}
