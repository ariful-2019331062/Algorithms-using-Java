public class Node {
  private int index;
  private String name;
  public boolean isVisited = false;

  Node(String name, int index) {
    this.index = index;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getIndex() {
    return this.index;
  }
}