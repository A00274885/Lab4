import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fswapper
{
    public static void main(String[] args)
    {
    File dir = new File ("Files");
    File[] files = dir.listFiles();

    for(int i = 0; i < files.length; i++)
    {
        int random = (int)(Math.random() * files.length);
        swap(files,random,i);
    }
    for (int i = 0; i< files.length;i++)
    {
        stats(files,i);
    }

    }



    private static void swap(File[] f, int r, int num)
    {
        try {
            Scanner sc1 = new Scanner(f[num]);
            Scanner sc2 = new Scanner(f[r]);

            String file1 = "";
            String file2 = "";

            while(sc1.hasNextLine())
            {
            file1 = file1 + sc1.nextLine();
            }

            while(sc2.hasNextLine())
            {
                file2 = file2 + sc2.nextLine();
            }

            sc1.close();
            sc2.close();

            PrintWriter pw1 = new PrintWriter(f[num]);
            PrintWriter pw2 = new PrintWriter(f[r]);

            pw1.println(file2);
            pw2.println(file1);

            pw1.close();
            pw2.close();
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }

    private static void stats(File[] f, int i)
    {
        try
        {
            int countWords = 0;
            int numVowels = 0;
            Scanner sc = new Scanner(f[i]);
            while(sc.hasNext())
            {
                String temp = sc.next();

                numVowels = numVowels + numVowels(temp);

                countWords++;
            }
            System.out.println("File = " + (i +1));
            System.out.println("The number of words is = "+countWords);
            System.out.println("Number of vowels per word is: " + (numVowels/countWords));
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println("Not Found");
        }
    }

    private static int numVowels(String temp)
    {
        int count = 0;
        //changes the words to lowercase
        temp = temp.toLowerCase();

        for(char c : temp.toCharArray())
        {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            {
                count ++;
            }
        }
        return count;
    }


}
