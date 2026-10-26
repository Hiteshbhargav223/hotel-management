# Hotel Management System

A console-based hotel management project written in Java to demonstrate Object-Oriented Programming (OOP) concepts without a graphical user interface. All room and booking data is stored in memory using `ArrayList`.

## Features
- View all rooms and their current occupancy status
- Search available rooms by category (Single, Double, Triple, Family)
- Book a room for a guest (supports standard booking and discount booking)
- View active reservations
- Check out a guest and print a bill receipt with tax calculation
- View overall hotel occupancy counts

## Project Structure
- `src/Billable.java` - Interface for billing calculation and receipt printing
- `src/Person.java` - Abstract base class storing basic contact details
- `src/Guest.java` - Subclass of `Person` representing a hotel guest
- `src/Room.java` - Abstract base class for hotel rooms
- `src/SingleRoom.java`, `src/DoubleRoom.java`, `src/TripleRoom.java`, `src/FamilyRoom.java` - Concrete subclasses of `Room` with different capacities and pricing rules
- `src/Reservation.java` - Connects a `Guest` and a `Room` and implements `Billable`
- `src/HotelManager.java` - Manages `ArrayList<Room>` and `ArrayList<Reservation>` collections
- `src/Main.java` - Entry point with the `Scanner` terminal menu

## OOP Concepts Used
- **Encapsulation:** Private fields with getter and setter methods across classes.
- **Inheritance:** `Guest` extends `Person`; the four room types extend `Room`.
- **Polymorphism:** Method overriding in room cost calculations (`calculateRoomCost`) and method overloading in `HotelManager` (`searchAvailableRooms` and `bookRoom`).
- **Abstraction:** Abstract classes (`Person`, `Room`) and the `Billable` interface.

## How to Run
```bash
javac src/*.java
java -cp src Main
```
