# Movie Ticket Booking System - Java Project Skeleton

This document outlines the basic structure and components of a Java-based Movie Ticket Booking System. The project is designed to simulate a real-time movie ticket booking platform where users can browse available movies, select seats, and make reservations.

## Project Structure

### 1. **Main Classes**

#### a. `Movie`
- **Attributes**:
  - `String title`
  - `String genre`
  - `int duration`
  - `String synopsis`
  - `List<Showtime> showtimes`
  
- **Methods**:
  - `addShowtime(Showtime showtime)`
  - `removeShowtime(Showtime showtime)`
  - `List<Showtime> getShowtimes()`

#### b. `Showtime`
- **Attributes**:
  - `LocalDateTime startTime`
  - `LocalDateTime endTime`
  - `String hall`
  - `List<Seat> seats`
  
- **Methods**:
  - `boolean isSeatAvailable(Seat seat)`
  - `void reserveSeat(Seat seat)`
  - `void cancelSeat(Seat seat)`

#### c. `Seat`
- **Attributes**:
  - `String seatNumber`
  - `boolean isReserved`
  
- **Methods**:
  - `void reserve()`
  - `void cancelReservation()`

#### d. `User`
- **Attributes**:
  - `String username`
  - `String password`
  - `List<Booking> bookings`
  
- **Methods**:
  - `void bookTicket(Showtime showtime, Seat seat)`
  - `void cancelBooking(Booking booking)`
  - `List<Booking> getBookings()`

#### e. `Admin`
- **Attributes**:
  - `String username`
  - `String password`
  
- **Methods**:
  - `void addMovie(Movie movie)`
  - `void removeMovie(Movie movie)`
  - `void addShowtime(Movie movie, Showtime showtime)`
  - `void removeShowtime(Movie movie, Showtime showtime)`

#### f. `Booking`
- **Attributes**:
  - `User user`
  - `Showtime showtime`
  - `Seat seat`
  - `LocalDateTime bookingTime`
  
- **Methods**:
  - `void confirmBooking()`
  - `void cancelBooking()`

### 2. **Database Management**

#### a. `Database`
- **Attributes**:
  - `List<Movie> movies`
  - `List<User> users`
  - `List<Admin> admins`
  
- **Methods**:
  - `void saveMovie(Movie movie)`
  - `void deleteMovie(Movie movie)`
  - `void saveUser(User user)`
  - `void deleteUser(User user)`
  - `void saveAdmin(Admin admin)`
  - `void deleteAdmin(Admin admin)`

### 3. **User Interface (UI)**

#### a. `MainMenu`
- **Methods**:
  - `void displayMenu()`
  - `void handleUserInput()`

#### b. `MovieMenu`
- **Methods**:
  - `void displayMovies()`
  - `void selectMovie(Movie movie)`

#### c. `BookingMenu`
- **Methods**:
  - `void displayShowtimes(Movie movie)`
  - `void selectSeat(Showtime showtime)`
  - `void confirmBooking(Booking booking)`

### 4. **Utility Classes**

#### a. `PaymentProcessor`
- **Methods**:
  - `boolean processPayment(double amount)`
  - `void generateETicket(Booking booking)`

#### b. `NotificationService`
- **Methods**:
  - `void sendConfirmation(User user, Booking booking)`
  - `void sendReminder(User user, Booking booking)`

### 5. **Main Application**

#### a. `MovieTicketBookingApp`
- **Methods**:
  - `void start()`
  - `void shutdown()`

## Workflow

1. **User Authentication**:
   - Users log in or register to access the system.
   
2. **Browse Movies**:
   - Users can view a list of available movies and their details.
   
3. **Select Showtime**:
   - Users select a showtime for the chosen movie.
   
4. **Choose Seat**:
   - Users select an available seat for the selected showtime.
   
5. **Make Payment**:
   - Users proceed to payment, which is simulated by the `PaymentProcessor`.
   
6. **Confirmation**:
   - Upon successful payment, a booking confirmation is generated, and an e-ticket is sent to the user.

## Conclusion

This skeleton provides a basic structure for a Movie Ticket Booking System in Java. The project can be expanded with additional features such as user reviews, movie ratings, and more advanced payment processing. The use of object-oriented principles ensures that the system is modular, scalable, and easy to maintain.