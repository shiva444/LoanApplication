
public abstract class Loan {
	protected String name;			// the applicant’s name
	protected double interestRate;		// the annual interest rate
	protected int length;			// the  length of the load in years
	protected double principle;			// the principle
	protected double monthlyPayment;		// the monthly payment

	public Loan (String name, double rate, int years, double amount ) {
		// constructor
		this.name = name;
		this.interestRate  = rate;
		this.length= years;
		this.principle= amount;
	}
	
	public String  process ()  {				// a template method
		// call method calcMonthlyPayment()
		this.calcMonthPayment();
		// call method makeSummary()
		String str = this.makeSummary();
		// return the summary
		return str;
	 }
	
	abstract public void calcMonthPayment ();		// an abstract method
	
	public String  makeSummary () {
		//this.calcMonthPayment;
		String str = "";
		str += this.toString();
		str += "\nName \t:\t" + this.name;
		str += "\npriciple \t:\t" + this.principle;
		str += "\nMonthly Payment \t:\t" + monthlyPayment;
		
		// make and return a summary on the loan
		return str;
	 }
	public String toString() { 
		return "Loan";
	}  

public class SimpleLoan extends Loan {
	
public SimpleLoan (String name, double rate, int years, double amount ){
		super( name,rate,years,amount);
	}
	
	
	public void calcMonthPayment () {
		// calculate the monthly payment using the appropriate formula
		// assign the result to the data field monthlyPayment
		monthlyPayment = interestRate +length*principle ; // = ( principal * (monthly-rate * length-in-months + 1)) / length-in-months
		}
	
	public String toString() { 
		return "Simple Interest Loan"; 
	}
}

}
public class SimpleLoan extends Loan {
	
public SimpleLoan (String name, double rate, int years, double amount ){
		super( name,rate,years,amount);
	}
	
	
	public void calcMonthPayment () {
	// calculate the monthly payment using the appropriate formula
	// assign the result to the data field monthlyPayment
	monthlyPayment = interestRate +length*principle ; // = ( principal * (monthly-rate * length-in-months + 1)) / length-in-months
		}
	
	public String toString() { 
		return "Simple Interest Loan"; 
	}
}

public class AmortizedLoan extends Loan {
public AmortizedLoan (String name, double rate, int years, double amount ){
		super( name,rate,years,amount);
	}
		public void calcMonthPayment () {
		// calculate the monthly payment using the appropriate formula
		// assign the result to the data field monthlyPayment
		monthlyPayment = interestRate+length*principle;//  ( principal * monthly-rate * n)/(n - 1) where n is (1 + monthly-rate)s
			
		}
		public String toString() { 
			return "Full Amortized Loan";
			
	}

}

import java.util.Scanner;
public class LoanApplication {
	
	private Loan loan;
	
	public void run() {
		
		Boolean exit = false;

		// start while loop here as long as exit does not equal true ask theses questions
		
		// prompt the user for information about the new loan
	
		String name;
		Scanner scan = new Scanner(System.in);
		System.out.println ("Enter your name:");
		name = scan.nextLine();
		
		Double rate;
		System.out.println ("Enter your rate");
		rate = Double.parseDouble(scan.nextLine());

		int years;
		System.out.println ("Enter your term");
		years = Integer.parseInt(scan.nextLine());
		
		Double amount;
		System.out.println ("Enter your principal");
		amount = Double.parseDouble(scan.nextLine());
		// Is this a simple loan (type Y or N)
		//ASK them loan type
		String loantype;
		System.out.println ("Enter your loan type ..type s for simple a for amortized");
		loantype= scan.nextLine();
		
		//do you want to quit---> exit = true
		
		// if it is a simple interest loan
		if (loantype.compareTo("s") == 0)
			loan = new SimpleLoan(name, rate, years, amount);
		//	 create an instance of SimpleLoan and assign it to data field loan 
		else
			loan = new AmortizedLoan(name, rate, years, amount);
		// 	create an instance of AmortizedLoan and assign it to data field loan
	
		
		// call method process() for the Loan object
		String theSummary = loan.process();
		// the result from the above call is stored in data field summary
		PrintSpooler printer = PrintSpooler.getSpooler();
		// call the static method getSpooler() for class PrintSpooler to get					// a reference to the only  instance of it
		// call method printDocument for the instance with data field summary as 
		// a parameter 
		printer.printDocument(theSummary);
		// repeat the above steps until the user wants to exit
		//end loop "good bye"
	}
	
	public static void main (String args[]){
		LoanApplication la = new LoanApplication();
		la.run();
	}

}

 





 
