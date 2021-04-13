cqlsh> create keyspace sfapp with replication = {'class':'SimpleStrategy','replication_factor':1};
cqlsh> use sfapp;
cqlsh:sfapp> create table regularUser(userRID int, email text, userName text,password text, following set<int>, followers set<int>, likedPost set<int>, primary key(userRID));
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (2,'iamacat@gmail.com','meow','meowlovers',{1,2,3},{2,3,4,5},{3,4,5,6,7});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (4,'sakura@gmail.com','sakura','sakurahere',{1,3},{3,5,7},{2,4,6,8});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (6,'conan@gmail.com','conan','conanhere',{1,3,2,4},{2,3,5},{2,4,6,8});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (8,'haibabra@gmail.com','haibara','haibarahere',{2,3,1},{1,3,2,4},{7,8,9});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (7,'kudo@gmail.com','kudo','kudohere',{1,4,2},{1,3},{1,8,2,9});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (3,'ran@gmail.com','ran','ranhere',{3,5,1,4,2},{5,1,3},{7,1,8,2,9});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (5,'naruto@gmail.com','naruto','narutohere',{3,4,5,2},{1,4,3},{7,1,9});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (9,'nabati@gmail.com','nabati','nabatihere',{3,8,1,2},{1,3},{1,9});
cqlsh:sfapp> insert into regularUser(userRID, email, userName,password, following, followers, likedPost) values (10,'roti@gmail.com','roti','rotihere',{3,8,1,2},{2,1,4,3},{8,1,9,7});
                                                                                                                 
