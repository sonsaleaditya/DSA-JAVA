import java.util.ArrayList;
public class DoubleHashing {
        String hashTable[];
        int usedCellNumber;
        DoubleHashing(int size){
            hashTable = new String[size];
            usedCellNumber = 0;
        }
    
        int hashFunction1(String word) {
            int HashTableLength = hashTable.length;
            char ch[] = word.toCharArray();
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                index += ch[i];
            }
            return index % HashTableLength;
        }
        int hashFunction2(String word) {
            char ch[] = word.toCharArray();
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                sum += ch[i];
            }
           
            if (sum > hashTable.length) {
                sum = addDigits(sum);
            }
            return sum % hashTable.length;
        }
        
       
        int addDigits(int sum) {
            if (sum == 0) {
              return 0;
            }
            return sum % 10 + addDigits(sum / 10);
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
            int x = hashFunction1(word);
            int y = hashFunction2(word);

            for(int i = 0 ; i<hashTable.length; i++){
              int newIndex = (x+i*y)%hashTable.length;
              if(hashTable[newIndex]==null){
                hashTable[newIndex]=word;
                System.out.println("'"+word+"'"+" inserted at index : "+newIndex);
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
            int targetIndex = hashFunction1(key);
            if(hashTable[targetIndex].equals(key)){
                hashTable[targetIndex] = null;
                System.out.println(key + " deleted from index " + targetIndex);
                return;
            } else {
                int y = hashFunction2(key);
                for(int i = 0; i < hashTable.length; i++) {
                    int newIndex = (targetIndex + i * y) % hashTable.length;
                    if(hashTable[newIndex] != null && hashTable[newIndex].equals(key)) {
                        hashTable[newIndex] = null;
                        System.out.println(key + " deleted from index " + newIndex);
                        return;
                    }
                }
                System.out.println("Key " + key + " not found.");
            }
        }
        
    }