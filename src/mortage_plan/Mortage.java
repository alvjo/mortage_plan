package mortage_plan;

public class Mortage {

	private float E;
	private String name;
	private float b; 
	private float U; 
	private float p;

	// Constructor for customer info
	public Mortage(String customerName, float Interest, float TotLoan, float PaymentNo) {
		name = customerName;
		b = Interest;
		U = TotLoan;
		p = PaymentNo;
	}

	// Method for counting mortage
	public void countMortage() {
		float temp1 = 0;
		float temp2 = 0;

		// Get percentage for loan each month
		b = b / 100;

		// E = U[b(1 + b) ^ p]/[(1 + b)^p - 1] (given equation)
		temp1 = b * countPowerOf(p, b);
		temp2 = countPowerOf(p, b) - 1;
		E = U * temp1 / temp2;

		customerOutput();

	}

	// Method for counting power of
	public float countPowerOf(float p, float b) {

		float power = p;
		float base = b + 1;
		float temp = b + 1;

		for (int i = 1; i < power; i++) {
			base = base * (temp);
		}
		return base;

	}

	// Method for output
	public void customerOutput() {
		System.out.println(name + " wants to borrow " + U + " € for a period of " + p / 12 + " years and pay " + E
				+ " € each month");
	}

}
