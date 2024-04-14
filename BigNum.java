public class BigNum{
    
    private double amount;
    private int exponent;
    
    public BigNum(double x, int exp){
        amount = x;
        exponent = exp;
        this.update();
    }
    
    public BigNum(AdComNum value){
        String input = value.toString();
        amount = value.getValue();
        String suffix = "";
        int indx = 0;
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch >= 65 && ch <= 90){
                suffix += "" + ch;
            } else if(ch >= 97 && ch <= 122){
                suffix += "" + (char)(ch - 32);
            }
        }
        if(suffix.length() == 0){
            exponent = 0;
        } else if(suffix.length() == 1){
            if(suffix.equals("K")){
                exponent = 3;
            }
            if(suffix.equals("M")){
                exponent = 6;
            }
            if(suffix.equals("B")){
                exponent = 9;
            }
            if(suffix.equals("T")){
                exponent = 12;
            }
        } else{
            exponent = ((suffix.length() - 2) * 78) + (((int)(suffix.charAt(0)) - 65) * 3) + 15;
        }
    
        this.update();
    }
    
    public BigNum(String input){
        String digits = "";
        String suffix = "";
        int indx = 0;
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if((ch >= 46 && ch <= 57) && (ch != 47)){
                digits += "" + ch;
            } else if(ch >= 65 && ch <= 90){
                suffix += "" + ch;
            } else if(ch >= 97 && ch <= 122){
                suffix += "" + (char)(ch - 32);
            }
        }
        amount = Double.parseDouble(digits);
        if(suffix.length() == 0){
            exponent = 0;
        } else if(suffix.length() == 1){
            if(suffix.equals("K")){
                exponent = 3;
            }
            if(suffix.equals("M")){
                exponent = 6;
            }
            if(suffix.equals("B")){
                exponent = 9;
            }
            if(suffix.equals("T")){
                exponent = 12;
            }
        } else{
            exponent = ((suffix.length() - 2) * 78) + (((int)(suffix.charAt(0)) - 65) * 3) + 15;
        }
    
        this.update();
    }
    
    public double getX(){
        return amount;
    }
    
    public int getEXP(){
        return exponent;
    }
    
    public void update(){
        if(amount != 0){
            while(amount >= 10.0){
                amount /= 10;
                exponent++;
            }
            while(amount < 1.0){
                amount *= 10;
                exponent--;
            }
        } else{
            exponent = 0;
        }
    }
    
    public static BigNum add(BigNum d1, BigNum d2){
        int lowerExp = Math.min(d1.getEXP(), d2.getEXP());
        double v1 = d1.getX();
        v1 *= Math.pow(10, d1.getEXP() - lowerExp);
        double v2 = d2.getX();
        v2 *= Math.pow(10, d2.getEXP() - lowerExp);
        BigNum result = new BigNum(v1 + v2, lowerExp);
        return result;
    }
    
    public static BigNum multiply(BigNum d1, BigNum d2){
        BigNum result = new BigNum(d1.getX() * d2.getX(), d1.getEXP() + d2.getEXP());
        return result;
    }
    
    public static BigNum multiply(BigNum d1, double x){
        BigNum result = new BigNum(d1.getX() * x, d1.getEXP());
        return result;
    }
    
    public static BigNum multiply(BigNum d1, BigNum d2, BigNum d3){
        BigNum result = new BigNum(d1.getX() * d2.getX() * d3.getX(), d1.getEXP() + d2.getEXP() + d3.getEXP());
        return result;
    }
    
    public static BigNum multiply(BigNum d1, BigNum d2, double x){
        BigNum result = new BigNum(d1.getX() * d2.getX() * x, d1.getEXP() + d2.getEXP());
        return result;
    }
    
    public static BigNum divide(BigNum d1, BigNum d2){
        BigNum result = new BigNum(d1.getX() / d2.getX(), d1.getEXP() - d2.getEXP());
        return result;
    }
    
    public String toString(){
        String res = amount + "E";
        if(exponent >= 0){
            res+= "+";
        }
        res+=exponent;
        return res;
    }
    
}