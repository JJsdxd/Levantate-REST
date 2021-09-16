# Levantate-REST API

Rest api for the levantate platform.

Levantate is a online Platform designed to help teenagers with depression and anxiety. Its a place where you can express yourself freely and improve your quality of life with the help of our tools and services.

## Setup and Installation

1. **Clone the repo from GitHub**
   ```sh
   git clone https://github.com/Snape25/Levantate-REST.git
   cd Levantate-REST
   ```
2. **Setting up the Database**

  
   Make sure postgres is installed on your device if not , download it from [here](https://www.postgresql.org/download). Optionally you can install pgAdmin. Then      creat a database on your local machine.

   
4. **Update database credentials in application.properties**
   
    update the src/main/resources/application.properties file with your database credentials.
   ```properties
   spring.datasource.url=jjdbc:postgresql://localhost:5432/springboot
   spring.datasource.username=snape
   spring.datasource.password=password
   ```
5. **Run the application**
   ```sh
   ./mvnw spring-boot:run
   ```

