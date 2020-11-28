// import java.io.BufferedReader;  
// import java.io.FileReader;
// import java.io.FileWriter;
import java.util.*;

public class test {  
    public static ArrayList <String> sTokens = new ArrayList<String>();

    public static void main(String args[])throws Exception{

     
        System.out.println(isNumber("F"));
        System.out.println(Character.isDigit('F'));
  

    }   

    public static boolean isNumber(String s)
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
        //if String did not satisfy any of the above conditions
        return false;
    }
    
}    

// for (; i < length; i++) {
//     char c = str.charAt(i);
//     if (c < '0' || c > '9') {
//         return false;
//     }
// }
     
// String x="   5 spaces, before            this one,,,, 4 commas";

// String y=x.replace(",", "");
// System.out.println("x= "+x);
// System.out.println("y= "+y);

// String []temp=y.split(" ");
// for(int i=0;i<temp.length;i++)
// {
    
//     if(!temp[i].isEmpty())
//     System.out.println(i+":"+temp[i]);
// }


/*Sources:
Write File:https://www.codejava.net/java-se/file-io/how-to-read-and-write-text-file-in-java
Read File: https://www.tutorialspoint.com/java/io/bufferedreader_readline.htm
*/