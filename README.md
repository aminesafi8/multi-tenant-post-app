# Multitenant Posts Application using Spring Boot and MongoDB

Welcome to our multitenant application for managing Posts, built using Spring Boot and MongoDB. This application enables multiple organizations (tenants) to retrieve posts within their respective environments.

## Features

- **Multitenancy**: The application ensures data isolation between tenants, providing each organization with access to their own posts.

- **Get Posts by Tenant**: The primary functionality of the application is to retrieve posts specific to a particular tenant, allowing organizations to access their content securely.

## Technologies Used

- **Spring Boot**: The application is built using Spring Boot, providing a robust and scalable framework for developing Java-based applications.

- **Spring Data MongoDB**: Spring Data MongoDB simplifies the interaction with MongoDB databases, making it easier to retrieve data.

- **MongoDB**: MongoDB is used as the underlying NoSQL database to store post data.

## Getting Started

To get started with the application, follow these steps:

1. **Clone the Repository**: Clone this repository to your local machine using `git clone`.

2. **Configure MongoDB**: Ensure MongoDB is installed and running on your local machine or configure the connection properties to connect to your MongoDB instance in the `application.yaml` file.

3. **Build and Run**: Use Maven to build the application, then run the Spring Boot application.

4. **Access the Application**: Once the application is running, access it through the specified URL. You can now retrieve posts specific to your organization by making GET requests to the appropriate endpoint.

## Contributing

Contributions are welcome! Feel free to fork the repository and submit pull requests with your enhancements or bug fixes.

## License

This project is licensed under the [MIT License](LICENSE).

## Contact

If you have any questions or suggestions, feel free to contact us at [aminesafig@gmail.com](mailto:aminesafig@gmail.com).

Thank you for choosing our Multitenant Posts Application!
