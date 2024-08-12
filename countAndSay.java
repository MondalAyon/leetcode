public class RLE {

    public static void main(String[] args) {
        //String str = "11";
        int n = 6;

        //System.out.println(RLE(str));

        System.out.println(countAndSay(n));


    }

    public static String countAndSay(int n) {
        if (n==1) return "1";
        else
            return RLE(countAndSay(n-1));
    }


    public static String RLE(String str) {

        String resultStr = "";
        int c=1;

        for (int i=0; i<str.length(); i++) {

            if (i==str.length()-1) {
                resultStr = resultStr + Integer.toString(c) + str.charAt(i);
                break;
            }
            else if (str.charAt(i) == str.charAt(i+1)) {
                c++;
            }
            else {
                resultStr = resultStr + Integer.toString(c) + str.charAt(i);
                c = 1;
            }
        }
        return resultStr;
    }
}
