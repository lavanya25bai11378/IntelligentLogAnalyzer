# Intelligent Log Anomaly Detection and Incident Correlation System Using Java

## Overview

This project is a Java-based system that analyzes application and system log files to identify unusual error patterns and group related errors into incidents.

The system reads log data, checks for repeated errors and critical failures, assigns a severity level to detected incidents, and generates a simple incident report.

The project was developed as part of Programming in Java to apply Java programming concepts such as classes and objects, collections, file handling, exception handling, methods, and modular programming.

## Problem Statement

Large log files can contain many error messages, making it difficult to manually identify repeated failures and understand which errors may belong to the same incident.

This project provides a simple automated approach to analyze log files and organize important errors into meaningful incidents.

## Main Features

- Read and parse log files
- Identify repeated errors by service
- Detect critical system failures
- Group related errors into incidents
- Assign severity levels to incidents
- Generate an incident report
- Handle invalid or empty input safely

## Project Modules

1. **Log Ingestion and Parsing**
   - Reads the input log file
   - Converts log entries into Java objects

2. **Pattern Detection**
   - Counts errors for different services
   - Identifies repeated error patterns

3. **Anomaly Detection**
   - Detects repeated errors
   - Detects critical failure messages

4. **Incident Correlation**
   - Groups related error events into incidents

5. **Severity Analysis**
   - Assigns LOW, MEDIUM, HIGH, or CRITICAL severity

6. **Report Generation**
   - Creates a text report containing detected incidents

## Technologies Used

- Java
- Java Collections Framework
- File Handling
- Object-Oriented Programming
- Exception Handling
- Git and GitHub

## Project Structure

```text
IntelligentLogAnalyzer/
│
├── README.md
├── .gitignore
│
├── data/
│   └── sample.log
│
├── output/
│   └── .gitkeep
│
└── src/
    ├── Main.java
    ├── model/
    │   ├── LogEvent.java
    │   ├── Anomaly.java
    │   └── Incident.java
    │
    ├── parser/
    │   └── LogParser.java
    │
    ├── detection/
    │   ├── PatternDetector.java
    │   └── AnomalyDetector.java
    │
    ├── correlation/
    │   └── IncidentCorrelator.java
    │
    ├── analysis/
    │   └── SeverityAnalyzer.java
    │
    └── reporting/
        └── ReportGenerator.java
