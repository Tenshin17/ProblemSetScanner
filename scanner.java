import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class scanner {  
    public static ArrayList <String> sTokens = new ArrayList<String>();

    public static void main(String args[])throws Exception{    
        System.out.println("START");
        filereader();   
        filewriter();
        System.out.println("DONE");
    }    


    public static void filereader()throws Exception
    {
        String thisLine = null;
        try 
        {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            while ((thisLine = br.readLine()) != null) 
            {
               // System.out.println(thisLine);
             
                String x= thisLine.replace(",", "");

                String []temp = x.split(" ");

                for(int i=0;i<temp.length;i++)
                {
                    if(!temp[i].isEmpty())
                    tokenrecognizer(temp[i]);
                }
               sTokens.add("\n");
            }   
            br.close();    
         } 
         catch(Exception e) 
         {
            e.printStackTrace();
         }
    }

    public static void tokenrecognizer(String s)
    {
    
        int j=0;
        if(s.charAt(j)=='R')
            sTokens.add("GPR ");
        else if(s.charAt(j)=='$')
            sTokens.add("FPR ");   
        else if(s.charAt(j)=='D')
            sTokens.add("KEYWORD ");
        else
            sTokens.add("Error ");      

    }
    public static void filewriter()
    {
        try {
            FileWriter writer = new FileWriter("Output1.txt", true);
            for(int i=0;i<sTokens.size();i++)
            {
               writer.write(sTokens.get(i));
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}    




/*Sources:
Write File:https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
Read File: https://www.tutorialspoint.com/java/io/bufferedreader_readline.htm
*/