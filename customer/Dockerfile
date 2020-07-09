FROM java:8-jdk-alpine
COPY ./out/artifacts/customer_jar/customer.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "customer.jar"]
