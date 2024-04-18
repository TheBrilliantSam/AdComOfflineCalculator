import java.util.*;
public class SVSResearcher extends Researcher{
    public SVSResearcher(double none, ArrayList<Integer> ind){
        super("crit", none, -1, -1, ind);
    }
    public double getBoost(){
        int lvl = super.getLvl();
        if(lvl != 0){
            return ((int)(Math.pow(4, lvl)) + (5 * lvl * lvl)) * super.getNone();
        } else{
            return super.getInit();
        }
    }
}