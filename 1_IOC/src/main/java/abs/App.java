package abs;

public class App {
	public static void main(String[] args) {
//		Emp emp = new Programmer();
//		emp.work();
//		
//		emp = new Designer();
//		emp.work();
		
		Develope develope = new Develope();
		develope.setEmp(new Programmer());
		develope.coding();
	}
}
