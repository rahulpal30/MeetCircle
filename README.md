# MeetCircle Chat Application

MeetCircle is a desktop-based Java chat application that supports user registration, login, and real-time messaging between connected users. 
It features a GUI-based client built with Swing and custom utilities for resizing and user interface responsiveness.

## Features

🔐 **User Registration & Login**

  * Secure login using credentials stored in a backend database.
  * Separate registration screen to onboard new users.

💬 **Chat Functionality**

  * Real-time communication using client-server architecture.
  * Message broadcasting to connected clients.

🧩 **Modular Design**

  * Separate classes for database operations, GUI components, and socket-based communication.

🎨 **Custom GUI Components**

  * Responsive resizing with `ComponentResizer`.
  * User-friendly interface built with Java Swing.

## File Descriptions

| File                    | Description                                                                           |
| ----------------------- | ------------------------------------------------------------------------------------- |
| `Client.java`           | Initializes the client GUI and manages the socket connection.                         |
| `Login.java`            | GUI and logic for user login. Connects to `DB.java` for credential verification.      |
| `Register.java`         | GUI and backend logic for user registration.                                          |
| `DB.java`               | Handles database operations including connection and credential checks.               |
| `MeetCircle1.java`      | The main chat interface post-login. Handles sending/receiving messages.               |
| `ChatCallback.java`     | Interface for handling incoming messages and updating the UI.                         |
| `ComponentResizer.java` | Utility class for adding dynamic resizing to GUI components.                          |
| `Loging.java`           | Appears to be a duplicate or experimental login screen. Consider merging or removing. |

## Requirements

* Java 8 or higher
* MySQL or any JDBC-compatible database
* JDBC driver for MySQL (e.g., `mysql-connector-java`)

## Setup Instructions

1. **Clone the Repository**

```bash
git clone https://github.com/your-username/meetcircle-chat.git
cd meetcircle-chat
```

2. **Set Up the Database**

* Create a MySQL database and update the connection details in `DB.java`.
* Run the following SQL commands to set up the user table:

```sql
CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL
);
```

3. **Compile and Run**

```bash
javac *.java
java Client
```

## To Do

* [ ] Implement encryption for messages
* [ ] Add user typing indicators
* [ ] Improve UI/UX with modern libraries
* [ ] Dockerize the application
