public class Practice {
    static int size = 0;

    public static void main(String[] args) {
        int arr[] = { 1, 4, 3, 2, 5, 7, 4, 3 };
        int heapArr[] = new int[arr.length + 1];

        Practice obj = new Practice();

        for (int i = 0; i < arr.length; i++) {
            obj.insert(arr[i], heapArr);
            // Print the heap after each insertion
            System.out.print("After inserting " + arr[i] + ": ");
            for (int j = 1; j <= size; j++) {
                System.out.print(heapArr[j] + " ");
            }
            System.out.println();
        }

        // Test deletion of max element
        int del = obj.delete(heapArr);
        System.out.println("Deleted max: " + del);
        System.out.print("Heap after deletion: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heapArr[i] + " ");
        }
        System.out.println();

        // Heapify for a given heap (optional part of the task)
        int n = size;
        for (int i = n / 2; i > 0; i--) {
            obj.heapify(heapArr, n, i);
        }

        System.out.print("Heap after heapify: ");
        for (int i = 1; i <= size; i++) {
            System.out.print(heapArr[i] + " ");
        }
        System.out.println();
    }


    void insert(int k, int[] heapArr) {
        size++;
        heapArr[size] = k;
        int indx = size;
        // Heapify: compare the inserted element with its parent and swap if necessary
        while (indx > 1) {
            int parent = indx / 2;
            if (heapArr[parent] < heapArr[indx]) {
                swap(parent, indx, heapArr);
                indx = parent;
            } else {
                break;
            }
        }
    }



    private void swap(int a, int b, int arr[]) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    int delete(int arr[]) {
        if (size == 0) {
            return -1;
        }

        int result = arr[1];
        arr[1] = arr[size];
        size--;

        int i = 1;
        while (i <= size) {
            int leftChild = 2 * i;
            int rightChild = 2 * i + 1;
            int largest = i;

            if (leftChild <= size && arr[largest] < arr[leftChild]) {
                largest = leftChild;
            }
            if (rightChild <= size && arr[largest] < arr[rightChild]) {
                largest = rightChild;
            }

            if (largest != i) {
                swap(i, largest, arr);
                i = largest;
            } else {
                break;
            }
        }

        return result;
    }

    void heapify(int arr[], int n, int i) {

        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;

        if (left <= n && arr[largest] < arr[left]) {
            largest = left;
        }
        if (right <= n && arr[largest] < arr[right]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest, arr);
            heapify(arr, n, largest);
        }


    }

    void slidingWindow(){
        int arr[] = {1 ,2 ,3 ,1 ,4, 5 ,2 ,3 ,6};
        int s = 0,e = 0, n = arr.length;
        int k = 3;
        int  heap[] = new int[k];
        int size = 0;

        while(e<n){
            
            insert(n, arr);

            if(e-s+1==k){
                
            }

            e++;
        }

    }
}
