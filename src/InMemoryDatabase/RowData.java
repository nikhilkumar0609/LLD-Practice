package InMemoryDatabase;

import java.util.Map;

public class RowData {
	public Map<String, Object> data;

	public RowData(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
}
