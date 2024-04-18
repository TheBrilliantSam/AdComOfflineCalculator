import java.util.*;
public class Generator{
    private int baseProd;
    private int baseTime;
    private int initCommon;
    private int commonMult;
    public Generator(int bp, int bt, int ic, int cm){
        baseProd = bp;
        baseTime = bt;
        initCommon = ic;
        commonMult = cm;
    }
    
    public BNandBool production(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, boolean boost, int ind, Time dur){
        double prodBoost = 1.0;
        double luckChance = 0.0;
        double critAmt = 1.0;
        double result = 0.0;
        BigNum ret;
        for(Researcher r : rsch){
            if(r.getUp().equals("prod") && r.thisIndustry(ind)){
                prodBoost *= r.getBoost();
                //System.out.println(prodBoost);
            }
            if(r.getUp().equals("crit") && r.thisIndustry(ind)){
                critAmt *= r.getBoost();
            }
            if(r.getUp().equals("luck") && r.thisIndustry(ind)){
                luckChance += r.getBoost();
            }
        }
        
        if(boost){
            prodBoost *= 2;
            //System.out.println(prodBoost);
        }
        
        int runs = 0;
        boolean randomized = false;
        //System.out.println(prodBoost + " " + luckChance + " " + critAmt);
        double time = baseTime;
        if(commonLvl != 0){
            time /= getSpeedBoost(commonLvl);
            //System.out.println(initCommon * (int)(Math.pow(commonMult, commonLvl - 1)));
            //System.out.println(baseTime + " -> " + time);
            runs = (int)(dur.getSecs() * 1.0 / time);
            //System.out.println(runs);
            if(runs < 500 && (luckChance != 0 && critAmt > 1)){
                randomized = true;
                int crits = 0;
                result = (baseProd * prodBoost);
                for(int i = 0; i < runs; i++){
                    if(Math.random() < luckChance){
                        crits++;
                    }
                }
                result = (result * critAmt * crits) + (result * (runs - crits));
            } else{
                result = (baseProd * prodBoost) * runs;
                result *= (luckChance * critAmt) + (1 - luckChance);
            }
            //System.out.println("Common Boost: " + (initCommon * (Math.pow(commonMult, (commonLvl - 1)))));
            //System.out.println("Time: " + baseTime + " -> " + time);
            //System.out.println(baseProd + " * " + prodBoost + " = " + (baseProd * prodBoost));
            //result = (baseProd * prodBoost) * runs;
            //result *= (luckChance * critAmt) + (1 - luckChance);
            //System.out.println(result);
            ret = BigNum.multiply(amt, result);
        } else{
            ret = new BigNum(0, 0);
        }
        //System.out.println(ret);
        return new BNandBool(ret, randomized);
    }
    
    public int getSpeedBoost(int l){
        return initCommon * (int)(Math.pow(commonMult, l - 1));
    }
    
    public void printDetails(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, boolean boost, int ind, Time dur){
        double prodBoost = 1.0;
        double luckChance = 0.0;
        double critAmt = 1.0;
        double result = 0.0;
        BigNum ret;
        for(Researcher r : rsch){
            if(r.getUp().equals("prod") && r.thisIndustry(ind)){
                prodBoost *= r.getBoost();
                //System.out.println(prodBoost);
            }
            if(r.getUp().equals("crit") && r.thisIndustry(ind)){
                critAmt *= r.getBoost();
            }
            if(r.getUp().equals("luck") && r.thisIndustry(ind)){
                luckChance += r.getBoost();
            }
        }
        
        if(boost){
            prodBoost *= 2;
            //System.out.println(prodBoost);
        }
        AdComNum p = new AdComNum(new BigNum((int)(prodBoost), 0));
        AdComNum c = new AdComNum(new BigNum((int)(critAmt), 0));
        
        String luckiness = Operations.removeDecimals(luckChance * 100);
        
        System.out.println("Production Boost: x" + p.toStringNoSpace());
        System.out.println("Luck Chance: " + luckiness + "%");
        System.out.println("Crit Bonus: x" + c.toStringNoSpace());
        //System.out.println("T1 Production Boost: x" + getSpeedBoost(commonLvl));
    }
    
}