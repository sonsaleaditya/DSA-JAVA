import java.util.LinkedList;

class DirectChaining {
    LinkedList<String>[] hashTable;

    DirectChaining(int size) {
        hashTable = new LinkedList[size];
    }

    int modAsciiFunction(String word) {
        int HashTableLength = hashTable.length;
        char ch[] = word.toCharArray();
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            index += ch[i];
        }
        return index % HashTableLength;
    }

    void insertKey(String key) {
        int newIndex = modAsciiFunction(key);
        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(key);
            System.out.println(key + " inserted at index " + newIndex);
        } else {
            // if linkedlist already allcoted then
            hashTable[newIndex].add(key);
            System.out.println(key + " inserted at index " + newIndex);
        }
    }

    void deleteKey(String key) {
        int targetIndex = modAsciiFunction(key);
        System.out.println(
                "target index of LinkedList is : " + targetIndex + "\n so search on this index you may get key \n");
        if (hashTable[targetIndex] == null) {
            System.out.println("key is not exist !!");
        } else {
            hashTable[targetIndex].remove(key);
            System.out.println(key + " deleted !!");
        }
    }

    void displayKeys(){
        if(hashTable.length==0){
            System.out.println("hashtable is empty!!");
        }else{
            for(int i =0 ; i<hashTable.length; i++){
                System.out.println("index : "+i);
                if(hashTable[i]!=null){
                    for(String k : hashTable[i]){
                    System.out.print(k + " ");
                    }
                }else{
                    System.out.println("empty ");
                }
                System.out.println();
                }
        }
    }
}

/**
 * DC
 */
public class DC {

     public static void main(String[] args) {
        DirectChaining obj = new DirectChaining(5);
        obj.insertKey("adit");
        obj.insertKey("aditya");
        obj.insertKey("babarao");
        obj.insertKey("sonsale");
        obj.deleteKey("adit");
        obj.displayKeys();
     }
}