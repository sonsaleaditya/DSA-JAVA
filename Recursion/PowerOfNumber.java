public class PowerOfNumber {
    public static void main(String[] args) {
        System.out.println(calculatPower(2, 1));
        System.out.println(optimizedPower(2, 9));
    }
    static int calculatPower(int base,int exp){
        if(exp==1){
            return base;
        }
        return base*calculatPower(base, exp-1);
    }

    static int optimizedPower(int base, int exp){

        if(exp==1){
            return base;
        }
        int result = optimizedPower(base, exp/2);
        if(exp % 2==0)  
            return result*result;
        return base*result*result;
        
    }
}
