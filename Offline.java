// Currently supported balances: All AdCom events and All AdAges events!

public class Offline {
    public static void main(String args[]) {
      
      Event evt = new Event("SVS");
      
      if(evt.isValid()){
          
          // Entering amounts is not case sensitive, but please use the dot decimal point (.) for tenths and beyond (parser ignores commas).
          String vals[][] = new String [evt.getIndustries()][];
          
          // Generator values for first industry, with first value being the resource amount, followed by generators.
          vals[0] = new String[] {"0", "6.09nn", "6.09nn", "6.09nn", "281jj", "18.38gg", "34.9dd", "26.37aa", "142.58m"};
          // Generator values for second industry, with first value being the resource amount, followed by generators.
          vals[1] = new String[] {"0", "8.45ii", "148ee", "29.6bb", "28.3b", "1629"};
          // Generator values for third industry, with first value being the resource amount, followed by generators.
          //vals[2] = new String[] {"0", "47.7hh", "109.1dd", "5.48aa", "84.53m"};
          
          int commons[][] = new int [evt.getIndustries()][];
          // Common levels for first industry.
          commons[0] = new int[] {103, 6, 6, 5, 6, 5, 6, 4};
          // Common levels for second industry.
          commons[1] = new int[] {6, 6, 6, 6, 4};
          // Common levels for third industry.
          //commons[2] = new int[] {6, 7, 6, 4};
          
          // Rare levels (order: Swann, Hooper, Manta, Moby, Zora, Neptune)
          int rares[] = {15, 4, 4, 1, 4, 4};
          evt.setRares(rares);
          
          /* public void calculateOffline(int INDUSTRY, String[], int[], Time, boolean BOOST)
          
          Time duration = new Time("4h");
          evt.calculateOffline(1, vals, commons, duration, true);
          evt.calculateOffline(2, vals, commons, duration, true);
          evt.calculateOffline(3, vals, commons, duration, true); */
          
          evt.calculateOffline(1, vals, commons, new Time ("3d"), true);
      
      }
    }
}