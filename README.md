DROP TABLE IF EXISTS flight;
CREATE TABLE flight(
flightNum VARCHAR(20) ,
flightPrice INT(10),
numSeats INT(10),
flightnumAvail INT(10),
flyDate DATE,
flyfromCity VARCHAR(20),
flytoCity VARCHAR(20),
PRIMARY KEY(flightNum)

)ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS hotel;
CREATE TABLE hotel(
hotelNum VARCHAR(20) ,
hotelName VARCHAR(20),
hotelCity VARCHAR(20),
hotelStar VARCHAR(20),
hotelPrice INT(10),
hotelnumRooms INT(10),
HotelnumAvail VARCHAR(20),
hotelConnectWay VARCHAR(20),
hotelPhone VARCHAR(20),
PRIMARY KEY(hotelNum)

)ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS Transfor;
CREATE TABLE Transfor(
carNum VARCHAR(20) ,
cartype VARCHAR(20),
CarFrom VARCHAR(20),
CarTO VARCHAR(20),
carPrice INT(10),
carNumAvail VARCHAR(20),
PRIMARY KEY(carNum)

)ENGINE=INNODB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS journeyUser;
CREATE TABLE journeyUser(
userId INT(10) NOT NULL AUTO_INCREMENT,
userName VARCHAR(20),
sex VARCHAR(10),
age INT(10),
identifyNo VARCHAR(20),
phone INT(10),
password VARCHAR(20),
ismanger INT(10),
PRIMARY KEY(userId)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS reservation;
CREATE TABLE reservation(
reservatId INT(10) NOT NULL AUTO_INCREMENT,
r_userId INT(10),
r_userName VARCHAR(20),
restype VARCHAR(20) NOT NULL,
associateId VARCHAR(20) NOT NULL,
resStatus VARCHAR(20),
PRIMARY KEY(reservatId),
FOREIGN KEY(r_userId) REFERENCES journeyUser(userId)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


