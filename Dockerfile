FROM adoptopenjdk/openjdk8:alpine
COPY build/libs/k8sdemo-integration-1.0.0.jar /
RUN mkdir config
CMD ["java", "-jar", "/k8sdemo-integration-1.0.0.jar"]