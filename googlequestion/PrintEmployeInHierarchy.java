/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package googlequestion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author itspa
 */


public class PrintEmployeInHierarchy {

  static void printHierarchy(Node node, String space) {
    if(node == null) return;
    System.out.println(space+"-"+node.name);
    if(node.list != null) {
      for (Node node1 : node.list) {
        printHierarchy(node1, space+" ");
      }
    }
  }

  static class Node {
    String name;
    List<Node> list = new ArrayList();
    Node(String name) {
      this.name = name;
    }
  }
  public static void main(String... args) {
    List<Node> all = new ArrayList();
    Node n = new Node("Manager1");
    Node joe = new Node("Joe");
    Node tom = new Node("Tom");
    n.list.add(joe);
    n.list.add(tom);
    all.add(n);


    Node linda = new Node("Linda");
    Node potter = new Node("Potter");
    joe.list.add(linda);
    tom.list.add(potter);
    Node harry = new Node("Harry");
    linda.list.add(harry);
    for(Node t : all) {
      printHierarchy(t, "");
    }
  }
}

