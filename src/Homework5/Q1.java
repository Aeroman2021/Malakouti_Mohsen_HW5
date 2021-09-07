package Homework5;

public class Q1 {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " : ");
            isPrime(i, 2);
        }

    }

    public static void isPrime(int number, int initialNumber) {
        if(number == 0 || number == 1)
            System.out.println("This is not a prime number");
        else if(number == 2)
            System.out.println("This is a prime number.");
        else if (number > initialNumber) {
            if (number % initialNumber == 0) {
                System.out.println("This is not a prime number.");
            } else {
                initialNumber++;
                isPrime(number, initialNumber);
            }
        } else
            System.out.println("This is a prime number!");
    }

}
