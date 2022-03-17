import java.util.*;

public class WeightedNode implements Comparable<WeightedNode> {
  public int index;
  public String name;
  public WeightedNode parent = null;
  public boolean isVisited = false;
  public int distance = Integer.MAX_VALUE;
  public ArrayList<WeightedNode> neighbor;
  public HashMap<WeightedNode, Integer> weightedMap;

  public WeightedNode(String name, int index) {

    this.name = name;
    this.index = index;
    neighbor = new ArrayList<>();
    weightedMap = new HashMap<>();
  }

  public ArrayList getNeighbourList() {
    return neighbor;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public int compareTo(WeightedNode o) {
    return this.distance - o.distance;
  }

}
