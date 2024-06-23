import java.util.*;
public class AgesGenerator extends Generator{
    
    /*
    
    EGYPT/JAPAN:
    IND 1 = i * 3^(level) + (level)^2
    IND 2 = 2i * 3^(level) + (level)^2
    IND 3 = 3i * 3^(level) + (level)^2
    
    SCANDINAVIA:
    IND 1 = 3^(level) + (level)^2
    IND 2 = 4^(level) + (level)^2
    IND 3 = 5^(level) + (level)^2
    
    GENERAL:
    boost = b * a^(level) + (level)^2
    
    */
    
    private int varA;
    private int varB;
    
    public AgesGenerator(int bp, int bt, int a, int b){
        super(bp, bt);
        varA = a;
        varB = b;
    }
    
    public BigNum getSpeedBoost(int l){
        BigNum part1 = new BigNum(1, 0);
        for(int i = 0; i < l; i++){
            part1 = BigNum.multiply(part1, varA);
        }
        part1 = BigNum.multiply(part1, varB);
        BigNum part2 = new BigNum(l * l, 0);
        BigNum ret = BigNum.add(part1, part2);
        return ret;
    }
    
}