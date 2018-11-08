"# 5GBack" 


----------------------------------------
	 #Installation de Maven			   
--------------------------------
JDK 
-Download JDK :  jdk-8u191-windows-x64.exe or jdk-8u191-windows-i586.exe
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
 	
-Add a JAVA_HOME system variables, and point it to the JDK folder.
JAVA_HOME "path_to_JDK"

-Add "path_to_JDK"\bin to PATH variable.

Maven
-install maven:
requirements : JDK, windows 10

-Download apache maven : apache-maven-3.6.0-bin.zip
https://maven.apache.org/download.cgi

-And unzip it to a folder.

-Add a MAVEN_HOME system variables, and point it to the Maven folder.
-Add %MAVEN_HOME%\bin To PATH

-Verification on Command line : 
>mvn -version
>echo %MAVEN_HOME%

-

----------------------------------------
	 #Création de la base de données    
-----------------------------------

```/\*BDD Mysql\*/
- Download MySQL Community Server 8.0
- https://dev.mysql.com/downloads/mysql/
- Login root 
- MDP root
- Executer les requêtes suivantes :

/\*CREATE SCHEMA\*/
CREATE SCHEMA 5g;

/\*USE SCHEMA\*/
USE 5g;

/\*CREATE TABLE USER\*/
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


/\*CREATE TABLE MESSAGE\*/
CREATE TABLE `message` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT, 
  `content` varchar(45) NOT NULL,
  `id_author` int(11) unsigned NOT NULL, 
  `id_discussion` int(11) unsigned NOT NULL, 
  `created_at` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


/\*INSERT DATAS USER\*/
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



/\*INSERT DATAS MESSAGE\*/
Insert INTO 5g.message (content, id_author, id_discussion, created_at) VALUES
("contenu message 1", 1, 1, current_timestamp(3)),  
("contenu message 1", 1, 1, current_timestamp(3)),
("contenu message 2", 2, 1, current_timestamp(3)+1),
("contenu message 3", 1, 1, current_timestamp(3)+2),
("contenu message 4", 3, 1, current_timestamp(3)+3),
("contenu message 5", 4, 1, current_timestamp(3)+4),
("contenu message 6", 1, 1, current_timestamp(3)+5),
("contenu message 7", 2, 1, current_timestamp(3)+6),
("contenu message 8", 1, 2, current_timestamp(3)+7),
("contenu message 9", 1, 2, current_timestamp(3)+8),
("contenu message 10", 4, 2, current_timestamp(3)+9),
("contenu message 11", 2, 2, current_timestamp(3)+10),
("contenu message 12", 4, 2, current_timestamp(3)+11) ;```
