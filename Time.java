public class Time{
    
    private int hrs;
    private int mins;
    private int secs;
    private int days;
    private String output;
    private boolean big;
    private BigNum bigSecs;
    
    public Time(int d, int h, int m, int s){
        days = d;
        hrs = h;
        mins = m;
        secs = s;
        big = false;
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
    }
    
    public Time(int h, int m, int s){
        days = 0;
        hrs = h;
        mins = m;
        secs = s;
        big = false;
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
    }
    
    public Time(int m, int s){
        days = 0;
        hrs = 0;
        mins = m;
        secs = s;
        big = false;
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
    }
    
    public Time(int s){
        days = 0;
        hrs = 0;
        mins = 0;
        secs = s;
        big = false;
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
    }
    
    public Time(BigNum s){
        bigSecs = s;
        if(s.getEXP() > 15){
            BigNum years = BigNum.divide(s, new BigNum(31557600));
            output = years.toString() + " years";
        } else if(s.getEXP() > 8){
            BigNum years = BigNum.divide(s, new BigNum(31557600));
            int y = (int)(years.toDouble());
            BigNum belowYears = BigNum.subtract(s, BigNum.multiply(new BigNum(31557600), new BigNum(y)));
            int dhms = (int)(belowYears.toDouble());
            Time belYear = new Time(dhms + "s");
            output = y + "y" + belYear.toString();
        }
    }
    
    public Time(String input){
        big = false;
        input = input.toLowerCase();
        if(input.indexOf("d") == -1){
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
    }
    public BigNum getSecs(){
        if(big){
            return bigSecs;
        } else{
            BigNum d = BigNum.multiply(new BigNum(8.64, 4), days);
            BigNum h = BigNum.multiply(new BigNum(3.6, 3), hrs);
            BigNum m = BigNum.multiply(new BigNum(6, 1), mins);
            BigNum ms = BigNum.add(m, new BigNum(secs, 0));
            BigNum hms = BigNum.add(ms, h);
            BigNum dhms = BigNum.add(hms, d);
            return dhms;
        }
    }
    public String toString(){
        if(output == null){
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
            return output;
        }
    }
    
    public String toHourString(){
        String ret = "" + days + "d";
        ret += hrs + "h";
        return ret;
    }
    
    public int getHours(){
        return 24 * days + hrs;
    }
}