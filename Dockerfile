FROM tomcat:9-jdk8
#ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005
EXPOSE 8080
ADD target/ArticlesFeed.war /usr/local/tomcat/webapps/ArticlesFeed.war
CMD ["catalina.sh", "run"]