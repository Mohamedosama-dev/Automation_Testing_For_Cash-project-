![Screenshot 2024-12-17 at 01-09-47 Test Automation images - بحث Google](https://github.com/user-attachments/assets/65e47176-ac3c-4a5c-9b30-e121615ede46)
# Payment Services Test Automation

This repository contains the test automation scripts for validating the payment services of a web application. The tests include functionalities such as user registration, deposit, withdrawal, transfer, and recharge services.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Tested Functionalities](#Tested-Functionalities)
- [Running Tests](#running-tests)
- [Prerequisites](#Prerequisites)
- [Contact](#Contact)


## Technologies Used
- **Java**: Programming language used for writing test scripts.
- **TestNG**: Test framework used for structuring and running tests.
- **Selenium**: Web automation tool for simulating user interactions with the web application.
- **Maven**: Build automation tool for managing dependencies.
- **Git**: Version control system for managing code changes.
- ![gifmaker_me(2)](https://github.com/user-attachments/assets/e8e95a04-ffa3-47f0-9fbc-d8b945bcdb22)


## Tested Functionalities

The test cases cover a variety of user actions in the system, including:

### 1. **User Registration**  
- **Valid registration** (correct details).  
- **Invalid registration scenarios**:
  - Phone number already exists.
  - Phone number too short or too long.
  - Weak password.

### 2. **Login**  
- **Valid login** (correct credentials).  
- **Invalid login scenarios**:
  - Incorrect phone number.
  - Incorrect password.

### 3. **Transactions**  
- **Deposit**: Valid deposit action.  
- **Withdraw**: Valid withdraw action.  
- **Transfer**: Valid transfer action.
- **Invalid scenarios**:
  - Negative amounts.
  - Insufficient balance.
  - Incorrect transfer amount.  
- **Special cases**:
  - Transfer to a non-existent phone number.
  - Transfer to charity.

### 4. **Recharge**  
- **Valid recharge** of a phone number.  
- **Invalid recharge**:
  - Negative or zero amounts.
  - Recharge to a non-existent phone number.

### 5. **Payment Services**  
- **Successful payment** for services (e.g., utility payments).  
- **Invalid payments**:
  - Negative amounts.

Each of these tests is structured in individual TestNG classes and can be executed as part of a suite.

## Running Tests

### Prerequisites
Before running the tests, ensure that the following are installed:
- Java (Version 8 or higher)
- Maven
- Selenium WebDriver (Ensure the required browser driver is set up, e.g., ChromeDriver)
- TestNG

### Clone the Repository
To get started, clone this repository to your local machine:
```bash
git clone https://github.com/Mohamedosama-dev/Payment_Services_Test_Automation.git

 ```

## Contact

For questions or support, please contact:

- **My Name**: [mohamedosama7337@gmail.com](mailto:mohamedosama7337@gmail.com)
- **GitHub**: [https://github.com/Mohamedosama-dev](https://github.com/Mohamedosama-dev)
---

