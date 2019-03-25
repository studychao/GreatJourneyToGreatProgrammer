# Mysql Tips and Notes

## Commands
- `CREATE DATABASE xxx` create a new database in your mysql service
- `CREATE TABLE table_name (column_name column_type);` Create a new table in one database
  ```
	CREATE TABLE IF NOT EXISTS `runoob_tbl`(
   `runoob_id` INT UNSIGNED AUTO_INCREMENT,
   `runoob_title` VARCHAR(100) NOT NULL,
   `runoob_author` VARCHAR(40) NOT NULL,
   `submission_date` DATE,
   PRIMARY KEY ( `runoob_id` )
	)ENGINE=InnoDB DEFAULT CHARSET=utf8;
  ```

- `DROP TABLE table_name ;` This is for deleting a mysql table

## ORM
Object-relational mapping (ORM, O/RM, and O/R mapping tool) in computer science is a programming technique for converting data between incompatible type systems using object-oriented programming languages.