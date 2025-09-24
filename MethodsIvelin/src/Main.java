public class Main {
    public static void main(String[] args) {
        int[] array1 = {10,15,20,25,30};
        System.out.println(printAverage(array1));
        System.out.println(factorial(5));
        isPalindrome("abvbd");
        int[][] matrix1={{1,2},{3,4}};
        System.out.println(findSumSecondRow(matrix1));
        System.out.println(simpleCalculator(10,5,"+"));
        System.out.println(convertTemp(100, 'C'));
        printTriangle(3);
    }
    public static double printAverage(int[] array){
        int sum = 0;
        for(int i = 0; i<array.length; i++){
            sum += array[i];
        }
        return sum/array.length;
    }
    public static int factorial(int n){
        int factorial = 1;
        for(int i = 1; i<=n; i++){
            factorial *= i;
        }
        return factorial;
    }
    public static boolean isPalindrome(String combo){
        for(int i = 0; i < combo.length(); i++){
            if(combo.charAt(i) != combo.charAt(combo.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static int findSumSecondRow(int[][] matrix){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[1][i];
        }
        return sum;
    }
    public static int simpleCalculator(int a, int b, String operation){
        switch(operation){
            case "+":
                return a+b;
                case "-":
                    return a-b;
                    case "*":
                        return a*b;
                        case "/":
                            return a/b;
                            default:
                                System.out.println("Invalid operation");
                                return 0;
        }
    }
    public static double convertTemp(double temp, char choice) {
        if (choice == 'C') {
            return (temp * 9.0 / 5) + 32; // Целзий в Фаренхайт
        } else if (choice == 'F') {
            return (temp - 32) * 5.0 / 9; // Фаренхайт в Целзий
        }
        System.out.println("Invalid choice");
        return 0;
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