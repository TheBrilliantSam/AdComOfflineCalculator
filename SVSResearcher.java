import java.util.*;
public class SVSResearcher extends Researcher{
    public SVSResearcher(double none, ArrayList<Integer> ind){
        super("crit", none, -1, -1, ind);
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
}