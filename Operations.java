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
    
}