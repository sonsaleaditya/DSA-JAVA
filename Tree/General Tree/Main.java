import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class Main {
    public static void main(String[] args) {
         TreeNode drinks = new TreeNode("Drinks");
         TreeNode hot = new TreeNode("Hot");
         TreeNode cold = new TreeNode("cold");
         TreeNode normal = new TreeNode("normal");
         TreeNode tea = new TreeNode("tea");
         TreeNode hotwater = new TreeNode("hot water");
         TreeNode coffee = new TreeNode("coffee");
         TreeNode wine = new TreeNode("wine");
         TreeNode beer = new TreeNode("beer");
         TreeNode water = new TreeNode("water");
         
         drinks.addChild(hot);
         drinks.addChild(cold);
         drinks.addChild(normal);


         hot.addChild(tea);
         hot.addChild(coffee);
         hot.addChild(hotwater);
         cold.addChild(wine);
         cold.addChild(beer);
         normal.addChild(water);

    System.out.println(drinks.print(0));
    String s = "aditya " + "  ".repeat(4)+" sonsale";
    System.out.println(s);
    }
   
}
