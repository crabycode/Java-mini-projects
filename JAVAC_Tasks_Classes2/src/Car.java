public class Car {
    //марка, модел, цвят, мощност, тип двигател, тип скоростна кутия, година на производство.
    private String brand;
    private String model;
    private String color;
    private int hp;
    private String engineType;
    private String gearBoxType;
    private int year;
    public Car() {
    }
    public Car(String brand, String model, String color, int hp, String engineType, String gearBoxType, int year) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.hp = hp;
        this.engineType = engineType;
        this.gearBoxType = gearBoxType;
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
    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public String getEngineType() {
        return engineType;
    }
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    public String getGearBoxType() {
        return gearBoxType;
    }
    public void setGearBoxType(String gearBoxType) {
        this.gearBoxType = gearBoxType;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Car[] searchByLetter(Car[] cars, char letter)
    {
        int count = 0;
        for (Car car : cars) {
            if (car.getBrand().charAt(0) == letter) {
                count++;
            }
        }
        Car[] newCars = new Car[count];
        int index = 0;
        for (Car car : cars) {
            if (car.getBrand().charAt(0) == letter) {
                newCars[index] = car;
                index++;
            }
        }
        return newCars;
    }
    public Car[] sortCars(Car[] cars, String choice)
    {
        Car[] newCars = cars.clone();
        if(choice.equals("up"))
        {
            for (int i = 0; i < newCars.length - 1; i++) {
                for (int j = i + 1; j < newCars.length; j++) {
                    if (newCars[i].getBrand().compareTo(newCars[j].getBrand()) > 0) {
                        Car temp = newCars[i];
                        newCars[i] = newCars[j];
                        newCars[j] = temp;
                    }
                }
            }
        }
        else if(choice.equals("down"))
        {
            for (int i = 0; i < newCars.length - 1; i++) {
                for (int j = i + 1; j < newCars.length; j++) {
                    if (newCars[i].getBrand().compareTo(newCars[j].getBrand()) < 0) {
                        Car temp = newCars[i];
                        newCars[i] = newCars[j];
                        newCars[j] = temp;
                    }
                }
            }
        }
        else
        {
            System.out.println("Error, please enter valid choice.");
        }
        return newCars;
    }
    public Car[] findDuplicateCars(Car[] cars)
    {
        String temp;
        int count = 0;
        for (int i = 0; i < cars.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (cars[i].getBrand().equals(cars[j].getBrand())) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                count++;
            }
        }
        Car[] newCars = new Car[count];
        int index = 0;
        for (int i = 0; i < cars.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (cars[i].getBrand().equals(cars[j].getBrand())) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                newCars[index] = cars[i];
                index++;
            }
        }
        return newCars;
    }
}
