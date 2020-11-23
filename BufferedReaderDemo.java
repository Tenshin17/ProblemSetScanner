import java.io.BufferedReader;  
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class BufferedReaderDemo {  
    public static ArrayList <String> sTokens = new ArrayList<String>();

    public static void main(String args[])throws Exception{    
           
        filereader();
        System.out.println("IN MAIN");
        for(int i=0;i<sTokens.size();i++)
        {
            if(sTokens.get(i)!=null && !sTokens.get(i).equals("\n"))
            {
                int j=0;

                if(sTokens.get(i).charAt(j)=='R')
                    sTokens.set(i,"GPR ");
                else if(sTokens.get(i).charAt(j)=='$')
                    sTokens.set(i,"FPR ");   
                else if(sTokens.get(i).charAt(j)=='D')
                    sTokens.set(i,"KEYWORD ");
                else
                    sTokens.set(i,"Error ");
            }
            else
            sTokens.set(i,"\n");
            System.out.println(sTokens.get(i));
        }
        System.out.println("IN MAIN");
        filewriter();
        System.out.println("Done");
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
                String []temp = thisLine.split("[\s,]+");
                for(int i=0;i<temp.length;i++)
                {
                    //System.out.println(temp[i]);
                    sTokens.add(temp[i]+" ");
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