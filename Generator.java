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
    
    public BigNum prodPerSec(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, boolean boost, int ind){
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
        
        //System.out.println(prodBoost + " " + luckChance + " " + critAmt);
        double time = baseTime;
        if(commonLvl != 0){
            time /= initCommon * (int)(Math.pow(commonMult, commonLvl - 1));
            //System.out.println("Common Boost: " + (initCommon * (Math.pow(commonMult, (commonLvl - 1)))));
            //System.out.println("Time: " + baseTime + " -> " + time);
            //System.out.println(baseProd + " * " + prodBoost + " = " + (baseProd * prodBoost));
            result = (baseProd * prodBoost) / time;
            result *= (luckChance * critAmt) + (1 - luckChance);
            //System.out.println(result);
            ret = BigNum.multiply(amt, result);
        } else{
            ret = new BigNum(0, 0);
        }
        //System.out.println(ret);
        return ret;
    }
    
}