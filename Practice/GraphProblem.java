package Graph;
/**
 *
 * @author itspa
 */

 /*
  *                                 Homework VIII                                  
  *                                                                                
  *  Problem: Graph                                                                
  *                                                                                
  *  Prompt: Create a Vertex class/constructor and Graph class/constructor.        
  *          Name it Graph.                                                        
  *                                                                                
  *  The Vertex will have the following properties:                                 
  *                                                                                
  *               value: integer value (initially null)                            
  *               edges: hash that contains edges to other vertices                
  *                                                                                
  *  The Graph will have the following properties:                                 
  *                                                                                
  *            vertices: A hash/dictionary/object to store vertices.               
  *       totalVertices: The total number of vertices in your Graph.               
  *          totalEdges: The total number of edges in your Graph                   
  *                                                                                
  *  The Graph will also have the following methods:                               
  *                                                                                
  *           addVertex: Method that accepts an id (int/str), and creates an       
  *                      object with a "value" of id, and a property called        
  *                      "edges" which will store the edges of the vertex. If a    
  *                      vertex with the id already exists, then do not create a   
  *                      new vertex.                                               
  *                                                                                
  *           getVertex: Method that takes an id, and outputs the vertex with the  
  *                      matching id, if it exists.                                
  *                                                                                
  *             addEdge: Method that accepts two different id's as its input, and  
  *                      creates an edge between both vertices.                    
  *                      (This edge may look like [id1,id2])                       
  *                                                                                
  *          removeEdge: Method that accepts two different id's as its input, and  
  *                      removes the edge between the two vertices if it exists.   
  *                                                                                
  *        removeVertex: Method that takes an id as its input, and removes the     
  *                      vertex with the matching id.                              
  *                                                                                
  *       findNeighbors: Method that accepts an id as its input, and returns       
  *                      all of the edges of that vertex.   

		BFS and DFS
  *                                                                                
  */

import java.util.*;
import java.util.Queue;

class Vertex {
    public String values;
    public Map<Vertex, String> edges = new HashMap<Vertex, String>();

    public Vertex(String value) {
        this.values = value;
//        edges = null;
    }        
};


class Graph {
        
    private Map<String, Vertex> vertices= new HashMap<String, Vertex>();
    private int totalVertices = 0;
    private int totalEdges = 0;
    
  // Time Complexity: O(1)
  // Auxiliary Space Complexity: 
  public void addVertex (String id){
      Vertex vertex = new Vertex(id);
      vertices.put(id, vertex);
      totalVertices++;
  }


  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public Vertex getVertex (String id){      
      return vertices.get(id);
  }


  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public void addEdge (String id1, String id2){
      Vertex v1 = vertices.get(id1);
      Vertex v2 = vertices.get(id2);
      
      if(v1 != null && v2 != null){
        v1.edges.put(v2, id2);
        v2.edges.put(v1, id1);
        totalEdges++;
      }                  
  }


  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public void removeEdge (String id1, String id2){
      Vertex v1 = vertices.get(id1);
      Vertex v2 = vertices.get(id2);
      if(v1 != null && v2 != null){
        v1.edges.remove(v2);
        v2.edges.remove(v1);
        totalEdges--;
      }
  }


  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public void removeVertex (String id){
      Vertex v1 = vertices.remove(id);
      for(Vertex v : v1.edges.keySet()){
          String value = v.values;
          
      }
      totalVertices--;
  }


  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public Map<Vertex, String> findNeighbors (String id){
      Vertex v1 = vertices.get(id);
      return v1.edges;
  }

  public void printVertex(){
      forEachVertex(vertices);
  }

  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public void forEachVertex (Map<String, Vertex> vertexs){
      
      for(Map.Entry<String, Vertex> entry : vertexs.entrySet()){
          System.out.print(entry.getKey() + " { ");
          Vertex v = entry.getValue();
          Map<Vertex, String> edges = v.edges;
          
          for(Map.Entry<Vertex, String> edge : edges.entrySet()){
              System.out.print(edge.getValue() + " ");
          }
          System.out.println("} ");
      }
      System.out.println();
  }


  // Time Complexity: 
  // Auxiliary Space Complexity: 
  public void forEachEdge (Map<Vertex, String> edges){
      for(Vertex v : edges.keySet()){
//          System.out.print();          
      }
      System.out.println(BFSearch("A"));
  }

  public List<String> BFSearch(String start){
      if(!vertices.containsKey(start)){
          return null;
      }
      List<String> vertexList = new ArrayList<String>();        

        Queue<String> queue = new java.util.LinkedList<String>();
      Set<String> set = new HashSet<String>();
      set.add(start);
      
      queue.add(start);
      while(queue.size()>0){
          String dequeueString = queue.remove();
          
//          Vertex dequeueVertex = vertices.get(dequeueString);
          Map<Vertex, String> edges = findNeighbors(dequeueString);
          for(Map.Entry<Vertex, String> edge : edges.entrySet()){
              if(!set.contains(edge.getValue())){          
                queue.add(edge.getValue());
                set.add(edge.getValue());                
              }
          }
          vertexList.add(dequeueString);
      }
      
      return vertexList;
    }
  
  public List<String> DFSearch(String start){
      if(!vertices.containsKey(start)){
          return null;
      }
      List<String> vertexList = new ArrayList<String>();        
        Stack<String> stack = new Stack<String>();
      Set<String> set = new HashSet<String>();
      set.add(start);
      
      stack.add(start);
      while(stack.size()>0){
          String dequeueString = stack.pop();
          
//          Vertex dequeueVertex = vertices.get(dequeueString);
          Map<Vertex, String> edges = findNeighbors(dequeueString);
          for(Map.Entry<Vertex, String> edge : edges.entrySet()){
              if(!set.contains(edge.getValue())){          
                stack.add(edge.getValue());
                set.add(edge.getValue());
                
              }
          }
          vertexList.add(dequeueString);
      }
      
      return vertexList;
    }
  
  public boolean graphIsTree(String start){
      if(!vertices.containsKey(start)){
          return false;
      }
      List<String> vertexList = new ArrayList<String>();        
      Stack<String> stack = new Stack<String>();
      Set<String> set = new HashSet<String>();
      Map<String, String> parentNode = new HashMap<String, String>();
      set.add(start);
      parentNode.put(start, "-1");
      stack.add(start);
      while(stack.size()>0){
          String dequeueString = stack.pop();
          
          Map<Vertex, String> edges = findNeighbors(dequeueString);
          for(Map.Entry<Vertex, String> edge : edges.entrySet()){
              if(!set.contains(edge.getValue())){          
                stack.add(edge.getValue());
                set.add(edge.getValue());
                parentNode.put(edge.getValue(), dequeueString);                
              }else{
                  if(edge.getValue() != parentNode.get(dequeueString)){
                      return false;
                  }
              }
              
          }
          vertexList.add(dequeueString);
      }
      
      return vertexList.size() == totalVertices;
    }
  
}



public class GraphProblem {
    public static void main(String[] args){
        Graph graph = new Graph();
        char[] arr = "ABCDEFG".toCharArray();
        for(char ch : arr){
            graph.addVertex(String.valueOf(ch));
        }
        
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("C", "D");
        graph.addEdge("B", "D");
        graph.addEdge("D", "F");
        graph.addEdge("D", "E");
        graph.addEdge("D", "G");
        graph.addEdge("F", "G");
        
        graph.printVertex();
        System.out.println(graph.DFSearch("A") + "\n");
        
        Graph graphIsTre = new Graph();
        char[] arr1 = "01234".toCharArray();
        for(char ch : arr1){
            graphIsTre.addVertex(String.valueOf(ch));
        }
        
        graphIsTre.addEdge("1", "0");
        graphIsTre.addEdge("2", "0");
        graphIsTre.addEdge("0", "3");
        graphIsTre.addEdge("3", "4");        
//        graphIsTre.addEdge("2", "1");s
        
        graphIsTre.printVertex();
        System.out.println(graphIsTre.graphIsTree("1"));
        
        
    }
}
