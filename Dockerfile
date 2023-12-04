FROM openjdk:17
WORKDIR /app
COPY target/planner-0.0.1-SNAPSHOT.jar app.jar
ENV PORT 8080
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]
#ENTRYPOINT exec java $JAVA_OPTS -jar app.jar