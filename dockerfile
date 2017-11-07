FROM frolvlad/alpine-oraclejdk8:slim

ADD /target/*.jar signupservice-0.1.0-SNAPSHOT.jar
RUN sh -c 'touch /signupservice-0.1.0-SNAPSHOT.jar'
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /signupservice-0.1.0-SNAPSHOT.jar" ]