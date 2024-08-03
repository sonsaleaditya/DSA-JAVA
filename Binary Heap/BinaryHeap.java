import java.util.Arrays;

public class BinaryHeap {
    int heapArray[];
    int sizeOfTree;

    BinaryHeap(int size) {
        heapArray = new int[size + 1]; // Initialize heap array with given size + 1
        sizeOfTree = 0; // Initialize size of tree to 0
        System.out.println("Heap array is initialized ");
    }
    BinaryHeap(int arr[]){
        heapArray = arr;
        sizeOfTree = arr.length-1;
    }


    // Check if the heap is empty
    public boolean isEmpty() {
        return sizeOfTree == 0;
    }

    // Get the value of the root node (minimum or maximum depending on the heap type)
    public int peek() {
        if (isEmpty()) {
            System.out.println("Heap is Empty!!");
            return -1; // or throw an exception
        }
        return heapArray[1];
    }

    // Get the current size of the heap
    public int size() {
        return sizeOfTree;
    }

    // Display the elements of the heap in level order
    public void levelOrder() {
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }

    // Heapify the heap from bottom to top
    // private void heapifyBottomToTop(int index, String heapType) {
    //     int parentIndex = index / 2;
    //     if (index <= 1) {
    //         return;
    //     }
    //     if (heapType.equals("Min")) {
    //         if (heapArray[index] < heapArray[parentIndex]) {
    //             // Swap elements if the current node is less than its parent (for Min Heap)
    //             int temp = heapArray[index];
    //             heapArray[index] = heapArray[parentIndex];
    //             heapArray[parentIndex] = temp;
    //         }
    //     }
    //     if (heapType.equals("Max")) {
    //         if (heapArray[index] > heapArray[parentIndex]) {
    //             // Swap elements if the current node is greater than its parent (for Max Heap)
    //             int temp = heapArray[index];
    //             heapArray[index] = heapArray[parentIndex];
    //             heapArray[parentIndex] = temp;
    //         }
    //     }
    //     // Recursively call heapify for the parent node
    //     heapifyBottomToTop(parentIndex, heapType);
    // }

    private void heapify(int index , String heapType){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        // min 
        if(heapType.equals("min")){
            if(heapArray[parent] > heapArray[index]){
            int temp = heapArray[parent];
             heapArray[parent]=heapArray[index];
             heapArray[index]=temp;
            }
            
        }

        if(heapType.equals("max")){
            if(heapArray[parent] < heapArray[index]){
            int temp = heapArray[parent];
             heapArray[parent]=heapArray[index];
             heapArray[index]=temp;
            }
            
        }
        heapify(parent, heapType);
    }

    // Insert a new element into the heap
    public void insert(int value, String heapType) {
        // Increment the size of the tree and insert the new value at the end
        sizeOfTree++;
        int currentIndex = sizeOfTree;
        heapArray[currentIndex] = value;
        // Heapify from bottom to top to maintain heap property
        heapify(currentIndex, heapType);
        System.out.println("Inserted value: " + value);
    }

    public void insert(int val){
        sizeOfTree++;
        int index = sizeOfTree;
        heapArray[index]=val;
        //heapify
        while(index>1){
            int parent = index/2;
            // max heap
            if(heapArray[parent] < heapArray[index] ){
                swap(parent,index);
                index = parent;
            }else{
                System.out.println("inserted : "+ val);
                return;
            }
            
        }

    }

    
    private void swap(int a, int b){
        int temp  = heapArray[a];
        heapArray[a]=heapArray[b];
        heapArray[b]=temp;
        
        
    }
// always we delete root node here
    void delete(){
        if(sizeOfTree == 0){
           System.out.println("nothing to delete");
        }
        // swap root with last node
        swap(sizeOfTree, 1);
        sizeOfTree--;
        //fix position of new root
        int i = 1;
        while(i<sizeOfTree){
            int leftIndex = i*2;
            int rightIndex= i*2+1;

            if(heapArray[leftIndex] > heapArray[i] && leftIndex < sizeOfTree){
                swap(leftIndex, i);
                i = leftIndex;
            }
           else if  (heapArray[rightIndex] > heapArray[i] && rightIndex< sizeOfTree){
                swap(rightIndex, i);
                i = rightIndex;
            }   
            else{
                // if no heap is satisfying pop
                break;  
            }         
        }
       
    }

    //max heap
    void heapify(int index){
        int maxChild = index; 
        int leftIndex = index*2;
        int rightIndex = index*2+1;
        if(leftIndex < sizeOfTree && heapArray[maxChild] < heapArray[leftIndex]){
            maxChild = leftIndex;
        }
        if(rightIndex < sizeOfTree && heapArray[maxChild] < heapArray[rightIndex]){
            maxChild = rightIndex;
        }
        if(maxChild != index){
            swap(maxChild,index);
            heapify(maxChild);
        }
       
    }
}
