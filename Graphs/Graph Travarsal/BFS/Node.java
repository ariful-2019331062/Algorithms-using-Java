public class Node {
  private int index;
  private String name;

  Node(String name, int index) {
    this.index = index;
    this.name = name;
  }

  public Boolean isVisited = false;

  public String getName() {
    return name;
  }

  public int getIndex() {
    return this.index;
  }
}