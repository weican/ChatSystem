CREATE TABLE IF NOT EXISTS CHAT_USER  (
  ID int AUTO_INCREMENT,
  NAME varchar(50) NOT NULL,
  PASSWORD varchar(65) NOT NULL,
  ROLE varchar(15) NOT NULL,
  LAST_PASSWORD_RESET_DATE datetime NOT NULL,
  PRIMARY KEY(ID)
);


CREATE TABLE IF NOT EXISTS ROOM  ( 
  ID int AUTO_INCREMENT,
  NAME varchar(50) NOT NULL,
  PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS GROUP_ROOM  ( 
  ID int AUTO_INCREMENT,
  ROOM_ID int NOT NULL,
  USER_ID int NOT NULL,
  PRIMARY KEY(ID),
  FOREIGN KEY (USER_ID) REFERENCES CHAT_USER(ID),
  FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ID)
);

CREATE TABLE IF NOT EXISTS MESSAGE  ( 
  ID int AUTO_INCREMENT,
  ROOM_ID int NULL,
  FROM_USER int NOT NULL,
  TO_USER int NOT NULL,
  MESSAGE varchar(256) NOT NULL,
  GROUP_ID int NULL,
  PRIMARY KEY(ID),
  FOREIGN KEY (GROUP_ID) REFERENCES GROUP_ROOM(ID),
  FOREIGN KEY (ROOM_ID) REFERENCES ROOM(ID),
  INDEX(ROOM_ID, GROUP_ID,TO_USER)
);