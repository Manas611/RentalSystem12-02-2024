import java.util.HashMap;

// Creating the  abstract class of Vehicle type
abstract class Vehicle
{
    String make;
    String model;
    int year;
    int rentalPrice;
    abstract int CalculateRentalCost();

    // Constructor of Vehicle class
    public Vehicle(String make, String model, int year, int rentalPrice) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }

    public int getYear()
    {
        return year;
    }
    
}

class Car extends Vehicle
{
    int numSeat;
    String FuelType;

    // Constructor of Car class
    public Car(String make, String model, int year, int rentalPrice, int numSeat, String fuelType) {
        super(make, model, year, rentalPrice);
        this.numSeat = numSeat;
        this.FuelType = fuelType;
    }

    public int CalculateRentalCost()
    {
        return rentalPrice;
    }

}

class Customer
{
    String name;
    String email;
    int days;

    // List to store the cars that customer Rented 
    HashMap<Integer,Vehicle> VehicleList;

    public Customer(String name, String email,int days) {
        this.name = name;
        this.email = email;
        this.days = days;
        this.VehicleList = new HashMap<>();
    }

    // Adding to Customer list and Removing from the Agency List that the car was Rented
    public void RentedVehicle(Vehicle vh)
    {
        VehicleList.put(vh.year, vh);
        RentalAgency.AllVehicles.remove(vh.year);
    }

    // To print the Vehicles that customer rented
    public void VehicleList()
    {
        System.out.println("List of Rented Vehivle is");
        for(Vehicle i:VehicleList.values())
        {
            System.out.println(i.make + " " + i.model + " " + i.rentalPrice + " "+i.getYear());
        }
        System.out.println();
    }
}


class RentalAgency
{
    // List to store all vehicles that are available in Agency
    public static HashMap<Integer,Vehicle> AllVehicles = new HashMap<>();

    // Function to  add Vehicles in the Agency
    public void AddingVehicle(Vehicle vh)
    {
        AllVehicles.put(vh.getYear(),vh);
    }

    // Function to print the rented cost of vehicle which the customer rented
    public void rentalCost(Vehicle vh,Customer cs)
    {
        System.out.println("Cost of vehicle is "+vh.CalculateRentalCost()*cs.days + " that was rented by "+cs.name);
    }

    //  Method to print the numbers of cars that are present in the Agency
    public void ListOfCar()
    {
        for(Vehicle i:AllVehicles.values())
        {
            System.out.print(i.make + " " + i.model + " " + i.rentalPrice + " ");
            System.out.println(i.getYear());
        }
        System.out.println();
    }
}


public class CarRental {
    public static void main(String[] args) {

        // Creating the objects of vehicle
        Car Alto = new Car("Maruti", "LXI", 2011, 2500, 4, "Petrol");
        Car Figo = new Car("Ford", "ZX", 2012, 3000, 5, "Diesel");
        Car I20 = new Car("Hyndai", "Sports", 2013, 4000, 5, "Diesel");
        Car Endavour = new  Car("Ford", "Xl", 2018, 5000, 6, "Diesel");
        Car Nexon = new Car("Tata", "EV", 2020, 1000, 6, "Electric");
        
        // Creating object of Agency
        RentalAgency Khanna = new RentalAgency();

        // Adding Vehicle to Agency
        Khanna.AddingVehicle(Alto);
        Khanna.AddingVehicle(Figo);
        Khanna.AddingVehicle(I20);
        Khanna.AddingVehicle(Endavour);
        Khanna.AddingVehicle(Nexon);
        
        // Creating cutomer
        Customer Manas = new Customer("Manas", "manaskhanna611@gmail.com", 2);
        // Customer Saksham = new Customer("Saksham", "Saksham@11", 5);

        System.out.println("List of cars that Available out in Agency having year");
        Khanna.ListOfCar();


        // Renting the vehicle 
        Manas.RentedVehicle(Alto);
        Manas.RentedVehicle(I20);
        
        Manas.VehicleList();
        
        System.out.println("List of cars that Available out in Agency having year ");

        Khanna.ListOfCar();

        // Check for cars that are left after renting
        Khanna.rentalCost(Alto, Manas);
        
    }
}
