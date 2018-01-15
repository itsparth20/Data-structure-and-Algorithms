"""
Node is defined as
self.left (the left child of the node)
self.right (the right child of the node)
self.data (the value of the node)
"""
def lca(root , v1 , v2):
  #Enter your code here
    r1,r2=root,root
    vl1,vl2=[],[]
    
    while(r1):
        if v1>r1.data:
            vl1.append(r1)
            r1=r1.right
            
        elif v1<r1.data:
            vl1.append(r1)
            r1=r1.left
        elif v1==r1.data:
            vl1.append(r1)
            break 
            
    while(r2):
        if v2>r2.data:
            vl2.append(r2)
            r2=r2.right
            
        elif v2<r2.data:
            vl2.append(r2)
            r2=r2.left
        elif v2==r2.data:
            vl2.append(r2)
            break 
    
    node = None
    for i in range(len(vl1) if len(vl1) < len(vl2) else len(vl2)):
        if vl1[i] == vl2[i]:
            node = vl1[i]
    return node
