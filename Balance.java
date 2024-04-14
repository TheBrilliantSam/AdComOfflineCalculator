import java.util.*;

public class Balance{
    
    private int length;
    private String eventName;
    
    private Generator[][] gens;
    
    private ArrayList<Researcher> rsch;
    
    public Balance(String event){
        eventName = event;
    }
    
    public void instantiate(int l, Generator[][] g, ArrayList<Researcher> r){
        length = l;
        gens = g;
        rsch = r;
        System.out.println("Event: " + eventName + "\n");
        String duration;
        switch(length){
            case 32:
                duration = "Mini";
                break;
            case 52:
                duration = "Fusion";
                break;
            case 100:
                duration = "Weekend";
                break;
            case 268:
                duration = "Supreme";
                break;
            default:
                duration = "Unknown";
                break;
        }
        System.out.println("Length: " + length + "h (" + duration + ")");
        System.out.println("Industries: " + getIndustries() + "\n");
    }
    
    public int getIndustries(){
        return gens.length;
    }
    
    public void setRares(int[] lvls){
        for(int i = 0; i < lvls.length; i++){
            rsch.get(i).setLvl(lvls[i]);
        }
    }
    
    public void calculateOffline(int industry, String[][] amounts, int[][] commons, Time dur, boolean boost){
        String[] duplicate = new String[amounts[industry - 1].length];
        System.arraycopy(amounts[industry - 1], 0, duplicate, 0, amounts[industry - 1].length);
        for(int k = 0; k < duplicate.length; k++){
            AdComNum fixer = new AdComNum(new BigNum(duplicate[k]));
            duplicate[k] = fixer.toString();
        }
        //System.out.println("Event: " + eventName);
        System.out.println("Calculating for Industry " + industry + ".");
        System.out.println("Offline Duration: " + dur.toString() + "\n");
        ArrayList<Researcher> relavantRsch = new ArrayList<Researcher>();
        ArrayList<String> printout = new ArrayList<String>();
        double secs = dur.getSecs();
        AdComNum fix = new AdComNum(new BigNum(amounts[industry - 1][amounts[industry - 1].length - 1]));
        amounts[industry - 1][amounts[industry - 1].length - 1] = fix.toString();
        boolean rand[] = new boolean[commons[industry - 1].length];
        boolean resRand = false;
        for(int i = commons[industry - 1].length - 1; i >= 0; i--){
            String prSt = "         G" + (i + 1) + ":  ";
            prSt += duplicate[i + 1];
            for(int j = duplicate[i + 1].length(); j < 14; j++){
                prSt += " ";
            }
            prSt += "——>     " + amounts[industry - 1][i + 1];
            if(rand[i]){
                prSt += "*";
            }
            printout.add(0, prSt);
            prSt = null;
            BigNum val = new BigNum(amounts[industry - 1][i + 1]);
            BNandBool thing = gens[industry - 1][i].prodPerSec(rsch, commons[industry - 1][i], val, boost, industry, dur);
            BigNum amt = thing.getBN();
            if(i != 0){
                rand[i - 1] = thing.getBOOL();
            } else{
                resRand = thing.getBOOL();
            }
            //BigNum output = BigNum.multiply(amt, secs);
            //System.out.print(amounts[i + 1] + " of generator " + (i + 1) + " produced ");
            //System.out.println(new AdComNum(output) + " of the previous generator.");
            //System.out.println(new AdComNum(new BigNum(amounts[i + 1])) + "\n");
            AdComNum acn = new AdComNum(BigNum.add(amt, new BigNum(amounts[industry - 1][i])));
            //System.out.print(new AdComNum(output));
            //System.out.print(" + ");
            //System.out.print(new AdComNum(new BigNum(amounts[i])));
            //System.out.print(" = ");
            //System.out.println(acn);
            amounts[industry - 1][i] = acn.toString();
        }
        AdComNum alsoPrintThis = new AdComNum(new BigNum(amounts[industry - 1][0]));
        printout.add(0, "");
        String prStm = "   Resource:  ";
        prStm += duplicate[0];
        for(int j = duplicate[0].length(); j < 14; j++){
            prStm += " ";
        }
        prStm += "——>     " + alsoPrintThis.toString();
        if(resRand){
                prStm += "*";
        }
        printout.add(0, prStm);
        for(String s : printout){
            System.out.println(s);
        }
        System.out.println("\nCommon Cards: " + Arrays.toString(commons[industry - 1]) + "\nProduction Rare Level: " + rsch.get(industry - 1).getLvl() + " (x" + (int)(rsch.get(industry - 1).getBoost()) + " BOOST)");
        //System.out.println("Luck Chance: " + rsch.get)
        System.out.println("\n----------------------------------------------------\n");
    }
    
}