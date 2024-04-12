// Currently supported balances: Atlantis/Winter/Stone, Crusade/Ninja/Zombie, Space/Cowboy, Power/Oil, Shield, Export, Santa/Supreme

public class Offline {
    public static void main(String args[]) {
      
      Balance bal = new Balance("Space");
      
      // Entering amounts is not case sensitive, but please use the dot decimal point for tenths and beyond (parser ignores commas).
      
      String vals[][] = new String [bal.getIndustries()][];
      // Generator values for first industry, with first value being the resource amount, followed by generators.
      vals[0] = new String[] {"0", "0", "0", "0", "0", "0", "1"};
      // Generator values for second industry, with first value being the resource amount, followed by generators.
      vals[1] = new String[] {"0", "789.99 B", "3500", "0", "0", "0"};
      // Generator values for third industry, with first value being the resource amount, followed by generators.
      vals[2] = new String[] {"0", "0", "0", "0", "100"};
      
      int commons[][] = new int [bal.getIndustries()][];
      // Common levels for first industry.
      commons[0] = new int[] {5, 4, 6, 7, 4, 4};
      // Common levels for second industry.
      commons[1] = new int[] {4, 1, 0, 0, 0};
      // Common levels for third industry.
      commons[2] = new int[]{1, 1, 1, 1};
      
      // Rare levels (order: Swann, Hooper, Manta, Moby, Zora, Neptune)
      int rares[] = {4, 4, 4, 0, 0, 0};
      bal.setRares(rares);
      
      // public Time(int h, int m, int s)
      Time offline = new Time(1, 46, 39);
      
      // public void calculateOffline(int INDUSTRY, String[], int[], Time, boolean BOOST)
      bal.calculateOffline(3, vals, commons, offline, true);
      
    }
}