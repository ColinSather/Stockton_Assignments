public class Person {
  private static int base = 1000;
  private static int acct;
  public static int BankAccount(int amount) {
	  return amount;
    }
  public static void main(String[] args) {
    String str1 = "sentence";
    String str2 = str1.toUpperCase();
    // delete final and it does stuff to prove the wrapper class is immutable i think idk fuck it.
    Integer a = 400;
    Integer b = a;
    b=b+5;
    BankAccount(123);
    System.out.println(a);// if Integer a could mutate this would print 405. 
    System.out.println(str1); // value of str1 is unchanged since its immutable. 
    System.out.println(BankAccount(123));//  this is immutable because its value can change to any integer.
  }  
}