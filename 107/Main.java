import java.util.*;

class Main{
  public static void main(String[]args){
    Scanner in = new Scanner(System.in);
    while(true){

      String[][] piles = new String[13][4];//First will [0][1-4] will be 1 and last [12] [1-4] will be king
      for(int i = 0; i < 4; i++){
        for(int j = 12; j >= 0; j--){
          String next = in.next();
          if(next.equals("#")){ return;}
          piles[j][i] = next;
        }
      }

      String currCard = piles [12][0];
      piles[12][0] = null;
      for(int i = 1; i <= 52;i++){
        int pileIndex = findNextPile(currCard.charAt(0));
        int cardIndex = isPileAllTurned(piles,pileIndex);
        if(cardIndex == -1){
          if(i <= 9)
            System.out.println("0" +i + "," + currCard);
          else
            System.out.println(i + "," + currCard);
          break;
        }
        else{
          currCard = piles[pileIndex][cardIndex];
          piles[pileIndex][cardIndex] = null;
        }
      }
    }
  }
  public static int findNextPile(char rank){
    if(Character.isLetter(rank)){
      if(rank =='A')
        return 0;
      else if(rank == 'T')
        return 9;
      else if(rank == 'J')
        return 10;
      else if(rank == 'Q')
        return 11;
      else if(rank == 'K')
        return 12;
      }
    return Character.getNumericValue(rank) -1;
  }

  public static int isPileAllTurned(String [][] piles, int index){
    for(int i = 0; i < 4; i++){
      if(piles[index][i] !=null)
        return i;
    }
    return -1;
  }
}
