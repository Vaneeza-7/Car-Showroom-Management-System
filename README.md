# Car Showroom Management System in Java

Automotive Sync, a desktop application built in Java using the Swing framework. The project leverages MySQL for the backend, following the MVC (Model-View-Controller) pattern. 

## Modules

### - Car View
- Displays a comprehensive view of available cars, their details, and specifications.

### - Manage Car Inventory
- Allows staff to add, update, and delete cars from the inventory.
- Singleton pattern applied to the Inventory class for centralized control.

### - Schedule Car for Service
- Enables scheduling maintenance services for cars in the showroom.

### - Schedule Car Test Drive
- Facilitates scheduling test drives for customers interested in specific cars.

### - Generate Sales Report
- Generates detailed sales reports for analysis and decision-making by the manager.

### - Purchase Order
- Facilitates the creation and tracking of purchase orders for new inventory.

### - Payment Module
- Manages the payment process for purchased cars using cash or credit card.

## User Roles

### - Customer
- Access to view available cars, schedule test drives, and make purchases.

### - Manager
- Access to report generation.

### - Staff
- Access for managing day-to-day operations, such as scheduling services and managing inventory (add, update, delete).

## Project Structure

### 1. Business Logic Package
- Core business logic resides here.
- Implements the code for the class diagram.
- Implements the Controller for each module.

### 2. Runner
- Entry point of the application.
- Initializes and launches the application.

### 3. Database Package
- Manages all interactions with the MySQL database.
- Implements functionalities related to data storage and retrieval.

### 4. UI Package
- Java Swing components for the user interface.
- Provides different views and interactive elements.

## Design Patterns

### - Singleton Pattern
- Applied to the Inventory class for ensuring a single instance and centralized control.

### - Factory Pattern
- Implemented for user management, providing a flexible and extensible way to create different types of users.

## External Library

### - Kcontrols
- [KControls library](https://github.com/k33ptoo/KControls) Utilized for enhancing the UI of sign-in page with additional features such as the K Gradient Panel and K Button.

## Getting Started

1. Clone the repository to your local machine.
2. Set up the MySQL database with the provided schema.
3. Update the database configuration in the application.
4. Run the application using the Runner class.

## Authors
- [Vaneeza](https://github.com/Vaneeza-7)
- [Eman Arshad](https://github.com/EmanArshad2)
  
## License
This project is licensed under the [MIT License](LICENSE).
