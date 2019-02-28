dawClub using SpringMVC
==========

Sample Maven Netbeans project with CRUD Web App using SpringMVC

Features:
-------------
- Simple Entity CRUD jsp views
- Simple DAOList for testing purpose
- Sample DAOJDBC and Spring JdbcTemplate implementations
- JEE DataSource definition (web.xml)
- Sample Tomcat Connection Pool configuration file (context.xml)
- Uses Spring CDI with qualifiers for DAO selection
- DataSource Bean for JNDI connetion pool location
- Bean Validation with customized messages
- Optional access constraints for JEE Authentication/Authorization.
- SpringMVC Logout controller and optional logout button for views
- Spring 3+ programmatic configuration
- Spring DispatcherServlet initialization using Servlet 3.0 programmatic configuration

## Requeriments

- JEE Application Server, i.e. Payara, Glassfish

## Usage
- Compile and deploy in a JEE Application Server

### DB Access:
1. Configure JEE Datasource in web.xml
2. Configura DataSource Bean (SpringMvcConfig.java)
3. Select JDBC or JDBCTemplate DAOs implementation in controller

### Realm Authentication/Authorization:
1. Create Realm in JEE Application Server, e.g. using AS GUI/asadmin tool
2. Uncomment/Create Security-constraints in web.xml
3. Select valid realm in web.xml