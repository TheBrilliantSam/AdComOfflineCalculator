public class AdComNumShort extends AdComNum{
    
    public AdComNumShort(BigNum number){
        super(number);
    }
    
    public String toString(){
        String val = "";
        if(super.getSuffix().length() > 0){
            val = "" + ((Math.round(super.getValue() * 100)) / 100.0);
            String arr[] = val.split("\\."); // Since value is a double, there will always be a decimal point
            boolean integer = false;
            if(Math.abs(Integer.parseInt(arr[1])) < 0.001){
                    val = arr[0];
                    integer = true;
            }
            if(val.length() > 4 && integer == false){
                val = val.substring(0, 4);
                if(val.indexOf(".") == 3){
                    val = val.substring(0, 3);
                }
            } else if(val.length() > 3 && integer == true){
                val = val.substring(0, 3);
            }
            if(super.getSuffix().length() < 2){
                return val + "" + super.getSuffix();
            } else{
                return val + " " + super.getSuffix();
            }
        } else if(super.getValue() >= 10000.0){
            super.setValue(super.getValue() / 1000);
            super.setSuffix("K");
            val = "" + ((Math.round(super.getValue() * 100)) / 100.0);
            String arr[] = val.split("\\."); // Since value is a double, there will always be a decimal point
            if(Math.abs(Integer.parseInt(arr[1])) < 0.001){
                val = arr[0];
            }
            if(val.length() > 4){
                val = val.substring(0, 4);
            }
            if(val.indexOf(".") == 3){
                val = val.substring(0, 3);
            }
            return val + "" + super.getSuffix();
        } else{
            val = "" + (int)(Math.round(super.getValue()));
            if(val.length() > 3){
                val = val.substring(0, val.length() - 3) + "," + val.substring(val.length() - 3, val.length());
            }
            return val;
        }
    }
    
    public String toDecimalString(){
        String val = "";
        if(super.getSuffix().length() > 0){
            val = "" + ((Math.round(super.getValue() * 100)) / 100.0);
            String arr[] = val.split("\\."); // Since value is a double, there will always be a decimal point
            boolean integer = false;
            if(Math.abs(Integer.parseInt(arr[1])) < 0.001){
                    val = arr[0];
                    integer = true;
            }
            if(val.length() > 4 && integer == false){
                val = val.substring(0, 4);
                if(val.indexOf(".") == 3){
                    val = val.substring(0, 3);
                }
            } else if(val.length() > 3 && integer == true){
                val = val.substring(0, 3);
            }
            if(super.getSuffix().length() < 2){
                return val + "" + super.getSuffix();
            } else{
                return val + " " + super.getSuffix();
            }
        } else if(super.getValue() >= 10000.0){
            super.setValue(super.getValue() / 1000);
            super.setSuffix("K");
            val = "" + ((Math.round(super.getValue() * 100)) / 100.0);
            String arr[] = val.split("\\."); // Since value is a double, there will always be a decimal point
            if(Math.abs(Integer.parseInt(arr[1])) < 0.001){
                val = arr[0];
            }
            if(val.length() > 4){
                val = val.substring(0, 4);
            }
            if(val.indexOf(".") == 3){
                val = val.substring(0, 3);
            }
            return val + "" + super.getSuffix();
        } else if(super.getValue() >= 1000){
            String intgr = "" + new BigNum(super.getValue()).toInteger();
            if(intgr.length() > 3){
                intgr = intgr.substring(0, intgr.length() - 3) + "," + intgr.substring(intgr.length() - 3, intgr.length());
            }
            return intgr;
        } else{
            String result = "";
            BigNum number = new BigNum(super.getValue());
            //System.out.println(number);
            if(number.getEXP() == 0){
                result += number.roundX(3);
                for(int i = ("" + number.roundX(3)).length(); i < 5; i++){
                    result += "0";
                }
                if(result.length() > 5){
                    result = result.substring(0, 5);
                }
            } else if(number.getEXP() == 1){
                result += number.roundX(2) * 10;
                for(int i = ("" + number.roundX(2) * 10).length(); i < 5; i++){
                    result += "0";
                }
                if(result.length() > 5){
                    result = result.substring(0, 5);
                }
            } else if(number.getEXP() == 2){
                result += number.roundX(1) * 100;
                for(int i = ("" + number.roundX(1) * 100).length(); i < 5; i++){
                    result += "0";
                }
                if(result.length() > 5){
                    result = result.substring(0, 5);
                }
            }
            return result;
        }
    }
    
}