package InMemoryDatabase;

import java.util.ArrayList;
import java.util.List;

public class Table {
	public String name;
	public List<Column> columns;
	public List<RowData> records = new ArrayList<>();
	
	public Table(String name, List<Column> columns) {
		this.name = name;
		this.columns = columns;
	}
	
	public void insertRecord(RowData rowData) {
		for(Column column : columns) {
			if(column.isMandatory && !rowData.getData().containsKey(column.name)) {
				throw new IllegalArgumentException("Mandatory Column Data is Missing: " + column.name);
			}
			
			Object value = rowData.getData().get(column.name);
			if(value != null && !column.isValidate(value)) {
				throw new IllegalArgumentException("Invalid Column Data: " + column.name);				
			}
		}
		records.add(rowData);
	}
	
	public void printRecords() {
		for(RowData rowData : records) {
			System.out.println(rowData.getData());
		}
	}
	
}
