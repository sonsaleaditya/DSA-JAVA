public class SumOfCube {
    public static void main(String[] args) {
        int a =4, b = 9;

        System.out.println(sumOfCube(a, b));
    }

    static int sumOfCube(int a, int b){
        int sum = 0;
        for(int i =a ;i<=b;i++){
            sum+=Math.pow(i, 3);
        }

        return sum;
    }
}
