FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD modeler-service-sample.jar /app.jar
ADD bin /bin
ENTRYPOINT exec java $JAVA_OPTS -server -jar /app.jar
