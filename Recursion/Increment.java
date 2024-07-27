public class Increment {
    public static void main(String[] args) {
        increasing(5);
    }

    static void increasing(int n){
        if(n<1){
            System.out.println("n is less than 1");
            // after getting into this if condition fuction get end 
        }else{
            increasing(n-1);
            System.out.print(n+" ");
        }
    }
}
