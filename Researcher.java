import java.util.*;

public class Researcher{
    
    private String upgrade;
    private double none;
    private double initial;
    private double multiplier;
    private ArrayList<Integer> industry;
    private int level;
    private double difference;
    private int[] override;
    
    public Researcher(String upg, double none, double init, double mult, ArrayList<Integer> ind){
        this.none = none;
        upgrade = upg;
        initial = init;
        multiplier = mult;
        industry = ind;
        level = 0;
        override = new int[] {};
        difference = 0;
    }
    
    public Researcher(String upg, double none, int[] ovrd, ArrayList<Integer> ind){
        this.none = none;
        upgrade = upg;
        override = ovrd;
        industry = ind;
        level = 0;
        initial = 1;
        multiplier = 1;
        difference = 0;
    }
    
    public Researcher(String upg, double none, double init, double diff, double mult, ArrayList<Integer> ind){
        this.none = none;
        upgrade = upg;
        initial = init;
        multiplier = mult;
        difference = diff;
        industry = ind;
        level = 0;
        override = new int[] {};
    }
    
    public void setLvl(int x){
        level = x;
    }
    
    public BigNum getBoost(){
        if(override.length == 0){
            if(upgrade.equals("prod") || upgrade.equals("single prod")){
                BigNum ret = new BigNum(none, 0);
                if(level > 0){
                    ret = BigNum.multiply(ret, initial);
                    for(int i = 1; i < level; i++){
                        ret = BigNum.multiply(ret, multiplier);
                    }
                } 
                return ret;
            } else if(upgrade.equals("crit")){
                BigNum ret = new BigNum(none, 0);
                if(level > 0){
                    ret = BigNum.multiply(ret, initial);
                    for(int i = 1; i < level; i++){
                        ret = BigNum.multiply(ret, multiplier);
                    }
                } 
                return ret;
            } else if(upgrade.equals("luck")){ // EXCEPTION: INIT IS ADDED TO EVERY LEVEL, MULT IS BONUS BOOST, SUCH AS IN MINIS
                if(difference == 0){
                    double bonus = 0;
                    for(int i = level; i > 1; i--){
                        bonus += ((i - 1) * multiplier);
                    }
                    //System.out.println(bonus);
                    return new BigNum(none + initial * level + bonus, 0);
                } else if(difference != 0 && level > 0){
                    double bonus = 0;
                    for(int i = level - 1; i > 1; i--){
                        bonus += ((i - 1) * multiplier);
                    }
                    //System.out.println(bonus);
                    return new BigNum(none + initial + difference * (level - 1) + bonus, 0);
                } else{
                    return new BigNum(none, 0);
                }
            } else{
                return new BigNum(0, 0);
            }
        } else{
            if(level < override.length){
                if(upgrade.equals("luck")){
                    return new BigNum(override[level] + none, 0);
                } else{
                    return new BigNum(override[level] * none, 0);
                }
            } else{
                System.out.println("ERROR: ONE OR MORE RARE RESEARCHERS ARE ABOVE MAX LEVEL");
                return new BigNum(0, 0);
            }
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
    
    public double getInit(){
        return initial;
    }
    
    public double getNone(){
        return none;
    }
    
}