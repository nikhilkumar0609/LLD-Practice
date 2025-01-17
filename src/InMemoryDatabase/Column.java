package InMemoryDatabase;

public class Column {
	public String name;
	public ColumnType type;
	public boolean isMandatory;
	public Constraint constraints;
	
	public Column(String name, ColumnType type, boolean isMandatory, Constraint constraints) {
        this.name = name;
        this.type = type;
        this.isMandatory = isMandatory;
        this.constraints = constraints;
    }

	public boolean isValidate(Object value) {
		if(type == ColumnType.STRING && value instanceof String) {
			return value.toString().length() < 20;
		}else if(type == ColumnType.INT && value instanceof Integer) {
			int  IntValue = (Integer)value;
			return IntValue >= constraints.minValue && IntValue <= constraints.maxValue;
		}
		return false;
	}
}
