FROM maven:3.6-jdk-8-slim
RUN git clone https://${username}:${password}@github.com/sam20487/AppiumCucumber.git
WORKDIR /sample
COPY src /sample/src
COPY pom.xml /sample
CMD ["mvn test"]
