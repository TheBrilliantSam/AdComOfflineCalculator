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
    
    public Generator(int bp, int bt){
        baseProd = bp;
        baseTime = bt;
    }
    
    public BNandBool production(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, double boost, int ind, BigNum secs, boolean ran, int gen){
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
            if(r.getUp().equals("single prod") && r.thisIndustry(ind) && gen == 0){
                prodBoost = BigNum.multiply(prodBoost, r.getBoost());
            }
        }
        
        if(boost > 1){
            prodBoost = BigNum.multiply(prodBoost, new BigNum(boost));
            //System.out.println(prodBoost);
        }
        
        int runs = 0;
        boolean randomized = false;
        //System.out.println(prodBoost + " " + luckChance + " " + critAmt);
        BigNum time = new BigNum(1.0 * baseTime);
        if(commonLvl != 0){
            //time = BigNum.divide(time, getSpeedBoost(commonLvl));
            //System.out.println(initCommon * (int)(Math.pow(commonMult, commonLvl - 1)));
            //System.out.println(baseTime + " -> " + time);
            BigNum r = BigNum.multiply(secs, getSpeedBoost(commonLvl));
            r = BigNum.divide(r, time);
            boolean validIntRuns;
            if(r.compareTo(new BigNum(2147483647)) <= 0){
                runs = r.toIntegerUnrounded();
                validIntRuns = true;
            } else{
                validIntRuns = false;
            }
            //System.out.println(runs);
            if(validIntRuns && ran && runs <= 500 && (luckChance.isNotZero() && critAmt.isMoreThanOne())){
                randomized = true;
                int crits = 0;
                result = BigNum.multiply(prodBoost, baseProd);
                for(int i = 0; i < runs; i++){
                    if(Math.random() < luckChance.toDouble()){
                        crits++;
                    }
                }
                result = BigNum.add(BigNum.multiply(result, BigNum.multiply(critAmt, crits)), BigNum.multiply(result, runs - crits));
            } else if(validIntRuns){
                result = BigNum.multiply(prodBoost, runs, baseProd);
                result = BigNum.multiply(result, BigNum.add( BigNum.multiply(luckChance, critAmt), 1 - luckChance.toDouble() ));
            } else{
                result = BigNum.multiply(prodBoost, r, baseProd);
                result = BigNum.multiply(result, BigNum.add( BigNum.multiply(luckChance, critAmt), 1 - luckChance.toDouble() ));
                //System.out.println(BigNum.multiply(luckChance, critAmt) + " + " + (1 - luckChance.toDouble())  + " = " + BigNum.add( BigNum.multiply(luckChance, critAmt), new BigNum(1 - luckChance.toDouble()) ));
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
    
    public BigNum getPreviousStrength(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, double boost, int ind){
        BigNum prodBoost = new BigNum(1, 0);
        BigNum luckChance = new BigNum(0.0);
        BigNum critAmt = new BigNum(1, 0);
        BigNum result = new BigNum(0, 0);
        BigNum s;
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
        
        if(boost > 1){
            prodBoost = BigNum.multiply(prodBoost, new BigNum(boost));
            //System.out.println(prodBoost);
        }
        
        //int runs;
        boolean randomized = false;
        //System.out.println(prodBoost + " " + luckChance + " " + critAmt);
        BigNum time = new BigNum(1.0 * baseTime);
        if(commonLvl != 0){
            //time = BigNum.divide(time, getSpeedBoost(commonLvl));
            //System.out.println(initCommon * (int)(Math.pow(commonMult, commonLvl - 1)));
            //System.out.println(baseTime + " -> " + time);
            BigNum r = BigNum.multiply(new BigNum(1), getSpeedBoost(commonLvl));
            r = BigNum.divide(r, time);
            //System.out.println(runs);
            result = BigNum.multiply(prodBoost, r, baseProd);
            result = BigNum.multiply(result, BigNum.add( BigNum.multiply(luckChance, critAmt), 1 - luckChance.toDouble() ));
            //System.out.println("Common Boost: " + (initCommon * (Math.pow(commonMult, (commonLvl - 1)))));
            //System.out.println("Time: " + baseTime + " -> " + time);
            //System.out.println(baseProd + " * " + prodBoost + " = " + (baseProd * prodBoost));
            //result = (baseProd * prodBoost) * runs;
            //result *= (luckChance * critAmt) + (1 - luckChance);
            //System.out.println(result);
            s = BigNum.multiply(amt, result);
        } else{
            s = new BigNum(0, 0);
        }
        return s;
    }
    
    public void printDetails(ArrayList<Researcher> rsch, int commonLvl, BigNum amt, double boost, int ind, Time dur, boolean emoji, boolean strength, BigNum previous){
        BigNum prodBoost = new BigNum(1, 0);
        BigNum luckChance = new BigNum(0.0);
        BigNum critAmt = new BigNum(1, 0);
        BigNum result = new BigNum(0, 0);
        BigNum s;
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
        
        if(boost > 1){
            prodBoost = BigNum.multiply(prodBoost, new BigNum(boost));
            //System.out.println(prodBoost);
        }
        
        //int runs;
        boolean randomized = false;
        //System.out.println(prodBoost + " " + luckChance + " " + critAmt);
        BigNum time = new BigNum(1.0 * baseTime);
        if(commonLvl != 0){
            //time = BigNum.divide(time, getSpeedBoost(commonLvl));
            //System.out.println(initCommon * (int)(Math.pow(commonMult, commonLvl - 1)));
            //System.out.println(baseTime + " -> " + time);
            BigNum r = BigNum.multiply(new BigNum(1), getSpeedBoost(commonLvl));
            r = BigNum.divide(r, time);
            //System.out.println(runs);
            result = BigNum.multiply(prodBoost, r, baseProd);
            result = BigNum.multiply(result, BigNum.add( BigNum.multiply(luckChance, critAmt), 1 - luckChance.toDouble() ));
            //System.out.println("Common Boost: " + (initCommon * (Math.pow(commonMult, (commonLvl - 1)))));
            //System.out.println("Time: " + baseTime + " -> " + time);
            //System.out.println(baseProd + " * " + prodBoost + " = " + (baseProd * prodBoost));
            //result = (baseProd * prodBoost) * runs;
            //result *= (luckChance * critAmt) + (1 - luckChance);
            //System.out.println(result);
            s = BigNum.multiply(amt, result);
        } else{
            s = new BigNum(0, 0);
        }
        //System.out.println(s);
        
        String SM;
        if(previous.compareTo(new BigNum(0)) == 0 && s.compareTo(new BigNum(0)) == 0){
            SM = "N/A";
        } else if(previous.compareTo(new BigNum(0)) == 0){
            SM = "Infinite";
        } else{
            BigNum strengthMult = BigNum.divide(s, previous);
            AdComNumShort formattedStrength = new AdComNumShort(strengthMult);
            SM = "x" + formattedStrength.toDecimalString();
        }
        //System.out.println(strengthMult);
        
        AdComNumShort pr = new AdComNumShort(prodBoost);
        AdComNumShort cr = new AdComNumShort(critAmt);
        
        String luckiness = Operations.removeDecimals(luckChance.toDouble() * 100);
        String p = pr.toString();
        String c = cr.toString();
        
        if(prodBoost.compareTo(new BigNum(1000)) == -1){
            p = Operations.removeDecimals(prodBoost.toDouble());
        }
        if(critAmt.compareTo(new BigNum(1000)) == -1){
            c = Operations.removeDecimals(critAmt.toDouble());
        }
        
        if(emoji) System.out.print("  ✦  ");
        if(emoji) System.out.print("🔨 x" + p);
        if(!emoji) System.out.println("Production Boost: x" + p);
        
        if(luckChance.isNotZero() && critAmt.isMoreThanOne()){
            if(emoji) System.out.print("  ✦  ");
            if(emoji) System.out.print("🍀 " + luckiness + "%");
            if(emoji) System.out.print("  ✦  ");
            if(emoji) System.out.print("💪 x" + c);
            if(!emoji) System.out.print("Crits: " + luckiness + "% chance of x" + c + " bonus");
        }
        if(emoji && strength) System.out.print("  ✦  ");
        if(emoji && strength) System.out.print("🚀 " + SM);
        if(!emoji && strength) System.out.print("\nProduction Strength Multiplier: " + SM);
        //System.out.println("T1 Production Boost: x" + new AdComNum(getSpeedBoost(commonLvl)));
    }
    
}