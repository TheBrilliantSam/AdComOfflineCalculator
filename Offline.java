// Currently supported balances: All AdCom events!

public class Offline {
    public static void main(String args[]) {
      
      Event evt = new Event("Winter");
      
      if(evt.isValid()){
          
          // Entering amounts is not case sensitive, but please use the dot decimal point (.) for tenths and beyond (parser ignores commas).
          String vals[][] = new String [evt.getIndustries()][];
          
          // Generator values for first industry, with first value being the resource amount, followed by generators.
          vals[0] = new String[] {"0", "20.25mm", "3.81jj", "224.6ff", "33cc", "96t", "15.45m"};
          // Generator values for second industry, with first value being the resource amount, followed by generators.
          vals[1] = new String[] {"0", "605.1hh", "27.05ee", "2.09bb", "239.34m", "121"};
          // Generator values for third industry, with first value being the resource amount, followed by generators.
          vals[2] = new String[] {"0", "2.73hh", "72.08dd", "22.78aa", "72.48m"};
          
          int commons[][] = new int [evt.getIndustries()][];
          // Common levels for first industry.
          commons[0] = new int[] {5, 5, 6, 6, 6, 4};
          // Common levels for second industry.
          commons[1] = new int[] {6, 6, 6, 5, 0};
          // Common levels for third industry.
          commons[2] = new int[] {6, 6, 5, 4};
          
          // Rare levels (order: Swann, Hooper, Manta, Moby, Zora, Neptune)
          int rares[] = {4, 4, 4, 3, 4, 4};
          evt.setRares(rares);
          
          // public void calculateOffline(int INDUSTRY, String[], int[], Time, boolean BOOST)
          Time duration = new Time("2h10m");
          evt.calculateOffline(1, vals, commons, duration, true);
          evt.calculateOffline(2, vals, commons, duration, true);
          evt.calculateOffline(3, vals, commons, duration, true);
      
      }
    }
}