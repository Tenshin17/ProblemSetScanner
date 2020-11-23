import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class test {  
    public static ArrayList <String> sTokens = new ArrayList<String>();

    public static void main(String args[])throws Exception{    
           
        String x="   5 spaces, before            this one,,,, 4 commas";

        String y=x.replace(",", "");
        System.out.println("x= "+x);
        System.out.println("y= "+y);
        
        String []temp=y.split(" ");
        for(int i=0;i<temp.length;i++)
        {
            
            if(!temp[i].isEmpty())
            System.out.println(i+":"+temp[i]);
        }
       
    }   
    
}    




/*Sources:
Write File:https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
Read File: https://www.tutorialspoint.com/java/io/bufferedreader_readline.htm
*/