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
        super(bp, bt, -1, -1);
        varA = a;
        varB = b;
    }
    
    public int getSpeedBoost(int l){
        return varB * (int)(Math.pow(varA, l)) + (int)(Math.pow(l, 2));
    }
    
}