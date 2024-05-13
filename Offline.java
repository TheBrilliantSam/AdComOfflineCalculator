// Currently supported balances: All AdCom events and All AdAges events!

// Entering amounts is not case sensitive, but please use the dot decimal point (.) for tenths and beyond (parser ignores commas).
// If you want to calculate all industries at once, enter 0 for the industry.
// Always make sure the number of generators in amounts ≥ number of generators in commons > 0 (unless the event doesn't have that industry)

import java.util.*;
public class Offline {
    public static void main(String args[]) {
      
      ArrayList<String[]> amounts = new ArrayList<String[]>();
      ArrayList<int[]> commons = new ArrayList<int[]>();
      
      ///////////////////////////
      ////  USER INPUT AREA  ////
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  String eventName = "Japan";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  amounts.add(new String[] {"", "353GG", "47.6EE", "4.45CC", "705.9T", "208.86M", "3M"});
      /**/  amounts.add(new String[] {"", "18.65EE", "764BB", "104T", "8.95M"});
      /**/  amounts.add(new String[] {"", "5.06b", "241k"});
      /**/  amounts.add(new String[] {""});
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  commons.add(new int[] {4, 3, 3, 3, 3, 4});
      /**/  commons.add(new int[] {2, 4, 3, 3});
      /**/  commons.add(new int[] {-1, -1});
      /**/  commons.add(new int[] {});
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  int rareCards[] = {2, 0, 0, 0, 0, 0, 2, 4, 3, 0};
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  String time = "15m";
      /**/  int industry = 0;
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  boolean boost = true;
      /**/  boolean randomize = true;
      /**/  boolean resetResource = false;
      /**/  boolean print = true;
      ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      Event evt = new Event(eventName);
      
      if(evt.isValid()){
          
          String vals[][] = new String [evt.getIndustries()][];
          int commonCards[][] = new int [evt.getIndustries()][];
          
          for(int i = 0; i < vals.length; i++){
              vals[i] = amounts.get(i);
              commonCards[i] = commons.get(i);
          }
          
          // public void calculateOffline(int INDUSTRY, String[], int[], Time, boolean BOOST, boolean RANDOMIZE, boolean RESET_RESOURCE, boolean PRINT)
          // public void calculateAllIndustriesOffline(String[], int[], Time, boolean BOOST, boolean RANDOMIZE, boolean RESET_RESOURCE, boolean PRINT)
          
          if(industry == 0){
              evt.calculateAllIndustriesOffline(vals, commonCards, rareCards, new Time (time), boost, randomize, resetResource, print);
          } else {
              evt.calculateOffline(industry, vals, commonCards, rareCards, new Time (time), boost, randomize, resetResource, print);
          }
          
          // Add any additional calculations below using the same calculation methods.
          
      }

    }
}