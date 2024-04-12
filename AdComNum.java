public class AdComNum{
    
    private double value;
    private String suffix;
    
    public AdComNum(BigNum number){
        double amount = number.getX();
        int exp = number.getEXP();
        while(exp % 3 != 0){
            amount *= 10;
            exp--;
        }
        int ascii = exp / 3;
        switch(ascii){
            case 0:
                suffix = "";
                break;
            case 1:
                suffix = "K";
                break;
            case 2:
                suffix = "M";
                break;
            case 3:
                suffix = "B";
                break;
            case 4:
                suffix = "T";
                break;
            default:
                suffix = "";
                break;
        }
        if(ascii > 4){
            ascii -= 5;
            int times = ascii / 26;
            times += 2;
            ascii = ascii % 26;
            char letter = (char)(65 + ascii);
            for(int i = 0; i < times; i++){
                suffix += "" + letter;
            }
        }
        value = amount;
    }
    
    public String toString(){
        String val = "" + ((Math.round(value * 100)) / 100.0);
        String arr[] = val.split("\\."); // Since value is a double, there will always be a decimal point
        while(arr[1].length() < 2){
            val += "0";
            arr[1] += "0"; // If there aren't two digits after the decimal, add zeroes in their place.
        }
        return val + " " + suffix;
    }
    
    public double getValue(){
        return value;
    }
    
}