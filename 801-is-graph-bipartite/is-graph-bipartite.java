class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        for(int i = 0 ; i<V;i++)color[i] = -1;
        for(int i = 0 ; i<V;i++){
            if(color[i]==-1){
                if(!dfs(i , 0 ,graph , color )){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean dfs(int i , int col , int[][] graph , int[] color){
        color[i] = col;
        for(int itr: graph[i]){
            if(color[itr]==-1){
                if(!dfs(itr, 1-col,graph , color)){
                    return false;
                }
            }else if(color[itr]==col){
                return false;
            }
        }
        return true;
    }

}