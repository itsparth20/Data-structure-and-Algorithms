def insert(r,val):
    if r == None:
        root = Node(val)
        return root
    else:
        rec(r, val)
    return r
   #Enter you code here.
def rec(r, val):
    if val < r.data:
        if r.left == None:
            node = Node(val)
            r.left = node
        else:
            rec(r.left, val)
    elif val > r.data:
        if r.right == None:
            node = Node(val)
            r.right = node
        else:
            rec(r.right, val)