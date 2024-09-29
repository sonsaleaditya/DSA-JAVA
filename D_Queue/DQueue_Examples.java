import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
public class DQueue_Examples {

    public static void main(String[] args) {
        Deque<Integer> dq  = new ArrayDeque<>();
        dq.addFirst(1);
        dq.addLast(2);
        dq.removeFirst();
        dq.removeLast();
        System.out.println(dq);
        
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(solve(arr,k));
    }

    static ArrayList<Integer> solve(int arr[], int k){
        Deque<Integer> dq = new ArrayDeque();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            if(!dq.isEmpty() &&  dq.peekFirst() == i-k) dq.removeFirst();
            while(!dq.isEmpty()&& arr[dq.peekLast()]<=arr[i]) dq.removeLast();
            dq.addLast(i);

            if(i>k-1) ans.add(arr[dq.peekFirst()]);
        }

        return ans;
    }
}
