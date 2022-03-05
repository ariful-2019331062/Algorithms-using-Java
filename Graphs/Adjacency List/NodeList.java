import java.util.ArrayList;

public class NodeList {
  private ArrayList<Node> arrayList;

  public NodeList(ArrayList<Node> arrayList) {
    this.arrayList = arrayList;
  }

  public void addUndirectedEdge(int i, int j) {
    Node firstNode = arrayList.get(i - 1);
    Node SecondNode = arrayList.get(j - 1);
    firstNode.addNeighbour(SecondNode);
    SecondNode.addNeighbour(firstNode);
  }

  public void showGraph() {
    for (Node temporaNode : arrayList) {
      ArrayList<Node> temp = temporaNode.getNeighbourList();
      System.out.print(temporaNode.getName() + ": ");
      for (int i = 0; i < temp.size() - 1; i++) {
        System.out.print(temp.get(i).getName() + " -> ");
      }
      System.out.print(temp.get(temp.size() - 1).getName() + "\n");

    }
  }

}
