dawClub using SpringMVC
==========

Sample Maven Netbeans project with CRUD Web App using SpringMVC

Features:
-------------
- Simple DAOList for testing purpose
- Sample DAOJDBC implementation
- Sample Tomcat/Glassfish Connection Pool configuration file
- Uses Spring CDI with qualifiers for DAO selection
- Resource injection for JNDI connetion pool
- Bean Validation with customized messages on messages.properties
- Simple Entity CRUD jsp views
- Optional access constraints for Authentication/Authorization.
- SpringMVC Logout controller and optional logout button for views

Requeriments:
-------------
- In Tomcat, for enabling Authentication form, uncomment <Auth-constraint> section in web.xml and add users on tomcat-users.xml
