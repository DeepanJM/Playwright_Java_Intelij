# Playwright Java Automation Framework

This project is a **Playwright-based test automation framework** built with **Java**, **TestNG**, and **Cucumber (BDD)**.  
It follows the **Page Object Model (POM)** design pattern and generates **HTML test reports using Extent Reports**.

The framework supports:
- TestNG tests
- Cucumber BDD scenarios
- Centralized browser setup and teardown
- Reusable page objects
- Detailed HTML reporting

---

## 🛠 Tech Stack

- Java 21
- Playwright for Java
- TestNG
- Cucumber (TestNG runner)
- Maven
- Extent Reports

---

## 📂 Project Structure
- src
  - test
    - java
      - base → Base test classes (Playwright setup)
      - hooks → Cucumber hooks (@Before / @After)
      - pages → Page Object Model classes
      - runners → Cucumber TestNG runner
      - tests → TestNG tests & Cucumber step definitions
      - utils → Utilities (Extent Report manager)
    - resources
      - features → Cucumber feature files


---

## 📋 Prerequisites

Ensure the following software is installed:

### 1️⃣ Java 21
Verify installation:
```
java -version
```
Download if needed:
https://adoptium.net/

### 2️⃣ Maven
Verify installation:
```
mvn -version
```
Download if needed:
https://maven.apache.org/download.cgi

### 3️⃣ IDE (Recommended)
- IntelliJ IDEA (Community or Ultimate)
- Eclipse

---

## 🌐 Playwright Browser Installation
```
mvn exec:java -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
```
---

## 📦 Dependencies
All dependencies are managed via Maven (pom.xml), including:
- Playwright
  - https://mvnrepository.com/artifact/com.microsoft.playwright/playwright/1.56.0
- TestNG
  - https://mvnrepository.com/artifact/org.testng/testng/7.11.0
- Cucumber
- Extent Reports
  - https://mvnrepository.com/artifact/com.aventstack/extentreports/5.1.2
- SLF4J

No manual JAR setup is required.

**NOTE: Run the following in terminal after adding a dependency to the pom.xml file**
```
mvn clean install
```

---
## 🧩 Framework Overview
### BaseTest
- Initializes Playwright
- Launches browser
- Creates Extent test
- Handles teardown

### OldBaseTest
- TestNG-specific base class
- Uses @BeforeMethod and @AfterMethod

### Hooks
- Cucumber lifecycle management
- Integrates Extent Reports with scenarios

### Page Objects
- LoginPage
- HomePage

Encapsulate locators and page actions for reusability.

---

## ▶️ Running the Tests

### ▶ Run All TestNG Tests
```
mvn test
```
This executes all classes ending with *Test.java.

### ▶ Run Using TestNG XML
From IDE:
- Right-click testng.xml
- Click Run

### ▶ Run Cucumber Tests
Run the TestNG Cucumber runner:
```
mvn test -Dtest=TestRunner
```
From IDE:
- Right-click TestRunner.java
- Click Run

---

## 📊 Test Reports

### 📄 Extent Report
Generated after execution at:
```
test-output/ExtentReport.html
```
Includes:
- Test / Scenario name
- Step logs
- Pass / Fail status

### 📄 Cucumber HTML Report
Generated at:
```
target/cucumber-report.html
```

---

## 🧪 Sample Cucumber Scenario
```gkerhin
Feature: Login functionality

Scenario: Successful login and click Time link
Given user navigates to the login page
When user logs in with username "Admin" and password "admin123"
Then user should see the Time link
And user clicks the Time link
```

---

## ⚙ Configuration Notes
- Browser runs in headed mode by default
- Slow motion is enabled for visibility
- These settings can be modified in:
  - BaseTest
  - OldBaseTest