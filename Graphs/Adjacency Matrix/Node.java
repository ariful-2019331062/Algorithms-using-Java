public class Node {
  private int index;
  private String name;

  Node(String name, int index) {
    this.index = index;
    this.name = name;
  }

  public String getName() {
    return name;
  }
}