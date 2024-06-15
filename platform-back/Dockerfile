# Stage 2: Runtime stage
FROM amd64/amazoncorretto:17

# Set working directory for runtime stage
WORKDIR /app

# Copy built JAR from build stage
COPY ./app/build/libs/platform-back-0.0.1-SNAPSHOT.jar /app/platform-back.jar

# Set timezone and define command to run the application
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "platform-back.jar"]