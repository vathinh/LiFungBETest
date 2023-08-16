# LiFungBETest
---
## Prerequisites

- Docker
- DataGrip (or any MySQL client)
- Postman (or any API testing tool)

## Getting Started

1. **Run Docker Compose**:
   - Open a terminal.
   - Navigate to the root directory of the project.
   - Run the following command to start the project:
   
     docker-compose up -d

2. **Connect DataGrip to MySQL**:
   - Open DataGrip.
   - Create a new MySQL data source with the following settings:
     - Host: `localhost` or Docker container IP
     - Port: Port defined in docker-compose (e.g., 3306)
     - User: root 
     - Password: admin
     - Database: lifung

3. **Initialize the Database**:
   - Open `initDB.sql` script from your project.
   - Copy the script content.
   - In DataGrip, open a query console and paste the script.
   - Run the script to create the required tables and initial data.

4. **Import Postman Collection**:
   - Open Postman.
   - Import the provided JSON file from the `postManImport` folder.
   - This collection contains APIs for signup, signin, and managing todos.

5. **Run the Application**:
   - Start your Spring Boot application using your preferred IDE or by running the JAR file.

6. **Test APIs**:
   - In Postman, execute the following steps:
     1. Signup: Create a new user account using the signup API.
     2. Signin: Use the signin API to get an authentication token.
     3. Create New ToDo: Create a new ToDo item using the appropriate API.
     4. Get All ToDo: Retrieve all ToDo items using the appropriate API.
