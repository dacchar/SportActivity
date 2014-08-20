DROP TABLE activities IF EXISTS;
create table activities 
	(activityId integer identity primary key
	, amount integer 
	, activityDate date
	, sportDeviceId integer 
    , activityTypeId integer
  	, activityTime time
  	, comments varchar(256)
  	, userId integer
	);


DROP TABLE IF EXISTS activitytypes;
CREATE TABLE activitytypes 
	(  activityTypeId integer identity primary key
	  , name varchar(45) DEFAULT NULL
	);

DROP TABLE IF EXISTS persistent_logins;
CREATE TABLE persistent_logins 
	(  username varchar(64) NOT NULL
	  , series varchar(64) NOT NULL
	  , token varchar(64) NOT NULL
	  , last_used timestamp NOT NULL 
	) ;


DROP TABLE IF EXISTS persons;
CREATE TABLE persons (
  personId integer identity primary key,
  name varchar(45) DEFAULT NULL
) ;

DROP TABLE IF EXISTS sportdevices;
CREATE TABLE sportdevices (
  sportDeviceId integer identity primary key,
  name varchar(45) DEFAULT NULL
) ;

DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles (
  USER_ROLE_ID integer NOT NULL,
  USER_ID integer NOT NULL,
  AUTHORITY varchar(45) NOT NULL
);

DROP TABLE IF EXISTS users;
CREATE TABLE users (
  USER_ID integer,
  USERNAME varchar(45) NOT NULL,
  PASSWORD varchar(45) NOT NULL,
  ENABLED integer NOT NULL,
  AVATAR BINARY
) ;
