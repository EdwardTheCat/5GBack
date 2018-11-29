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
  users_discussion VARCHAR(45) NOT NULL DEFAULT "userDefault",
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
("contenufzcze", 3, 1, current_timestamp(3) )
;

insert into dirword (dir_word_sentence, dir_word_date, created_at, user_id) values ('Bonjour l\'équipe 5g', current_timestamp(), current_timestamp(3), 1 );