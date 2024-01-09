import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Car{
    private String carId;
    private String carBrand;
    private String carModel;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId, String carBrand, String carModel, double basePricePerDay){
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.basePricePerDay = basePricePerDay;
        this.isAvailable = true;
    }

    public String getCarId(){
        return carId;
    }
    public String getCarBrand(){
        return carBrand;
    }
    public String getCarModel(){
        return carModel;
    }
    public double getBasePricePerDay(){
        return basePricePerDay;
    }
    public double calculatePrice(int rendDays){
        return basePricePerDay*rendDays;
    }
    public boolean isAvailable(){
        return isAvailable;
    }
    public void rent(){
        isAvailable = false;
    }
    public void returnCar(){
        isAvailable = true;
    }
}

class Customer{
    private String customerId;
    private String getCustomerName;

    public Customer(String customerId, String getCustomerName){
        this.customerId = customerId;
        this.getCustomerName = getCustomerName;
    }

    public String getCustomerId(){
        return customerId;
    }
    public String getGetCustomerName(){
        return getCustomerName;
    }
}

class Rental{
    private Car car;
    private Customer customer;
    private int days;

    public Rental(Car car, Customer customer, int days){
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    public Car getCar(){
        return car;
    }
    public Customer getCustomer(){
        return customer;
    }
    public int getDays(){
        return days;
    }
}

class CarRentalSystem{
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem(){
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }
    public void addCar(Car car){
        cars.add(car);
    }
    public void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentCar(Car car, Customer customer, int days){
        if(car.isAvailable()){
            rentals.add(new Rental(car, customer, days));
            car.rent();
        }else{
            System.out.println("Car is not available");
        }
    }

    public void returnCar(Car car){
        Rental rentalRemove = null;
        for(Rental rental : rentals){
            if(rental.getCar() == car){
                rentalRemove = rental;
                break;
            }
        }
        if(rentalRemove != null){
            rentals.remove(rentalRemove);
            car.returnCar();
        }else{
            System.out.println("Car was not found.");
        }
    }

    public void menu(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("===== Car Rental System =====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if(choice == 1){
                System.out.println("\n=== Rent a Car ===\n");
                System.out.print("Enter your name: ");
                String customerName = input.nextLine();
                System.out.println("\nAvailable Cars: ");
                System.out.println("CarID - Brands - Models - Base price per day.");
                System.out.println("----------------------------------------------");
                for(Car car: cars){
                    if(car.isAvailable()){
                        System.out.println(car.getCarId()+" - "+car.getCarBrand()+" - "+car.getCarModel()+" - "+car.getBasePricePerDay());
                    }
                }
                System.out.print("\nEnter the car ID you want to rent: ");
                String carId = input.nextLine();
                System.out.print("Enter the number of days for rental: ");
                int rentalDays = input.nextInt();
                input.nextLine();

                Customer newCustomer = new Customer("CUS"+(customers.size()+1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car: cars){
                    if(car.getCarId().equals(carId) && car.isAvailable()){
                        selectedCar = car;
                        break;
                    }
                }

                if(selectedCar != null){
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("\n=== Rental Information ===\n");
                    System.out.println("Customer ID: "+newCustomer.getCustomerId());
                    System.out.println("Customer Name: "+newCustomer.getGetCustomerName());
                    System.out.println("Car: "+selectedCar.getCarBrand()+" "+selectedCar.getCarModel());
                    System.out.println("Rental Days: "+rentalDays);
                    System.out.printf("Total Price: %.2f taka\n", totalPrice);

                    System.out.print("\nConfirm rental (Y/N): ");
                    String confirm = input.nextLine();
                    if(confirm.equalsIgnoreCase("Y")){
                        rentCar(selectedCar, newCustomer, rentalDays);
                        System.out.println("\nCar Rented Successfully.");
                    }else{
                        System.out.println("\nRental Canceled.");
                    }
                }else{
                    System.out.println("Car not Available or Invalid car selection.");
                }
            }
            else if(choice == 2){
                System.out.println("\n=== Return a Car ===\n");
                System.out.print("Enter the car ID you want to return: ");
                String carId = input.nextLine();

                Car carReturn = null;
                for(Car car : cars){
                    if(car.getCarId().equals(carId) && !car.isAvailable()){
                        carReturn = car;
                        break;
                    }
                }

                if(carReturn != null){
                    Customer customer = null;
                    for(Rental rental: rentals){
                        if(rental.getCar() == carReturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }

                    if(customer != null){
                        returnCar(carReturn);
                        System.out.println("Car returned successfully by: "+customer.getGetCustomerName());
                    }else{
                        System.out.println("Car was not rented Or Rental Information is missing.");
                    }
                }else{
                    System.out.println("Invalid car ID or Car was not rented");
                }
            }
            else if(choice == 3){
                break;
            }else{
                System.out.println("Invalid choice, Please enter a valid option.");
            }
        }
        System.out.println("\nThank your for using the Car Rental System!");
    }
}

public class Main {
    public static void main(String[] args) {
        CarRentalSystem carRentalSystem = new CarRentalSystem();
        Car car1 = new Car("T001", "Toyota", "X Corolla", 100.00);
        Car car2 = new Car("T002", "Toyota", "RAV4", 150.00);
        Car car3 = new Car("T003", "Toyota", "Land Cruiser", 200.00);
        Car car4 = new Car("M001", "Mitsubishi", "Pajero", 120.00);
        Car car5 = new Car("B001", "BMW", "X1", 180.00);
        Car car6 = new Car("B002", "BMW", "X2", 200.00);

        carRentalSystem.addCar(car1);
        carRentalSystem.addCar(car2);
        carRentalSystem.addCar(car3);
        carRentalSystem.addCar(car4);
        carRentalSystem.addCar(car5);
        carRentalSystem.addCar(car6);

        carRentalSystem.menu();

    }
}
