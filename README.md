# 5G- Groupe Back 1
## Installation du projet			   
### JDK 
1. Download [JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Add a `JAVA_HOME` system variables, and point it to the JDK folder. `JAVA_HOME` "*path_to_JDK*"
3. Add "path_to_JDK"\bin to PATH variable.

### Apache Maven
1. Download [Apache Maven](https://maven.apache.org/download.cgi) and unzip it to a folder.
2. Add a `MAVEN_HOME` system variables, and point it to the Maven folder. 
3. Add %MAVEN_HOME%\bin To PATH
4. Verification on Command line :
```mvn -version echo %MAVEN_HOME%```

## Installation de la base de données    

1. Download [MySQL Community Server 8.0](https://dev.mysql.com/downloads/mysql/)
- Login: `root`
- Password: `root`

2. Executer les requêtes suivantes :
```
/*CREATE SCHEMA*/ CREATE SCHEMA 5g;

/*USE SCHEMA*/ USE 5g;

/*CREATE TABLE USER*/ CREATE TABLE user ( user_id INT NOT NULL AUTO_INCREMENT, user_name VARCHAR(30) NOT NULL, user_first_name VARCHAR(30), user_mail VARCHAR(50) NOT NULL, user_login VARCHAR(30), user_password VARCHAR(10), user_active BOOLEAN DEFAULT 1, user_admin BOOLEAN DEFAULT 0, user_last_connection TIMESTAMP, user_creation VARCHAR(30), user_status VARCHAR(30), user_token VARCHAR(200), PRIMARY KEY (user_id) ) ;

/*CREATE TABLE MESSAGE*/ CREATE TABLE message ( id int(11) unsigned NOT NULL AUTO_INCREMENT, content varchar(45) NOT NULL, id_author int(11) unsigned NOT NULL, id_discussion int(11) unsigned NOT NULL, created_at timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3), PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=1;

/*INSERT DATAS USER*/ INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin, user_last_connection, user_creation, user_status, user_token) VALUES ('Dupont', 'Tom', 'tom@localhost.fr', 'tomDupont', '123', 1, 0, '2008-11-13 21:52:00', '08/11/18', 'En ligne', '123ABC');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin, user_last_connection, user_creation, user_status, user_token) VALUES ('Duran', 'Pascal', 'pduran@localhost.fr', 'pduran', '456', 1, 1, '2008-11-18 11:48:00', '09/11/18', 'En ligne', '123BCD');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin, user_last_connection, user_creation, user_status, user_token) VALUES ('Paul', 'Elodie', 'elodie@free.fr', 'elodie', 'AAA', 1, 0, '2008-11-17 13:12:00', '07/11/18', 'En ligne', 'ABCD12');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin, user_last_connection, user_creation, user_status, user_token) VALUES ('Roger', 'Virginie', 'vir@gmail.com', 'viRog', 'Pass', 0, 0, '2008-11-17 05:54:00', '07/11/18', 'Déconnecté', '29PP13');

INSERT INTO 5g.user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin, user_last_connection, user_creation, user_status, user_token) VALUES ('Bertrand', 'Paul', 'paul@gmail.com', 'pol12', '123Paul', 1, 0, '2008-11-15 11:12:00', '04/11/18', 'Absent', 'MJVFS8N9');

/*INSERT DATAS MESSAGE*/ Insert INTO 5g.message (content, id_author, id_discussion, created_at) VALUES ("contenu message 1", 1, 1, current_timestamp(3)),
("contenu message 1", 1, 1, current_timestamp(3)), ("contenu message 2", 2, 1, current_timestamp(3)+1), ("contenu message 3", 1, 1, current_timestamp(3)+2), ("contenu message 4", 3, 1, current_timestamp(3)+3), ("contenu message 5", 4, 1, current_timestamp(3)+4), ("contenu message 6", 1, 1, current_timestamp(3)+5), ("contenu message 7", 2, 1, current_timestamp(3)+6), ("contenu message 8", 1, 2, current_timestamp(3)+7), ("contenu message 9", 1, 2, current_timestamp(3)+8), ("contenu message 10", 4, 2, current_timestamp(3)+9), ("contenu message 11", 2, 2, current_timestamp(3)+10), ("contenu message 12", 4, 2, current_timestamp(3)+11) ;
```
## Deploiement du projet

### Installation de l'IDE

1. Download [IntelliJ IDEA 2018.2 Ultimate Edition - Windows](https://www.jetbrains.com/idea/download/index.html#section=windows).
2. Run the ideaIc.exe or the ideaIU.exe
3. Import IntelliJ IDEA settings
4. Select the user interface theme
5. Disable the unnecessary plugins

### Installation de git bash et import du projet

1. Telecharger [Git](https://github.com/git-for-windows/git/releases/download/v2.19.1.windows.1/Git-2.19.1-64-bit.exe)
2. Open Git Bash
3. Write command:
- `cd /C`
- `git clone https://github.com/EdwardTheCat/5GBack`

### Import du projet sur IntelliJ (IDE)

1. From the Welcome screen, click Import Project.
   The Select File or Directory to Import dialog opens.
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Capture_import.PNG)
2. Follow the step, next.
3. Select projet SDK - choose jdk 1.8
4. Select import project from external model and then Maven
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Capture_import_Project.PNG)
5. The right project will be set if you get this :
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Import_Project_Completed.PNG)
6. Click on Add Configuration
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Add_Config.PNG)
7. Click on the "+" and then on Spring Boot :
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/add_config_spring.PNG)
8. You have to get this page :
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/set_config.PNG)
9. Click on "play" :
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/run_config.PNG)
10. If you get this the project is all set :
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/completed_run.PNG)
11. Go on your favorite navigator and write `localhost:8080/`
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/see_project.PNG)
