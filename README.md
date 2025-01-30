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
- Access to the RQCODE tutorial repository.
- Basic knowledge of Java programming.

### Get Familiar with the Following Resources:
- [RQCODE Basics](https://dorian-lead-ad4.notion.site/ReQuirements-as-CODE-RQCODE-Concept-2c5409de940247e28bf13996eb08e866)
- [Tutorial with Password Policy Implementation](https://dorian-lead-ad4.notion.site/Tutorial-4dc766e08aac4aa588271f1fb0768e50)

### Make a Fork of the GitHub Repository
To begin, make a fork of the RQCODE GitHub tutorial repository:
- Visit the repository: [RQCODE Tutorial GitHub Repository](https://github.com/Ildar1/RQCODE_tutorial).
- Follow this [GitHub tutorial on how to fork a repository](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/working-with-forks/fork-a-repo) if you're unsure how to fork a repository.

### Open the Web Editor
- Navigate to the cloned repository folder on your local machine.
- Press the `.` key to open the repository in an online VS Code IDE.
- Click **Run and Debug** and then **Continue Working On**  
  <img width="342" alt="image" src="https://github.com/user-attachments/assets/a5d844f3-bb1d-4703-95aa-da36ace2629e" />
- Click **Create New Code Space**  
  <img width="604" alt="image" src="https://github.com/user-attachments/assets/fcd8a673-7b5c-4ab0-b634-fe784063ca10" />
- Choose **2 cores, 8 GB RAM, 32 GB Storage**  
  <img width="605" alt="image" src="https://github.com/user-attachments/assets/a79c49b7-5747-4060-874e-f17c40b8a350" />

### How to Make a Pull Request
Follow this [GitHub guide on creating a Pull Request from a fork](https://docs.github.com/en/pull-requests/collaborating-with-pull-requests/proposing-changes-to-your-work-with-pull-requests/creating-a-pull-request-from-a-fork). 

It is important to create a Pull Request, as you will need to send the link to your Pull Request in the survey as proof of your work.

## Security Requirement Example:
```text
The system must lock a user’s account after 5 consecutive failed login attempts.
```
___

## Step-by-Step Instructions

Your task is to implement a security requirement that enforces password lockout after repeated failed login attempts. Follow the steps below carefully:

### 1. Implement the Required Functionality  
Your implementation should include the following functionality:
- Implement the class **`PasswordLockoutRequirement`** (ensure the name matches exactly). It should inherit from the [`Requirement`](https://github.com/Ildar1/RQCODE_tutorial/blob/main/Requirement.java) class.  

- In this class, implement the following methods:  
  - Track and increment the count of failed login attempts for a specific user.  
  - Determine whether an account is locked after **5 consecutive failed login attempts**.  
  - Provide a way to reset failed login attempts after a successful login or manual reset.  
  - Evaluate whether the lockout condition has been met and return the appropriate status using the `check()` method.    

### 2. Use an Example for Reference
For guidance, refer to the implementation of [PasswordUpdateRequirement](https://github.com/Ildar1/RQCODE_tutorial/blob/main/PasswordUpdateRequirement). This example demonstrates how to structure and implement a security requirement in RQCODE.

By following these steps, you will successfully integrate the password lockout functionality into the RQCODE framework.

### Example Implementation
For reference, you can check the implementation of a requirement in the [PasswordLockoutRequirement](https://github.com/Ildar1/RQCODE_tutorial/blob/main/PasswordLockoutRequirement.java). You might use it as a guide for your own implementation.


### Run the Main Class
- The Main class is pre-implemented. Run it following the [GitHub Guide](https://github.com/VeriDevOps/RQCODE).
- Install the recommended "Extension Pack for Java":
  <img width="394" alt="image" src="https://github.com/user-attachments/assets/b50f9aa7-571c-4652-9f7e-0dd05e9468d6" />
- After successful installation, you will see this window:
  <img width="841" alt="image" src="https://github.com/user-attachments/assets/964a4ac9-83f7-43ee-8c9b-7d30f240cca5" />
- In the terminal, you should be prompted with the following options:

```text
Choose an action:
1. Simulate failed login attempt
2. Reset failed attempts
3. Check lockout status
4. Exit
```

### Expected Results

After running the Main class, you should observe the following behavior:

1. Enter `1`: Simulate a failed login attempt multiple times.
2. Enter `3`: Check the lockout status after 5 consecutive failed attempts. The system should respond with “Account is locked.”
3. Enter `2`: Reset the failed attempts. Then, enter `3` again to verify that the account is no longer locked.
4. Enter `4`: Exit the program.


### Final Step: Your Feedback

We value your feedback! After completing the implementation, please take a moment to fill out the survey:

[Pass the Survey](https://forms.gle/GDDF1d9xu7pFcua9A)
