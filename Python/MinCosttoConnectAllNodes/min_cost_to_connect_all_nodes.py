int[] parent;
int component;
private int find(int v){
    while(parent[v] != v)
        v = parent[v];
    return v;
}
private void connect(int v1, int v2){
    if(find(v1) == find(v2)) return;
    int root = find(v1);
    while(v2 != parent[v2]){
        int temp = parent[v2];
        parent[v2] = root;
        v2 = temp;
    }
    --component;
    parent[v2] = root;
}
private boolean isConnected(int v1, int v2){
    return find(v1) == find(v2);
}
public int minCosttoConnectAllNodes(int n, int edges[][], int newEdges[][]){
    parent = new int[n + 1]; component = n;
    for(int i = 0; i <= n; ++i) parent[i] = i;
    for(int[] edge: edges) connect(edge[0], edge[1]);
    Arrays.sort(newEdges, (a, b) -> (a[2] - b[2]));
    int cost = 0;
    for(int i = 0; i < newEdges.length; ++i){
        if(!isConnected(newEdges[i][0], newEdges[i][1])){
            connect(newEdges[i][0], newEdges[i][1]);
            cost += newEdges[i][2];
            if(component == 1) return cost;
        }
    }
    return -1;
}