public class Queue{
        int arr[];
        int front,end;
    Queue(int size){
        
        this.arr = new int[size];
        this.front = -1;
        this.end = -1;
    }

    public boolean isEmpty(){
        if(front==-1 && end==-1) 
            return true;

        return false;
    }

    public boolean isFull(){
        if(end == arr.length-1) 
            return true;
        return false;
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is Full !!!");
            return;
        }
        if(front ==-1 && end ==-1){
            front++;
            end++;
            arr[end]=data;
        }else{
             end++;
        arr[end]=data;
        }
       
        

    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
        }else{
            if(front == end){
                 System.out.println(arr[front++] + " is deleted");
                 front = end = -1;
            }
           
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!!");
        }
            return arr[front];
        
    }

    public void deleteQueue(){
        if(isEmpty())
            System.out.println("queue is already empty!!");
        arr=null;
        front = end = -1;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("queue is empty!");
        }else{
            System.out.print("elements are : ");
            for(int i = front; i<=end;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
        }
    }
}