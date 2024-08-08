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
    private boolean hidden;
    
    public Researcher(String upg, double none, double init, double mult, ArrayList<Integer> ind){
        this.none = none;
        upgrade = upg;
        initial = init;
        multiplier = mult;
        industry = ind;
        level = 0;
        override = new int[] {};
        difference = 0;
        hidden = false;
    }
    
    public Researcher(String upg, double none, double init, double mult, ArrayList<Integer> ind, boolean hide){
        this.none = none;
        upgrade = upg;
        initial = init;
        multiplier = mult;
        industry = ind;
        level = 0;
        override = new int[] {};
        difference = 0;
        hidden = hide;
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
        hidden = false;
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
        hidden = false;
    }
    
    public void setLvl(int x){
        level = x;
    }
    
    public BigNum getBoost(){
        if(override.length == 0){
            if(upgrade.equals("prod") || upgrade.equals("single prod") || upgrade.equals("crit") || upgrade.equals("com") || upgrade.equals("discount")){
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
    
    public String toString(int index){
        if(hidden){
            return "";
        } else{
            int currentLevel = level;
            String ret = "RS" + index + " - ";
            if(industry.size() > 1){
                ret += "Global ";
            } else{
                ret += "Ind " + industry.get(0) + " ";
            }
            switch(upgrade){
                case "prod":
                    ret += "Production: ";
                    break;
                case "crit":
                    ret += "Crit Bonus: ";
                    break;
                case "luck":
                    ret += "Luck: ";
                    break;
                case "com":
                    ret += "Trade: ";
                    break;
                case "single prod":
                    ret += "Single Production: ";
                    break;
                case "discount":
                    ret += "Discount: ";
                    break;
                default:
                    ret += "";
                    break;
            }
            for(int i = 1; i <= 4; i++){
                switch(upgrade){
                    case "prod":
                        ret += "x";
                        break;
                    case "crit":
                        ret += "x";
                        break;
                    case "luck":
                        ret += "";
                        break;
                    case "com":
                        ret += "x";
                        break;
                    case "single prod":
                        ret += "x";
                        break;
                    case "discount":
                        ret += "x";
                        break;
                    default:
                        ret += "";
                        break;
                }
                level = i;
                if(upgrade.equals("luck")){
                    ret += Operations.removeDecimals(getBoost().toDouble() * 100) + "%";
                } else if(upgrade.equals("crit")){
                    ret += Operations.removeDecimals(BigNum.divide(getBoost(), none).toDouble());
                } else{
                    ret += (int)(getBoost().toDouble());
                }
                if(i != 4) ret += ", ";
            }
            level = currentLevel;
            ret += "...";
            return ret;
        }
    }
    
}