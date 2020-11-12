import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FifthWord
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File f = new File("C:\\Users\\caola\\Documents\\Java Projects\\Lab4\\src\\text.txt");

        Scanner sc = new Scanner(f);

        int wordCount = 0;

        while (sc.hasNext())
        {
            wordCount++;
            if (wordCount % 5 == 0)
            {
                System.out.println(sc.next());
            }
            else
            sc.next();

        }
    }
}
