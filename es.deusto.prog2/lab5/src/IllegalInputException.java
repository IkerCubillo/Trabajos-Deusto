
public class IllegalInputException extends CalculatorException {
	private String exceptionType = "";
	
	
	public IllegalInputException(String exceptionType) {
		this.exceptionType = exceptionType;
		// TODO Auto-generated constructor stub
	}
	public String getExceptionType() {
		return this.exceptionType;
	}
}