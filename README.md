# Movie Ticket Booking System

This project is a Java-based Movie Ticket Booking System that simulates a real-time platform for booking movie tickets.

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- Visual Studio Code (VS Code) with Java extensions

### Folder Structure
- `src`: Source code
- `lib`: Dependencies
- `bin`: Compiled output files

## Project Structure

### Main Classes
- **Movie**: Represents a movie with attributes like title, genre, duration, synopsis, and showtimes.
- **Showtime**: Represents a showtime with attributes like start time, end time, hall, and seats.
- **Seat**: Represents a seat with attributes like seat number and reservation status.
- **User**: Represents a user with attributes like username, password, and bookings.
- **Admin**: Represents an admin with attributes like username and password.
- **Booking**: Represents a booking with attributes like user, showtime, seat, and booking time.

### Database Management
- **Database**: Manages lists of movies, users, and admins with methods to save and delete these entities.

### User Interface (UI)
- **MainMenu**: Displays and handles the main menu options.
- **MovieMenu**: Displays and allows selection of movies.
- **BookingMenu**: Displays showtimes, allows seat selection, and confirms bookings.

### Utility Classes
- **PaymentProcessor**: Processes payments and generates e-tickets.
- **NotificationService**: Sends booking confirmations and reminders.

### Main Application
- **MovieTicketBookingApp**: Starts and shuts down the application.

## Workflow
1. **User Authentication**: Users log in or register.
2. **Browse Movies**: Users view available movies.
3. **Select Showtime**: Users select a showtime.
4. **Choose Seat**: Users select an available seat.
5. **Make Payment**: Users proceed to payment.
6. **Confirmation**: A booking confirmation is generated, and an e-ticket is sent to the user.

## Conclusion
This project provides a basic structure for a Movie Ticket Booking System in Java. It can be expanded with additional features like user reviews, movie ratings, and more advanced payment processing.