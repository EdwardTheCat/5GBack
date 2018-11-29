# 5G- Groupe Back 1
## Release	
- Master: Projet sans la gestion du token de session et JWT
- Develop: Projet avec la gestion du token de session et JWT (partie d'Alexis, Non fonctionnel) 

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
use 5g;

/*CREATE TABLE USER*/
CREATE TABLE IF NOT EXISTS user (
     user_id INT unsigned NOT NULL AUTO_INCREMENT,
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

 CREATE TABLE IF NOT EXISTS dirword (
  dir_word_id int(4) NOT NULL AUTO_INCREMENT,
  dir_word_sentence text NOT NULL,
  dir_word_date TIMESTAMP NOT NULL,
  created_at TIMESTAMP(3) NOT NULL,
  user_id INT unsigned NOT NULL ,
  PRIMARY KEY (dir_word_id),
FOREIGN KEY (user_id) REFERENCES user (user_id)
ON DELETE CASCADE
);

/*table discussion*/
CREATE TABLE IF NOT EXISTS discussion (
  id_discussion int(4) unsigned NOT NULL AUTO_INCREMENT,
  name_discussion varchar(32),
  creator_discussion INT unsigned NOT NULL,
  users_discussion VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_discussion),
  FOREIGN KEY (creator_discussion) REFERENCES user(user_id) ON DELETE CASCADE
  );

/*table message*/
CREATE TABLE IF NOT EXISTS `message` (
  id_message int(11) unsigned NOT NULL AUTO_INCREMENT,
  content varchar(45) NOT NULL,
  id_author INT unsigned NOT NULL , 
  id_discussion int(4) unsigned NOT NULL,
  created_at TIMESTAMP(3) NOT NULL,
  PRIMARY KEY (id_message),
  FOREIGN KEY (id_discussion) REFERENCES discussion(id_discussion) ON DELETE CASCADE,
  FOREIGN KEY (id_author) REFERENCES user(user_id) ON DELETE CASCADE
  );

insert into user (user_name, user_first_name, user_mail, user_login, user_password, user_active, user_admin, user_creation, user_status, user_token) values 
("test1", "test1", "test1@test.fr", "test1", "test1", true, true, current_timestamp(), "test1", "test1"),
("test2", "test2", "test2@test.fr", "test2", "test2", true, true, current_timestamp(), "test2", "test2"),
("test3", "test3", "test3@test.fr", "test3", "test3", true, true, current_timestamp(), "test3", "test3"),
("test4", "test4", "test4@test.fr", "test4", "test4", true, true, current_timestamp(), "test4", "test4"),
("test5", "test5", "test5@test.fr", "test5", "test5", true, true, current_timestamp(), "test5", "test5"),
("test6", "test6", "test6@test.fr", "test6", "test6", true, true, current_timestamp(), "test6", "test6");

insert into discussion (name_discussion, creator_discussion) values 
("first", 1 ),
("second", 2 ),
("third", 5 ),
("fourth", 1 );

insert into `message` (content, id_author, id_discussion, created_at) values 
("contenu1", 1, 1, current_timestamp(3) ),
("contenu2", 2, 1, current_timestamp(3) ),
("contenu3", 5, 1, current_timestamp(3) ),
("contenu4", 2, 2, current_timestamp(3) ),
("contenufrzrf", 2, 3, current_timestamp(3) ),
("contenudezdze", 2, 1, current_timestamp(3) ),
("contenufzcze", 3, 1, current_timestamp(3) ),
("contenuvrezzec", 3, 4, current_timestamp(3) );

insert into dirword (dir_word_sentence, dir_word_date, created_at, user_id) values ('Bonjour l\'équipe 5g', current_timestamp(), current_timestamp(3), 1 );
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
- `git clone https://github.com/EdwardTheCat/5GBack`
- `cd 5GBack`

### Import du projet sur IntelliJ (IDE)

1. From the Welcome screen, click Import Project.
   The Select File or Directory to Import dialog opens.
   
![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Capture_Import.PNG)

2. Follow the step, next..
3. Select projet SDK - choose jdk 1.8.
4. Select import project from external model and then Maven.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Capture_Import_Project.PNG)

5. The right project will be set if you get this.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Import_Project_Completed.PNG)

6. Click on Add Configuration.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/Add_Config.PNG)

7. Click on the "+" and then on Spring Boot.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/add_config_spring.PNG)

8. You have to get this page.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/set_config.PNG)

9. Click on "play".

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/run_config.PNG)

10. If you get this the project is all set.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/completed_run.PNG)

11. Go on your favorite navigator and write `localhost:8080/`.

![Import_project](https://github.com/EdwardTheCat/5GBack/blob/master/image/see_project.PNG)
