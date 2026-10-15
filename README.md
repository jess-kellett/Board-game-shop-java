# Board Game Shop Management System

A command-line shop system for a board game retailer, written in Java to demonstrate object-oriented design. Customers can browse stock, fill a shopping basket and pay by credit card or PayPal, while admins can view stock with purchase costs and add new products.

## Features

### Customer
- View all products in stock, sorted by price (highest first)
- Add products to a shopping basket, with a check that enough stock is available
- View the basket and its total price
- Pay by **credit card** or **PayPal** and receive a receipt with the billing address
- Cancel (clear) the basket
- Look up a product by its ID
- Search accessories by game compatibility

### Admin
- View all products, including the purchase cost (hidden from customers)
- Add new products to the stock, which are saved back to `Stock.txt`

## Object-oriented design

The project is built around core OOP principles:

| Principle | Where it's used |
|-----------|-----------------|
| **Abstraction** | Abstract classes `Product`, `BoardGame`, `Accessory` and `User` define shared structure that concrete classes build on |
| **Inheritance** | `StrategyGame` and `PartyGame` extend `BoardGame`; `Dice`, `Miniature` and `AccessoryKit` extend `Accessory`; `Admin` and `Customer` extend `User` |
| **Polymorphism** | `Admin` overrides `viewAllProducts()` to show purchase costs; each product overrides `toString()` to format its own output |
| **Interfaces** | `PaymentMethod` is implemented by `CreditCardPayment` and `PayPalPayment`, so new payment types can be added without changing the checkout code |
| **Encapsulation** | Private fields with getters and setters throughout |
| **Enums** | `ProductCategory`, `BoardGameType`, `AccessoryType` and `Role` keep product and user types consistent |


### Class hierarchy

```
Product (abstract)
├── BoardGame (abstract)
│   ├── StrategyGame
│   └── PartyGame
└── Accessory (abstract)
    ├── Dice
    ├── Miniature
    └── AccessoryKit

User (abstract)
├── Admin
└── Customer

PaymentMethod (interface)
├── CreditCardPayment
└── PayPalPayment
```

Supporting classes: `Stock`, `ShoppingBasket`, `Receipt`, `Address`, `FileManager`, `AdminCLI`, `CustomerCLI` and `Main`.

## Project structure

```
├── src/objectOrientatedProgrammingCoursework/   # all Java source files
├── bgms.jar                                     # runnable build of the program
├── classDiagram.pdf                             # UML class diagram
├── Stock.txt                                    # product stock data
└── UserAccounts.txt                             # user accounts
```

### Data files
- **`Stock.txt`** – one product per line: ID, category, type, name, price, quantity in stock, purchase cost, and either the number of players (board games) or compatibility (accessories)
- **`UserAccounts.txt`** – one user per line: ID, name, house number, postcode, city and role (admin or customer)

## How to run

You need Java installed (JDK 8 or later).

### Option 1: run the jar
From the project folder, so the program can find the `.txt` files:

```
java -jar bgms.jar
```

### Option 2: compile from source

```
javac -d out src/objectOrientatedProgrammingCoursework/*.java
java -cp out objectOrientatedProgrammingCoursework.Main
```

### Using the program
1. Choose a user from the welcome menu. User 1 is an admin and the others are customers.
2. Pick an option from the numbered menu.
3. Enter `0` to log out, then `0` again to exit.

## Technologies

- Java
- Command-line interface
- Plain text file storage

## Author

Jess Kellett
