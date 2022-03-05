import java.util.ArrayList;

public class Node {
  private int index;
  private String name;

  private ArrayList<Node> list = new ArrayList<>();

  Node(String name, int index) {
    this.index = index;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void addNeighbour(Node neighbour) {
    list.add(neighbour);
  }

  public ArrayList<Node> getNeighbourList() {
    return list;
  }

}