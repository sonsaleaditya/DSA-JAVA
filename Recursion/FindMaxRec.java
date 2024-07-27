class FindMaxRec{
    public static void main(String[] args) {
        System.out.println("HII");
        int arr[]={1,2,3,4,6,88,9};
        System.out.println(fm(arr,arr.length-1));
    }

    static int fm(int arr[],int n){
        if(n==0){
            return arr[0];
        }

        return Math.max(arr[n],fm(arr,n-1));
    }
}