FROM maven:3.6.3-jdk-11-slim
COPY src /home/AppiumFramework/src
COPY pom.xml /home/AppiumFramework
COPY testng.xml /home/AppiumFramework


