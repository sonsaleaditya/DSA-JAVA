import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
       Scanner sc  = new Scanner(System.in);
       System.out.println("enter a string : ");
       String str = sc.nextLine();
        System.out.println("reversed String is : " + reverse(str));
    }

   static String reverse(String str){
        StringBuilder sb = new StringBuilder(str);

        return sb.reverse().toString();
    }
}
