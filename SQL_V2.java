/*
https://leetcode.com/problems/design-sql/description/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency
https://leetcode.com/problems/design-sql/?envType=study-plan-v2&envId=amazon-spring-23-high-frequency

You are given n tables represented with two arrays names and columns, where names[i] is the name of the ith table and columns[i] is the number of columns of the ith table.

You should be able to perform the following operations:

Insert a row in a specific table. Each row you insert has an id. The id is assigned using an auto-increment method where the id of the first inserted row is 1, and the id of each other row inserted into the same table is the id of the last inserted row (even if it was deleted) plus one.
Delete a row from a specific table. Note that deleting a row does not affect the id of the next inserted row.
Select a specific cell from any table and return its value.
Implement the SQL class:

SQL(String[] names, int[] columns) Creates the n tables.
void insertRow(String name, String[] row) Adds a row to the table name. It is guaranteed that the table will exist, and the size of the array row is equal to the number of columns in the table.
void deleteRow(String name, int rowId) Removes the row rowId from the table name. It is guaranteed that the table and row will exist.
String selectCell(String name, int rowId, int columnId) Returns the value of the cell in the row rowId and the column columnId from the table name.


Example 1:

Input
["SQL", "insertRow", "selectCell", "insertRow", "deleteRow", "selectCell"]
[[["one", "two", "three"], [2, 3, 1]], ["two", ["first", "second", "third"]], ["two", 1, 3], ["two", ["fourth", "fifth", "sixth"]], ["two", 1], ["two", 2, 2]]
Output
[null, null, "third", null, null, "fifth"]

Explanation
SQL sql = new SQL(["one", "two", "three"], [2, 3, 1]); // creates three tables.
sql.insertRow("two", ["first", "second", "third"]); // adds a row to the table "two". Its id is 1.
sql.selectCell("two", 1, 3); // return "third", finds the value of the third column in the row with id 1 of the table "two".
sql.insertRow("two", ["fourth", "fifth", "sixth"]); // adds another row to the table "two". Its id is 2.
sql.deleteRow("two", 1); // deletes the first row of the table "two". Note that the second row will still have the id 2.
sql.selectCell("two", 2, 2); // return "fifth", finds the value of the second column in the row with id 2 of the table "two".


Constraints:

n == names.length == columns.length
1 <= n <= 104
1 <= names[i].length, row[i].length, name.length <= 20
names[i], row[i], and name consist of lowercase English letters.
1 <= columns[i] <= 100
All the strings of names are distinct.
name exists in the array names.
row.length equals the number of columns in the chosen table.
rowId and columnId will be valid.
At most 250 calls will be made to insertRow and deleteRow.
At most 104 calls will be made to selectCell.

 */
import java.util.*;

public class SQL_V2 {

    HashMap<String, HashMap<Integer, List<String>>> db;
    HashMap<String, Integer> tableRowMap;

    public SQL_V2(List<String> names, List<Integer> columns) {

        this.db = new HashMap<>();
        this.tableRowMap = new HashMap<>();

        for (int i=0; i<names.size(); i++) {
            this.db.put(names.get(i), new HashMap<Integer, List<String>>());
            this.tableRowMap.put(names.get(i), 0);
        }
    }

    public void insertRow(String name, List<String> row) {

        HashMap<Integer, List<String>> rowVal = new HashMap<>();
        int newRowId = tableRowMap.get(name);

        //Fetch existing data first.
        rowVal = db.get((name));

        rowVal.put(newRowId, row);

        db.put(name,rowVal);
        tableRowMap.put(name, tableRowMap.get(name)+1);
    }

    public void deleteRow(String name, int rowId) {

        HashMap<Integer, List<String>> rowVal = new HashMap<>();

        rowVal = db.get(name);

        if (rowVal.containsKey(rowId-1)) {
            rowVal.remove(rowId-1);
            db.put(name, rowVal);
        }
    }

    public String selectCell(String name, int rowId, int columnId) {

        return db.get(name).get(rowId-1).get(columnId-1);
    }

    public static void main(String[] args) {

        SQL_V2 sql = new SQL_V2(Arrays.asList("one","two","three"), Arrays.asList(2,3,1));

        sql.insertRow("two", Arrays.asList("first","second","third"));

        System.out.println(sql.selectCell("two", 1, 3));

        sql.insertRow("two", Arrays.asList("fourth","fifth","sixth"));

        sql.deleteRow("two", 1);

        System.out.println(sql.selectCell("two", 2, 2));

        sql.insertRow("one", Arrays.asList("one_first","one_second"));
        sql.insertRow("one", Arrays.asList("one_fourth","one_fifth"));

        System.out.println(sql.selectCell("one", 1, 1));
        System.out.println(sql.selectCell("one", 2, 2));
    }
}
