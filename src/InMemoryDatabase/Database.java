package InMemoryDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	public Map<String, Table> tables = new HashMap<>();
	
	public void createTable(String name, List<Column> columns) {
		tables.put(name, new Table(name, columns));
	}
	
	public void deleteTable(String name) {
		tables.remove(name);
	}
}
