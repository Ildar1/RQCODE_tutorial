# RQCODE Implementation Guide: Password Lockout Requirement

This guide walks you through implementing a new security requirement using the RQCODE framework. Follow the steps carefully to complete the task successfully.

## Table of Contents
1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Step-by-Step Instructions](#step-by-step-instructions)
   - [Clone the GitHub Repository](#1-clone-the-github-repository)
   - [Open the Online VS Code IDE](#2-open-the-online-vs-code-ide)
   - [Implement the Password Lockout Requirement](#3-implement-the-password-lockout-requirement)
   - [Run the Main Class](#4-run-the-main-class)
4. [Expected Results](#expected-results)
5. [Resources](#resources)

---

## Introduction
This task demonstrates how to use the RQCODE framework to implement a security requirement for password lockout. The goal is to create a requirement that locks user accounts after a defined number of failed login attempts, preventing brute-force attacks.

---

## Prerequisites
Before starting, ensure you have the following:
- Access to the RQCODE repository.
- A Java development environment.
- Basic knowledge of Java programming.

---

## Step-by-Step Instructions

### 1. Clone the GitHub Repository
To begin, clone the RQCODE GitHub repository to your local machine:
- Visit the repository: [RQCODE GitHub Repository](https://github.com/VeriDevOps/RQCODE).
- Follow this [GitHub tutorial](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository) if you're unsure how to clone a repository.

### 2. Open the Online VS Code IDE
- Navigate to the cloned repository folder on your local machine.
- Press the `.` key to open the repository in an online VS Code IDE.
- Alternatively, access the repository in the online IDE directly via this link: [Online IDE for RQCODE](https://miniature-halibut-wx64j6975v35gw.github.dev/).

### 3. Implement the Password Lockout Requirement
- Create a new Java class named **`PasswordLockoutRequirement`** (ensure the name matches exactly).
- The class must inherit from the `Requirement` class provided by the RQCODE framework.
- Implement the logic to:
  - Lock user accounts after a defined number of failed login attempts.
  - Track the number of failed login attempts and reset them as needed.
  - Include a temporary lockout period.

**Requirement Example:**
```text
The system must lock a user’s account after 5 consecutive failed login attempts.
