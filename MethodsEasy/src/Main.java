public class Main {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        System.out.println(sumNums(array1));
        System.out.println(sumEvenNums(array1));
        System.out.println(sumOddNums(array1));
        reverseArray(array1);
        System.out.println("\n" + findBiggestNum(array1));
        int[][] matrix1 = {{1,2},{3,4}};
        System.out.println(sumDiagonals(matrix1));
        System.out.println(sumFirstRow(matrix1));
        System.out.println(sumSecondRow(matrix1));
        System.out.println(isOdd(7));
        System.out.println(isPositive(-5));
        System.out.println(isGreaterThan10(15));
        System.out.println(areEven(5,5));
        System.out.println(isPrime(11));
        printSquare(3);
        printTriangle(3);
    }
    public static int sumNums(int [] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }
    public static int sumEvenNums(int [] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                sum += array[i];
            }
        }
        return sum;
    }
    public static int sumOddNums(int [] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 != 0){
                sum += array[i];
            }
        }
        return sum;
    }
    public static void reverseArray(int[] array) {
        for(int i = array.length - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
    }
    public static int findBiggestNum(int [] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > temp){
                temp = array[i];
            }
        }
        return temp;
    }
    public static int sumDiagonals(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }
    public static int sumFirstRow(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[0][i];
        }
        return sum;
    }
    public static int sumSecondRow(int[][] matrix) {
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[1][i];
        }
        return sum;
    }
    public static String isOdd(int number)
    {
        if(number % 2 == 0){
            return "Even";
        }
        else{
            return "Odd";
        }
    }
    public static String isPositive(int number){
        if(number<0) return "Negative";
        else return "Positive";
    }
    public static boolean isGreaterThan10(int number){
        if(number > 10) return true;
        else return false;
    }
    public static boolean areEven(int number1, int number2){
        if(number1 == number2) return true;
        else return false;
    }
    public static boolean isPrime(int number){
        if(number <= 1) return false;
        for(int i = 2; i < 20; i++) {
            if(number %i == 0 && i!=number) return false;
        }
        return true;
    }
    public static void printSquare(int number){
        for(int i = 0; i < number; i++){
            for (int j = 0; j<number; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    public static void printTriangle(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}