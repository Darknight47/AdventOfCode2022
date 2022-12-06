package Daysix;
import java.io.*;
import java.util.HashSet;
/*
 * Link for the challange: https://adventofcode.com/2022/day/6
 */

public class DaySixth {
    public static void main(String[] args) throws IOException {
        File file = new File("Day6input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = "";
        int answerFirstPart = -1;
        int answerSecondPart = -1;
        DaySixth ds = new DaySixth();
        while((temp = br.readLine()) != null)
        {
            char[] arr = temp.toCharArray();
            answerFirstPart = ds.firstPart(arr);
            answerSecondPart = ds.secondPart(arr);          
        }
        System.out.println(answerFirstPart);
        System.out.println(answerSecondPart);
        br.close();
    }

    private int firstPart(char[] arr)
    {
        for (int i = 0; i < arr.length - 3; i++) {
            char first = arr[i];
            char second = arr[i + 1];    
            char third = arr[i + 2];    
            char fourth = arr[i + 3];
            HashSet<Character> tempSet = new HashSet<>();    
            tempSet.add(first);
            tempSet.add(second);
            tempSet.add(third);
            tempSet.add(fourth);
            if(tempSet.size() == 4)
            {
                return (i + 4);
            }
        }
        return -1;
    }

    private int secondPart(char[] arr)
    {
        for (int i = 0; i < arr.length - 14; i++) {
            HashSet<Character> tSet = new HashSet<>();
            int indx = 0;
            int cpy = i;
            while(indx < 14)
            {
                char ch = arr[cpy];
                tSet.add(ch);
                indx++;
                cpy++;
            }

            if(tSet.size() == 14)
            {
                return cpy;
            }
        }
        return -1;
    }
}
