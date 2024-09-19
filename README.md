
Task List Application
This project is a web-based task management application designed to help users organize tasks, especially focused on job hunting. It allows users to create, edit, delete, and view tasks, each with details such as a start date, duration, and completion status. The application is built with Spring Boot, Thymeleaf, and Bootstrap, and uses MySQL as the database. Docker is used to containerize the application, making it easy to deploy and run.

Features
Create New Task: Add a new task with a description, start date, duration, and completion status.
View All Tasks: See a list of all tasks, sorted by the start date.
Edit Task: Modify the details of an existing task.
Delete Task: Remove a task from the list.
Task Completion Status: Visual indication of task completion with a green checkmark for completed tasks and a red cross for incomplete tasks.
Responsive Design: The application is built using Bootstrap, making it responsive and user-friendly on different devices.
Technologies Used
Backend: Spring Boot
Frontend: Thymeleaf, Bootstrap, FontAwesome
Database: MySQL
Containerization: Docker
Prerequisites
Docker and Docker Compose installed on your system.
MySQL installed locally or running as a Docker container (if not using the provided Docker Compose configuration).

 Configuration
Application Properties: Configure your database connection in src/main/resources/application.properties if not using Docker Compose.

How It Works
Task Management: Users interact with the application through the web interface, where they can create, view, edit, and delete tasks.
Task Display: The tasks are displayed in a table, showing task description, start date, duration, and completion status.
Database Interaction: The application interacts with the MySQL database to persist tasks.
Docker: Docker simplifies deployment by containerizing both the Spring Boot application and the MySQL database, ensuring consistency across different environments.
Future Improvements
User Authentication: Add user authentication and authorization features to personalize the task list for different users.
Task Categories: Introduce categories or labels to organize tasks better.
Priority Levels: Allow setting priority levels for tasks to manage them more effectively.
Search and Filter: Implement search and filtering functionality for easier task management.
Contributing
If you'd like to contribute to this project, feel free to fork the repository and submit a pull request with your changes. Contributions are always welcome!
