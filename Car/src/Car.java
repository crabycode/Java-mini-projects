public class Car {
    private String brand;
    private String model;
    private String color;
    private int horsePower;
    private String engineType;
    private String year;
    public Car(String brand, String model, String color, int horsePower, String engineType, String year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.engineType = engineType;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getHorsePower() {
        return horsePower;
    }
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }
    public String getEngineType() {
        return engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public static Car[] cleanUp(Car[] cars, char alphabet){
        int count=0;
        for(int i = 0; i < cars.length; i++){
            if(cars[i].getBrand().charAt(0) == alphabet){
                count++;
            }
        }
        Car[] newCars = new Car[count];
        int index = 0;
        for(int i = 0; i < cars.length; i++){
            if(cars[i].getBrand().charAt(0) == alphabet){
                newCars[index++] = cars[i];
            }
        }
        return newCars;
    }
    public static Car[] sortCarsByBrand(Car[] cars, boolean ascending) {
        Car[] sortedCars = cars.clone();
        java.util.Arrays.sort(sortedCars, (car1, car2) -> {
            if (ascending) {
                return car1.brand.compareTo(car2.brand);
            } else {
                return car2.brand.compareTo(car1.brand);
            }
        });
        return sortedCars;
    }
    public static Car[] removeDuplicates(Car[] cars) {
        int n = cars.length;
        boolean[] isDuplicate = new boolean[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            if (!isDuplicate[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (cars[i].equals(cars[j])) {
                        isDuplicate[j] = true;
                    }
                }
                uniqueCount++;
            }
        }

        Car[] uniqueCars = new Car[uniqueCount];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (!isDuplicate[i]) {
                uniqueCars[index++] = cars[i];
            }
        }

        return uniqueCars;
    }

}
