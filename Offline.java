// Currently supported balances: All AdCom events and All AdAges events!

public class Offline {
    public static void main(String args[]) {
      
      Event evt = new Event("Scandinavia");
      
      if(evt.isValid()){
          
          // Entering amounts is not case sensitive, but please use the dot decimal point (.) for tenths and beyond (parser ignores commas).
          String vals[][] = new String [evt.getIndustries()][];
          
          // Generator values for first industry, with first value being the resource amount, followed by generators.
          vals[0] = new String[] {"0", "129.3rr", "705nn", "62.8kk", "10.87hh", "3.3ee", "1.43bb", "1.34b"};
          // Generator values for second industry, with first value being the resource amount, followed by generators.
          vals[1] = new String[] {"290.7ss", "65.03oo", "7.51kk", "731ff", "137bb", "5.43b", "1069"};
          // Generator values for third industry, with first value being the resource amount, followed by generators.
          vals[2] = new String[] {"1.43pp", "201.28kk", "3.48gg", "887.55bb", "3.38b", "0"};
          
          int commons[][] = new int [evt.getIndustries()][];
          // Common levels for first industry.
          commons[0] = new int[] {6, 6, 6, 6, 6, 6, 5};
          // Common levels for second industry.
          commons[1] = new int[] {7, 7, 7, 7, 4, 0};
          // Common levels for third industry.
          commons[2] = new int[] {7, 7, 6, 5, 0};
          
          // Rare levels (order: Swann, Hooper, Manta, Moby, Zora, Neptune)
          int rares[] = {4, 3, 4, 3, 4, 2, 4, 4, 4, 4};
          evt.setRares(rares);
          
          // public void calculateOffline(int INDUSTRY, String[], int[], Time, boolean BOOST)
          evt.calculateAllIndustriesOffline(vals, commons, new Time ("48m2s"), true);
          
          /*vals[1][5] = "8500";
          vals[1][0] = "0";
          commons[1][4] = 5;
          
          Time duration2 = new Time("4h");
          evt.calculateOffline(1, vals, commons, duration2, true);
          evt.calculateOffline(2, vals, commons, duration2, true);
          evt.calculateOffline(3, vals, commons, duration2, true);
          
          vals[1][5] = "198040";
          vals[1][0] = "0";
          
          Time sleep = new Time("7h");
          evt.calculateOffline(1, vals, commons, sleep, true);
          evt.calculateOffline(2, vals, commons, sleep, true);
          evt.calculateOffline(3, vals, commons, sleep, true);*/
      
      }
    }
}