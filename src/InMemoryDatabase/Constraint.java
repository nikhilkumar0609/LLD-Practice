package InMemoryDatabase;

public class Constraint {
	public int maxLength;
	public int minValue;
	public int maxValue;
	
	public Constraint(int maxLength, int minValue, int maxValue) {
        this.maxLength = maxLength;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

}
