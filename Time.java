public class Time{
    private int hrs;
    private int mins;
    private int secs;
    public Time(int h, int m, int s){
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
    }
    public int getSecs(){
        return hrs * 3600 + mins * 60 + secs;
    }
    public String toString(){
        return "" + hrs + "h" + mins + "m" + secs + "s";
    }
}