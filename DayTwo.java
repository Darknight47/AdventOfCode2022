/*
 * Link to the challenge: https://adventofcode.com/2022/day/2
 */
import java.io.*;

public class DayTwo
{
    public static void main(String[] args) throws IOException {
        File file = new File("Day2input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = "";
        long total = 0;
        while((temp = br.readLine()) != null)
        {
            String[] strs = temp.split(" ");
            String computer = strs[0];
            String you = strs[1];
            // ---------------- Part One --------------------- //
           /* if(computer.compareTo("A") == 0)
            {
                if(you.compareTo("Y") == 0)
                {
                    total += 8;
                }
                else if(you.compareTo("X") == 0)
                {
                    total += 4;
                }
                else if(you.compareTo("Z") == 0)
                {
                    total += 3;
                }
            }
            else if(computer.compareTo("B") == 0)
            {
                if(you.compareTo("X") == 0)
                    total += 1;
                else if(you.compareTo("Y") == 0)
                    total += 5;
                else if(you.compareTo("Z") == 0)
                    total += 9;
            }
            else if(computer.compareTo("C") == 0)
            {
                if(you.compareTo("X") == 0)
                    total += 7;
                else if(you.compareTo("Y") == 0)
                    total += 2;
                else if(you.compareTo("Z") == 0)
                    total += 6;
            }
            */
            // ------------------ Part Two ------------------- //
            if(computer.compareTo("A") == 0) //Rock
            {
                if(you.compareTo("X") == 0) //Loose
                    total += 3; //3 + 0
                else if(you.compareTo("Y") == 0) //Draw
                    total += 4; //1+3
                else if(you.compareTo("Z") == 0) //Win
                    total += 8; //2+6
            }
            else if(computer.compareTo("B") == 0) //Paper
            {
                if(you.compareTo("X") == 0) //Loose
                    total += 1;//3 + 0
                else if(you.compareTo("Y") == 0) //Draw
                    total += 5; //2 + 3
                else if(you.compareToIgnoreCase("Z") == 0) //Win
                    total += 9; //3+6
            }
            else if(computer.compareTo("C") == 0) //Scissor
            {
                if(you.compareTo("X") == 0) //Loose
                    total += 2;//2 + 0
                else if(you.compareTo("Y") == 0) //Draw
                    total += 6; //3+3
                else if(you.compareTo("Z") == 0) //Win
                    total += 7; //1 + 6
            }
        }
        System.out.println(total);
        br.close();
    }
}