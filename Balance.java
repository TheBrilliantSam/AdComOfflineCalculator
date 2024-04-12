import java.util.*;

public class Balance{
    
    private int length;
    private int industries;
    private String eventName;
    
    private Generator[][] gens;
    
    private ArrayList<Researcher> rsch;
    
    public Balance(String event){
        eventName = event;
        if(event.equals("Atlantis") || event.equals("Winter") || event.equals("Stone")){
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(3 + 2 * i, (int)(Math.pow(2, i)), 5, 5);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(5 + 5 * i, (int)(Math.pow(3, i)), 5, 5);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(5 + 10 * i, (int)(Math.pow(4, i)), 5, 5);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            rsch.add(new Researcher("prod", 1, 3, 3, i1));
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("prod", 1, 3, 3, i3));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("com", 1, 6, 2, i2));
            rsch.add(new Researcher("com", 1, 8, 2, i3));
        } else if(event.equals("Crusade") || event.equals("Zombie") || event.equals("Ninja")){
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(1 + i, 2 * (int)(Math.pow(3, i - 1)), 2 + i, 2);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(3 * i, 3 * (int)(Math.pow(4, i - 1)), 4 + i, 2);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(4 + 5 * (i - 1), 4 * (int)(Math.pow(6, i - 1)), 6 + i, 2);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            rsch.add(new Researcher("prod", 1, 4, 2, i1));
            rsch.add(new Researcher("prod", 1, 6, 2, i2));
            rsch.add(new Researcher("prod", 1, 8, 2, i3));
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("com", 1, 5, 2, i3));
        } else if(event.equals("Space") || event.equals("Cowboy")){
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(1 + 2 * i, (int)(Math.pow(2, i)), 3, 3);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(2 + 4 * i, (int)(Math.pow(2, i + 1)), 4, 4);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(4 + 8 * i, (int)(Math.pow(2, i + 2)), 5, 5);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            global.add(3);
            rsch.add(new Researcher("prod", 1, 2, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.15, 0.00, global));
            rsch.add(new Researcher("com", 1, 3, 2, global));
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("com", 1, 9, 2, i3));
            rsch.add(new Researcher("crit", 256, 1, 1, global));
        } else if(event.equals("Power") || event.equals("Oil")){
            gens = new Generator[2][];
            gens[0] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[0][i - 1] = new Generator(3 + i, 3 * (int)(Math.pow(2, i - 1)), 1 + i, 2);
            }
            gens[1] = new Generator[3];
            for(int i = 1; i <= 3; i++){
                gens[1][i - 1] = new Generator(5 + 2 * i, 6 * (int)(Math.pow(3, i - 1)), 2 + 2 * i, 4);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("luck", 0.00, 0.13, 0.02, global));
            rsch.add(new Researcher("com", 1, 3, 3, i1));
            rsch.add(new Researcher("com", 1, 4, 2, global));
            rsch.add(new Researcher("crit", 8, 1, 1, global));
        } else if(event.equals("Shield")){
            gens = new Generator[2][];
            gens[0] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[0][i - 1] = new Generator(3 * (1 + i), (int)(Math.pow(3, i)), 4, 4);
            }
            gens[1] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[1][i - 1] = new Generator(9 * (1 + i), (int)(Math.pow(3, i)), 3, 3);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("prod", 1, 5, 2, i1));
            rsch.add(new Researcher("luck", 0.00, 0.13, 0.02, i2));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("com", 1, 4, 2, i2));
            rsch.add(new Researcher("crit", 8, 1, 1, global));
        } else if(event.equals("Export")){
            gens = new Generator[2][];
            gens[0] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[0][i - 1] = new Generator(3 * (1 + i), (int)(Math.pow(3, i)), 4, 4);
            }
            gens[1] = new Generator[4]; // I hate you HH
                gens[1][0] = new Generator(18, 3, 3, 3);
                gens[1][1] = new Generator(60, 6, 3, 3);
                gens[1][2] = new Generator(120, 30, 3, 3);
                gens[1][3] = new Generator(240, 90, 3, 3);
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            rsch.add(new Researcher("prod", 1, 5, 2, i1));
            rsch.add(new Researcher("prod", 1, 5, 5, i2));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("com", 1, 4, 2, i2));
        } else if(event.equals("Santa") || event.equals("Supreme")){
            gens = new Generator[4][];
            gens[0] = new Generator[7];
            for(int i = 1; i <= 7; i++){
                gens[0][i - 1] = new Generator(2 + 3 * (i - 1), 2 * (int)(Math.pow(3, i - 1)), 3 * i, 3);
            }
            gens[1] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[1][i - 1] = new Generator(6 + 15 * (i - 1), 3 * (int)(Math.pow(4, i - 1)), 6 * i, 3);
            }
            gens[2] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[2][i - 1] = new Generator(12 + 52 * (i - 1), 4 * (int)(Math.pow(6, i - 1)), 9 * i, 3);
            }
            gens[3] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[3][i - 1] = new Generator(20 + 190 * (i - 1), 5 * (int)(Math.pow(12, i - 1)), 12 * i, 3);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            ArrayList<Integer> i4 = new ArrayList<Integer>();
            i4.add(4);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            global.add(3);
            global.add(4);
            rsch.add(new Researcher("prod", 1, 2, 4, i1));
            rsch.add(new Researcher("prod", 1, 4, 4, i2));
            rsch.add(new Researcher("prod", 1, 6, 4, i3));
            rsch.add(new Researcher("prod", 1, 8, 4, i4));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, global));
            rsch.add(new Researcher("crit", 32, 8, 2, global));
            rsch.add(new Researcher("com", 1, 3, 2, i1));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("com", 1, 7, 2, i3));
            rsch.add(new Researcher("com", 1, 9, 2, i4));
            rsch.add(new Researcher("com", 1, 2, 2, global));
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
        System.out.println("Event: " + eventName);
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
            BigNum amt = gens[industry - 1][i].prodPerSec(rsch, commons[industry - 1][i], val, boost, industry);
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