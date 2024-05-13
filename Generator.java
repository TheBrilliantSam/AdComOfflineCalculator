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
    
    public BNandBool production(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, boolean boost, int ind, BigNum secs, boolean ran){
        BigNum prodBoost = new BigNum(1, 0);
        BigNum luckChance = new BigNum(0.0);
        BigNum critAmt = new BigNum(1, 0);
        BigNum result = new BigNum(0, 0);
        BigNum ret;
        for(Researcher r : rsch){
            if(r.getUp().equals("prod") && r.thisIndustry(ind)){
                prodBoost = BigNum.multiply(prodBoost, r.getBoost());
                //System.out.println(prodBoost);
            }
            if(r.getUp().equals("crit") && r.thisIndustry(ind)){
                critAmt = BigNum.multiply(critAmt, r.getBoost());
            }
            if(r.getUp().equals("luck") && r.thisIndustry(ind)){
                luckChance = BigNum.add(luckChance, r.getBoost());
            }
        }
        
        if(boost){
            prodBoost = BigNum.multiply(prodBoost, 2);
            //System.out.println(prodBoost);
        }
        
        int runs;
        boolean randomized = false;
        //System.out.println(prodBoost + " " + luckChance + " " + critAmt);
        BigNum time = new BigNum(1.0 * baseTime);
        if(commonLvl != 0){
            //time = BigNum.divide(time, getSpeedBoost(commonLvl));
            //System.out.println(initCommon * (int)(Math.pow(commonMult, commonLvl - 1)));
            //System.out.println(baseTime + " -> " + time);
            BigNum r = BigNum.multiply(secs, getSpeedBoost(commonLvl));
            r = BigNum.divide(r, time);
            runs = r.intVal();
            //System.out.println(runs);
            if(ran && !(r.compareTo(500)) && (luckChance.isNotZero() && critAmt.isMoreThanOne())){
                randomized = true;
                int crits = 0;
                result = BigNum.multiply(prodBoost, baseProd);
                for(int i = 0; i < runs; i++){
                    if(Math.random() < luckChance.toDouble()){
                        crits++;
                    }
                }
                result = BigNum.add(BigNum.multiply(result, BigNum.multiply(critAmt, crits)), BigNum.multiply(result, runs - crits));
            } else{
                result = BigNum.multiply(prodBoost, r, baseProd);
                result = BigNum.multiply(result, BigNum.add( BigNum.multiply(luckChance, critAmt), 1 - luckChance.toDouble() ));
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
    
    //Precondition: l ≠ 0
    public BigNum getSpeedBoost(int l){
        if(l > 0){
            BigNum ret = new BigNum(initCommon);
            for(int i = 1; i < l; i++){
                ret = BigNum.multiply(ret, commonMult);
            }
            return ret;
        } else{
            return new BigNum(1, 0);
        }
    }
    
    public void printDetails(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, boolean boost, int ind, Time dur){
        BigNum prodBoost = new BigNum(1, 0);
        BigNum luckChance = new BigNum(0.0);
        BigNum critAmt = new BigNum(1, 0);
        BigNum result = new BigNum(0, 0);
        BigNum ret;
        for(Researcher r : rsch){
            if(r.getUp().equals("prod") && r.thisIndustry(ind)){
                prodBoost = BigNum.multiply(prodBoost, r.getBoost());
                //System.out.println(prodBoost);
            }
            if(r.getUp().equals("crit") && r.thisIndustry(ind)){
                critAmt = BigNum.multiply(critAmt, r.getBoost());
            }
            if(r.getUp().equals("luck") && r.thisIndustry(ind)){
                luckChance = BigNum.add(luckChance, r.getBoost());
            }
        }
        
        if(boost){
            prodBoost = BigNum.multiply(prodBoost, 2);
            //System.out.println(prodBoost);
        }
        
        AdComNumShort p = new AdComNumShort(prodBoost);
        AdComNumShort c = new AdComNumShort(critAmt);
        
        String luckiness = Operations.removeDecimals(luckChance.toDouble() * 100);
        
        System.out.println("Production Boost: x" + p);
        if(luckChance.isNotZero() && critAmt.isMoreThanOne()){
            System.out.println("Crits: " + luckiness + "% chance of x" + c + " bonus");
        }
        //System.out.println("T1 Production Boost: x" + getSpeedBoost(commonLvl));
    }
    
}