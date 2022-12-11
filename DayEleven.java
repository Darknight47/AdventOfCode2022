import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
public class DayEleven {

    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    HashMap<Integer, ArrayList<Integer>> answers = new HashMap<>();
    public static void main(String[] args) throws IOException {
        File file = new File("Day11input.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String temp = "";
        DayEleven de = new DayEleven();
        while((temp = br.readLine()) != null )
        {
            if(!temp.isEmpty())
            {
                String[] arr = temp.split(" ");
                if(arr[0].equals("Monkey"))
                {
                    de.filling(temp, br);
                }
            }
        }
        for (int i = 0; i < 20; i++) {
            de.repeat(temp, br, file);
        }
        System.out.println(1);

        br.close();
    }

    private void filling(String temp, BufferedReader br) throws IOException
    {
        String[] tempArr = temp.split(" ");
        String keyStr = tempArr[1].replace(":", "");
        int keyNum = Integer.parseInt(keyStr);
        map.put(keyNum, new ArrayList<>());
        answers.put(keyNum, new ArrayList<>());
        
        String itemsStr = br.readLine().replace(",", " ");
        String[] arr = itemsStr.split(" ");

        for (int j = 0; j < arr.length; j++) {
            if(!arr[j].isEmpty())
            {
                boolean isNumeric = arr[j].chars().allMatch(Character::isDigit);
                if(isNumeric)
                {
                    int item = Integer.parseInt(arr[j]);
                    map.get(keyNum).add(item);
                    answers.get(keyNum).add(item);
                }
            }  
        }
    }

    private void repeat(String temp, BufferedReader br, File file) throws NumberFormatException, IOException
    {
        br = new BufferedReader(new FileReader(file));
        while((temp = br.readLine()) != null )
        {
            if(!temp.isEmpty())
            {
                String[] arr = temp.split(" ");
                int keyNum = -1;
                if(arr[0].equals("Monkey"))
                {
                    String keyStr = arr[1].replace(":", "");
                    keyNum = Integer.parseInt(keyStr);
                    br.readLine();
                }
                String operationInfo = br.readLine();
                String[] newArr = operationInfo.split(" ");
                String operation = newArr[newArr.length - 2];
                String condition = newArr[newArr.length - 1];
                ArrayList<Integer> tempArrLi = map.get(keyNum);
                boolean isConditionNumeric = condition.chars().allMatch(Character::isDigit);
                ListIterator<Integer> listIt = tempArrLi.listIterator();
                String test = br.readLine();
                String[] testArr = test.split(" ");
                int div = Integer.parseInt(testArr[testArr.length - 1]);
                String trueCond = br.readLine();
                String falseCond = br.readLine();
                while(listIt.hasNext())
                {
                    int item = listIt.next();
                    int conditionNum = item;
                    if(isConditionNumeric)
                    {
                        conditionNum = Integer.parseInt(condition);
                    }
                    switch (operation) {
                        case "*":
                            item = item * conditionNum;
                            break;
                        case "+":
                            item = item + conditionNum;
                            break;
                    }
                    item = item / 3;
     
                    if(item % div == 0)
                    {                 
                        String[] trueArr = trueCond.split(" ");
                        int trueDes = Integer.parseInt(trueArr[trueArr.length - 1]);
                        map.get(trueDes).add(item);
                        answers.get(trueDes).add(item);
                    }
                    else
                    {
                        String[] falseArr = falseCond.split(" ");
                        int falseDes = Integer.parseInt(falseArr[falseArr.length - 1]);
                        map.get(falseDes).add(item);
                        answers.get(falseDes).add(item);
                    }
                }
                map.get(keyNum).clear();
            }
        }
        br.close();

    }

}
