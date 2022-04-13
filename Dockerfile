FROM openjdk:13-jdk-alpine

# For the sake of security, run the application via a non-root user
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Tweak performance
ENV spring.jmx.enabled false

# Create application directory
ENV APP_DIR /home/spring/app
RUN mkdir -p ${APP_DIR}
WORKDIR ${APP_DIR}
VOLUME ${APP_DIR}

# Create slim layered application structure, for a faster startup
# You have to unpack the fat JAR
# RUN mkdir -p ${APP_DIR}/lib && mkdir -p ${APP_DIR}/META-INF

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]

# To build an image
# docker build -t spring-boot .

# To run a container in the background
# docker run -p 8080:8080 spring-boot

# To run a container interactively
# docker run -p 8080:8080 -it spring-boot /bin/sh

# Don't forget to add mount option to mount your JAR file directory
# -v <jar_file_dir>:/home/spring/app
# For Maven project, the JAR files reside in
# <your_spring_project>/target
# For Gradle project, the JAR files reside in
# <your_spring_project>/build/libs
