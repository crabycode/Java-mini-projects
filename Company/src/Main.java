public class Main {
    public static void main(String[] args) {
        CompanyET company1 = new CompanyET("Vazov OOD", "10.01.2025",
                "1234567890", "Kaloyan Yorgov", 150, 205.25);
        System.out.println(company1.calculateProfit());
        company1.setBulstat("123456789");
        System.out.println(company1.getBulstat());
    }
}
