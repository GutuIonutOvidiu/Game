public class CheckingNumber {

    public static boolean isPerfectNumber(int number) {
        int sumDiv =1;

        for(int i =2; i<= number/2 ; i++) {
            if(number % i ==0) {
                sumDiv += i;
            }
        }
        return sumDiv == number;
    }

    public static boolean numberPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int sumOfNumbers(int number) {
        int sum = 0;
        while(number !=0) {
            int lastDigit = number % 10;

            sum = sum + lastDigit;
            number/=10;
        }
        return sum;
    }
}
