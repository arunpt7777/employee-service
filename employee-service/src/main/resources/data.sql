USE employee_management;

TRUNCATE TABLE employee;

INSERT INTO employee (id, employee_number, age, first_name, last_name, email, phone, gender) VALUES  
(10001,10001,65,'Vince','McMahon','vince@gmail.com','12345-001','Male'),
(10002,10002, 40,'Shane','McMahon','shane@gmail.com','12345-001','Male'),
(10003,10003, 60, 'Linda','McMahon','linda@gmail.com','12345-001','Female'),
(10004,10004, 35, 'Stephanie','McMahon','stephanie@gmail.com','12345-001','Female'),
(10005,10005, 40, 'Chyna','Jean','chyna@gmail.com','12345-001','Other')
;