import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
// User class to store user information
class User {
private String userId;
private String name;
private String role;
public User(String userId, String name, String role) {
this.userId = userId;
this.name = name;
this.role = role;
}
public String getUserId() { return userId; }
public String getName() { return name; }
public String getRole() { return role; }
}

// Car class to store car information
class Car {
private String carId;
private String model;
private boolean isAvailable;
public Car(String carId, String model, boolean isAvailable) {


this.carId = carId;
this.model = model;
this.isAvailable = isAvailable;
}
public String getCarId(){ return carId; }
public String getModel(){ return model; }
public boolean isAvailable() { return isAvailable; }
public void setAvailable(boolean available) { isAvailable = available; }
}
// Booking class to store booking details
class Booking {
private String bookingId;
private User user;
private Car car;
private Date startDate;
private Date endDate;
public Booking(String bookingId, User user, Car car, Date startDate, Date
endDate) {
this.bookingId = bookingId;
this.user = user;
this.car = car;
this.startDate = startDate;
this.endDate = endDate;
}
public String getBookingId() { return bookingId; }
public User getUser() { return user; }
public Car getCar() { return car; }
}


// Payment class to store payment details
class Payment {
private String paymentId;
private double amount;
private Date paymentDate;
private String status;
public Payment(String paymentId,
String status) {
this.paymentId = paymentId;
this.amount = amount;
this.paymentDate = paymentDate;
this.status = status;
}

double amount, Date paymentDate,

public String getPaymentId() { return paymentId; }
public double getAmount() { return amount; }
public String getStatus(){ return status; }
}
// Main Car Rental System class
public class CarRentalSystem {
private List<User> users = new ArrayList<>();
private List<Car> cars = new ArrayList<>();
private List<Booking> bookings = new ArrayList<>();
private List<Payment> payments = new ArrayList<>();
private Scanner scanner = new Scanner(System.in);
// Register a user
public void registerUser(String userId, String name, String role) {
users.add(new User(userId, name, role));
}

// Add a car to the system
public void addCar(String carId, String model) {
cars.add(new Car(carId, model, true));
}
// Make a booking
public void createBooking(String bookingId, String userId, String carId) {
User user = findUserById(userId);
Car car = findCarById(carId);
if (user != null && car != null && car.isAvailable()) {
car.setAvailable(false);
Booking booking = new Booking(bookingId, user, car, new Date(), new
Date());
bookings.add(booking);
System.out.println("Booking successful for " + user.getName() + " with
car " + car.getModel());
} else {
System.out.println("Booking failed: User or car not available.");
}
}
// Process a payment
public void processPayment(String paymentId, double amount) {
Payment payment = new Payment(paymentId, amount, new Date(),
"Completed");
payments.add(payment);
System.out.println("Payment of $" + payment.getAmount() + " processed
successfully.");
}
// Find user by ID

private User findUserById(String userId) {
for (User user : users) {
if (user.getUserId().equals(userId)) {
return user;
}
}
return null;
}
// Find car by ID
private Car findCarById(String carId) {
for (Car car : cars) {
if (car.getCarId().equals(carId)) {
return car;
}
}
return null;
}
// Menu-driven interface
public void run() {
while (true) {
System.out.println("\nCar Rental System");
System.out.println("1. Register User");
System.out.println("2. Add Car");
System.out.println("3. Make Booking");
System.out.println("4. Process Payment");
System.out.println("5. Exit");
System.out.print("Select an option: ");
int choice = scanner.nextInt();


scanner.nextLine(); // Consume newline
switch (choice){
case 1:
System.out.print("Enter User ID: ");
String userId = scanner.nextLine();
System.out.print("Enter Name: ");
String name = scanner.nextLine();
System.out.print("Enter Role (Customer/Admin): ");
String role = scanner.nextLine();
registerUser(userId, name, role);
System.out.println("User registered successfully.");
break;

case 2:
System.out.print("Enter Car ID: ");
String carId = scanner.nextLine();
System.out.print("Enter Car Model: ");
String model = scanner.nextLine();
addCar(carId, model);
System.out.println("Car added successfully.");
break;

case 3:
System.out.print("Enter Booking ID: ");
String bookingId = scanner.nextLine();
System.out.print("Enter User ID: ");
userId = scanner.nextLine();
System.out.print("Enter Car ID: ");


carId = scanner.nextLine();
createBooking(bookingId, userId, carId);
break;

case 4:
System.out.print("Enter Payment ID: ");
String paymentId = scanner.nextLine();
System.out.print("Enter Amount: ");
double amount = scanner.nextDouble();
processPayment(paymentId, amount);
break;

case 5:
System.out.println("Exiting...");
return;

default:
System.out.println("Invalid option. Please try again.");
}
}
}

// Main method
public static void main(String[] args) {
CarRentalSystem system = new CarRentalSystem();
system.run();
}
}
