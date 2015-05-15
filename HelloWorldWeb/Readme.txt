Server Runtime(Tomcat 7)
Java Runtime 
%JAVA_HOME%\db\bin\startNetworkServer
%JAVA_HOME%\db\bin\ij
ij> CONNECT 'jdbc:derby://localhost:1527/seconddb;create=true';