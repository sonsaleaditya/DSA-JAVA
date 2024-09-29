import java.util.Scanner;

public class SumOfNumberInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string : ");
        String str = sc.nextLine();
        System.out.println("result String is : " + sum(str));
    }

    static int sum(String str) {
        int n = str.length();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            char ch  = str.charAt(i);
            if(Character.isDigit(ch)){
                sum+=Integer.parseInt(ch+"");
            }

        }
        return sum;
    }

}
