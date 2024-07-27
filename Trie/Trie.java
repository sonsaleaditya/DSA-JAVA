public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
        System.out.println("the new trie has been created");
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            TrieNode chNode = current.child.get(ch);
            if(chNode == null){
                chNode = new TrieNode();
                current.child.put(ch,chNode);
            }
            current = chNode;
        
        }
        current.endOfString = true;
        System.out.println("succesfully inserted "+ word + " in trie ");
    }

    boolean search(String word){
         //if word not found 
         
         TrieNode curr = root;
         for(int i = 0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = curr.child.get(ch);
            if(node==null){
                System.out.println("string not exiest !!");
                return false;
            }
            curr = node;

         }
         if(curr.endOfString == true){
            System.out.println("string found !!!");
            return true;
         }else{
            System.out.println("string not exiest !!");
         }
         
         return curr.endOfString;
    }

    private boolean delete(TrieNode parent, String word, int index){
        char ch = word.charAt(index);
        TrieNode curr = parent.child.get(ch);

        boolean canThisNodeToBeDeleted;
        //case 1
        if(curr.child.size()>1){
            delete(parent, word, index+1);
            return false;
        }
        //case2
        if(index==word.length()-1){
            if(curr.child.size()>=1){
                curr.endOfString = false;
                return false;
            }else{
                parent.child.remove(ch);
                return true;
            }
        }

        //case 3
        if(curr.endOfString == true){
            delete(parent, word, index+1);
            return false;
        }

        //case 4

       canThisNodeToBeDeleted = delete(parent, word, index+1);
       if(canThisNodeToBeDeleted == true){
        parent.child.remove(ch);
        return true;
       }else{
        return false;
       }
    }

       public void delete(String word){
        if(search(word))
            delete(root, word, 0);
       }
    
}
