import java.util.ArrayList;

public class RotateAndDelete {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);

        System.out.println(roteateDelete(arr));
    }

    static int roteateDelete(ArrayList<Integer> arr) {
        int n = arr.size(), k = 1;
        while (n > 1) {
            arr.add(0, arr.remove(n - 1));
            int id = n - k;
            if (id < 0)
                id = 0;

            arr.remove(id);
            k++;
            n--;

        }

        return arr.get(0);
    }
}
