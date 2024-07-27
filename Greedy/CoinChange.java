import java.util.Arrays;
public class CoinChange {
static void coinChange(int N, int coins[]){
       
        Arrays.sort(coins);
        int index = coins.length-1;
        while(true) {
            int coinValue = coins[index];
            index--;
            int selectedCoins = (N/coinValue)*coinValue;
            if(selectedCoins>0)
            {
                System.out.println("selected coin of : "+coinValue +" X "+(N/coinValue));
                N=N-selectedCoins;
            }
            if(N==0){
                break;
            }
        }
    }

public static void main(String[] args) {
    int coins[] = {1,2,5,10,20,50,100,1000};
    coinChange(2035, coins);
}
}
