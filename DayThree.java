/*
 * Link: https://adventofcode.com/2022/day/3
 */
import java.io.*;

public class DayThree
{
    public static void main(String[] args) throws IOException {
        File file = new File("Day3input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String temp = "";
        long total = 0;
        int counter = 0;
        String first = "";
        String second = "";

        while((temp = br.readLine()) != null)
        {
            //ArrayList<Character> arr = new ArrayList<>(); For the first part.
            counter++;
            char c = ' ';
            boolean isLower = false;
            /* -------------------- PART ONE --------------------
            for (int i = 0; i < tempArr.length / 2; i++) {
                arr.add(tempArr[i]);
            }
            for (int i = tempArr.length / 2; i < tempArr.length; i++) {
                if(arr.contains(tempArr[i]))
                {
                    c = tempArr[i];
                    break;
                }
            }
            */
            if(counter == 3)
            {
                char[] tempArr = temp.toCharArray();
                for (int i = 0; i < tempArr.length; i++) {
                    char ch = tempArr[i];
                    if(first.indexOf(ch) >= 0 && second.indexOf(ch) >= 0)
                    {
                        c = ch;
                        break;
                    }
                }
                first = "";
                second = "";
            }
            else
            {
                if(counter == 1)
                    first = temp;
                else
                    second = temp;
            }
            
            if(counter == 3)
            {
                if(Character.isLowerCase(c))
                    isLower = true;
                else
                {
                    c = Character.toLowerCase(c);
                    isLower = false;
                }
                int priority = 0;
                for (int i = 0; i < alphabet.length; i++) {
                    if(alphabet[i] == c)
                    {
                        priority = i;
                        priority++;
                        break;
                    }
                }
                if(isLower)
                {
                    total += priority;
                }
                else
                {
                    priority = 26 + priority;
                    total += priority;
                }
                counter = 0;
            } 
        }
        System.out.println(total);
        br.close();
    }
}