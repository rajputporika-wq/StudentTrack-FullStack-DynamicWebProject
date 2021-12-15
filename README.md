# Secure Student Portal – Full Stack Java Application

## Description
The **Secure Student Portal** is a full-stack Java web application developed using **JSP**, **Servlets**, **JDBC**, and **MySQL**.
It provides a secure login authentication system with role-based access.
The **administrator (id = 1)** can view all student details, while regular student users can log in to view only their own information.

---

## Features
- **User Authentication** – Secure login and registration system
- **Role-Based Access** – Admin (id = 1) can view all student records
- **Student Dashboard** – Students can view their own details
- **Database Integration** – Connected to MySQL via JDBC
- **MVC Architecture** – Structured and maintainable code
- **Responsive UI** – Designed using JSP, HTML, CSS, and Bootstrap

---

## Tech Stack
| Layer | Technology |
|-------|-------------|
| **Frontend** | JSP, HTML, CSS, Bootstrap |
| **Backend** | Java Servlets, JDBC |
| **Database** | MySQL |
| **Server** | Apache Tomcat |

---

## How It Works
1. Users register or log in using valid credentials.
2. If `id = 1`, the user is recognized as the **Administrator**.
3. The **Administrator** can view all student details stored in the database.
4. Regular users (students) can log in to view only their personal information.
5. Data is managed dynamically via JDBC and displayed using JSP pages.

---

## Project Structure

This project follows the **Model-View-Controller (MVC)** design pattern:

```bash
Student-Management-System-FullStack-Java/
│
├── java/com/
│   └── pentagon/
│       ├── Conn/
│       │   └── Connectors.java                   # Establishes MySQL database connection
│       │
│       ├── StudentDAO/
│       │   ├── StudentDAO.java                   # Interface defining student data operations
│       │   └── StudentDAOImp.java                # Implements DAO methods using JDBC
│       │
│       ├── StudentDTO/
│       │   └── Student.java                      # Data Transfer Object (student model class)
│       │
│       └── student/dynamic/
│           ├── Dashboard.java                    # Servlet handling dashboard display
│           ├── Forgotpassword.java               # Servlet for password recovery
│           ├── Login.java                        # Servlet managing login authentication
│           ├── Signup.java                       # Servlet handling new user registration
│           └── UpdateAccount.java                # Servlet for updating student information
│
├── webapp/                                    # Frontend JSP and resource files
│   ├── index.jsp                                 # Homepage or welcome page
│   ├── login.jsp                                 # User login page
│   ├── register.jsp                              # Registration page
│   ├── dashboard.jsp                             # Dashboard after login
│   ├── forgotpassword.jsp                        # Forgot password form
│   ├── updateAccount.jsp                         # Update profile page
│   └── viewStudents.jsp                          # Admin-only page showing all student data
│
├── web.xml                                   # Servlet mapping and configuration
├──  .classpath                                # Java classpath configuration
├──  .project                                  # Eclipse project settings
└── README.md                                 # Project documentation
```
## Setup and Installation

To run this project on your local machine, follow these steps:

1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/prashanth0630/StudentTrack-FullStack-DynamicWebProject](https://github.com/prashanth0630/StudentTrack-FullStack-DynamicWebProject)
    cd Secure-Student-Portal
    ```

2.  **Database Setup**
    * Open your MySQL server (e.g., MySQL Workbench).
    * Create a new database for the project.
        ```sql
        CREATE DATABASE student_portal;
        ```
    * Create the necessary tables (e.g., `users`, `students`).
        ```sql
        -- You will need to add your full schema here.
        -- Example:
        CREATE TABLE users (
          id INT PRIMARY KEY AUTO_INCREMENT,
          username VARCHAR(50) NOT NULL UNIQUE,
          password VARCHAR(100) NOT NULL,
          email VARCHAR(100)
        );
        ```

3.  **Configure JDBC**
    * Navigate to the database utility class (e.g., `src/main/java/.../util/DBUtil.java`).
    * Update the JDBC connection string with your database URL, username, and password.
        ```java
        private static final String DB_URL = "jdbc:mysql://localhost:3306/student_portal";
        private static final String DB_USER = "your_mysql_username";
        private static final String DB_PASS = "your_mysql_password";
        ```
    * **Important:** Download the [MySQL JDBC Driver](https://dev.mysql.com/downloads/connector/j/) and add the `.jar` file to your `webapp/WEB-INF/lib` directory.
4.  **Build and Deploy**
    * Open the project in your IDE (e.g., Eclipse IDE for Java EE Developers, IntelliJ IDEA Ultimate).
    * Configure an Apache Tomcat server.
    * Right-click the project and select "Run As" > "Run on Server".
    * Access the application in your browser at `http://localhost:8080/Secure-Student-Portal/` (the context path may vary).

---
## Key Concepts & Technologies Used

This project demonstrates the following core Java web concepts:

# Servlets and JSP Notes

## 1. Servlets
A technology used to develop dynamic web applications.
Servlet is an interface present in the Jakarta applications package.

### Application Logic Tiers
* **Frontend:** Presentation logic
* **Backend:** Persistence logic
* **Database:** Storage logic

---

## 2. Servlet Hierarchy
The general hierarchy is `HttpServlet` extends `GenericServlet` which implements `Servlet`.

### Servlet Interface
We can't use the `Servlet` interface directly because it contains unimplemented methods.

### GenericServlet
An abstract class present in the Jakarta package.
It contains both concrete methods and abstract methods.

* **Concrete methods:** `init()` and `destroy()`.
* **Abstract method:** `service()`.

It can throw `ServletException` & `IOException`.

**Drawback:** It shows the data in the URL. Hence, we use `HttpServlet`.

### HttpServlet
An abstract class present in the `Jakarta.servlet.http` package.
The `HttpServlet` class does not contain abstract methods.

In Java, we can create an abstract class without any abstract methods for the following reasons:
1.  To convey a message that a class has a partial or dummy implementation.
2.  To convey a message that we can't create an object for the class.

`HttpServlet` is given as an abstract class to indicate to developers that it is an incomplete class.

`HttpServlet` class has defined `doXXX()` methods (like `doGet()`, `doPost()`, `doPut()`, `doDelete()`, `doTrace()`, `doOptions()`, `doHead()`) with some dummy implementation logic.
Developers must override the required `doXXX()` methods in their servlet classes.
The `doXXX()` methods take `HttpServletRequest` and `HttpServletResponse` objects as arguments.

---

## 3. Servlet Lifecycle
This describes the phases from servlet object creation to servlet object destruction. There are 3 main phases (plus initialization).
For a single servlet, we can have only one servlet object.

### 1. Instantiation (Object Creation Phase)
* The servlet object gets created when the client makes the first request.
* The web container creates the object by using the default constructor.
* When the servlet object is created, the `ServletConfig` object also gets created.
* The `ServletConfig` object is limited to that particular servlet object.

### 2. Initialization
* The `init()` method is responsible for making initializations to the servlet object.
* The `init()` method will accept the `ServletConfig` object as an argument.
* If it fails to initialize, it will call `ServletException`.

### 3. Service Phase
* This phase occurs when the client makes a request.
* The request (`req`) and response (`res`) objects get created.
* The Web Container is responsible for creating the `req` and `res` objects.
* The `service()` method accepts `req` and `res` as arguments.

### 4. Destruction Phase
* The `destroy()` method is responsible for the termination of the servlet object.
* When the server stops, the servlet object gets destroyed by `destroy()`.

---

## 4. Reading Form Data
* You can read form data by using the `getParameter()` method.
* This method accepts a key in the form of a string.
* **Signature:** `public String getParameter (String key);`

---

## 5. JSP (JavaServer Pages)
* JSP stands for JavaServer Page.
* It helps to make a static page dynamic in nature.
* It is a combination of HTML and Servlet. Each JSP is a servlet itself.
* It is used to have Java code inside an HTML page.

### JSP Tags
* **Scriptlet Tag (`<% ... %>`):** Used to embed Java code.
* **Page Directive (`<%@ page ... %>`):** Used to import classes (e.g., `<%@ page import="java.util.List" %>`).
* **Expression Tag (`<%= ... %>`):** Used to print a value directly to the HTML output (e.g., `<%= student.getName() %>`).

---

## 6. Request Dispatching
* The process of chaining from one resource to another resource.
* It is the process of forwarding data from one resource to another resource, or including the resource.
* This can be implemented by using the `RequestDispatcher` interface.
* **Syntax:** `RequestDispatcher rd = req.getRequestDispatcher("next_resource");`
* `RequestDispatcher` has 2 methods:
    1.  `forward(req, resp);`
    2.  `include(req, resp);`

---

## 7. Sessions
* By default, the HTTP protocol exhibits stateless behavior.
* This means the HTTP protocol doesn't remember anything about a previous request in the current request.
* Even if the same client is sending multiple requests, the HTTP protocol assumes different clients are sending the requests. Each request is treated as an independent request.
* By default, web applications also exhibit stateless behavior.

### Session Management
* A mechanism that provides stateful communication between a server and a client over multiple requests.
* **Stateful behavior** means the web application will remember the information/data of a client over multiple requests.
* If one client has made 'n' requests to a server, only one session object is created.
* If there are two clients logged in, then two session objects are created (one per each).

### HttpSession Syntax
* `HttpSession session = req.getSession();`
* `session = req.getSession(true);` // Should create a new session object
* `session = req.getSession(false);` // Should carry the previous session object


---

## 8. Other Definitions
* **Parameter:** Data provided in key & value pair. The key return type is `String`, and the value return type is `String`.
* **Argument:** Data provided in a key & value pair. The value return type is `Object`..

---


<!-- auto-update 2021-02-15 11:12:13 -->

<!-- auto-update 2021-02-18 11:12:13 -->

<!-- auto-update 2021-02-21 11:12:13 -->

<!-- auto-update 2021-02-24 11:12:13 -->

<!-- auto-update 2021-02-27 11:12:13 -->

<!-- auto-update 2021-03-02 11:12:13 -->

<!-- auto-update 2021-03-05 11:12:13 -->

<!-- auto-update 2021-03-08 11:12:13 -->

<!-- auto-update 2021-03-11 11:12:13 -->

<!-- auto-update 2021-03-14 11:12:13 -->

<!-- auto-update 2021-03-17 11:12:13 -->

<!-- auto-update 2021-03-20 11:12:13 -->

<!-- auto-update 2021-03-23 11:12:13 -->

<!-- auto-update 2021-03-26 11:12:13 -->

<!-- auto-update 2021-03-29 11:12:13 -->

<!-- auto-update 2021-04-01 11:12:13 -->

<!-- auto-update 2021-04-04 11:12:13 -->

<!-- auto-update 2021-04-07 11:12:13 -->

<!-- auto-update 2021-04-10 11:12:13 -->

<!-- auto-update 2021-04-13 11:12:13 -->

<!-- auto-update 2021-04-16 11:12:13 -->

<!-- auto-update 2021-04-19 11:12:13 -->

<!-- auto-update 2021-04-22 11:12:13 -->

<!-- auto-update 2021-04-25 11:12:13 -->

<!-- auto-update 2021-04-28 11:12:13 -->

<!-- auto-update 2021-05-01 11:12:13 -->

<!-- auto-update 2021-05-04 11:12:13 -->

<!-- auto-update 2021-05-07 11:12:13 -->

<!-- auto-update 2021-05-10 11:12:13 -->

<!-- auto-update 2021-05-13 11:12:13 -->

<!-- auto-update 2021-05-16 11:12:13 -->

<!-- auto-update 2021-05-19 11:12:13 -->

<!-- auto-update 2021-05-22 11:12:13 -->

<!-- auto-update 2021-05-25 11:12:13 -->

<!-- auto-update 2021-05-28 11:12:13 -->

<!-- auto-update 2021-05-31 11:12:13 -->

<!-- auto-update 2021-06-03 11:12:13 -->

<!-- auto-update 2021-06-06 11:12:13 -->

<!-- auto-update 2021-06-09 11:12:13 -->

<!-- auto-update 2021-06-12 11:12:13 -->

<!-- auto-update 2021-06-15 11:12:13 -->

<!-- auto-update 2021-06-18 11:12:13 -->

<!-- auto-update 2021-06-21 11:12:13 -->

<!-- auto-update 2021-06-24 11:12:13 -->

<!-- auto-update 2021-06-27 11:12:13 -->

<!-- auto-update 2021-06-30 11:12:13 -->

<!-- auto-update 2021-07-03 11:12:13 -->

<!-- auto-update 2021-07-06 11:12:13 -->

<!-- auto-update 2021-07-09 11:12:13 -->

<!-- auto-update 2021-07-12 11:12:13 -->

<!-- auto-update 2021-07-15 11:12:13 -->

<!-- auto-update 2021-07-18 11:12:13 -->

<!-- auto-update 2021-07-21 11:12:13 -->

<!-- auto-update 2021-07-24 11:12:13 -->

<!-- auto-update 2021-07-27 11:12:13 -->

<!-- auto-update 2021-07-30 11:12:13 -->

<!-- auto-update 2021-08-02 11:12:13 -->

<!-- auto-update 2021-08-05 11:12:13 -->

<!-- auto-update 2021-08-08 11:12:13 -->

<!-- auto-update 2021-08-11 11:12:13 -->

<!-- auto-update 2021-08-14 11:12:13 -->

<!-- auto-update 2021-08-17 11:12:13 -->

<!-- auto-update 2021-08-20 11:12:13 -->

<!-- auto-update 2021-08-23 11:12:13 -->

<!-- auto-update 2021-08-26 11:12:13 -->

<!-- auto-update 2021-08-29 11:12:13 -->

<!-- auto-update 2021-09-01 11:12:13 -->

<!-- auto-update 2021-09-04 11:12:13 -->

<!-- auto-update 2021-09-07 11:12:13 -->

<!-- auto-update 2021-09-10 11:12:13 -->

<!-- auto-update 2021-09-13 11:12:13 -->

<!-- auto-update 2021-09-16 11:12:13 -->

<!-- auto-update 2021-09-19 11:12:13 -->

<!-- auto-update 2021-09-22 11:12:13 -->

<!-- auto-update 2021-09-25 11:12:13 -->

<!-- auto-update 2021-09-28 11:12:13 -->

<!-- auto-update 2021-10-01 11:12:13 -->

<!-- auto-update 2021-10-04 11:12:13 -->

<!-- auto-update 2021-10-07 11:12:13 -->

<!-- auto-update 2021-10-10 11:12:13 -->

<!-- auto-update 2021-10-13 11:12:13 -->

<!-- auto-update 2021-10-16 11:12:13 -->

<!-- auto-update 2021-10-19 11:12:13 -->

<!-- auto-update 2021-10-22 11:12:13 -->

<!-- auto-update 2021-10-25 11:12:13 -->

<!-- auto-update 2021-10-28 11:12:13 -->

<!-- auto-update 2021-10-31 11:12:13 -->

<!-- auto-update 2021-11-03 11:12:13 -->

<!-- auto-update 2021-11-06 11:12:13 -->

<!-- auto-update 2021-11-09 11:12:13 -->

<!-- auto-update 2021-11-12 11:12:13 -->

<!-- auto-update 2021-11-15 11:12:13 -->

<!-- auto-update 2021-11-18 11:12:13 -->

<!-- auto-update 2021-11-21 11:12:13 -->

<!-- auto-update 2021-11-24 11:12:13 -->

<!-- auto-update 2021-11-27 11:12:13 -->

<!-- auto-update 2021-11-30 11:12:13 -->

<!-- auto-update 2021-12-03 11:12:13 -->

<!-- auto-update 2021-12-06 11:12:13 -->

<!-- auto-update 2021-12-09 11:12:13 -->

<!-- auto-update 2021-12-12 11:12:13 -->

<!-- auto-update 2021-12-15 11:12:13 -->
