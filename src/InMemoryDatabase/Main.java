package InMemoryDatabase;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a new Database instance
        Database database = new Database();

        // Define columns for a table
        List<Column> columns = new ArrayList<>();
        columns.add(new Column("id", ColumnType.INT, true, new Constraint(0, -1024, 1024)));
        columns.add(new Column("name", ColumnType.STRING, true, new Constraint(20, 0, 0)));
        columns.add(new Column("age", ColumnType.INT, false, new Constraint(0, -1024, 1024)));

        // Create a table
        database.createTable("users", columns);

        // Insert records into the table
        Map<String, Object> record1 = new HashMap<>();
        record1.put("id", 1);
        record1.put("name", "Alice");
        record1.put("age", 25);

        Map<String, Object> record2 = new HashMap<>();
        record2.put("id", 2);
        record2.put("name", "Bob");

        Map<String, Object> record3 = new HashMap<>();
        record3.put("id", 3);
        record3.put("name", "Charlie");
        record3.put("age", 30);

        try {
            Table usersTable = database.tables.get("users");
            usersTable.insertRecord(new RowData(record1));
            usersTable.insertRecord(new RowData(record2));
            usersTable.insertRecord(new RowData(record3));

            // Print all records in the table
            System.out.println("Records in 'users' table:");
            usersTable.printRecords();
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Attempt to insert an invalid record
        try {
            Map<String, Object> invalidRecord = new HashMap<>();
            invalidRecord.put("id", 4);
            invalidRecord.put("name", "ThisNameIsWayTooLongToFit"); // Exceeds max length

            Table usersTable = database.tables.get("users");
            usersTable.insertRecord(new RowData(invalidRecord));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Delete the table
        database.deleteTable("users");
        System.out.println("Table 'users' deleted.");
    }
}