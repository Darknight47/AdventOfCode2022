import java.io.*;
import java.util.ArrayDeque;

public class Dayfifth {
    ArrayDeque<Character> first = new ArrayDeque<>();
    ArrayDeque<Character> second = new ArrayDeque<>();
    ArrayDeque<Character> third = new ArrayDeque<>();
    ArrayDeque<Character> fourth = new ArrayDeque<>();
    ArrayDeque<Character> fifth = new ArrayDeque<>();
    ArrayDeque<Character> sixth = new ArrayDeque<>();
    ArrayDeque<Character> seven = new ArrayDeque<>();
    ArrayDeque<Character> eight = new ArrayDeque<>();
    ArrayDeque<Character> nine = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        File file = new File("Day5input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = "";
        int num = 1;
        Dayfifth df = new Dayfifth();
        while((temp = br.readLine()) != null)
        {   
            if(df.isNumeric(temp))
            {
                num = Integer.parseInt(temp);
                num++;
            }
            else
            {
                if(num <= 9)
                {
                   df.filling(temp, num);
                }
                else if(num > 9 && !temp.isEmpty())
                {
                    String[] arr = temp.split(" ");
                    int quant = Integer.parseInt(arr[1]);
                    int from = Integer.parseInt(arr[3]);
                    int to = Integer.parseInt(arr[5]);
                    for (int i = 0; i < quant; i++) {
                        char ch = df.getChar(from);
                        df.putChar(ch, to);
                    }
                }
            }
            
        }
        df.printAnswer();
        br.close();
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void filling(String temp, int num) {
        char[] arr = temp.toCharArray();
        switch (num) {
            case 1:
                first.offerFirst(arr[1]);
                break;
            case 2:
                second.offerFirst(arr[1]);
                break;
            case 3:
                third.offerFirst(arr[1]);
                break;
            case 4:
                fourth.offerFirst(arr[1]);
                break;
            case 5:
                fifth.offerFirst(arr[1]);
                break;
            case 6:
                sixth.offerFirst(arr[1]);
                break;
            case 7:
                seven.offerFirst(arr[1]);
                break;
            case 8:
                eight.offerFirst(arr[1]);
                break;
            case 9:
                nine.offerFirst(arr[1]);
                break;
        }
    }

    public char getChar(int from) {
        if (from == 1) {
            return first.pollLast();
        } else if (from == 2) {
            return second.pollLast();
        } else if (from == 3) {
            return third.pollLast();
        } else if (from == 4) {
            return fourth.pollLast();
        } else if (from == 5) {
            return fifth.pollLast();
        } else if (from == 6) {
            return sixth.pollLast();
        } else if (from == 7) {
            return seven.pollLast();
        } else if (from == 8) {
            return eight.pollLast();
        } else
            return nine.pollLast();
    }

    public void putChar(char ch, int to) {
        if (to == 1)
        {
            first.offerLast(ch);
        } else if (to == 2) 
        {
            second.offerLast(ch);
        } 
        else if (to == 3)
        {
            third.offerLast(ch);
        }
        else if (to == 4)
        {
            fourth.offerLast(ch);
        }
        else if (to == 5)
        {
            fifth.offerLast(ch);
        }
        else if (to == 6)
        {
            sixth.offerLast(ch);
        }
        else if (to == 7)
        {
            seven.offerLast(ch);
        }
        else if (to == 8)
        {
            eight.offerLast(ch);
        }
        else 
        {
            nine.offerLast(ch);
        }
    }

    public void printAnswer()
    {
        String answer = "";
        answer += first.peekLast();
        answer += second.peekLast();
        answer += third.peekLast();
        answer += fourth.peekLast();
        answer += fifth.peekLast();
        answer += sixth.peekLast();
        answer += seven.peekLast();
        answer += eight.peekLast();
        answer += nine.peekLast();
        System.out.println(answer);
    }
}
