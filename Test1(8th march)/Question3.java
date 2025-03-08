import java.util.Scanner;
public class Question3{
    public static int fibonacci(int n) {
        if (n <= 1) {
        return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.print("n= ");
        Scanner sc=new Scanner(System.in);
        int terms=sc.nextInt();
     for (int i = 0; i < terms; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}