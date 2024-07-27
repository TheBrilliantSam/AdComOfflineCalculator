import java.util.*;

public class Balance{
    
    private Time length;
    private String eventName;
    private boolean debug = false;
    private boolean parseDebug = false;
    private int threshold = 50;
    
    private Generator[][] gens;
    
    private ArrayList<Researcher> rsch;
    
    public Balance(String str){
        String[] words = str.split("\\s+");
        StringBuilder capitalizedStr = new StringBuilder();
        for (String word : words) {
            if (word.length() > 0) {
                // Capitalize the first letter and append the rest of the word
                capitalizedStr.append(Character.toUpperCase(word.charAt(0)))
                              .append(word.substring(1).toLowerCase())
                              .append(" ");
            }
        }
        eventName = capitalizedStr.toString().trim();
    }
    
    public void instantiate(Time t, Generator[][] g, ArrayList<Researcher> r){
        length = t;
        gens = g;
        rsch = r;
        System.out.println("Event: " + eventName + "\n");
        String duration;
        int len = length.getHours();
        switch(len){
            case 28, 32:
                duration = "Mini";
                break;
            case 52:
                duration = "Fusion";
                break;
            case 76:
                duration = "Extended Fusion";
                break;
            case 100:
                duration = "Weekend";
                break;
            case 148:
                duration = "Weeklong";
                break;
            case 268:
                duration = "Supreme";
                break;
            default:
                duration = "Unknown";
                break;
        }
        System.out.println("Length: " + length.toHourString() + " (" + duration + ")");
        System.out.println("Industries: " + getIndustries() + "\n");
        //System.out.println(java.time.LocalDateTime.now() + "——>" + "\n");
    }
    
    public void instantiate(Generator[][] g, ArrayList<Researcher> r){
        //length = t;
        gens = g;
        rsch = r;
        System.out.println(eventName + "\n");
        System.out.println("Length: Infinite (or until HH goes bankrupt)");
        System.out.println("Industries: " + getIndustries() + "\n");
        //System.out.println(java.time.LocalDateTime.now() + "——>" + "\n");
    }
    
    public int getIndustries(){
        return gens.length;
    }
    
    public void setRares(int[] lvls){
        for(int i = 0; i < lvls.length; i++){
            rsch.get(i).setLvl(lvls[i]);
        }
    }
    
    public void offlineUntilResource(String target, int industry, String[][] amounts, int[][] commons, int[] rares, boolean boost, boolean reset, boolean print, boolean printAllIndustries){
        setRares(rares);
        if(reset){
                amounts[industry - 1][0] = "";
                //System.out.println("RESET COMPLETE");
        }
        AdComNum mission = new AdComNum(new BigNum(target));
        BigNum seconds = new BigNum(3600); // Start by trying 1 hour
        BigNum high = new BigNum(9.99, 2147483647);
        BigNum low = new BigNum(0);
        BigNum prev = new BigNum(0);
        String[] amountsDup = new String[amounts[industry - 1].length];
        String[] amountsDupBackup = new String[amounts[industry - 1].length];
        System.arraycopy(amounts[industry - 1], 0, amountsDup, 0, amounts[industry - 1].length);
        System.arraycopy(amounts[industry - 1], 0, amountsDupBackup, 0, amounts[industry - 1].length);
        //System.out.println(Arrays.toString(amountsDupBackup));
        boolean complete = false;
        AdComNum result = new AdComNum(new BigNum(""));
        if(debug) System.out.println("Attempts to Calculate:\n");
        int attempts = 1;
        while(!complete){
            BNandBool compute = calculate(industry, amountsDup, commons[industry - 1], rares, seconds, boost, false, true, print, attempts);
            if(!compute.getBOOL()){
                break;
            }
            result = new AdComNum(compute.getBN());
            //AdComNum result = calculateOffline(industry, String[][] amounts, commons, rares, new Time(seconds + "s"), boost, ran, reset, print);
            if(debug && seconds.getEXP() > 8 && attempts > threshold) System.out.print("attempt: " + attempts + ", resource generated: " + result + ", time: " + new Time(seconds).toString() + ", compare: " + mission.compareTo(result) + ", ");
            if(debug && seconds.getEXP() <= 8 && attempts > threshold) System.out.print("resource generated: " + result + ", time: " + new Time((int)seconds.toDouble()).toString() + ", compare: " + mission.compareTo(result) + ", ");
            System.arraycopy(amountsDupBackup, 0, amountsDup, 0, amountsDup.length);
            //System.out.println(Arrays.toString(amountsDup));
            prev = seconds;
            switch(mission.compareTo(result)){
                case 0:
                    complete = true;
                    if(debug) System.out.println("exiting loop: target hit");
                    break;
                case 1:
                    if(seconds.compareTo(low) == 1){
                        low = seconds;
                    }
                    seconds = Operations.findBestNextGuess(seconds, high, low, "higher");
                    break;
                case -1:
                    if(seconds.compareTo(high) == -1){
                        high = seconds;
                    }
                    seconds = Operations.findBestNextGuess(seconds, high, low, "lower");
            }
            if(debug && attempts > threshold) System.out.println("high: " + high + ", low: " + low);
            if(parseDebug && attempts > threshold) System.out.println("\n");
            if(new BigNum(1).compareTo(BigNum.abs(BigNum.subtract(seconds, prev))) == 1){
                if(debug) System.out.println("exiting loop: time convergence");
                complete = true;
            }
            /*if(seconds > 864000000){
                System.out.println("ERROR: Maximum sim time reached. (10000d simulated)");
                break;
            }*/
            attempts++;
        }
        if(complete){
            if(debug) System.out.println();
            if(printAllIndustries){
                industry = 0;
            }
            if(mission.compareTo(result) == 1){
                seconds = BigNum.add(seconds, new BigNum(1));
            }
            if(seconds.getEXP() > 8){
                calculateOffline(industry, amounts, commons, rares, seconds, boost, false, reset, print);
            } else{
                calculateOffline(industry, amounts, commons, rares, seconds, boost, false, reset, print);
            }
        }
    }
    
    public BNandBool calculate(int industry, String[] amounts, int[] commons, int[] rares, BigNum secs, boolean boost, boolean ran, boolean reset, boolean print, int attempts){
        boolean valid = true;
        if(amounts.length == 1){
            System.out.println("ERROR: No generator amounts entered in the target industry.");
            valid = false;
        }
        if(amounts.length - 1 > commons.length){
            System.out.println("ERROR: Insufficient common cards assigned to generators in the target industry.");
            valid = false;
        }
        if(valid){
            if(parseDebug && attempts > threshold) System.out.println(Arrays.toString(amounts));
            String[] duplicate = new String[amounts.length];
            System.arraycopy(amounts, 0, duplicate, 0, amounts.length);
            for(int k = 0; k < duplicate.length; k++){
                AdComNum fixer = new AdComNum(new BigNum(duplicate[k]));
                duplicate[k] = fixer.toString();
            }
            ArrayList<Researcher> relavantRsch = new ArrayList<Researcher>();
            AdComNum fix = new AdComNum(new BigNum(amounts[amounts.length - 1]));
            amounts[amounts.length - 1] = fix.toString();
            boolean rand[] = new boolean[commons.length];
            boolean resRand = false;
            for(int i = Math.min(commons.length - 1, amounts.length - 2); i >= 0; i--){
                BigNum val = new BigNum(amounts[i + 1]);
                BNandBool thing = gens[industry - 1][i].production(rsch, commons[i], val, boost, industry, secs, ran, i);
                BigNum amt = thing.getBN();
                if(i != 0){
                    rand[i - 1] = thing.getBOOL();
                } else{
                    resRand = thing.getBOOL();
                }
                AdComNum acn = new AdComNum(BigNum.add(amt, new BigNum(amounts[i])));
                amounts[i] = acn.toString();
            }
            if(parseDebug && attempts > threshold) System.out.println(Arrays.toString(amounts));
            return new BNandBool(new BigNum(amounts[0]), true);
        } else{
            return new BNandBool(new BigNum(""), false);
        }
    }
    
    public void calculateOffline(int industry, String[][] amounts, int[][] commons, int[] rares, BigNum secs, boolean boost, boolean ran, boolean reset, boolean print){
        Time dur = new Time(0);
        if(secs.getEXP() > 8){
            dur = new Time(secs);
        } else{
            dur = new Time((int)(secs.toDouble()));
        }
        boolean valid = true;
        if(industry == 0){
            calculateAllIndustriesOffline(amounts, commons, rares, secs, boost, ran, reset, print);
        }else{
            setRares(rares);
            if(reset){
                amounts[industry - 1][0] = "";
                //System.out.println("RESET COMPLETE");
            }
            if(print){
                System.out.println("Calculating for Industry " + industry + ".");
                System.out.println("Offline Duration: " + dur.toString() + "\n");
                if(amounts[industry - 1].length == 1){
                    System.out.println("ERROR: No generator amounts entered.");
                    valid = false;
                }
                if(amounts[industry - 1].length - 1 > commons[industry - 1].length){
                    System.out.println("ERROR: Insufficient common cards assigned to generators.");
                    valid = false;
                }
                if(valid){
                    String[] duplicate = new String[amounts[industry - 1].length];
                    System.arraycopy(amounts[industry - 1], 0, duplicate, 0, amounts[industry - 1].length);
                    for(int k = 0; k < duplicate.length; k++){
                        AdComNum fixer = new AdComNum(new BigNum(duplicate[k]));
                        duplicate[k] = fixer.toString();
                    }
                    //System.out.println("Event: " + eventName);
                    ArrayList<Researcher> relavantRsch = new ArrayList<Researcher>();
                    ArrayList<String> printout = new ArrayList<String>();
                    //BigNum secs = dur.getSecs();
                    AdComNum fix = new AdComNum(new BigNum(amounts[industry - 1][amounts[industry - 1].length - 1]));
                    amounts[industry - 1][amounts[industry - 1].length - 1] = fix.toString();
                    boolean rand[] = new boolean[commons[industry - 1].length];
                    boolean resRand = false;
                    for(int i = Math.min(commons[industry - 1].length - 1, amounts[industry - 1].length - 2); i >= 0; i--){
                        String prSt = "         G" + (i + 1) + ": ";
                        if(i < 9){
                            prSt += " ";
                        }
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
                        BNandBool thing = gens[industry - 1][i].production(rsch, commons[industry - 1][i], val, boost, industry, secs, ran, i);
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
                    System.out.println("\nCommon Cards: " + Arrays.toString(commons[industry - 1]));
                    /*
                    System.out.print("\nCommon Cards: [");
                    for(int i = 0; i < commons[industry - 1].length; i++){
                        System.out.print(new AdComNum(gens[industry - 1][i].getSpeedBoost(commons[industry - 1][i])));
                        if(i != commons[industry - 1].length - 1){
                            System.out.print(", ");
                        }
                    }
                    System.out.println("]");
                    */
                    BigNum valNum = new BigNum(amounts[industry - 1][1]);
                    gens[industry - 1][0].printDetails(rsch, commons[industry - 1][0], valNum, boost, industry, dur);
                    //System.out.println("Luck Chance: " + rsch.get)
                }
                System.out.println("\n----------------------------------------------------\n");
            } else {
                if(amounts[industry - 1].length == 1){
                    System.out.println("ERROR: No generator amounts entered.");
                    valid = false;
                }
                if(amounts[industry - 1].length - 1 > commons[industry - 1].length){
                    System.out.println("ERROR: Insufficient common cards assigned to generators.");
                    valid = false;
                }
                if(valid){
                    String[] duplicate = new String[amounts[industry - 1].length];
                    System.arraycopy(amounts[industry - 1], 0, duplicate, 0, amounts[industry - 1].length);
                    for(int k = 0; k < duplicate.length; k++){
                        AdComNum fixer = new AdComNum(new BigNum(duplicate[k]));
                        duplicate[k] = fixer.toString();
                    }
                    ArrayList<Researcher> relavantRsch = new ArrayList<Researcher>();
                    //BigNum secs = dur.getSecs();
                    AdComNum fix = new AdComNum(new BigNum(amounts[industry - 1][amounts[industry - 1].length - 1]));
                    amounts[industry - 1][amounts[industry - 1].length - 1] = fix.toString();
                    boolean rand[] = new boolean[commons[industry - 1].length];
                    boolean resRand = false;
                    for(int i = Math.min(commons[industry - 1].length - 1, amounts[industry - 1].length - 2); i >= 0; i--){
                        BigNum val = new BigNum(amounts[industry - 1][i + 1]);
                        BNandBool thing = gens[industry - 1][i].production(rsch, commons[industry - 1][i], val, boost, industry, secs, ran, i);
                        BigNum amt = thing.getBN();
                        if(i != 0){
                            rand[i - 1] = thing.getBOOL();
                        } else{
                            resRand = thing.getBOOL();
                        }
                        AdComNum acn = new AdComNum(BigNum.add(amt, new BigNum(amounts[industry - 1][i])));
                        amounts[industry - 1][i] = acn.toString();
                    }
                }
            }
        }
    }
    
    public void calculateAllIndustriesOffline(String[][] amounts, int[][] commons, int[] rares, BigNum secs, boolean boost, boolean ran, boolean reset, boolean print){
        for(int i = 0; i < getIndustries(); i++){
            calculateOffline(i + 1, amounts, commons, rares, secs, boost, ran, reset, print);
        }
    }
    
}