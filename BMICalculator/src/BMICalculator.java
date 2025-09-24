import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        printIntroduction();
        Scanner input = new Scanner(System.in);
        double bmi = getBMI(input);
        reportResult(1, bmi, getStatus(bmi));
    }

    public static void printIntroduction(){
        System.out.println("Hello and welcome to the BMI Calculator!\n" +
                "Here you should enter your height and weight and our great app will calculate your BMI!");
    }
    public static double getBMI(Scanner scanner){
        System.out.println("Enter your height: ");
        double height = scanner.nextDouble();
        height *= 0.3937;
        System.out.println("Enter your weight: ");
        double weight = scanner.nextDouble();
        weight *= 2.2046;
        return bmiFor(height, weight);
    }
    public static double bmiFor(double height, double weight){
        return weight*703/(height* height);
    }
    public static String getStatus(double index){
        if(index < 18.5){
            return "underweight";
        }
        else if(index < 25){
            return "normal";
        }
        else if(index < 30){
            return "overweight";
        }
        else{
            return "obese";
        }
    }
    public static void reportResult(int resultNum, double BMI, String status){
        System.out.println("Report number: " + resultNum + "\nYou have a BMI of "+ Math.round(BMI)
        +", which means that you are " + status);
    }
}

