import java.util.*;

public class Researcher{
    
    private String upgrade;
    private double none;
    private double initial;
    private double multiplier;
    private ArrayList<Integer> industry;
    private int level;
    
    public Researcher(String upg, double none, double init, double mult, ArrayList<Integer> ind){
        this.none = none;
        upgrade = upg;
        initial = init;
        multiplier = mult;
        industry = ind;
        level = 0;
    }
    
    public void setLvl(int x){
        level = x;
    }
    
    public double getBoost(){
        if(upgrade.equals("prod")){
            if(level > 0){
                return initial * (int)(Math.pow(multiplier, level - 1));
            } else{
                return none;
            }
        } else if(upgrade.equals("crit")){
            if(level > 0){
                return none * initial * (int)(Math.pow(multiplier, level - 1));
            } else{
                return none;
            }
        } else if(upgrade.equals("luck")){ // EXCEPTION: INIT IS ADDED TO EVERY LEVEL, MULT IS BONUS BOOST, SUCH AS IN MINIS
            double bonus = 0;
            for(int i = level; i > 1; i--){
                bonus += ((i - 1) * multiplier);
            }
            //System.out.println(bonus);
            return none + initial * level + bonus;
        } else{
            return -1;
        }
    }
    
    public ArrayList<Integer> getInd(){
        return industry;
    }
    
    public boolean thisIndustry(int x){
        return industry.contains(x);
    }
    
    public int getLvl(){
        return level;
    }
    
    public String getUp(){
        return upgrade;
    }
    
}