# 🌐 Web-API Automation Test

Automation testing project for both **Web UI** and **API** using powerful testing tools and frameworks.

---

## 🚀 Overview

This project performs automated testing on:

- 🖥️ **Web UI**: [Demoblaze](https://www.demoblaze.com/index.html) using **Selenium**
- 📡 **API**: [DummyAPI.io](https://dummyapi.io/) using **Rest Assured**

Both layers use the **Cucumber** framework for behavior-driven development (BDD) and are integrated with **Gradle** for build and run management, as well as **GitHub Actions** for CI/CD.

---

## 🧰 Tech Stack

| Tool         | Purpose                         |
|--------------|----------------------------------|
| Selenium     | Web UI automation                |
| Rest Assured | API automation testing           |
| Cucumber     | BDD (Behavior Driven Development)|
| Gradle       | Build and test runner            |
| GitHub Action| Continuous Integration           |

---

## 🎯 Objectives

- Automate UI testing for the Demoblaze website.
- Automate REST API testing for DummyAPI.io.
- Use tag-based filtering for flexible test execution.
- Provide clean, maintainable, and scalable test structure.

---
📁 Project Structure

├── src
│   ├── main
│   └── test
│       ├── java
│       │   └── com.achmad
│       │       ├── base           # Base classes 
│       │       ├── page           # Page Object Models (POM)
│       │       ├── runner         # Cucumber runners for API & Web
│       │       └── stepdef        # Step definitions for Cucumber scenarios
│       └── resources
│           ├── api-dummyapi      # Feature files for dummyapi.io API testing
│           ├── jsonschema        # JSON Schema files for response validation
│           ├── web-demoblaze     # Feature files for web testing on demoblaze.com
│           └── config.properties # Configuration settings (e.g., base URLs, tokens)
├── .gitignore
├── build.gradle
├── gradlew
├── gradlew.bat
└── README.md

## ▶️ How to Run Tests

### 📘 Web Automation

#### Using Gradle
```bash
# Run all scenarios
./gradlew cucumber

# Run scenarios by tag
./gradlew cucumber -Ptags="@tag-name"
