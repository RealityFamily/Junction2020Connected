FROM centos

RUN yum install -y java

VOLUME /tmp
ADD /swagger-spring-1.0.1.jar java-back.jar
RUN sh -c 'touch /java-back.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/java-back.jar"]
