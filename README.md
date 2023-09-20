
# <h1 align="center"> Hotel Management Application </h1>
___ 
<p align="center">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.3-brightgreen.svg" />
    <img alt="H2 Database" src="https://img.shields.io/badge/H2%20Database-embedded-orange.svg" />
</p>


---

<p align="left">

## Overview

The Hotel Management Application is a Spring Boot-based system designed to manage hotel room data efficiently. It provides a set of RESTful API endpoints for tasks such as creating, retrieving, updating, and deleting room records. This application offers features for room type filtering, price updates, and availability tracking.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven
- **Database:** H2 (embedded)

## Data Flow

### Controller

The Controller layer handles incoming HTTP requests and delegates them to the appropriate services. It defines API endpoints for various operations:

1. **Add Room:** `POST /room`
2. **Add Rooms:** `POST /rooms`
3. **Get All Rooms:** `GET /rooms`
4. **Get Room by ID:** `GET /room/{roomId}`
5. **Update Room Price by Type:** `PUT /room/price/{roomType}/{priceIncrease}`
6. **Get Available Rooms by Type:** `GET /rooms/available/{roomType}`
7. **Delete Room by ID:** `DELETE /room/{roomId}`

```java
@RestController
public class RoomController {
    @Autowired
    RoomService roomService;

    // Add a room
    @PostMapping("/room")
    public String addRoom(@RequestBody Room room) {
        return roomService.addARoom(room);
    }

    // Get all rooms
    @GetMapping("/rooms")
    public Iterable<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    // ...
}
```

### Services

The Services layer implements business logic, data processing, and interactions with the data repository. Key responsibilities include:

- Validating input data.
- Performing CRUD operations on room data.
- Handling price updates and availability tracking.

```java
@Service
public class RoomService {
    @Autowired
    IRoomRepo roomRepo;

    // Get all rooms
    public Iterable<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    // ...
}
```

### Repository

The Repository layer manages data access to the embedded H2 database. It handles database operations, including Create, Read, Update, and Delete (CRUD) for room data.

```java
@Repository
public interface IRoomRepo extends CrudRepository<Room, Long> {
    List<Room> findByRoomType(RoomType roomType);
    List<Room> findByRoomTypeAndRoomAvailableStatus(RoomType roomType, boolean availableStatus);
}
```

## Database Design

The project's database design includes tables for room management with fields such as:

- `roomId` (Room ID)
- `roomNo` (Room Number)
- `roomType` (Room Type)
- `roomPrice` (Room Price)
- `roomAvailableStatus` (Availability Status)

### Room Table

| Column Name          | Data Type    | Description                     |
| -------------------- | ------------ | ------------------------------- |
| roomId               | BIGINT       | Unique identifier for each room |
| roomNo               | INTEGER      | Unique room number              |
| roomType             | ENUM         | Room type (AC, NON_AC)          |
| roomPrice            | DOUBLE       | Price of the room               |
| roomAvailableStatus  | BOOLEAN      | Availability status             |

The "Room" table stores room-related information, including room IDs, numbers, types, prices, and availability status. Timestamps for record creation and modification are not included in this embedded database.

## Data Structures Used

The project uses the following data structures:

### Room Class

The `Room` class defines the structure for room data, including room attributes such as `roomId`, `roomNo`, `roomType`, `roomPrice`, and `roomAvailableStatus`.

### RoomType Enum

The `RoomType` enum enumerates the possible room types: AC and NON_AC.

### ArrayList

The `ArrayList` data structure is used for managing lists of `Room` objects efficiently.

These data structures enable the application to organize and manipulate room data effectively while ensuring data integrity.

## Project Summary

The Hotel Management Application is a Spring Boot-based system designed for efficient room data management. It offers a set of RESTful API endpoints for various room-related operations, including creating, retrieving, updating, and deleting room records.

### Key Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Build Tool:** Maven
- **Database:** H2 (embedded)

### Data Flow

#### Controller

The Controller layer handles incoming HTTP requests and routes them to the appropriate services. It defines API endpoints for operations such as adding, retrieving, updating, and deleting room records.

#### Services

The Services layer implements core business logic and data processing, including input validation, CRUD operations on room data, and handling price updates and availability tracking.

#### Repository

The Repository layer manages data access to the embedded H2 database, performing Create, Read, Update, and Delete (CRUD) operations for room data.

#### Database Design

The database design includes tables for room management, featuring fields such as `roomId`, `roomNo`, `roomType`, `roomPrice`, and `roomAvailableStatus`.

### Data Structures Used

- **Room Class:** Defines the structure for room data, including room attributes and availability status.
- **RoomType Enum:** Enumerates room types (AC, NON_AC).
- **ArrayList:** Utilized for managing lists of `Room` objects efficiently.

### Key Features

- RESTful API endpoints for room management.
- Data validation to ensure data integrity.
- Clean code separation with a layered architecture (Controller, Services, Repository).
- Efficient data storage and retrieval using an embedded H2 database.

The Hotel Management Application serves as a practical example of Spring Boot application development, demonstrating best practices in API design and room data management. It offers a solid foundation for building and extending hotel management systems in various applications.

<!-- License -->
## License
This project is licensed under the [GNU General Public License v3.0](LICENSE).

<!-- Acknowledgments -->
## Acknowledgments
Special thanks to the Spring Boot and Java communities for providing valuable tools and resources.

<!-- Contact -->
## Contact
For questions or feedback, please contact [Amit Ashok Swain](mailto:business.amitswain@gmail.com).

