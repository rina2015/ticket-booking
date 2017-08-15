create table `CUSTORDER`(     
    `CUSTOMER` int(10) unsigned NOT NULL,
    `ROUTE` int(10) unsigned NOT NULL);
          
         
create table `ROUTE`(     
     `FROM` varchar(100),
     `TO` varchar(100) ,
     `PRICE`  double(16,4),     
     `ROUTE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,     
     primary key(`ROUTE_ID`))ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
             
      

create table `CUSTOMER` (     
    `FIRST NAME` varchar(100) NOT NULL,
    `LAST NAME` varchar(100),
    `AGE` int(10) unsigned NOT NULL,     
    `GENDER` varchar(100) NOT NULL,
    `CUST_ID` int(10) unsigned NOT NULL AUTO_INCREMENT, 
     primary key (`CUST_ID`) )ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8; 