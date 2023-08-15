# CarBookingCLISystem

A Demo Car Booking Project can perform some task as below:
1️⃣ - Book Car
2️⃣ - View All User Booked Cars
3️⃣ - View All Bookings
4️⃣ - View Available Cars
5️⃣ - View Available Electric Cars
6️⃣ - View all users
7️⃣ - Exit
This is a in-Memory demo (fake of DB connection) 
---
This demo show you layers often used in real program:
-Switch statement stand for a controller dispatch request to our core logic method, and then response.
-Each object have 3 main Layers (even more in complidated architecture):
+ POJOs: stand for entity model (business things you deal with), this can be mapped to database with ORM (like Hibernate), plain JDBC/JDBC Template is for strongly customize entity or performance tuning.
+ DAO layer (Data Access Object): this layer is a gate to access data from Database when you mapped model in Database. CRUD operations are often used.
+ Service Layer: combine some operation in DAO layer to represent your business logic
=> final use DI (Dependency Injection) these class to controller and perform your logic here (combine methods from Service Logics), when you deal with multiple service from multiple DAO Entity, please use transaction in Controller to wrap all of it.
