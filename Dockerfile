FROM maven:3.6-jdk-8-slim
RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh
ARG username
ARG password

RUN git clone https://${username}:${password}@github.com/
WORKDIR /sample
COPY src /sample/src
COPY pom.xml /sample
CMD ["mvn test"]
