CREATE USER 'cs548projectdb'@'localhost' IDENTIFIED BY 'momoko';

GRANT ALL PRIVILEGES ON cs548_finalProject.* TO 'aircustomerdb'@'localhost' WITH GRANT OPTION;

SHOW GRANTS FOR 'aircustomerdb'@'localhost';
