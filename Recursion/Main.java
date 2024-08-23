public class Main {
    public static void main(String[] args) {
        int input = 30;

        // Check if 'input' is divisible by 3 and 5
        if (input % 3 == 0) {
            System.out.print("Raja ");
        } 
        else if (input % 5 == 0) {
            System.out.print("Software ");
        } 
        // Check if 'input' is divisible by 3
         if (input %  3 == 0 && input % 5 ==  0 ) {
            System.out.print("Raja Software");
        } 
        // Check if 'input' is divisible by 5
       
        // If none of the above conditions are true
        else {
            System.out.print("Exit");
        }
    }
}
