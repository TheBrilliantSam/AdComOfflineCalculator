public class Researcher{
    
    private String upgrade;
    private int initial;
    private int multiplier;
    private int industry;
    private int level;
    
    public Researcher(String upg, int init, int mult, int ind){
        upgrade = upg;
        initial = init;
        multiplier = mult;
        industry = ind;
        level = 0;
    }
    
    public void setLvl(int x){
        level = x;
    }
    
    public int getBoost(){
        return initial * (int)(Math.pow(multiplier, level - 1));
    }
    
    public int getInd(){
        return industry;
    }
    
    public int getLvl(){
        return level;
    }
    
    public String getUp(){
        return upgrade;
    }
    
}