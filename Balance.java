import java.util.*;

public class Balance{
    
    private int length;
    private int industries;
    
    private Generator[][] gens;
    
    private ArrayList<Researcher> rsch;
    
    public Balance(String event){
        if(event.equals("Atlantis")){
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(3 + 2 * i, (int)(Math.pow(2, i)), 0, 1, 5, 5);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(5 + 5 * i, (int)(Math.pow(3, i)), 0, 1, 5, 5);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(5 + 10 * i, (int)(Math.pow(4, i)), 0, 1, 5, 5);
            }
            rsch = new ArrayList<Researcher>();
            rsch.add(new Researcher("prod", 3, 3, 1));
            rsch.add(new Researcher("prod", 3, 3, 2));
            rsch.add(new Researcher("prod", 3, 3, 3));
            rsch.add(new Researcher("com", 4, 2, 1));
            rsch.add(new Researcher("com", 6, 2, 1));
            rsch.add(new Researcher("com", 8, 2, 1));
            rsch.get(0).setLvl(1);
        }
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
        
        
        System.out.println("Calculating for Industry " + industry + ".");
        System.out.println("Offline Duration: " + dur.toString() + "\n");
        ArrayList<Researcher> relavantRsch = new ArrayList<Researcher>();
        ArrayList<String> printout = new ArrayList<String>();
        double secs = dur.getSecs();
        AdComNum fix = new AdComNum(new BigNum(amounts[industry - 1][amounts[industry - 1].length - 1]));
        amounts[industry - 1][amounts[industry - 1].length - 1] = fix.toString();
        for(int i = commons[industry - 1].length - 1; i >= 0; i--){
            String prSt = "         G" + (i + 1) + ":  ";
            prSt += duplicate[i + 1];
            for(int j = duplicate[i + 1].length(); j < 14; j++){
                prSt += " ";
            }
            prSt += "——>      " + amounts[industry - 1][i + 1];
            printout.add(0, prSt);
            prSt = null;
            BigNum val = new BigNum(amounts[industry - 1][i + 1]);
            BigNum amt = gens[industry - 1][i].prodPerSec(rsch.get(0), commons[industry - 1][i], val, boost);
            BigNum output = BigNum.multiply(amt, secs);
            //System.out.print(amounts[i + 1] + " of generator " + (i + 1) + " produced ");
            //System.out.println(new AdComNum(output) + " of the previous generator.");
            //System.out.println(new AdComNum(new BigNum(amounts[i + 1])) + "\n");
            AdComNum acn = new AdComNum(BigNum.add(output, new BigNum(amounts[industry - 1][i])));
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
        prStm += "——>      " + alsoPrintThis.toString();
        printout.add(0, prStm);
        for(String s : printout){
            System.out.println(s);
        }
        System.out.println("\nCommon Cards: " + Arrays.toString(commons[industry - 1]) + "\nProduction Rare Level: " + rsch.get(industry - 1).getLvl());
    }
    
}