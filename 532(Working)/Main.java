import java.util.*;

class Main{
  public static void main(String[]args){
    Scanner in = new Scanner(System.in);
      while(true){
        int l = in.nextInt(), r = in.nextInt(), c = in.nextInt();
        in.nextLine();
        if(l == 0 && r == 0 && c == 0){
          return;
        }
        int[] start = new int[3];
        boolean[][][] dungeon = new boolean[l][r][c];
        int[] end = new int[3];
        for(int i = 0; i < l; i++){
          if(i != 0){in.nextLine();}
          for(int j = 0; j < r; j++){
            String row = in.nextLine();
            for(int k = 0; k < c; k++){
              char cell = row.charAt(k);
              if(cell == '#'){ dungeon[i][j][k] = false;}
              else if(cell == 'S'){ start[0] = i; start[1] = j; start[2] = k; dungeon[i][j][k] = true;}
              else if(cell == 'E'){end[0] = i; end[1] = j; end[2] = k; dungeon[i][j][k] = true; }
              else{dungeon[i][j][k] = true;}
            }
          }
        }

        if(start[0] == end[0] && start[1] == end[1] && start[2] == end[2]){System.out.println("Escaped in 0 minute(s).");}
        int[][]queue = new int[l*r*c][3];
        queue[0][0] = start[0];
        queue[0][1] = start[1];
        queue[0][2] = start[2];
        int head =0, tail = 1;

        boolean[][][] disc = new boolean[l][r][c];
        disc[start[0]][start[1]][start[2]] = true;

        HashMap<int[][][], int[][][]> prev = new HashMap<>();

        boolean success = false;
        while(!success && head < tail){
          int[] u = {queue[head][0],queue[head][1],queue[head][2]};
          head++;
          if(dungeon[u[0]][u[1]][u[2]] == true){
            boolean[] neighbors = findNeighbors(dungeon, u[0], u[1], u[2]);
            for(int i = 0; i< 6; i++){
              if(neighbors[i] = true && !disc[u[0]][u[1]][u[2]]){
                disc[u[0]][u[1]][u[2]] = true;
                queue[tail][0] = u[0];
              }
            }
          }
        }
      }


  }
  private static boolean isNeighbor(boolean[][][] dungeon, int level, int row, int col){
    if(level < 0 || row < 0 || col < 0 || level > dungeon.length || row > dungeon[0].length || col > dungeon[0][0].length ){return false;}
    return dungeon[level][row][col];
  }

  private static int[][] findNeighbors(boolean[][][] dungeon, int i, int j, int k){
    int neighbors[][] = new int[6][3]; //0 up, 1 down, 2 west, 3 east, 4 north, 5 south
    neighbors[0][0] = isNeighbor(dungeon, i+1, j, k);
    neighbors[1] = isNeighbor(dungeon, i-1, j, k);
    neighbors[2] = isNeighbor(dungeon, i, j+1, k);
    neighbors[3] = isNeighbor(dungeon, i, j-1, k);
    neighbors[4] = isNeighbor(dungeon, i, j, k+1);
    neighbors[5] = isNeighbor(dungeon, i, j, k-1);
    return neighbors;
  }
}
