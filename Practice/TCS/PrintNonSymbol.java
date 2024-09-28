public class PrintNonSymbol {
    public static void main(String[] args) {
        String str = "#$%@!@#aditya**Sonsa%ie";
        
        System.out.println(nonSymbol(str));
    }

    static String nonSymbol(String str) {
        String ans = "";

        System.out.println(65+25);
        for(int i = 0; i<str.length();i++){
            int pos  = (int) str.charAt(i);
            if((pos >=65 && pos<=90 )|| (pos>=97 && pos<=122)){
                ans+=str.charAt(i);
            } 
        }
        
        System.out.println((int) 'a' + " : "+ (int)'A');

        return ans;
    }
}
