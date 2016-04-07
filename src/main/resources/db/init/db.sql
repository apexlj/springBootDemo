CREATE TABLE IF NOT EXISTS t_permission (
  id SERIAL NOT NULL PRIMARY KEY ,
  permissionname varchar(32) DEFAULT NULL UNIQUE
);

/*Data for the table "t_permission" */

insert  into t_permission("permissionname") values ('gps'),('history');

/*Table structure for table "t_role" */

CREATE TABLE IF NOT EXISTS t_role (
  id SERIAL PRIMARY KEY ,
  rolename varchar(32) DEFAULT NULL UNIQUE
);

/*Data for the table "t_role" */

insert  into t_role(rolename) values ('admin'),('normal');

/*Table structure for table "t_user" */

CREATE TABLE IF NOT EXISTS t_user (
  id SERIAL PRIMARY KEY ,
  username varchar(32) DEFAULT NULL UNIQUE ,
  password varchar(100) DEFAULT NULL,
  role_id INTEGER REFERENCES t_role(id)
);

/*Data for the table "t_user" */

insert  into t_user("username","password",role_id) values ('apexlj','$shiro1$SHA-256$500000$AjvLVGPE+Kdyn9OOrAIXyw==$1xcsSx5NTNuQ9ue80pCefSSrVpIRbiebfDsgkWBBZIE=',1),('hong','$shiro1$SHA-256$500000$AjvLVGPE+Kdyn9OOrAIXyw==$1xcsSx5NTNuQ9ue80pCefSSrVpIRbiebfDsgkWBBZIE=',2);

/*Table structure for table "t_user_role" */

CREATE TABLE IF NOT EXISTS t_role_permission (
  id SERIAL PRIMARY KEY ,
  role_id INTEGER REFERENCES t_role(id),
  permission_id INTEGER REFERENCES t_permission(id)
);

/*Data for the table "t_user_role" */

insert  into t_role_permission("role_id","permission_id") values (1,1),(1,2),(2,1);