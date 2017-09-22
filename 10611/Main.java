import java.util.*;

class Main{

public static void main(String []args){
    Scanner in = new Scanner(System.in);
    int numberOfChimps = in.nextInt();
    int[] chimpsHeight = new int[numberOfChimps];
    for(int i = 0; i < numberOfChimps; i++){
      chimpsHeight[i] = in.nextInt();
    }
    int numberOfQueries = in.nextInt();
    for(int i = 0; i < numberOfQueries; i++ ){
      int heightOfLuchu = in.nextInt();
      int l = 0, u = numberOfChimps - 1;
      int m;
      while(l < u){
        m = (l+u) /2;
        if(chimpsHeight[m] >= heightOfLuchu){ u = m; }
        else if (chimpsHeight[m] < heightOfLuchu){ l = m+1; }
    }
        while(u< chimpsHeight.length && chimpsHeight[u] <= heightOfLuchu){
          u++;
        }
        while(  l >= 0 &&chimpsHeight[l] >= heightOfLuchu){
          l--;
        }
        if(l >= 0 && chimpsHeight[l] != heightOfLuchu){
          System.out.print(chimpsHeight[l] + " ");
        }
        else{
          System.out.print("X ");
        }
        if(u <chimpsHeight.length && chimpsHeight[u] != heightOfLuchu ){
          System.out.println(chimpsHeight[u]);
        }
        else
          System.out.println("X");
    }
  }

}
