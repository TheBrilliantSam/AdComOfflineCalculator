// Currently supported balances: Atlantis/Winter/Stone

public class AdComOfflineCalculator {
    public static void main(String args[]) {
      
      Balance bal = new Balance("Atlantis");
      
      String vals[][] = new String [bal.getIndustries()][];
      // Generator values for first industry, with first value being the resource amount, followed by generators.
      vals[0] = new String[] {"0", "33 CC", "21 AA", "5 B", "0", "0", "0"};
      // Generator values for second industry, with first value being the resource amount, followed by generators.
      vals[1] = new String[] {"10.32 BB", "789.99 B", "3500", "0", "0", "0"};
      // Generator values for third industry, with first value being the resource amount, followed by generators.
      vals[2] = new String[] {"55.32 T", "9 M", "5", "0", "0"};
      
      int commons[][] = new int [bal.getIndustries()][];
      // Common levels for first industry.
      commons[0] = new int[] {3, 2, 2, 0, 0, 0};
      // Common levels for second industry.
      commons[1] = new int[] {4, 1, 0, 0, 0};
      // Common levels for third industry.
      commons[2] = new int[]{3, 1, 0, 0};
      
      // Rare levels (order: Swann, Hooper, Manta, Moby, Zora, Neptune)
      int rares[] = {2, 2, 1, 2, 1, 1};
      bal.setRares(rares);
      
      // public Time(int h, int m, int s)
      Time offline = new Time(0, 31, 29);
      
      // public void calculateOffline(int industry, String[] amounts, int[] commons, int hours, int minutes, int seconds, boolean boost)
      bal.calculateOffline(1, vals, commons, offline, true);
      
    }
}