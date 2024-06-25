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
      /**/  String eventName = "Motherland";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  GENERATOR AMOUNTS: enter resource amount followed by generators separated by a slash [/]; insert ampersand [&] between industries
      /**/  String amounts = "0/1mmmm/1ffff/1zzz/1sss/1lll/1fff/1yy/1ss/1ll/1ff/1t";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  COMMON LEVELS: enter researcher levels in hexadecimal, add a space in between industries
      /**/  String commons = "ccccccbbbbc ccbbbbbbbbc bbbbbbbbbbb cccbbbbbbbb bbbbbbbbbaa";
      ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  RARE CARDS: enter researcher levels in hexadecimal, add whitespaces or symbols as you see fit for organization
      /**/  String rares = "bbbb babb b9ab babb babb / 78 78 78 88 88 / 55455";
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