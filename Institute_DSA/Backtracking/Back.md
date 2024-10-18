# 01 Rat in a Maze Problem - I
Difficulty: MediumAccuracy: 35.75%Submissions: 296K+Points: 4
Consider a rat placed at (0, 0) in a square matrix mat of order n* n. It has to reach the destination at (n - 1, n - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents that rat can be travel through it.
Note: In a path, no cell can be visited more than one time. If the source cell is 0, the rat cannot move to any other cell. In case of no path, return an empty list. The driver will output "-1" automatically.

Examples:

Input: mat[][] = [[1, 0, 0, 0],
                [1, 1, 0, 1], 
                [1, 1, 0, 0],
                [0, 1, 1, 1]]
Output: DDRDRR DRDDRR
Explanation: The rat can reach the destination at (3, 3) from (0, 0) by two paths - DRDDRR and DDRDRR, when printed in sorted order we get DDRDRR DRDDRR.
 public void solve(int[][]mat,int i,int j,int n,String path,ArrayList<String>ans){
        if(i<0 || j<0 || i==n || j==n || mat[i][j]==0)return;
        if(i==n-1 && j==n-1){
            ans.add(path);
            return;
        }
        mat[i][j]=0;
        solve(mat,i+1,j,n,path+'D',ans);
         solve(mat,i-1,j,n,path+'U',ans);
            solve(mat,i,j+1,n,path+'R',ans);
              solve(mat,i,j-1,n,path+'L',ans);
              mat[i][j]=1;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String>ans=new ArrayList<>();
        int n=mat.length;
        //if(mat[0][0] || mat[n-1][n-1])return;
        String path="";
        solve(mat,0,0,n,path,ans);
        return ans;
        
    }