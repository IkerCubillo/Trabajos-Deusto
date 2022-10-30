public class Main {

	
	private String prop1 = "Bruce Wayne";
	
	public Main() {}
	
	public Main(String p1) {
		this.prop1 = p1;
	}
	
	public String getProp1() {
		return this.prop1;
	}
	
	public static void main(String[] args) {
		
		Main m = new Main("Batman");
		Main m2 = new Main();
		Main m3 = new Main("Robin");
		
		System.out.print("Hola " + m.getProp1());
		System.out.println("Hola " + m2.getProp1());
		System.out.println("Hola " + m3.getProp1());
	}
}
