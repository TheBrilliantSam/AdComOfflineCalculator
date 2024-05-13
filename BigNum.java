public class BigNum{
    
    private double amount;
    private int exponent;
    
    public BigNum(double x, int exp){
        amount = x;
        exponent = exp;
        this.update();
    }
    
    public BigNum(AdComNum value){
        String disp = value.toString();
        String components[] = disp.split(" ");
        String suffix = "";
        amount = value.getValue();
        if(components.length < 2){
            exponent = 0;
        } else{
            suffix = components[1];
            if(suffix.length() == 1){
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
        }
    
        this.update();
    }
    
    public BigNum(double d){
        amount = d;
        exponent = 0;
        this.update();
    }
    
    public BigNum(String input){
        if(input.length() == 0){
            amount = 0.0;
            exponent = 0;
        } else{
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
        }
    
        this.update();
    }
    
    public boolean isMoreThanOne(){
        if(exponent > 0){
            return true;
        } else if(exponent == 0 && amount > 1){
            return true;
        } else{
            return false;
        }
    }
    
    public boolean isNotZero(){
        if(exponent == 0 && amount == 0){
            return false;
        } else{
            return true;
        }
    }
    
    public boolean compareTo(double d){
        BigNum input = new BigNum(d);
        if(exponent > input.getEXP()){
            return true;
        } else if(exponent == input.getEXP()){
            if(amount > input.getX()){
                return true;
            } else{
                return false;
            }
        } else{
            return false;
        }
    }
    
    public double toDouble(){
        return amount * Math.pow(10, exponent);
    }
    
    public double getX(){
        return amount;
    }
    
    public int getEXP(){
        return exponent;
    }
    
    public int intVal(){
        return (int)(amount * (Math.pow(10, exponent)));
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
    
    public static BigNum add(BigNum d1, double x){
        x *= Math.pow(10, d1.getEXP());
        BigNum result = new BigNum(d1.getX() + x, d1.getEXP());
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
    
    public static BigNum multiply(BigNum d1, int x, int y){
        BigNum result = new BigNum(d1.getX() * x * y, d1.getEXP());
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
    
    public static BigNum divide(BigNum d1, double x){
        BigNum result = new BigNum(d1.getX() / x, d1.getEXP());
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