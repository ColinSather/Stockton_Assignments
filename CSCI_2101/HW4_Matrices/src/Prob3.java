public class Prob3
{
    static int i;
    
    static void MyUpperCase(String s)
    {
        for(i=0;i<s.length();i++)
        {
            int ch=s.charAt(i);
            if(ch>64&&ch<91)
            {
                
                System.out.print( (char) ch);
            }
            else if(ch>96&&ch<123)
            {
                ch=ch-32;
                System.out.print( (char) ch);
            }
            if(ch==32)
            System.out.print(" ");
        }
    }
    static void MyLowerCase(String s){
        for(i=0;i<s.length();i++)
        {
            int ch=s.charAt(i);
            if(ch>64&&ch<91)
            {
                ch=ch+32;
                System.out.print( (char) ch);
            }
            else if(ch>96&&ch<123)
            {
            	
                System.out.print( (char) ch);
            }
            if(ch==32)
            System.out.print(" ");
        }
    }
    public static void main (String args[])
    {
        
        System.out.println("Original String is : ");
        System.out.println("Alive is awesome ");
        Prob3.MyUpperCase("Alive is awesome ");
      	Prob3.MyLowerCase("Alive is awesome ");
        
    }
}