"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.data (the value of the node)"""

def insert(r,val):
    if r == None:
        return Node(val)
    p = r
    while p != None:
        if p.data < val:
            if p.right == None:
                p.right = Node(val)
                break
            else:
                p = p.right
        else:
            if p.left == None:
                p.left = Node(val)
                break
            else:
                p = p.left                        
    return r
   #Enter you code here.