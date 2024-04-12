public class Generator{
    private int baseProd;
    private int baseTime;
    private double critRate;
    private int critAmt;
    private int initCommon;
    private int commonMult;
    public Generator(int bp, int bt, double cr, int ca, int ic, int cm){
        baseProd = bp;
        baseTime = bt;
        critRate = cr;
        critAmt = ca;
        initCommon = ic;
        commonMult = cm;
    }
    
    public BigNum prodPerSec(Researcher r1, int commonLvl, BigNum amt, boolean boost){
        double prodBoost = 1.0;
        double result = 0.0;
        BigNum ret;
        if(r1.getUp().equals("prod")){
            prodBoost *= r1.getBoost();
            //System.out.println(prodBoost);
        }
        if(boost){
            prodBoost *= 2;
            //System.out.println(prodBoost);
        }
        double time = baseTime;
        if(commonLvl != 0){
            time /= initCommon * (commonMult * (commonLvl - 1));
            //System.out.println("Common Boost: " + (initCommon * (Math.pow(commonMult, (commonLvl - 1)))));
            //System.out.println("Time: " + baseTime + " -> " + time);
            //System.out.println(baseProd + " * " + prodBoost + " = " + (baseProd * prodBoost));
            result = (baseProd * prodBoost) / time;
            //System.out.println(result);
            ret = BigNum.multiply(amt, result);
        } else{
            ret = new BigNum(0, 0);
        }
        //System.out.println(ret);
        return ret;
    }
    
}