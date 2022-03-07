import java.util.ArrayList;
import java.util.LinkedList;

class ListNodes {
  private ArrayList<Nodes> arrayList;

  public ListNodes(ArrayList<Nodes> arrayList) {
    this.arrayList = arrayList;
  }

  public void addUndirectedEdge(int i, int j) {
    Nodes firstNodes = arrayList.get(i - 1);
    Nodes SecondNodes = arrayList.get(j - 1);
    firstNodes.addNeighbour(SecondNodes);
    SecondNodes.addNeighbour(firstNodes);
  }

  public void showGraph() {
    for (Nodes temporaNodes : arrayList) {
      ArrayList<Nodes> temp = temporaNodes.getNeighbourList();
      System.out.print(temporaNodes.getName() + ": ");
      if (temp.size() > 0) {
        for (int i = 0; i < temp.size() - 1; i++) {
          System.out.print(temp.get(i).getName() + " -> ");
        }
        System.out.print(temp.get(temp.size() - 1).getName());
      }
      System.out.println();

    }
  }

  public void BFSVisit(Nodes node) {
    System.out.print("Visiting for node " + node.getName() + " -->> ");
    LinkedList<Nodes> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Nodes temp = queue.remove(0);
      temp.isVisited = true;
      System.out.print(temp.getName() + " ");
      ArrayList<Nodes> templist = temp.getNeighbourList();
      for (Nodes index : templist) {
        if (index.isVisited == false) {
          index.isVisited = true;
          queue.add(index);
        }
      }

    }

  }

  public void FuLLTravarse() {
    for (Nodes node : arrayList) {
      if (!node.isVisited) {
        BFSVisit(node);
      }
    }
  }
}

class Nodes {
  private int index;
  private String name;
  public boolean isVisited = false;

  private ArrayList<Nodes> list = new ArrayList<>();

  Nodes(String name, int index) {
    this.index = index;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addNeighbour(Nodes neighbour) {
    list.add(neighbour);
  }

  public ArrayList<Nodes> getNeighbourList() {
    return list;
  }

}

public class BFS_With_adjacencyList {

  public static void main(String[] args) {
    ArrayList<Nodes> arrayList = new ArrayList<>();
    arrayList.add(new Nodes("A", 1));
    arrayList.add(new Nodes("B", 2));
    arrayList.add(new Nodes("C", 3));
    arrayList.add(new Nodes("D", 4));
    arrayList.add(new Nodes("E", 5));

    ListNodes graph = new ListNodes(arrayList);
    graph.addUndirectedEdge(1, 2);
    graph.addUndirectedEdge(1, 3);
    graph.addUndirectedEdge(1, 4);
    graph.addUndirectedEdge(5, 4);
    graph.addUndirectedEdge(3, 4);
    graph.addUndirectedEdge(2, 5);

    graph.showGraph();
    // graph.BFSVisit(arrayList.get(1));
    // graph.BFSVisit(arrayList.get(0));
    // graph.BFSVisit(arrayList.get(2));
    // graph.BFSVisit(arrayList.get(3));
    // graph.BFSVisit(arrayList.get(4));

    graph.FuLLTravarse();

  }

}
