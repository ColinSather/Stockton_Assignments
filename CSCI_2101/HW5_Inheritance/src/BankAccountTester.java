public class BankAccountTester {
	public static void main(String[] args) {
	  // Object A with withdraw error
        BankAccount A = new BankAccount();
		System.out.println("Account: #"+A.getNumber());
      	A.deposit(1000);
      	A.withdraw(2000);
      	A.transfer(10);
        System.out.println("Balance: $"+A.getBalance());
      // Object B with transfer error
      BankAccount B = new BankAccount();
        System.out.println("Account: #"+B.getNumber());
        B.deposit(1000);
      	B.withdraw(200);
      	B.transfer(10000);
        System.out.println("Balance: $"+B.getBalance());
      // Object C with deposit error
      BankAccount C = new BankAccount();
        System.out.println("Account: #"+C.getNumber());
        C.deposit(-1000);
      	C.withdraw(200);
      	C.transfer(10);
        System.out.println("Balance: $"+C.getBalance());
	}
}