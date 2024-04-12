// Currently supported balances: Atlantis/Winter/Stone, Crusade/Ninja/Zombie, Space/Cowboy, Power/Oil, Shield, Export, Santa/Supreme

public class Offline {
    public static void main(String args[]) {
      
      Balance bal = new Balance("Winter");
      
      String vals[][] = new String [bal.getIndustries()][];
      // Generator values for first industry, with first value being the resource amount, followed by generators.
      vals[0] = new String[] {"0", "5.2 EE", "3.5 CC", "12 AA", "5 B", "80 M", "0"};
      // Generator values for second industry, with first value being the resource amount, followed by generators.
      vals[1] = new String[] {"0", "789.99 B", "3500", "0", "0", "0"};
      // Generator values for third industry, with first value being the resource amount, followed by generators.
      /als[2] = new String[] {"55.32 T", "9 M", "5", "0", "0"};
      
      int commons[][] = new int [bal.getIndustries()][];
      // Common levels for first industry.
      commons[0] = new int[] {5, 4, 3, 3, 4, 0};
      // Common levels for second industry.
      commons[1] = new int[] {4, 1, 0, 0, 0};
      // Common levels for third industry.
      commons[2] = new int[]{3, 1, 0, 0};
      
      // Rare levels (order: Swann, Hooper, Manta, Moby, Zora, Neptune)
      int rares[] = {4, 4, 0, 0, 0, 0};
      bal.setRares(rares);
      
      // public Time(int h, int m, int s)
      Time offline = new Time(4, 12, 13);
      
      // public void calculateOffline(int industry, String[] amounts, int[] commons, int hours, int minutes, int seconds, boolean boost)
      bal.calculateOffline(1, vals, commons, offline, true);
      
    }
}