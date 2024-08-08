import java.util.*;
public class SVSResearcher extends Researcher{
    private ArrayList<Integer> industry;
    private double non;
    public SVSResearcher(double none, ArrayList<Integer> ind){
        super("crit", none, -1, -1, ind);
        industry = ind;
        non = none;
    }
    public BigNum getBoost(){
        // 4^n + 5(n^2)
        int lvl = super.getLvl();
        if(lvl != 0){
            BigNum part1 = new BigNum(1.0, 0);
            for(int i = 0; i < lvl; i++){
                part1 = BigNum.multiply(part1, 4.0);
            }
            BigNum part2 = new BigNum(lvl, 0);
            part2 = BigNum.multiply(part2, lvl);
            part2 = BigNum.multiply(part2, 5.0);
            return BigNum.multiply(BigNum.add(part1, part2), super.getNone());
        } else{
            return new BigNum(super.getNone(), 0);
        }
    }
    public BigNum getBoost(int lvl){
        if(lvl != 0){
            BigNum part1 = new BigNum(1.0, 0);
            for(int i = 0; i < lvl; i++){
                part1 = BigNum.multiply(part1, 4.0);
            }
            BigNum part2 = new BigNum(lvl, 0);
            part2 = BigNum.multiply(part2, lvl);
            part2 = BigNum.multiply(part2, 5.0);
            return BigNum.multiply(BigNum.add(part1, part2), super.getNone());
        } else{
            return new BigNum(super.getNone(), 0);
        }
    }
    public String toString(int index){
        String ret = "RS" + index + " - ";
        if(industry.size() > 1){
            ret += "Global ";
        } else{
            ret += "Ind " + industry.get(0) + " ";
        }
        ret += "Crit Bonus: ";
        for(int i = 1; i <= 4; i++){
            ret += "x";
            ret += Operations.removeDecimals(BigNum.divide(getBoost(i), non).toDouble());
            if(i != 4) ret += ", ";
        }
        ret += "...";
        return ret;
    }
}