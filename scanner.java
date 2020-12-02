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

    //read file
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

    //check what type of tokens
    public static void tokenrecognizer(String s)
    {    
        if(isGPR(s))
            sTokens.add("GPR ");
        else if(isFPR(s))
            sTokens.add("FPR ");
        else if(isKeyword(s))
            sTokens.add("KEYWORD ");
        else
            sTokens.add("ERROR ");

    }
   
    //check if pattern is a GPR
    // Input: String that contains the pattern that would be checked
    // return: True if it is a GPR and False if not
    public static boolean isGPR(String s)
    {
        int index=0;
        if(s.charAt(index)=='$')
        {
            if(s.length()>1)
            {
                return isNumber(s.substring(1,s.length()));
            }
        }
        else if(s.charAt(index)=='R')
        {
            if(s.length()>1)
            {
                return isNumber(s.substring(1,s.length()));
            }
            
        }
        //if String did not satisfy any of the above conditions
        return false;
    }
    
    //check if pattern is a FPR
    // Input: String that contains the pattern that would be checked
    // return: True if it is a FPR and False if not
    public static boolean isFPR(String s)
    {
        int index=0;
        if(s.charAt(index)=='$' && s.length()>2)
        {
            index++;
            if(s.charAt(index)=='F')
            {
               return isNumber(s.substring(2,s.length()));   
            }
        }
        else if(s.charAt(index)=='F')
        {
            if(s.length()>1)
            {
                return isNumber(s.substring(1,s.length()));
            }
        }
        //if String did not satisfy any of the above conditions
        return false;
    }
    
    //check if String is between 0-31
    // Input: String that contains the number that would be checked
    // return: True if it is between 0-31 and False if not
    public static boolean isNumber(String s)
    {
        if(isNumeric(s))
        {
            int index=0;
            if(s.length()==1)
            {
                if(s.charAt(index)>='0'  || s.charAt(index)<='9')
                {
                    return true;
                }
            }
            else if(s.length()==2)
            {
                if(s.charAt(index)=='3')
                {
                    index++;
                    if(s.charAt(index)>='0' && s.charAt(index)<='1')
                    {
                        return true;
                    }
                }
                else if(s.charAt(index)>='1' && s.charAt(index)<='2')
                {
                    index++;
                    if(s.charAt(index)>='0'  || s.charAt(index)<='9')
                    {
                        return true;
                    }
                }
            }
        }
        //if String did not satisfy any of the above conditions
        return false;
    }

    //check if it a string is numeric first
    //input string
    //return true if numeric else return false
    public static boolean isNumeric(String s)
    {
         for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
    //check if pattern is a KEYWORD
    // Input: String that contains the pattern that would be checked
    // return: True if it is a KEYWORD and False if not
    public static boolean isKeyword(String s)
    {
        int index=0;
        if(s.charAt(index)=='D' && s.length()>=5)
        {
            index++;
            if(s.charAt(index)=='A')
            {
                index++;
                if(s.charAt(index)=='D')
                {
                    index++;
                    if(s.charAt(index)=='D')
                    {
                        index++;
                        if(s.charAt(index)=='U')
                        {
                            if(s.length()>5)
                            {
                                return false;
                            }
                            return true;
                        }
                        else if(s.length()==6 && s.charAt(index)=='I')
                        {
                            index++;
                            if(s.charAt(index)=='U')
                            {
                                return true;
                            }
                        }
                        
                    }
                }

            }
            else if(s.charAt(index)=='M')
            {
                index++;
                if(s.charAt(index)=='U')
                {
                    index++;
                    if(s.charAt(index)=='L')
                    {
                        index++;
                        if(s.charAt(index)=='T')
                        {
                            index++;
                            if(s.length()==6 && s.charAt(index)=='U')
                            {
                                return true;
                            }
                            else if(s.length()>=6)
                            {
                                return false;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        //if String did not satisfy any of the above conditions
        return false;
    }

    //write file 
    public static void filewriter()
    {
        try {
            FileWriter writer = new FileWriter("Output.txt", true);
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
Numeric string: https://mkyong.com/java/java-how-to-check-if-a-string-is-numeric/
*/
