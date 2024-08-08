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
    
}