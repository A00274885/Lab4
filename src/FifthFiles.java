import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FifthFiles
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("C:\\Users\\caola\\Documents\\Java Projects\\Lab4\\src\\text.txt");
        String words = "";
        Scanner sc = new Scanner(f);
        //Translates the file text into the string words
        //Also removes things we dont need
        while(sc.hasNextLine())
        {
            words = words + sc.nextLine();
            words = words.replace("'","");
            words = words.replace("\"","");
            words = words.replace(".","");
            words = words.replace(",","");
            words = words.replace("!","");
        }
        //converts the string into an array defining each split to be an empty space
        String [] wordsArray = words.split(" ");
        //Calls the method
        splitFiles(wordsArray,5);
    }

    private static void splitFiles(String[] words, int numFile)
    {
        //Accounts for if the number of files surpasses the amount of words in the text
        if (numFile > words.length)
            numFile = words.length;

        //The partition determines how many words should go into each file
       int  partition = (words.length / numFile);

       File [] files = new File[numFile];

       //The following for loop creates and names each file
       for(int i = 0; i < files.length; i++)
       {
           files[i] = new File("text" + (i + 1) + ".txt");
       }


       for (int i = 0; i < numFile; i++)
       {
        try
        {
            //The printwriter allows us to input data to the files
            PrintWriter pw = new PrintWriter(files[i]);
            //For loop uses the partition to print the required number of words into each file
            for (int j = (i * partition); j < ((i + 1) * partition); j++)
            {

                pw.println(words[j]);

            }
            pw.close();//save filewords
        }
        catch(Exception e)
        {
            System.out.println("PW Exception");
            e.printStackTrace();
        }
       }
    }
}
