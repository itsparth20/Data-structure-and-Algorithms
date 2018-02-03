   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
    
   void levelOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        Queue<Node> data=new LinkedList<Node>();
        data.offer(root);
        while(data.peek() != null){
            Node rt = data.remove();            
            if(rt.left != null){
                data.offer(rt.left);
                System.out.print(rt.left.data + " ");
            }
            if(rt.right != null){
                data.offer(rt.right);
                System.out.print(rt.right.data + " ");
            }
        }
      
    }

