package miloProj2;

public class Insurance {

	public static void main(String[] args) {

		// these are hardcoded, you still need to get input and validate it.

		double startInterest = .04;
		double endInterest = .06;
		double incAmt = 0.0025;
		int firstYearRepay = 15;
		int lastYearRepay = 30;
		int yearsInc = 5;
		int loanAmt = 100000;

		paymentCalc(startInterest, endInterest, incAmt, firstYearRepay, lastYearRepay, yearsInc, loanAmt);

	}

	private static void paymentCalc(double startInterest, double endInterest, double incAmt, int firstYearRepay,
			int lastYearRepay, int yearsInc, int loanAmt) {

		System.out.println("Payment Schedule");
		System.out.println("");
		System.out.println("Interest");
		System.out.print("  rate    ");
		for (int j = firstYearRepay; j <= lastYearRepay; j += yearsInc) {

			System.out.printf("%11s ", j + " years");

		}
		System.out.print("\n\n");
		for (double i = startInterest; i <= (endInterest + incAmt); i += incAmt) {
			System.out.print(String.format("%.4f", i * 100) + "  ");

			for (int j = firstYearRepay; j <= lastYearRepay; j += yearsInc) {
				double mir = i / 12;
				double mtp = j * 12;
				double numerator = mir * (Math.pow((1 + mir), mtp));
				double denominator = (Math.pow((1 + mir), mtp) - 1);
				double annuityFactor = numerator / denominator;
				double payment = loanAmt * annuityFactor;
				String paymentStr = String.format("%.2f", payment);
				System.out.printf("%12s", paymentStr);

			}
			System.out.println();
		}

	}

}
