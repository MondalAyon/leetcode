public class convertToTitle {

    public static void main (String[] args) {
        int inputcolumnNumber = 2147483647;
        String columnTitle = "";

        int columnNumber = inputcolumnNumber;
        int offset = 64;
        int q = -1;
        int r = -1;

        if (columnNumber >= 1 && columnNumber <= 26) {
            columnTitle = String.valueOf((char)(columnNumber + offset));
        }
        else if (columnNumber > 26) {

            while (true) {

                r = columnNumber % 26;
                q = columnNumber / 26;
                System.out.println("q=" + q + " r=" + r);

                if (r == 0) {
                    q--;
                    r=26;
                    //System.out.println("Changed q=" + q + " r=" + r);
                }

                if (q <= 26) {
                    columnTitle =  String.valueOf((char)(r + offset)) + columnTitle;
                    columnTitle =  String.valueOf((char)(q + offset)) + columnTitle;
                    break;
                }
                else {
                    columnTitle = String.valueOf((char)(r + offset)) + columnTitle;
                    columnNumber = q;
                }
            } // eod of while
        }

        System.out.println("inputcolumnNumber = " + inputcolumnNumber + " columnTitle = " + columnTitle);

    }
}
