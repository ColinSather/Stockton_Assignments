public class DiceRoll {
  public static void main(String[] args) {
    int dice1=(int)(Math.random()*6+1);
    int dice2=(int)(Math.random()*6+1);
    int sum= dice1 + dice2;
	System.out.println("Dice Roll One = " +dice1);
    System.out.println("Dice Roll Two = " +dice2);
    System.out.println("Roll: total = " +sum);   
  }
}