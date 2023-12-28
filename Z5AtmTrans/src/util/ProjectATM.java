package util;
import java.util.*;

public class ProjectATM {
	private static final String USER_ID="812152";  		 //PreDefined USER_ID
	private static final String USER_PIN="6769";		//PreDefined USRE_PIN
	private double balance;
	private int a=100;
	private int b=500;
	
	private List <String>transactionHistory=new ArrayList<>();
	public void TransactionHistory() {
		if(transactionHistory.isEmpty()) {
			System.out.println("No Transation Yet.");
		}else {
			System.out.println("Transaction History:");
			System.out.println(transactionHistory);	
		}
		System.out.println("****************************************************************************");
	}
	private void recordTransaction(String transaction) {
		transactionHistory.add(transaction);
	}
	public void withdraw(int Amount) {
	//	System.out.println("Only ₹100 And ₹500 Notes Are Available");
		if(Amount%a!=0) {
			System.out.println("Invalid Transaction Amount...");
		}else if (Amount>=500) {
				int x=Amount/b;
				Amount=Amount%b;
				System.out.println(x+" multiples of "+b+" Notes");
				if (Amount>=100){
				int y=Amount/a;
				Amount=Amount%a;
				System.out.println(y+" multiples of "+a+" Notes");
				}
			}
		if(balance>=Amount) {
			balance-=Amount;
			recordTransaction("Withdrawal:-₹"+Amount);
			//System.out.println("New balance:₹"+balance);
		}else {
			System.out.println("Insuffcient Funds.");
		}
		System.out.println("*************************************************************");
	}
	public void deposit(int Amount) {
		if(Amount<=200000) {
			balance+=Amount;
			recordTransaction("Diposit:₹"+balance);
			System.out.println("₹"+Amount+"--Deposited Successfully");
			System.out.println("New Balance:₹"+balance);
		}else {
			System.out.println("The Transaction Limit is 2,00,000...");
			System.out.println("Please Enter A Valid Amount...");
		}
		System.out.println("*******************************************************");
		
	}
	public void transfer(double Amount,String recipient) {
		if(balance>=Amount) {
			balance-=Amount;
			recordTransaction("Transfer to--"+recipient+":-₹"+Amount);
			System.out.println("₹"+Amount+"--transferred to account--"+recipient+"--Successfully.");
		}else {
			System.out.println("Insufficient Funds.");
			
		}
		System.out.println("*******************************************************************");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProjectATM atm=new ProjectATM();
		Scanner sc=new Scanner(System.in);
		System.out.println("************Welcome To ATM************");
		
		System.out.println("Enter user_id:");
		String userid=sc.nextLine();
		
		System.out.println("Enter user_pin:");
		String userpin=sc.nextLine();
		
		if(!userid.equals(USER_ID)||!userpin.equals(USER_PIN)) {
			System.out.println("invalid user id or pin...please check it....Exiting...");
			return;
		}
		while(true) {
			System.out.println("Please Select Your Transaction");
			System.out.println("1.View Transaction History");
			System.out.println("2.Withdraw");
			System.out.println("3.Deposit");
			System.out.println("4.transfer");
			System.out.println("5.Quit");
			
			int option=sc.nextInt();
			switch(option) {
			case 1:
				atm.TransactionHistory();
				break;
			case 2:
				System.out.println("Only ₹100 And ₹500 Notes Are Available...");
				System.out.println("Enter Amount To Withdraw:");
				int withdrawAmount=sc.nextInt();
				atm.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Enter Amount To Deposit:");
				int depositAmount=sc.nextInt();
				atm.deposit(depositAmount);
				break;
			case 4:
				System.out.println("Enter Amount To Transfer:");
				double transferAmount=sc.nextDouble();
				System.out.println("Enter Recipient's Account Number:");
				String recipient =sc.next();
				atm.transfer(transferAmount,recipient);
				break;
			case 5:
				System.out.println("Exiting...");
				return;
				default:
					System.out.println("invalid option.try again.");
					break;
				}	
			}		
		}
}

