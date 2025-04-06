# AI Chatbot Test Automation Framework

![Selenium](https://img.shields.io/badge/-Selenium-43B02A?logo=selenium&logoColor=white)
![Cucumber](https://img.shields.io/badge/-Cucumber-23D96C?logo=cucumber&logoColor=white)
![Dialogflow](https://img.shields.io/badge/-Dialogflow-FF9800?logo=dialogflow&logoColor=white)

Automated testing framework for validating AI chatbot responses by comparing them with Dialogflow intents using Selenium WebDriver and BDD approach.

## Features

- ✅ BDD-style tests using Cucumber
- ✅ Dual validation against chatbot UI and Dialogflow API
- ✅ Response time measurement
- ✅ Semantic response comparison
- ✅ Detailed HTML/JSON reporting

## Tech Stack

### Core Components
- **Selenium WebDriver** - Browser automation
- **Cucumber** - BDD test framework
- **TestNG** - Test runner
- **Dialogflow API** - NLP response validation

### Supporting Tools
- Maven - Dependency management
- Log4j2 - Test logging
- Google Cloud SDK - Dialogflow integration

## Prerequisites

- Java 17+
- Chrome browser
- Maven 3.8+
- Google Cloud account (for Dialogflow)
- ChromeDriver (matching your Chrome version)

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/ai-chatbot-test-automation.git
