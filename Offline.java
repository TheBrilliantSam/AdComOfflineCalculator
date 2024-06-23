// Currently supported balances: All AdCom events and All AdAges events!

// Entering amounts is not case sensitive, but please use the dot decimal point (.) for tenths and beyond (parser ignores commas).
// If you wish to calculate all industries at once, enter 0 for the industry.
// Always make sure the number of generators in amounts ≥ number of generators in commons > 0 (unless the event doesn't have that industry)

import java.util.*;
public class Offline {
    public static void main(String args[]) {
      
      ///////////////////////////
      ////  USER INPUT AREA  ////
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  String eventName = "Zombie";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  GENERATOR AMOUNTS: enter resource amount followed by generators separated by a slash [/]; insert ampersand [&] between industries
      /**/  String amounts = "1mm/1kk/1hh/1ee/1bb/1b/1k & 0/5m/500 & 0/1k";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  COMMON LEVELS: enter researcher levels in hexadecimal, add a space in between industries
      /**/  String commons = "666652 6655 531";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  RARE CARDS: enter researcher levels in hexadecimal, add whitespaces as you see fit for organization
      /**/  String rares = "54 3 2 1";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  String time = "5h30m";
      /**/  int industry = 1;
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  boolean boost = true;
      /**/  boolean randomize = true;
      /**/  boolean resetResource = false;
      /**/  boolean print = true;
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      Event evt = new Event(eventName);
      
      if(evt.isValid()){
          
          String[][] amountsArr = Operations.parseAmounts(amounts);
          int[][] commonArr = Operations.parseCommons(commons);
          int[] rareArr = Operations.parseRares(rares);
          
          evt.calculateOffline(industry, amountsArr, commonArr, rareArr, new Time (time), boost, randomize, resetResource, print);
          
          // Add any additional calculations below using the same calculation methods.
          
      }

    }
}