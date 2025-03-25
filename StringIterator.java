import java.util.LinkedList;
import java.util.Queue;

public class StringIterator {
    private Queue<Character> queue;

    public StringIterator(String compressedString) {

        queue = new LinkedList<>();

        int i = 0;
        while (i<compressedString.length()) {

            char c = compressedString.charAt(i);
            i++;
            StringBuilder sb = new StringBuilder();

            while (i <compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
                sb.append(compressedString.charAt(i));
                i++;
            }

            for (int j=0; j<Integer.parseInt(sb.toString()); j++) {
                queue.add(c);
            }
        }
    }

    public char next() {

        if (queue.isEmpty()) {
            return ' ';
        }
        else return queue.remove();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

    public static void main(String[] args) {

        //String compressedString = "A2B12C1";
        String compressedString = "";

        StringIterator obj = new StringIterator(compressedString);

        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());


    }
}

/*

A2B12C1

A:2
B:12
C:1

 */