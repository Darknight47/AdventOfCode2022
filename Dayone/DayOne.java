package Dayone;
import java.io.*;
import java.util.ArrayList;
/**
 * Link to the first day's challenge: https://adventofcode.com/2022/day/1
 */
import java.util.Collections;

public class DayOne{
    public static void main(String[] args) throws IOException {
        File file = new File("day1input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        //int largest = 0; This is for part one of the question.
        String temp = "";
        long tempNum = 0;
        ArrayList<Long> arr = new ArrayList<>();
        while((temp = br.readLine()) != null)
        {
            if(temp.isBlank())
            {
                //This is for part one of the question.
                // if(tempNum > largest)
                // {
                //     largest = tempNum;
                // }
                arr.add(tempNum);
                tempNum = 0;
            }
            else
                tempNum += Long.parseLong(temp);
        }
        Collections.sort(arr);
        long ans = arr.get(arr.size() - 1) + arr.get(arr.size() - 2) + arr.get(arr.size() - 3);
        System.out.println(ans);
        br.close();
    }
}