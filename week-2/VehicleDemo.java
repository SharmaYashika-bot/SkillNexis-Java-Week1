class Vehicle {
    protected String brand;
    
    public Vehicle(String brand) {
        this.brand = brand;
    }
    
    public void start() {
        System.out.println(this.brand + " vehicle is starting...");
    }
    
    public void stop() {
        System.out.println(this.brand + " vehicle is stopping...");
    }
    
    public void displayInfo() {
        System.out.println("Brand: " + this.brand);
    }
}

class Car extends Vehicle {
    private int seats;
    
    public Car(String brand, int seats) {
        super(brand);
        this.seats = seats;
    }
    
    @Override
    public void start() {
        System.out.println(this.brand + " Car engine started with key. Seats: " + this.seats);
    }
}

class Bike extends Vehicle {
    private String type;
    
    public Bike(String brand, String type) {
        super(brand);
        this.type = type;
    }
    
    @Override
    public void start() {
        System.out.println(this.brand + " " + this.type + " Bike engine started with self-start."); // FIXED
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("--- Vehicle Inheritance Demo ---");
        
        Vehicle v1 = new Car("Maruti", 5);
        Vehicle v2 = new Bike("Honda", "Sports");
        
        v1.displayInfo();
        v1.start();
        v1.stop();
        
        System.out.println();
        
        v2.displayInfo();
        v2.start();
        v2.stop();
    }
}
