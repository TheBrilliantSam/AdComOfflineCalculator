import java.util.*;

public class Operations{
    
    public static String removeDecimals (double d){
        String s = "" + d;
        String arr[] = s.split("\\."); // Since d is a double, there will always be a decimal point
        if(Math.abs(d - Integer.parseInt(arr[0])) < 0.001){
            return arr[0];
        } else{
            return "" + (int)(Math.round(d * 100)) / 100.0;
        }
    }
    
    public static String[][] parseAmounts(String s){
        String[] arr = s.split("&");
        String[][] finalArr = new String[arr.length][];
        for(int ind = 0; ind < arr.length; ind++){
            String[] industry = arr[ind].split("/");
            finalArr[ind] = new String[industry.length];
            for(int gen = 0; gen < industry.length; gen++){
                finalArr[ind][gen] = industry[gen];
                finalArr[ind][gen] = finalArr[ind][gen].trim();
            }
            //System.out.println(Arrays.toString(finalArr[ind]));
        }
        return finalArr;
    }
    
    public static int[][] parseCommons(String s){
        String[] arr = s.split(" ");
        /*while(arr[0] == ""){
            String[] newArr = new String[arr.length - 1];
            for(int i = 1; i < arr.length; i++){
                newArr[i - 1] = arr[i];
            }
            arr = newArr;
        }*/
        int[][] finalArr = new int[arr.length][];
        for(int ind = 0; ind < arr.length; ind++){
            finalArr[ind] = new int[arr[ind].length()];
            for(int gen = 0; gen < arr[ind].length(); gen++){
                finalArr[ind][gen] = Integer.parseInt(arr[ind].substring(gen, gen + 1), 36);
            }
            //System.out.println(Arrays.toString(finalArr[ind]));
        }
        return finalArr;
    }
    
    public static int[] parseRares(String str){
        str = str.replaceAll("\\s+","");
        str = str.toUpperCase();
        String s = "";
        for(int i = 0; i < str.length(); i++){
            if((str.charAt(i) >= 48 && str.charAt(i) <= 57) || (str.charAt(i) >= 65 && str.charAt(i) <= 90)){
                s += "" + str.charAt(i);
            }
        }
        int[] finalArr = new int[s.length()];
        for(int card = 0; card < finalArr.length; card++){
                finalArr[card] = Integer.parseInt(s.substring(card, card + 1), 36);
        }
        //System.out.println(Arrays.toString(finalArr));
        return finalArr;
    }
    
    public static Time[] parseTimes(String str){
        String[] arr = str.split(";");
        Time[] ret = new Time[arr.length];
        for(int i = 0; i < arr.length; i++){
            ret[i] = new Time(arr[i]);
        }
        return ret;
    }
    
    public static ACNandInteger[][] parseTargets(String str){
        String[] arr = str.split(";");
        ACNandInteger[][] ret = new ACNandInteger[arr.length][];
        for(int i = 0; i < arr.length; i++){
            String[] concurrent = arr[i].split("&");
            ret[i] = new ACNandInteger[concurrent.length];
            for(int j = 0; j < concurrent.length; j++){
                String startSubstr = concurrent[j].substring(0, concurrent[j].indexOf("-"));
                String endSubstr = concurrent[j].substring(concurrent[j].indexOf("-") + 1).trim();
                BigNum bigNumValue = new BigNum(endSubstr);
                int intValue = Integer.parseInt(startSubstr);
                AdComNum adComNumValue = new AdComNum(bigNumValue);
                ret[i][j] = new ACNandInteger(adComNumValue, intValue);
            }
        }
        return ret;
    }
    
    public static boolean determineTimeValidity(String str){
        ArrayList<Integer> strikes = new ArrayList<Integer>();
        strikes.add(0);
        String[] messages = {"Your calculation could not be completed.", "SPECIAL CHARACTERS DETECTED.", "TIME UNIT OVERFLOW.", "INVALID TIME UNIT."};
        String[] messages2 = {"There was one or more error with your time format.", "Only alphanumeric characters and whitespaces are accepted.", "No sum of a time units should reach or exceed 2^31.", "Only these units are accepted: y, d, h, m, s."};
        String[] arr = str.split(";");
        //Time[] ret = new Time[arr.length];
        for(String input : arr){
            if(input.length() > 0){
                if(!isAlphanumericOrWhitespace(input)) strikes.add(1);
                input = input.replaceAll("\\s+", "");
                input = input.toLowerCase();
                if(!Character.isDigit(input.charAt(0))) input = "0" + input;
                char[] validCharacters = {'y', 'd', 'h', 'm', 's'};
                BigNum yrs = new BigNum(0);
                BigNum days = new BigNum(0);
                BigNum hrs = new BigNum(0);
                BigNum mins = new BigNum(0);
                BigNum secs = new BigNum(0);
                String[] numbers = input.split("[^\\d]");
                String[] timeUnits = input.split("\\d+");
                List<String> theTimeUnits = new ArrayList<>();
                for (String strng : timeUnits) {
                    for (char ch : strng.toCharArray()) {
                        theTimeUnits.add(String.valueOf(ch));
                    }
                }
                String[] finalTimeUnits = theTimeUnits.toArray(new String[0]);
                //System.out.println(Arrays.toString(numbers));
                //System.out.println(Arrays.toString(finalTimeUnits));
                String[][] numWithTime = new String[numbers.length][2];
                for(int i = 0; i < numbers.length; i++){
                    numWithTime[i][0] = numbers[i];
                    numWithTime[i][1] = finalTimeUnits[i];
                }
                //System.out.println(numWithTime.length);
                for(String[] unit : numWithTime){
                    //System.out.println(unit[0] + unit[1]);
                    char timeUnit = unit[1].charAt(0);
                    if(!isValidTimeUnit(timeUnit, validCharacters)){
                        strikes.add(3);
                    } else{
                        if(timeUnit == 'y') yrs = BigNum.add(yrs, new BigNum(unit[0]));
                        if(timeUnit == 'd') days = BigNum.add(days, new BigNum(unit[0]));
                        if(timeUnit == 'h') hrs = BigNum.add(hrs, new BigNum(unit[0]));
                        if(timeUnit == 'm') mins = BigNum.add(mins, new BigNum(unit[0]));
                        if(timeUnit == 's') secs = BigNum.add(secs, new BigNum(unit[0]));
                    }
                    
                }
                if(yrs.compareTo(new BigNum(2147483647)) == 1) strikes.add(2);
                if(days.compareTo(new BigNum(2147483647)) == 1) strikes.add(2);
                if(hrs.compareTo(new BigNum(2147483647)) == 1) strikes.add(2);
                if(mins.compareTo(new BigNum(2147483647)) == 1) strikes.add(2);
                if(secs.compareTo(new BigNum(2147483647)) == 1) strikes.add(2);
            }
        }
        if(strikes.size() == 1){
            return true;
        } else{
            for (int i = 0; i < messages.length; i++){
                if(strikes.contains(i)) System.out.println(messages[i] + "\n" + messages2[i] + "\n");
            }
            return false;
        }
    }
    
    /*public static int findBestNextGuess(int current, int max, int min, String descriptor){
        if(descriptor.equals("higher")){
            if(max == Integer.MAX_VALUE){
                return current * 2;
            } else{
                return (int)Math.round((current + max) / 2.0);
            }
        } else if(descriptor.equals("lower")){
            return (int)Math.round((current + min) / 2.0);
        } else{
            return 0;
        }
    }*/
    
    public static BigNum findBestNextGuess(BigNum current, BigNum max, BigNum min, String descriptor){
        if(descriptor.equals("higher")){
            if(max.compareTo(new BigNum(9.99, 2147483647)) == 0){
                return BigNum.multiply(current, 2);
            } else{
                return BigNum.divide((BigNum.add(current, max)), 2);
            }
        } else if(descriptor.equals("lower")){
            return BigNum.divide((BigNum.add(current, min)), 2);
        } else{
            return new BigNum(0);
        }
    }
    
    public static boolean isValidTimeUnit(char c, char[] valid){
        for(char ch : valid){
            if(ch == c || !Character.isLetter(c)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isAlphanumericOrWhitespace(String input) {
        // Iterate through each character in the string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // Check if the character is not alphanumeric and not whitespace
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                return false; // Return false if any character is not valid
            }
        }
        // Return true if all characters are alphanumeric or whitespace
        return true;
    }
    
}