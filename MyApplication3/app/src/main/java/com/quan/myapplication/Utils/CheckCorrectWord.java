

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class CheckCorrectWord {

public static String fileName = "C:\\Users\\Gryphon\\Desktop\\test.txt" ; // đổi tên file tại đây
    
    public static void main (String[] args) throws IOException {
        check(fileName);
    }

 
    private static void check(String fileName) throws IOException {
    Rule rule = new Rule();
    Path path = Paths.get(fileName);
    StringBuilder result = new StringBuilder("");
        Scanner scanner = new Scanner(path);
        // read word by word
        while (scanner.hasNext()) {
            String word = scanner.next();
            
            if(rule.checkValid(word) == false ){
                word= "$"+word;
            };
            result.append(" " + word);
            //check word
            //System.out.println(word);
        }
//        System.out.println(result);
    }
    
    
}