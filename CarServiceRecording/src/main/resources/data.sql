INSERT INTO customer (customer_Id, customer_Nme, customer_Address, customer_Area)
VALUES 	(101, 'Peeter', 'Street 1, Door3, Main Road','MainCenter'),
	(102, 'Sam', 'Street 2, Door4, Main Road','MainCenter'),
	(103, 'John', 'Street 100, Door3, Outer Road','OuterLink'),
	(104, 'Biden', 'Street 20, Door10, Inner Road','OuterLink'),
	(105, 'Harry', 'Street 45, Door30, Inner Road','OuterLink'),
	(106, 'Joel', 'Street 50, Door240, Suberban Road','Suburban');


INSERT INTO `car_service`
(service_id,car_id,car_name,customer_id,service_date,service_name,service_notes)
VALUES
(1,100,'Bens',101,null,'FirstService','Done Full service'),
(2,100,'Benz',101,null,'FirstService','Done Full service'),
(3,100,'Benz',101,null,'FirstService','Done Full service'),
(4,100,'Bens',104,null,'FirstService','Done Full service'),
(5,104,'Porshe',104,null,'FirstService','Done Full service'),
(6,106,'Ferary',104,null,'FirstService','Done Full service'),
(7,100,'Bens',106,null,'FirstService','Done Full service');
 
