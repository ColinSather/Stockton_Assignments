 import java.util.Comparator;
// Implements the Interface Comparator of type <Account>
public class SortByBalance implements Comparator<Account> { 

    public int compare(Account a, Account b) 
    { 
        return (int) (a.balance - b.balance); 
    } 
} 