# RQCODE Implementation Guide: Password Lockout Requirement

This guide walks you through implementing a new security requirement using the RQCODE . Follow the steps carefully to complete the task successfully.

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
This task demonstrates how to use the RQCODE  to implement a security requirement for password lockout. The goal is to create a requirement that locks user accounts after a defined number of failed login attempts, preventing brute-force attacks.

---

## Prerequisites
Before starting, ensure you have the following:
- Access to the RQCODE repository.
- A Java development environment.
- Basic knowledge of Java programming.

## Security Requirement Example:
```text
The system must lock a user’s account after 5 consecutive failed login attempts.

## Security Requirement Example:

Your task is to implement this security requirement as a new Java class named `PasswordLockoutRequirement`. This class should:
- Inherit from the `Requirement` class provided in the RQCODE framework.
- Track failed login attempts.
- Lock the user account after 5 consecutive failed login attempts.
- Provide a method to reset failed login attempts.
---

## Step-by-Step Instructions

### 1. Clone the GitHub Repository
To begin, clone the RQCODE GitHub repository to your local machine:
- Visit the repository: [RQCODE GitHub Repository](https://github.com/VeriDevOps/RQCODE).
- Follow this [GitHub tutorial](https://docs.github.com/en/repositories/creating-and-managing-repositories/cloning-a-repository) if you're unsure how to clone a repository.

### 2. Open the Online VS Code IDE
- Navigate to the cloned repository folder on your local machine.
- Press the `.` key to open the repository in an online VS Code IDE.

### 3. Implement the Password Lockout Requirement
- Create a new Java class named **`PasswordLockoutRequirement`** (ensure the name matches exactly).
- The class must inherit from the `Requirement` class provided by the RQCODE.
- Implement the logic to:
  - Lock user accounts after a defined number of failed login attempts.
  - Track the number of failed login attempts and reset them as needed.
  - Include a temporary lockout period.


### 4. Run the Main Class
- The Main class is pre-implemented. Run it following the [RQCODE User Guide](https://dorian-lead-ad4.notion.site/Tutorial-4dc766e08aac4aa588271f1fb0768e50).
- In the terminal, you should be prompted with the following options:

```text
Choose an action:
1. Simulate failed login attempt
2. Reset failed attempts
3. Check lockout status
4. Exit

### Expected Results

After running the Main class, you should observe the following behavior:

1. **Simulate Failed Login**: Simulate a failed login by entering `1` multiple times.
2. **Check Lockout Status**: After 5 consecutive failed attempts, check the lockout status by entering `3`. The system should respond with “Account is locked.”
3. **Reset Attempts**: Reset the failed attempts by entering `2`, then check the status again by entering `3` to confirm the account is no longer locked.
4. **Exit Program**: Exit the program by entering `4`.

### Final Step: Provide Feedback

We value your feedback! After completing the implementation, please take a moment to fill out the survey:

[Pass the Survey](https://forms.gle/GDDF1d9xu7pFcua9A)
