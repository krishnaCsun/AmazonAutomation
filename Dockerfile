FROM openjdk:8-jre-slim

WORKDIR /usr/share/tag

# Add the project jar & copy dependencies
ADD  target/ui-automation-example-1.0-SNAPSHOT.jar ui-automation-example-1.0-SNAPSHOT.jar
ADD  target/ui-automation-example-1.0-SNAPSHOT-tests.jar ui-automation-example-1.0-SNAPSHOT-tests.jar
ADD  target/libs libs

# Add the suite xmls
ADD testng.xml testng.xml

ENTRYPOINT java -cp ui-automation-example-1.0-SNAPSHOT.jar:ui-automation-example-1.0-SNAPSHOT-tests.jar:libs/*  org.testng.TestNG testng.xml
