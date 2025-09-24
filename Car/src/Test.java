public class Test {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", "Red", 120, "Petrol", "2018");
        Car car2 = new Car("Toyota", "Camry", "Blue", 150, "Diesel", "2019");
        Car car3 = new Car("BMW", "X5", "Black", 300, "Petrol", "2020");
        Car car4 = new Car("Toyota", "Corolla", "Red", 120, "Petrol", "2018"); // Duplicate
        Car[] cars = {car1, car2, car3, car4};
        Car[] filteredCars = Car.cleanUp(cars, 'T');
        System.out.println("Filtered Cars:");
        for (Car car : filteredCars) {
            System.out.println(car.getBrand());
        }
        Car[] sortedCars = Car.sortCarsByBrand(cars, true);
        System.out.println("Sorted Cars:");
        for (Car car : sortedCars) {
            System.out.println(car.getBrand());
        }
        Car[] uniqueCars = Car.removeDuplicates(cars);
        System.out.println("Unique Cars:");
        for (Car car : uniqueCars) {
            System.out.println(car.getBrand());
        }
    }
}