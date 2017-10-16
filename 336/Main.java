import java.util.*;

class Main{
  public static void main(String[]args){
    Scanner in = new Scanner(System.in);
    int count  =1;
    while(true){
      int m = in.nextInt();
      //System.out.println("m: " + m);
      if(m == 0){ return;}
      HashMap<String, ArrayList<String>> adj = new HashMap<>();
      ArrayList<String> nodes = new ArrayList<>();
      for(int i = 0; i <m; i++){
        String u = ""+ in.nextInt(), v =""+in.nextInt();
        if(!adj.containsKey(u)){ adj.put(u, new ArrayList<>());}
        if(!adj.containsKey(v)){ adj.put(v, new ArrayList<>());}
        if(!nodes.contains(u)){ nodes.add(u);}
        if(!nodes.contains(v)){ nodes.add(v);}
        ArrayList<String> uAdj = adj.get(u), vAdj = adj.get(v);

        uAdj.add(v);
        vAdj.add(u);
      }

      while(true){

        int notReach = 0;
        String initNode = ""+in.nextInt();

        int TTL = in.nextInt();

        if(initNode.equals("0") && TTL == 0){ break;}
        if(!nodes.contains(initNode)){ System.out.println("Case "+count+ ": "+ nodes.size()+" nodes not reachable from node "+ initNode + " with TTL = "+ TTL+"."); count++; continue;}
        String[] queue = new String[2*m +1];
         queue[0]= initNode;
        int head = 0, tail = 1;

        HashSet<String> disc = new HashSet<>();
        disc.add(initNode);
        HashMap<String, String> prev = new HashMap<>();
        while(head < tail){
          String u = queue[head++];
          for(String v : adj.get(u)){
            if(!disc.contains(v)){
              queue[tail++] = v;
              disc.add(v);
              prev.put(v, u);
            }
          }
        }

        for(int k = 0; k < nodes.size(); k++){
          String v = nodes.get(k);
          String u ="";
          if(v.equals(initNode)){ continue;}
          for(int j = 0; j < TTL; j++){
            if(prev.containsKey(v)){ u =prev.get(v); }
            if(v.equals(initNode)){ break; }
            v = u;
          }
          if(u != initNode){
            notReach++;
          }
        }
        System.out.println("Case "+count+ ": "+ notReach+" nodes not reachable from node "+ initNode + " with TTL = "+ TTL+".");
        count++;
      }
    }
  }
}
