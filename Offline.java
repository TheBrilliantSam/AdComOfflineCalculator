// Currently supported balances: All AdCom events and All AdAges events!

// Entering amounts is not case sensitive, but please use the dot decimal point (.) for tenths and beyond (parser ignores commas).
// Always make sure the number of generators in amounts ≥ number of generators in commons > 0 before attempting a calculation

import java.util.*;
public class Offline {
    public static void main(String args[]) {

      ///////////////////////////
      ////  USER INPUT AREA  ////
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      /**/  String eventName = "crusade";
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  GENERATOR AMOUNTS: enter RESOURCE AMOUNT followed by generators separated by a slash [/]; insert ampersand [&] between industries
      /**/  String amounts = "0/60.47jj/2.48hh/173.86ee/11.15cc/2.65aa/1.23b & 0/134.93ff/665.65cc/6.15aa/345.72m/327 & 0/4.02dd/13.38aa/83.21m/117";
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  COMMON LEVELS: enter researcher levels in hexadecimal, add a space in between industries
      /**/  String commons = "555655 66654 5664";
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  RARE CARDS: enter researcher levels in hexadecimal, add whitespaces or symbols as you see fit for organization
      /**/  String rares = "444 / 344";
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  CALCULATE FOR A DURATION OF TIME
      /**/  boolean timeCalculationEnabled = false;
      /**/  String time = "3h45m12s";
      /**/  int industry = 0; // enter 0 for all industries
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  CALCULATE UNTIL A MISSION COMPLETES
      /**/  boolean missionCalculationEnabled = true;
      /**/  int targetIndustry = 3;
      /**/  String targetAmount = "1.8 GG"; // how many of the resource
      /**/  boolean printAllIndustries = true; // target industry is printed by default, but you can choose to print all industries in addition
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      ////  GLOBAL SETTINGS
      /**/  boolean boost = true;
      /**/  boolean randomize = true;
      /**/  boolean resetResource = false;
      /**/  boolean print = true;
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      Event evt = new Event(eventName);
      
      if(evt.isValid()){
          
          String[][] amountsArr = Operations.parseAmounts(amounts);
          int[][] commonArr = Operations.parseCommons(commons);
          int[] rareArr = Operations.parseRares(rares);
          
          if(timeCalculationEnabled) evt.calculateOffline(industry, amountsArr, commonArr, rareArr, new Time (time), boost, randomize, resetResource, print);
          
          if(missionCalculationEnabled) evt.calculateOffline(targetAmount, targetIndustry, amountsArr, commonArr, rareArr, boost, randomize, resetResource, print, printAllIndustries);
          
          /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          //  CALCULATION METHODS GUIDE
          /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          //  calculateOffline(int ind, String[][] amounts, int[][] commons, int[] rares, Time dur, boolean boost, boolean rand, boolean reset, boolean print);
          //  offlineUntilResource(String tarAmm, int tarInd, String[][] amounts, int[][] commons, int[] rares, boolean boost, boolean rand, boolean reset, boolean print, boolean printAll)
          /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          // Add any additional calculations below.
          
          
          
          
     
      }

    }
}