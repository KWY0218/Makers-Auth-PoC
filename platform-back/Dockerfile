# Stage 1: Build stage
FROM amd64/amazoncorretto:17 AS BUILD

# Set working directory for build stage
WORKDIR /platform-back/app

# Copy Gradle wrapper and adjust line endings if necessary
COPY platform-back/gradlew .
RUN sed -i 's/\r$//' gradlew

# Copy Gradle directory and files
COPY platform-back/gradle ./gradle
COPY platform-back/build.gradle .
COPY platform-back/settings.gradle .

# Copy application source
COPY platform-back/src ./src

# Change directory permissions and build application (excluding tests)
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# Stage 2: Runtime stage
FROM amd64/amazoncorretto:17

# Set working directory for runtime stage
WORKDIR /platform-back/app

# Copy built JAR from build stage
COPY --from=BUILD /platform-back/app/build/libs/platform-back-0.0.1-SNAPSHOT.jar /platform-back/app/platform-back.jar

# Set timezone and define command to run the application
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "platform-back.jar"]
