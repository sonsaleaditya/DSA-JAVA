import java.util.ArrayList;
public class QuadraticProbing{
    String hashTable[];
    int usedCellNumber;
    QuadraticProbing(int size){
        hashTable = new String[size];
        usedCellNumber = 0;
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

    double getLoadFactor(){
        return usedCellNumber*1.0/hashTable.length;
    }

    void rehashKeys(){
        usedCellNumber = 0;
        ArrayList<String> data  = new ArrayList<>();
        for(String k : hashTable){
            if(k!=null)
                data.add(k);
        }

        hashTable = new String[2*data.size()];
        for(int i = 0; i<data.size(); i++){
            hashTable[i] = data.get(i);
        }

        System.out.println("hashtable reallocated with size " + hashTable.length);
    }

    void insertKeys(String word){
        
        if(getLoadFactor() >= 0.75){
            rehashKeys();
        }

        int insertinIndex = modAsciiFunction(word);
       
        for(int i = 0; i<word.length(); i++ ){
              insertinIndex =(insertinIndex + i*i) % hashTable.length;
            if(hashTable[insertinIndex]==null){
                hashTable[insertinIndex]=word;
                System.out.println("'" +word + "'"+ " inserted at index : "+insertinIndex);
                break;
            }
        }
        usedCellNumber++;
    }

    void displayKey(){
        if(hashTable.length == 0){
            System.out.println("hastable is empty!!");
        }else{

            for(int i = 0; i<hashTable.length; i++){
                 System.out.println("index : "+i +" key : "+hashTable[i]);
            }
           
        }
    }

    void deleteKeys(String key){
        int targetIndex = modAsciiFunction(key);
        if(hashTable[targetIndex].equals(key)){
              System.out.println("target is locked at : "+targetIndex);
              hashTable[targetIndex]=null;
              System.out.println(key + " get killed ");
        }else{
            for(int i = 0; i<hashTable.length; i++){
                if(hashTable[i].equals(key)){
                    System.out.println("target is locked at : "+targetIndex);
                    hashTable[targetIndex]=null;
                    System.out.println(key + " get killed !! ");
                    System.out.println("mission succesfull !!!");
                    return;
                }
            }
            System.out.println("target is escaped or not exist !!");
        }
            
              
       
    }
}

