/* DELETE 'strava_user' database*/
DROP SCHEMA stravadb;
/* DELETE USER 'strava_user' AT LOCAL SERVER*/
DROP USER 'strava_user'@'%';

/* CREATE ''stravadb' DATABASE */
CREATE SCHEMA stravadb;
/* CREATE THE USER 'strava_user' AT LOCAL SERVER WITH PASSWORD 'strava_user' */
CREATE USER 'strava_user'@'%' IDENTIFIED BY 'password';
/* GRANT FULL ACCESS TO THE DATABASE 'stravadb' FOR THE USER 'strava_user' AT LOCAL SERVER*/
GRANT ALL ON stravadb.* TO 'strava_user'@'%';
