---

# Parking Management API

This project is a Java Spring application designed for managing and organizing parking lots, particularly in buildings. It leverages Spring Security for enhanced security features and provides a robust backend for parking control.

## Features

- **Spring Boot**: Simplifies application configuration and deployment.
- **Spring Security**: Secures the application and handles authentication and authorization.
- **Spring Data JPA**: Manages database interactions with ease.
- **MySQL Database**: Uses MySQL for data storage.
- **JWT Authentication**: Secures APIs using JSON Web Tokens.

## Getting Started

### Prerequisites

Ensure you have the following installed:

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/install.html)
- [MySQL](https://dev.mysql.com/downloads/installer/)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/GugsFranca/ParkingManagementAPI.git
   cd ParkingManagementAPI
   ```

2. **Configure the database:**

   Update `src/main/resources/application.properties` with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/parking_control
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

### Environment Variables

To enhance security, you can configure sensitive information using environment variables. For example:

```bash
export SPRING_DATASOURCE_PASSWORD=your_password
export JWT_SECRET=my_secret_key
```

And update your `application.properties` accordingly:

```properties
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
api.security.token.secret=${JWT_SECRET}
```

## Usage

Once the application is running, you can interact with it using tools like [Postman](https://www.postman.com/) or through your frontend application.

### API Endpoints

#### Authentication
- **Login**: `/api/auth/login` (POST)
- **Register**: `/api/auth/register` (POST)

#### Parking Management
- **List Parking Spots**: `/api/parking-spots` (GET)
- **Add Parking Spot**: `/api/parking-spots` (POST)
- **Update Parking Spot**: `/api/parking-spots/{id}` (PUT)
- **Remove Parking Spot**: `/api/parking-spots/{id}` (DELETE)

#### Users
- **List Users**: `/api/users` (GET)
- **Add User**: `/api/users` (POST)
- **Update User**: `/api/users/{id}` (PUT)
- **Remove User**: `/api/users/{id}` (DELETE)

#### Vehicles
- **List Vehicles**: `/api/vehicles` (GET)
- **Add Vehicle**: `/api/vehicles` (POST)
- **Update Vehicle**: `/api/vehicles/{id}` (PUT)
- **Remove Vehicle**: `/api/vehicles/{id}` (DELETE)

## Contributing

Feel free to fork this repository and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under The Unlicense. See `LICENSE` for more information.

## Contact

Gustavo França Fonseca - [LinkedIn](https://www.linkedin.com/in/gustavo-franca/) [GMAIL](guto602@gmail.com)


---
