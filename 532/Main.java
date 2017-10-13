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
        int sL = -1, sR = -1, sC = -1;
        boolean[][][] dungeon = new boolean[l][r][c];
        int[] end = new int[3];
        for(int i = 0; i < l; i++){
          if(i != 0){in.nextLine();}
          for(int j = 0; j < r; j++){
            String row = in.nextLine();
            for(int k = 0; k < c; k++){
              char cell = row.charAt(k);
              if(cell == '#'){ dungeon[i][j][k] = false;}
              else if(cell == 'S'){ sL = i; sR = j; sC = k; dungeon[i][j][k] = true;}
              else if(cell == 'E'){end[0] = i; end[1] = j; end[2] = k; dungeon[i][j][k] = true; }
              else{dungeon[i][j][k] = true;}
            }
          }
        }
        int timeElapsed = escape(dungeon, 0, sL, sR, sC, end);
        if (timeElapsed != -1){ System.out.println("Escaped in " + timeElapsed + " minute(s)."); }
        else{ System.out.println("Trapped!");}
      }

  }

  private static int escape(boolean[][][] dungeon, int time, int i, int j, int k, int[] end){
    if((i >= dungeon.length || j>= dungeon[0].length || k >= dungeon[0][0].length || i < 0 || j< 0|| k < 0)){ return -1;}
    else if(dungeon[i][j][k] == false){return -1;}
    else if(i == end[0] && j == end[1] && k == end[2]){ return time;}

    dungeon[i][j][k]= false;
    int[] move = new int[6];
    move[0] =escape(dungeon, time+1, i+1, j, k,end); // up
    move[1] =escape(dungeon, time+1, i-1, j, k,end); //down
    move[2] = escape(dungeon, time+1, i, j-1, k,end);//south
    move[3] =escape(dungeon, time+1, i, j, k-1,end); //left
    move[4] = escape(dungeon, time+1, i, j, k+1,end);//right
    move[5] = escape(dungeon, time+1, i, j+1, k,end);//north
    dungeon[i][j][k]= true;

    int max = -1;

    for(int q = 0; q < move.length; q++){
      if(max == -1 && move[q] != -1){
        max = move[q];
      }
      else if(move[q] != -1 && move[q] < max){
        max = move[q];
      }
    }

    return max;
  }
}
