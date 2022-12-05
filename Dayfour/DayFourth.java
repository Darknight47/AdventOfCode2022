import java.io.*;
public class DayFourth {
    public static void main(String[] args) throws IOException {
        File file = new File("Day4input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = "";
        int answer = 0;
        while((temp = br.readLine()) != null)
        {
            String[] arr = temp.split(",");
            String[] lefts = arr[0].split("-");
            String[] rights = arr[1].split("-");
            int l1 = Integer.parseInt(lefts[0]);
            int l2 = Integer.parseInt(lefts[1]);

            int r1 = Integer.parseInt(rights[0]);
            int r2 = Integer.parseInt(rights[1]);

            if(l1 < r1 && l2 < r1)
            {
            }
            else if(r1 > l2){}
            else
            {
                answer++;
            }
        }
        System.out.println(answer);
        br.close();
    }
    private void partOne(String temp)
    {
        int answer= 0;
        String[] arr = temp.split(",");
        String[] lefts = arr[0].split("-");
        String[] rights = arr[1].split("-");
        int l1 = Integer.parseInt(lefts[0]);
        int l2 = Integer.parseInt(lefts[1]);

        int r1 = Integer.parseInt(rights[0]);
        int r2 = Integer.parseInt(rights[1]);

        if(l1 <= r1 && l2 >= r2)
        {
            answer++;
        }
        else if(r1 <= l1 && r2 >= l2)
        {
            answer++;
        }
        System.out.println(answer);
    }
}
