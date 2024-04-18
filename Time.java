public class Time{
    private int hrs;
    private int mins;
    private int secs;
    private int days;
    public Time(int d, int h, int m, int s){
        days = d;
        hrs = h;
        mins = m;
        secs = s;
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
    public Time(String input){
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
    public int getSecs(){
        return hrs * 3600 + mins * 60 + secs;
    }
    public String toString(){
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