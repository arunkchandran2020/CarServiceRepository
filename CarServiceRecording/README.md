<h2>About CarServiceRecording Project</h2>

The application would keep record of the customers, their car(s), and the individual services and service notes associated with each car.

<h5>This application contains 4 end points.</h5>

      List all customers.
      List all car(s) services for a specific customer.
      List all services for a specific car.
      Record a service for a specific car.
      
<br/><br/><h5>Specification.</h5><br/>
<l>
  <li>All the data has saved to MySQL database</li>
  <li>The application creates tables automatically on the spot once the application is launched and the database connection configuration is set via JPA.</li>
  <li>The API documentation is available using Swagger.</li>
  <li>The Unit Test covered all scinarios.</li>
  <li>Docker image created using added Dockerfile.</li>
 <br/> <br/>
<h5>Assumption</h5>
<br/>
  Only existing customers will do car services.
  
  Details of end points available at http://<server:port>/swagger-ui.html  eg. http://localhost:8089/swagger-ui.html

  <h5>Two Tables are used. Please see below details.</h5>
<br/><br/>
Table 1: CAR_SERVICE
<br/>
        CREATE TABLE `car_service` (
          `service_id` int(11) NOT NULL,
          `car_id` int(11) NOT NULL,
          `car_name` varchar(255) DEFAULT NULL,
          `customer_id` int(11) NOT NULL,
          `service_date` datetime DEFAULT NULL,
          `service_name` varchar(255) DEFAULT NULL,
          `service_notes` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`service_id`),
          KEY `FKi8gi2dk0lineh1swvryjkiavq` (`customer_id`),
          CONSTRAINT `FKi8gi2dk0lineh1swvryjkiavq` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
<br/><br/>
Table 2: CUSTOMER
<br/>
        CREATE TABLE `customer` (
          `customer_id` int(11) NOT NULL,
          `customer_address` varchar(255) DEFAULT NULL,
          `customer_area` varchar(255) DEFAULT NULL,
          `customer_nme` varchar(255) DEFAULT NULL,
          PRIMARY KEY (`customer_id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
<br/><br/>

Refer <b>src/main/resources/data.sql</b> for DATA used.
