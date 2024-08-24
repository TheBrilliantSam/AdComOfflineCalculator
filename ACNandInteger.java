public class ACNandInteger{ // The sole purpose of this class is to encapsulate an AdComNum object along with an int, for classifying missions.
    
    private AdComNum acn;
    private int industry;
    
    public ACNandInteger (AdComNum a, int i){
        acn = a;
        industry = i;
    }
    
    public AdComNum getACN(){
        return acn;
    }
    
    public int getINT(){
        return industry;
    }
    
    
}