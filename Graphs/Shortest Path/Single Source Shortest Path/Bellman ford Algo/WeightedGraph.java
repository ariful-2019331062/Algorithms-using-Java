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

  // public void BellmanFord(WeightedNode node) {
  // node.distance = 0;
  // for (int i = 0; i < list.size() - 1; i++) {
  // for (WeightedNode currentNode : list) {
  // for (WeightedNode neighbor : currentNode.neighbor) {
  // if (neighbor.distance > currentNode.distance +
  // currentNode.weightedMap.get(neighbor)) {
  // neighbor.distance = currentNode.distance +
  // currentNode.weightedMap.get(neighbor);
  // neighbor.parent = currentNode;
  // }
  // }
  // }
  // }
  // System.out.println("Checking for negative cycle");
  // for (WeightedNode currentNode : list) {
  // for (WeightedNode neighbor : currentNode.neighbor) {
  // if (neighbor.distance > currentNode.distance +
  // currentNode.weightedMap.get(neighbor)) {
  // System.out.println("Negative cycle detected");
  // System.out.println("Old cost: " + neighbor.distance);
  // int newDistance = currentNode.distance +
  // currentNode.weightedMap.get(neighbor);
  // System.out.println("new cost: " + newDistance);
  // return;
  // }
  // }
  // }

  // for (WeightedNode nodetoCheck : list) {
  // System.out.print("Node : " + nodetoCheck.getName() + " , distance "
  // + nodetoCheck.distance + " , path ");
  // pathPrint(nodetoCheck);
  // System.out.println();

  // }

  // }
  void bellmanFord(WeightedNode sourceNode) {
    sourceNode.distance = 0;
    for (int i = 0; i < list.size() - 1; i++) {
      for (WeightedNode currentNode : list) {
        for (WeightedNode neighbor : currentNode.neighbor) {
          if (neighbor.distance > currentNode.distance + currentNode.weightedMap.get(neighbor)) {
            neighbor.distance = (currentNode.distance + currentNode.weightedMap.get(neighbor));
            neighbor.parent = currentNode;
          }
        }
      }
    }
    System.out.println("Checking for Negative Cycle..");
    for (WeightedNode currentNode : list) {
      for (WeightedNode neighbor : currentNode.neighbor) {
        if (neighbor.distance > currentNode.distance + currentNode.weightedMap.get(neighbor)) {
          System.out.println("Negative cycle found: \n");
          System.out.println("Vertex name: " + neighbor.getName());
          System.out.println("Old cost: " + neighbor.distance);
          int newDistance = currentNode.distance + currentNode.weightedMap.get(neighbor);
          System.out.println("new cost: " + newDistance);
          return;
        }
      }
    }
    System.out.println("Negative Cycle not found");

    for (WeightedNode nodeToCheck : list) {
      System.out.print("Node " + nodeToCheck.getName() + ", distance: " + nodeToCheck.distance + ", Path: ");
      pathPrint(nodeToCheck);
      System.out.println();
    }

  }

}
