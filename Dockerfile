# Use an official OpenJDK 22 image as a base image
FROM eclipse-temurin:22-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the project files to the container
COPY . /app


# Build the project (Update as necessary to match your build command)
RUN ./gradlew build

# Expose the required port (update based on your application, e.g., 8080 for web apps)
EXPOSE 8080

# Run the application (Update the jar file to the proper output file of your project)
CMD ["java", "-jar", "build/libs/ParkingLot-1.0-SNAPSHOT.jar"]