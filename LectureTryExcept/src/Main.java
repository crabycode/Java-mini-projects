import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Error {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = sc.nextInt();
        try{
            System.out.println(divide(n, n1));
        }
        catch(ArithmeticException err)
        {
            System.out.println("Division is not possible.");
        }
        catch(DivisionByZeroError err)
        {
            System.out.println("Division forbidden");
        }
        finally
        {
            System.out.println("Finally");
        }
    }
    public static int divide(int num1, int num2) throws Error {
        if(num2 != 0)
        {
            return num1 / num2;
        }
        else
        {
            throw new DivisionByZeroError();
        }
    }
}
