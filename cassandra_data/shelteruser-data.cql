cqlsh:sfapp> create table sfapp.ShelterUsers (userid int, username text, password text, address text, email text, following set<int>, followers set<int>, likedPost set<int>, primary key(userid));
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (5,'Boing','pass6','222 Dr Pepper Street CA 91116','user6@email.com',{1},{5},{11});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (6,'Umai','pass7','1176 Sushi Blvd CA 91117','user7@email.com',{1},{5},{11,2});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (7,'Anna','pass8','563 Pico Blvd CA 91119','user8@email.com',{1},{5,2},{11,2});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (8,'Pinkberry','pass9','563 Berendo St CA 90041','user9@email.com',{1,2},{5,2},{11,2});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (9,'Chipotle','pass10','9090 Mariposa St CA 90045','user10@email.com',{5,2},{5,2},{11,2});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (1,'user2','pass2','1414 Mental Road CA 93271','user2@email.com',{1,2,3},{5,3,2},{10,3,6});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (2,'user3','pass3','755 Butwhy Way CA 94444'
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (3,'user4','pass4','755 Iris Street CA 93232','user4@email.com',{1,2,3,0,5},{5,3,2,4},{11,3,6,14});
cqlsh:sfapp> INSERT INTO ShelterUsers (userid,username,password,address,email,following,followers,likedPost) VALUES (4,'NotSasuke','pass5','490 Ninja Way Street
