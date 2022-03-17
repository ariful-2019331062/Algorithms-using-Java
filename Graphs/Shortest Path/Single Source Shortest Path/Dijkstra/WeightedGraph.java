import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.*;

public class WeightedGraph {
  public ArrayList<WeightedNode> list = new ArrayList<>();

  WeightedGraph(ArrayList<WeightedNode> list) {
    this.list = list;
  }

  public void addWeightedEdge(int i, int j, int cost) {
    WeightedNode first = list.get(i);
    WeightedNode second = list.get(j);
    first.neighbor.add(second);
    first.weightedMap.put(second, cost);
  }

  public void pathPrint(WeightedNode node) {
    if (node.parent != null) {
      pathPrint(node.parent);
    }
    System.out.print(node.getName() + " ");
  }

  public void dijkstra(WeightedNode node) {
    PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
    node.distance = 0;
    queue.addAll(list);
    while (!queue.isEmpty()) {
      WeightedNode temp = queue.remove();
      for (WeightedNode neighbor : temp.neighbor) {
        if (queue.contains(neighbor)) {
          if (neighbor.distance > temp.distance + temp.weightedMap.get(neighbor)) {
            neighbor.distance = temp.distance + temp.weightedMap.get(neighbor);
            neighbor.parent = temp;
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }

      }

    }

    for (WeightedNode nodetoCheck : list) {
      System.out.print("Node : " + nodetoCheck.getName() + " , distance "
          + nodetoCheck.distance + " , path  ");
      pathPrint(nodetoCheck);
      System.out.println();

    }

  }

}
