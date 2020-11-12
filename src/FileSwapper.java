import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSwapper
{
    public static void main(String[] args)
    {
       fileSwap(5);

    }

    private static void fileSwap(int numFile)
    {
        File[] files = new File[numFile];
        String[] temp = new String[numFile];
        try
        {
            //Adding the files to the array
            for (int i = 0; i < files.length; i++)
            {
            files[i] = new File("text" + (i + 1) + ".txt");
            Scanner sc = new Scanner(files[i]);
            while (sc.hasNext())
            {
                temp[i] = temp[i] + sc.nextLine();
            }
            }
            //Randomly choose what file to write to another
            for (int i = 0; i < files.length; i++)
            {
                int tempRan = (int)(Math.random() * files.length);
                PrintWriter out = new PrintWriter(files[i]);
                for(int l = 0; l < temp.length; l++)
                {
                    out.print(temp[i]);
                }
                out.close();
            }


        }
        catch(Exception e)
        {
           System.out.println("File not found");
        }
    }
}
