FROM maven:3-openjdk-11 as builder
ADD . / opt/
RUN (cd opt; mvn clean package;)

FROM openjdk:11
COPY --from=builder opt/target/kymnevoistlus-*.jar /usr/src/kymnevoistlus/kymnevoistlus.jar
WORKDIR /usr/src/kymnevoistlus
EXPOSE 8080
CMD java -jar kymnevoistlus.jar