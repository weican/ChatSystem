INSERT INTO CHAT_USER(NAME, PASSWORD, ROLE, LAST_PASSWORD_RESET_DATE) 
VALUES("ADMIN", "$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq", "ADMIN", now());
-- password: password
INSERT INTO CHAT_USER(NAME, PASSWORD, ROLE, LAST_PASSWORD_RESET_DATE) 
VALUES("USER1", "$2a$10$TLxBirtYVclcWiuiB8KU6elu3lzGcO81KG.nozp59nF75fBqzJUqK", "USER", now());
-- password: user
INSERT INTO CHAT_USER(NAME, PASSWORD, ROLE, LAST_PASSWORD_RESET_DATE) 
VALUES("USER2", "$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq", "USER", now());


INSERT INTO ROOM(NAME ) 
VALUES("room1");

INSERT INTO ROOM(NAME ) 
VALUES("room2");

INSERT INTO ROOM(NAME ) 
VALUES("room3");

INSERT INTO USER_ROOM(ROOM_ID, USER_ID)
VALUE(1, 1);

INSERT INTO USER_ROOM(ROOM_ID, USER_ID)
VALUE(1, 2);


INSERT INTO MESSAGE(ROOM_ID, FROM_USER, TO_USER, MESSAGE,POSTED_ON)
VALUE(1, 1, 2, "this is a test message", now());

INSERT INTO MESSAGE(ROOM_ID, FROM_USER, TO_USER, MESSAGE, POSTED_ON)
VALUE(1, 1, 3, "this is a test message", now());

INSERT INTO PRIVATE_MESSAGE(FROM_USER, TO_USER, MESSAGE, POSTED_ON)
VALUE(1, 2, "this is a private test message :p", now());
