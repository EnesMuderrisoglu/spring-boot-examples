-- Drop user first if they exist
DROP USER if exists 'vipcustomer'@'%' ;

-- Now create user with prop privileges
CREATE USER 'vipcustomer'@'%' IDENTIFIED BY 'vipcustomer';

GRANT ALL PRIVILEGES ON * . * TO 'vipcustomer'@'%';