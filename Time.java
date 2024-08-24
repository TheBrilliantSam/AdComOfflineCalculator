import java.util.*;

public class Time{
    
    private int yrs;
    private int hrs;
    private int mins;
    private int secs;
    private int days;
    private String output;
    private boolean big;
    private BigNum bigSecs;
    
    public Time(int d, int h, int m, int s){
        yrs = 0;
        days = d;
        hrs = h;
        mins = m;
        secs = s;
        big = false;
        update();
    }
    
    public Time(int h, int m, int s){
        yrs = 0;
        days = 0;
        hrs = h;
        mins = m;
        secs = s;
        big = false;
        update();
    }
    
    public Time(int m, int s){
        yrs = 0;
        days = 0;
        hrs = 0;
        mins = m;
        secs = s;
        big = false;
        update();
    }
    
    public Time(int s){
        yrs = 0;
        days = 0;
        hrs = 0;
        mins = 0;
        secs = s;
        big = false;
        update();
    }
    
    public Time(BigNum s){
        bigSecs = s;
        int secondsInYear = 31557600;
        BigNum SIY = new BigNum(31557600);
        if(BigNum.divide(s, SIY).compareTo(new BigNum(2147483647)) == 1){
            BigNum years = BigNum.divide(s, new BigNum(secondsInYear));
            output = years.toString() + " years";
        } else if(s.compareTo(SIY) >= 0){
            BigNum years = BigNum.divide(s, new BigNum(secondsInYear));
            int y = (int)(years.toDouble());
            BigNum belowYears = BigNum.subtract(s, BigNum.multiply(new BigNum(secondsInYear), new BigNum(y)));
            int dhms = (int)(belowYears.toDouble());
            Time belYear = new Time(dhms + "s");
            yrs = y;
            output = y + "y" + belYear.toString();
        }
        big = true;
    }
    
    public Time(BigNum s, boolean b){
        bigSecs = s;
        int secondsInYear = 31557600;
        BigNum SIY = new BigNum(31557600);
        if(BigNum.divide(s, SIY).compareTo(new BigNum(2147483647)) == 1){
            BigNum years = BigNum.divide(s, new BigNum(secondsInYear));
            output = years.toString() + " years";
        } else if(s.compareTo(SIY) >= 0){
            BigNum years = BigNum.divide(s, new BigNum(secondsInYear));
            int y = (int)(years.toDouble());
            BigNum belowYears = BigNum.subtract(s, BigNum.multiply(new BigNum(secondsInYear), new BigNum(y)));
            int dhms = (int)(belowYears.toDouble());
            Time belYear = new Time(dhms + "s");
            yrs = y;
            output = y + "y" + belYear.toFullString();
        }
        big = true;
    }
    
    public Time(String input){
        input = input.replaceAll("\\s+", "");
        input = input.toLowerCase();
        if(input.substring(0, 1).matches("[a-z]")) input = "0" + input;
        big = false;
        yrs = 0;
        days = 0;
        hrs = 0;
        mins = 0;
        secs = 0;
        char[] validCharacters = {'y', 'd', 'h', 'm', 's'};
        String[] numbers = input.split("[a-z\\s]");
        String[] timeUnits = input.split("\\d+");
        List<String> theTimeUnits = new ArrayList<>();
        for (String str : timeUnits) {
            for (char ch : str.toCharArray()) {
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
            char timeUnit = unit[1].charAt(0);
            //System.out.println(unit[0] + unit[1]);
            if(Operations.isValidTimeUnit(timeUnit, validCharacters)){
                if(timeUnit == 'y') yrs += Integer.parseInt(unit[0]);
                if(timeUnit == 'd') days += Integer.parseInt(unit[0]);
                if(timeUnit == 'h') hrs += Integer.parseInt(unit[0]);
                if(timeUnit == 'm') mins += Integer.parseInt(unit[0]);
                if(timeUnit == 's') secs += Integer.parseInt(unit[0]);
            }
        }
        update();
        //System.out.println(toString() + " original");
        //System.out.println(getSecs());
        
        /*if(input.indexOf("d") == -1){
            days = 0;
            if(input.indexOf("h") == -1){
                hrs = 0;
                if(input.indexOf("m") == -1){
                    mins = 0;
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(0, input.indexOf("s")));
                    }
                } else{
                    mins = Integer.parseInt(input.substring(0, input.indexOf("m")));
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("m") + 1, input.indexOf("s")));
                    }
                }
            } else{
                hrs = Integer.parseInt(input.substring(0, input.indexOf("h")));
                if(input.indexOf("m") == -1){
                    mins = 0;
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("h") + 1, input.indexOf("s")));
                    }
                } else{
                    mins = Integer.parseInt(input.substring(input.indexOf("h") + 1, input.indexOf("m")));
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("m") + 1, input.indexOf("s")));
                    }
                }
            }
        } else{
            days = Integer.parseInt(input.substring(0, input.indexOf("d")));
            if(input.indexOf("h") == -1){
                hrs = 0;
                if(input.indexOf("m") == -1){
                    mins = 0;
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("d") + 1, input.indexOf("s")));
                    }
                } else{
                    mins = Integer.parseInt(input.substring(input.indexOf("d") + 1, input.indexOf("m")));
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("m") + 1, input.indexOf("s")));
                    }
                }
            } else{
                hrs = Integer.parseInt(input.substring(input.indexOf("d") + 1, input.indexOf("h")));
                if(input.indexOf("m") == -1){
                    mins = 0;
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("h") + 1, input.indexOf("s")));
                    }
                } else{
                    mins = Integer.parseInt(input.substring(input.indexOf("h") + 1, input.indexOf("m")));
                    if(input.indexOf("s") == -1){
                        secs = 0;
                    } else{
                        secs = Integer.parseInt(input.substring(input.indexOf("m") + 1, input.indexOf("s")));
                    }
                }
            }
        }*/
    }
    public BigNum getSecs(){
        if(big){
            return bigSecs;
        } else{
            BigNum y = BigNum.multiply(new BigNum(3.15576, 7), yrs);
            BigNum d = BigNum.multiply(new BigNum(8.64, 4), days);
            BigNum h = BigNum.multiply(new BigNum(3.6, 3), hrs);
            BigNum m = BigNum.multiply(new BigNum(6, 1), mins);
            BigNum ms = BigNum.add(m, new BigNum(secs, 0));
            BigNum hms = BigNum.add(ms, h);
            BigNum dhms = BigNum.add(hms, d);
            BigNum ydhms = BigNum.add(dhms, y);
            //System.out.println(ydhms);
            if(ydhms.compareTo(new BigNum(2147483647)) <= 0){
                ydhms = new BigNum(ydhms.toInteger());
            }
            return ydhms;
        }
    }
    
    public BigNum getSecsExceptYears(){
        if(big){
            return bigSecs;
        } else{
            //BigNum y = BigNum.multiply(new BigNum(3.15576, 7), yrs);
            BigNum d = BigNum.multiply(new BigNum(8.64, 4), days);
            BigNum h = BigNum.multiply(new BigNum(3.6, 3), hrs);
            BigNum m = BigNum.multiply(new BigNum(6, 1), mins);
            BigNum ms = BigNum.add(m, new BigNum(secs, 0));
            BigNum hms = BigNum.add(ms, h);
            BigNum dhms = BigNum.add(hms, d);
            //BigNum ydhms = BigNum.add(dhms, y);
            if(dhms.compareTo(new BigNum(2147483647)) <= 0){
                dhms = new BigNum(dhms.toInteger());
            }
            return dhms;
        }
    }
    
    public String toString(){
        if(output == null){
            //System.out.println(getSecs());
            if(getSecs().compareTo(new BigNum(1, 0)) == -1){
                return "Instant";
            } else{
                if(yrs == 0){
                    if(days == 0){
                        String ret = "" + hrs + "h";
                        if(mins < 10){
                            ret += "0";
                        }
                        ret += mins + "m";
                        if(secs < 10){
                            ret += "0";
                        }
                        ret += secs + "s";
                        return ret;
                    } else {
                        String ret = "" + days + "d";
                        if(hrs < 10){
                            ret += "0";
                        }
                        ret += hrs + "h";
                        if(mins < 10){
                            ret += "0";
                        }
                        ret += mins + "m";
                        if(secs < 10){
                            ret += "0";
                        }
                        ret += secs + "s";
                        return ret;
                    }
                } else{
                    String ret = "" + yrs + "y";
                    //if(days == 0) ret += "0";
                    if(days < 100){
                        ret += "0";
                    }
                    if(days < 10){
                        ret += "0";
                    }
                    ret += days + "d";
                    if(hrs < 10){
                        ret += "0";
                    }
                    ret += hrs + "h";
                    if(mins < 10){
                        ret += "0";
                    }
                    ret += mins + "m";
                    if(secs < 10){
                        ret += "0";
                    }
                    ret += secs + "s";
                    return ret;
                }
            }
        } else{
            return output;
        }
    }
    
    public String toFullString(){
        String ret = "";
        //if(days == 0) ret += "0";
        if(days < 100){
            ret += "0";
        }
        if(days < 10){
            ret += "0";
        }
        ret += days + "d";
        if(hrs < 10){
            ret += "0";
        }
        ret += hrs + "h";
        if(mins < 10){
            ret += "0";
        }
        ret += mins + "m";
        if(secs < 10){
            ret += "0";
        }
        ret += secs + "s";
        return ret;
    }
    
    public String toHourString(){
        String ret = "" + days + "d";
        ret += hrs + "h";
        return ret;
    }
    
    public int getHours(){
        return 24 * days + hrs;
    }
    
    public int compareTo(Time other){
        return getSecs().compareTo(other.getSecs());
    }
    
    public void update(){
        if((hrs >= 0 && hrs < 24) && (mins >= 0 && mins < 60) && (secs >= 0 && secs < 60) && (getSecsExceptYears().compareTo(new BigNum(31557600))) == -1){
            //System.out.println("in simplest form already: " + getSecs());
            return;
        }
        //System.out.println("pre update: " + getSecs());
        while (getSecsExceptYears().compareTo(new BigNum(31557600)) >= 0 && !big){
            yrs++;
            days-= 365;
            hrs -= 6;
        }
        while (hrs < 0){
            hrs++;
            mins -= 60;
        }
        while (mins < 0){
            mins++;
            secs -= 60;
        }
        while (hrs > 23){
            hrs -= 24;
            days++;
        }
        while (secs > 59){
            secs -= 60;
            mins++;
        }
        while (mins > 59){
            mins -= 60;
            hrs++;
        }
        while (hrs > 23){
            hrs -= 24;
            days++;
        }
        //System.out.println("post update: " + getSecs());
        //System.out.println("final: " + yrs + "y" + days + "d" + hrs + "h" + mins + "m" + secs + "s");
    }
}