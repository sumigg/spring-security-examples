# Gemini CLI Project Context: Demo Security

This project is a Spring Boot application focused on demonstrating and implementing Spring Security configurations.

## Core Mandates

### 1. Security Standards
- **Password Encoding:** Always use a secure `PasswordEncoder` (e.g., `BCryptPasswordEncoder`) for production-like configurations. `NoOpPasswordEncoder` is strictly for initial development or demonstration only.
- **Configuration Style:** Prefer the Lambda DSL (`http -> http...`) for `SecurityFilterChain` configurations to maintain consistency with modern Spring Security versions.
- **Principle of Least Privilege:** Ensure authorization rules are as specific as possible. Avoid `anyRequest().permitAll()` in shared branches.

### 2. Development Workflow
- **Surgical Edits:** When modifying `SecurityConfig.java`, preserve existing comments or disabled configurations unless explicitly asked to remove them, as they often serve as reference points.
- **Testing:** Every security change (authentication or authorization) must be accompanied by an integration test using `@SpringBootTest` and `MockMvc` with Spring Security test support.

### 3. Conventions
- **Naming:** Follow standard Spring Boot naming conventions.
- **Structure:** Keep security configurations within the `com.prj.sec.ex.demo.security.config` package.
- **User Management:** Use the custom `Users` and `InMemoryUserDetailsService` in the `users` package for user-related logic unless a more robust provider is requested.

## Useful Commands
- `./mvnw spring-boot:run`: Start the application.
- `./mvnw test`: Run all tests.
- `./mvnw clean install`: Build the project.
