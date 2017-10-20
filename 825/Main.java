import java.util.*;

class Main{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for(int testCases = 0; testCases < t; testCases++){
      if(testCases !=0){
        System.out.println();
      }
      int w = in.nextInt(), n = in.nextInt();
      int[][] grid = new int[w][n];
      in.nextLine();

      grid[0][0] = 1;
      for(int i =0; i < w; i++){
        Scanner block = new Scanner(in.nextLine());
        block.nextInt();
        while(block.hasNext()){
          grid[i][block.nextInt() -1] = -1;
        }
        for(int j = 0; j < n; j++){
          if(i == 0 && j==0){ continue;}
          else if(grid[i][j] != -1){
            if(i >0 ){grid[i][j] = Math.max(grid[i-1][j], 0);}
            if(j >0){grid[i][j]+= Math.max(grid[i][j-1], 0);}
          }
        }
      }
      System.out.println(grid[w-1][n-1]);
    }
  }
}
