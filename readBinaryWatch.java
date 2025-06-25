/*
https://leetcode.com/problems/binary-watch/description/
https://leetcode.com/problems/binary-watch/submissions/1675481486/
 */
import java.util.ArrayList;
import java.util.List;

public class readBinaryWatch {

    public static void main(String[] args) {

        System.out.println(readBinaryWatch(2));

        //System.out.println(String.format("%02d",1));


    }

    public static List<String> readBinaryWatch(int turnedOn) {

        List<String> resultList = new ArrayList<>();

        for (int i=0; i<=11; i++) {
            for (int j=0; j<=59; j++) {

                //System.out.println("i=" + i + " j=" + j + "  " + (Integer.bitCount(i) + Integer.bitCount(j)));

                if ((Integer.bitCount(i) + Integer.bitCount(j)) == turnedOn) {
                    resultList.add(i + ":" + String.format("%02d",j));
                }


            }
        }
        return resultList;
    }

}
