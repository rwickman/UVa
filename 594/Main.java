import java.util.*;

class Main{
  public static void main(String[]args){
    Scanner in = new Scanner(System.in);
    while(in.hasNext()){
      int x = in.nextInt();
      int u1 = x << 24;
      int u2 = x << 16;
      u2 = u2 >>> 24;
      u2 = u2 << 16;
      int u3 = x >>>24;
      int u4 = x >>>16;
      u4 = u4 << 24;
      u4 = u4 >>> 16;
      System.out.println(x + " converts to " + (u1 | u2 | u3| u4));
    }
  }
}
