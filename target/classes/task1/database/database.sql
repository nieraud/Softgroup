/* CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
 creating a unique identifier using functions.*/

DROP TABLE IF EXISTS employees CASCADE ;
create table employees (
  employeeID UUID NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY ,
  departmentID UUID NOT NULL REFERENCES departments(departmentID),
  bossID UUID REFERENCES employees(employeeID),
  name VARCHAR(50) NOT NULL,
  salary int NOT NULL
);

DROP TABLE IF EXISTS departments CASCADE ;
CREATE TABLE departments (
  departmentID UUID        NOT NULL DEFAULT uuid_generate_v4() PRIMARY KEY,
  name         VARCHAR(30) NOT NULL
);

/* departments */
INSERT INTO departments VALUES (DEFAULT, 'Management');
INSERT INTO departments VALUES (DEFAULT, 'Marketing');
INSERT INTO departments VALUES (DEFAULT, 'Sales');


/* bosses */
/* boss of management department */
INSERT INTO employees
VALUES (DEFAULT, 'f83309bf-9342-4103-9860-0c886b32d492',
        null, 'Olexandr', 70000);
/* boss of marketing department */
INSERT INTO employees
VALUES (DEFAULT, 'f49ac304-1bdd-40a0-85ce-bf113668c8bb',
        null, 'Roman', 50000);
/* boss of sales department */
INSERT INTO employees
VALUES (DEFAULT, 'f74bb3e4-3db9-4597-b81c-1239a27a2c9e',
        null, 'Olena', 25000);


/* employees */
/* employees of management department */
INSERT INTO employees
VALUES (DEFAULT, 'f83309bf-9342-4103-9860-0c886b32d492',
       '78d3aa86-55d0-4610-975e-938161fae3f8', 'Egor', 100000);

/* employees of marketing department */
INSERT INTO employees
VALUES (DEFAULT, 'f49ac304-1bdd-40a0-85ce-bf113668c8bb',
        'da2b0efd-31be-4035-8caa-67bc8cc3bca2', 'Petro', 20000);
INSERT INTO employees
VALUES (DEFAULT, 'f49ac304-1bdd-40a0-85ce-bf113668c8bb',
        'da2b0efd-31be-4035-8caa-67bc8cc3bca2', 'Angelica', 17000);

/* employees of sales department */
INSERT INTO employees
VALUES (DEFAULT, 'f74bb3e4-3db9-4597-b81c-1239a27a2c9e',
        'c97b8d6a-83a1-41e6-bc7b-03c002146abf', 'Petro', 14000);
INSERT INTO employees
VALUES (DEFAULT, 'f74bb3e4-3db9-4597-b81c-1239a27a2c9e',
        'c97b8d6a-83a1-41e6-bc7b-03c002146abf', 'Angelica', 100000);
INSERT INTO employees
VALUES (DEFAULT, 'f74bb3e4-3db9-4597-b81c-1239a27a2c9e',
        'c97b8d6a-83a1-41e6-bc7b-03c002146abf', 'Nikolay', 1000);
INSERT INTO employees
VALUES (DEFAULT, 'f74bb3e4-3db9-4597-b81c-1239a27a2c9e',
        'c97b8d6a-83a1-41e6-bc7b-03c002146abf', 'Olena', 1600);



/* Всі відповіді мають бути у вигляді запита та вміщуватися у файлі .sql */

/*1. Знайдіть імена (name) всіх працівників (employees), зарплата (salary) яких
більша за керівника (boss).*/
SELECT empl.name AS "Employee's name",
       empl.salary :: FLOAT8 :: INTEGER :: MONEY AS "Employee's salary",
       boss.name AS "Boss's name",
       boss.salary AS "Boss's salary"
FROM employees empl, employees boss
WHERE boss.bossid IS NULL
      AND empl.bossid = boss.employeeid
      AND empl.salary > boss.salary;


/*2.Знайдіть працівників, котрі мають найбільшу зарплатню в своєму підрозділі
(department)*/
SELECT
  departments.name AS "Department",
  empl.name        AS "Employee's name",
  empl.salary :: FLOAT8 :: INTEGER :: MONEY AS "Employee's salary"
FROM employees empl
  INNER JOIN (SELECT
                departmentid,
                MAX(salary) salary
              FROM employees
              GROUP BY departmentid) maxsalary
    ON empl.departmentid = maxsalary.departmentid
       AND empl.salary = maxsalary.salary
  INNER JOIN departments ON departments.departmentid = empl.departmentid;


/*3. Знайдіть назви всіх підрозділи, котрі мають менш ніж 3-х працівників*/
SELECT dep.name AS "Department", "Number of employees"
FROM departments dep
  INNER JOIN (SELECT
                departmentid,
                count(*) AS "Number of employees"
              FROM employees
              GROUP BY departmentid
              HAVING count(*) < 3) numb
    ON dep.departmentid = numb.departmentid;

/*4.	Знайдіть працівників, котрі не бають керівників в своєму підрозділі*/
/* Якщо не бають = не мають. Працівники, які не мають керівника - є керівниками. */
SELECT
  employees.name                                 AS "Employee's name",
  employees.salary :: FLOAT8 :: INTEGER :: MONEY AS "Employee's salary",
  employees.bossid                               AS "Boss",
  departments.name                               AS "Department"
FROM employees
  INNER JOIN departments ON employees.departmentid = departments.departmentid
WHERE employees.bossid IS NULL;


/*5.	Знайдіть котру загальну суму зарплатні отримує кожен підрозділ.*/
SELECT dep.name, "Summa" :: FLOAT8 :: INTEGER :: MONEY
FROM departments dep
  INNER JOIN (SELECT departmentid, sum(salary) AS "Summa"
              FROM employees
              GROUP BY departmentid) summa
    on dep.departmentid = summa.departmentid;
