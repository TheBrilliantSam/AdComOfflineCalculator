public class BNandBool{ // The sole purpose of this class is to encapsulate a BigNum object along with a boolean, for if randomization occurred.
    
    private BigNum big;
    private boolean bool;
    
    public BNandBool (BigNum bn, boolean b){
        big = bn;
        bool = b;
    }
    
    public BigNum getBN(){
        return big;
    }
    
    public boolean getBOOL(){
        return bool;
    }
    
    
}