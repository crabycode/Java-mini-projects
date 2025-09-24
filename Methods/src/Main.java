public class Main {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        arraySums(array1);
        printReverse(array1);
        findMinMax(array1);
        isPrime(7);
        int[][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        findSums(matrix1);
        printTriangle(7);
    }
    public static void arraySums(int[] array){
        int sum = 0;
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
            if(i%2 == 0){
                sumEven += array[i];
            }
            else{
                sumOdd += array[i];
            }
        }
        System.out.println("Sum: " + sum +"\nSum Even: " + sumEven +"\nSum Odd: " + sumOdd);
    }
    public static void printReverse(int[] array){
        for(int i = array.length - 1; i >= 0; i--){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void findMinMax(int[] array){
        int min = array[0];
        int max = array[0];
        for(int i = 0; i < array.length; i++){
            if(array[i]<min) min = array[i];
            if(array[i]>max) max = array[i];
        }
        System.out.println("Min: " + min + "\nMax: " + max);
    }
    public static boolean isPrime(int number){
        if(number <= 1) return false;
        for(int i = 2; i < 20; i++) {
            if(number %i == 0 && i!=number) return false;
        }
        return true;
    }
    public static void findSums(int[][] matrix){
        int diagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            diagonalSum += matrix[i][i];
            if (i != matrix.length - 1 - i) {
                diagonalSum += matrix[i][matrix.length - 1 - i];
            }
        }
        System.out.println("Diagonal Sum without repetitions: " + diagonalSum);
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