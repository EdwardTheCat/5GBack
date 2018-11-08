"# 5GBack" 


----------------------------------------
-	 Création de la  base de données   -
----------------------------------------

/*BDD Mysql*/

/*CREATE SCHEMA*/
CREATE SCHEMA 5g;

/*USE SCHEMA*/
USE 5g;

/*CREATE USER*/
CREATE TABLE user (
     user_id INT NOT NULL AUTO_INCREMENT,
     user_name VARCHAR(30) NOT NULL,
     user_first_name VARCHAR(30),
     user_mail VARCHAR(50) NOT NULL,
     user_login VARCHAR(30),
     user_password VARCHAR(10),
     user_active BOOLEAN DEFAULT 1,
     user_admin BOOLEAN DEFAULT 0,
     user_last_connection TIMESTAMP,
     user_creation VARCHAR(30),
     user_status VARCHAR(30),
     user_token VARCHAR(200),
	PRIMARY KEY (user_id)
) ;


/*INSERT DATAS*/
INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin,
user_last_connection, user_creation, user_status, user_token) VALUES ('Dupont', 'Tom', 'tom@localhost.fr', 'tomDupont', '123', 1, 0, '2008-11-13 21:52:00', '08/11/18', 'En ligne', '123ABC');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin,
user_last_connection, user_creation, user_status, user_token) VALUES ('Duran', 'Pascal', 'pduran@localhost.fr', 'pduran', '456', 1, 1, '2008-11-18 11:48:00', '09/11/18', 'En ligne', '123BCD');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin,
user_last_connection, user_creation, user_status, user_token) VALUES ('Paul', 'Elodie', 'elodie@free.fr', 'elodie', 'AAA', 1, 0, '2008-11-17 13:12:00', '07/11/18', 'En ligne', 'ABCD12');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin,
user_last_connection, user_creation, user_status, user_token) VALUES ('Roger', 'Virginie', 'vir@gmail.com', 'viRog', 'Pass', 0, 0, '2008-11-17 05:54:00', '07/11/18', 'Déconnecté', '29PP13');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin,
user_last_connection, user_creation, user_status, user_token) VALUES ('Bertrand', 'Paul', 'paul@gmail.com', 'pol12',  '123Paul', 1, 0, '2008-11-15 11:12:00', '04/11/18', 'Absent', 'MJVFS8N9');
