import java.util.Scanner;

public class RemoveBracketFromExpression {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
       System.out.println("enter a string : ");
       String str = sc.nextLine();
        System.out.println("result String is : " + remomveBracket(str));
    }

    static String remomveBracket(String str){
        String ans = "";
        for(int i = 0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='(' || ch==')' || ch == '{' || ch == '}' || ch == '[' || ch == ']'){
                continue;
            }else{
                ans+=ch;
            }
        }
        return ans;
    }
}
