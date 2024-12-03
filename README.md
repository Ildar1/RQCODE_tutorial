# RQCODE_tutorial
Template repository for student practice assignments. 

# TODO
* add the tutorial content here

Introduction
This tutorial is designed to provide an understanding of how to effectively apply RQCODE to structure security requirements in an object-oriented way and translate them into programming code. The following aspects are covered:
Prerequisites for setting up the RQCODE environment
The value of processing security requirements with RQCODE
RQCODE concepts
The example of Password Policy Requirements
Explanation of output status
Describing the requirements through programming code
Verifying the requirements in code
Maintaining security requirements through RQCODE
Value of Processing Security Requirements with RQCODE:
Consistency: RQCODE ensures uniform enforcement of security requirements throughout the entire application, thereby mitigating discrepancies and reducing vulnerabilities.
Systematic Verification: RQCODE facilitates a systematic approach to the verification and analysis of security requirements, enhancing the ability to identify and rectify potential issues efficiently.
Reusability: RQCODE promotes the reuse of security requirement templates across different applications, streamlining the process of defining and implementing policies, and conserving time and resources.
Maintenance: Using RQCODE simplifies the maintenance of security requirements by providing a structured, modular approach that makes updates and modifications easier to manage.
Prerequisites for Running RQCODE
To set up the environment for running RQCODE, the following steps are required:
Java Development Kit (JDK):
Ensure that the Java Development Kit (JDK) version 8 or higher is installed. The JDK can be downloaded from the Oracle website. Verification of the installation can be performed by executing java -version in the command line interface.
Integrated Development Environment (IDE):
It is recommended to use IntelliJ IDEA for development. The Community Edition of IntelliJ IDEA can be downloaded from JetBrains. Alternative IDEs such as Eclipse, NetBeans, or Visual Studio Code with Java extensions are also suitable.
Project Cloning:
The RQCODE project can be obtained by cloning the GitHub repository. This can be done by executing the following command in the Terminal:
git clone https://github.com/VeriDevOps/RQCODE.git
​
Project Setup:
Once cloned, the project should be opened in the IDE. In IntelliJ IDEA, it is advisable to import the project as a Maven project to ensure proper dependency management.
Build and Execution:
After importing the project, it can be built and executed using the tools the chosen IDE provides.
RQCODE Concepts
The goal of RQCODE concepts is to provide a structured framework for defining, verifying, and enforcing requirements in software systems. This framework aims to streamline the process of requirement management by offering built-in methods for verification and enforcement, ensuring that the requirements are not only clearly stated but also effectively checked and implemented.
The Checkable interface is used to verify if the current environment satisfies the requirement programmatically. The check() method returns the status as either PASS, FAIL, or INCOMPLETE.
The Requirement abstract class in RQCODE serves as a foundational element for defining security requirements. It includes a statement attribute for the textual representation of the requirement and redefines the check() method from the Checkable interface for built-in requirement verification. 
These concepts serve as foundational elements for implementing new Java classes that describe specific requirements. By inheriting from the Requirement class, new specific requirement classes can be created. The Checkable interface is used to verify whether the requirement meets the defined standards.
How to apply RQCODE?
This example demonstrates the implementation of password policy requirements and its alignment with security standards. The policy encompasses several measures designed to enhance the security of user accounts, including the enforcement of strong password creation, regular password updates, and secure storage protocols.

Password Policy Requirements
A strong password policy is a critical component of software systems. To ensure the password policy meets security standards, we have defined Specific Requirements:
Requirement 1: Minimum Length
1.1: Passwords must be at least 8 characters long 
1.2. Passwords should not be empty.
Passwords must be at least 8 characters long. This requirement ensures that passwords are of sufficient length to provide a basic level of security, making them harder to crack through brute-force attacks.
Requirement 2: Complexity Requirements
2.1: Passwords must include at least:
2.1.2: One lowercase letter (a-z). This requirement ensures that passwords are not entirely in uppercase or numeric, adding to their complexity.
2.1.1: One uppercase letter (A-Z). Passwords must include at least one uppercase letter (A-Z). This requirement ensures that passwords are not entirely in lowercase, increasing their complexity and making them harder to guess.
2.1.3: One digit (0-9). This requirement ensures that passwords contain numeric characters, making them more diverse and secure against brute-force attacks.
2.1.4: One special character (e.g., !@#$%^&*). Special characters increase the complexity of passwords, making them more resistant to common password-cracking techniques.
Verification status explanation
Within verification of a Specific Requirement using RQCODE, the system returns one of three possible statuses: PASS, INCOMPLETE, or FAIL. Each status provides specific information about the outcome of the verification process.
1. PASS
Message: Password is correct.
Condition: Both Requirement 1 (Minimum Length) and Requirement 2 (Complexity Requirements) are met.
Explanation: The password has successfully passed all checks, indicating that it meets the security requirements defined in the system. This includes being of sufficient length and containing the necessary components such as uppercase letters, lowercase letters, digits, and special characters.
2. INCOMPLETE
Message: Verification cannot be executed.
Condition: The check() method could not be executed for some reason. 
Explanation: The system encountered a condition that prevented it from performing the verification. 
3. FAIL
Message: Password is incorrect.
Condition: Either Requirement 1 or Requirement 2 is not met.
Explanation: The password failed to meet one or more of the defined security requirements. This could be due to the password being too short or empty, missing an uppercase letter, lacking a digit, or not containing a special character. 
Step-by-step explanation of RQCODE implementation
The implementation of RQCODE begins with logically splitting the requirements into distinct parts. For this example, we consider two primary requirements: Requirement 1: Minimum Length and Requirement 2: Complexity Requirements.
Each requirement Minimum Length and Complexity Requirements should be represented as separate Java classes - PasswordMinimumLength and PasswordComplexity correspondingly. Furthermore, each of the Specific Requirements will be implemented as method within these Java classes.
Parent Java class - Requirement()
Each Java class is extended from the parent - Requirement class.
The Requirement class in the RQCODE project serves as an abstract base class for defining various software requirements. Its purpose is to provide a common structure and methods that other specific requirement classes can inherit and implement. 
Key Features of the Requirement Class:
Description of requirement:
The class acts as a stub and has a statement attribute, which provides a human-readable description of the requirement. This helps in understanding the purpose and scope of the requirement.

Inheritance:
By extending this class, subclasses inherit common properties and behaviors, promoting code reuse and consistency across different types of requirements.

Requirement 1: Minimum Length (link to GitHub)
Requirement 1 implementation 
To implement Requirement 1: Minimum Length, we start by creating a class PasswordMinimumLength that extends a parent class Requirement. It also specifies that PasswordMinimumLength extends the Requirement class, inheriting its properties and methods.
public class PasswordMinimumLength extends Requirement 
​
private static final int MIN_LENGTH = 8;: This declares a constant named MIN_LENGTH with a value of 8. 
private String password: This declares a private instance variable named password of type String. This variable will hold the password that needs to be verified against the minimum length requirement.
 		private static final int MIN_LENGTH = 8;
    private String password;
​
public PasswordMinimumLength(String password): This is the constructor for the PasswordMinimumLength class. It takes a single parameter, password, to verify the password.
super("Passwords must be at least 8 characters long and should not be empty.");: This calls the constructor of the superclass (Requirement). It passes a string argument that serves as the description of this specific requirement. This description is set in the Requirement class.
this.password = password: This assigns the provided password to the instance variable password.
 public PasswordMinimumLength(String password) {
        super("Passwords must be at least 8 characters long and should not be empty.");
        this.password = password;
    }
​
Then we create specific methods for Specific requirements: 1.1: Passwords must be at least 8 characters long and 1.2. Passwords should not be empty - isLengthValid() and isEmpty() correspondingly. 
  private boolean isEmpty() {
        return password == null || password.isEmpty();
    }

    private boolean isLengthValid() {
        return password.length() >= MIN_LENGTH;
​
Requirement verification
@Override
    public CheckStatus check() {
        if (password == null) {
            return CheckStatus.INCOMPLETE; 
        }

        boolean emptyCheck = isEmpty();
        boolean lengthCheck = isLengthValid();

        // Print the results of each check
        System.out.println("1.1: Passwords must be at least " + MIN_LENGTH + " characters long - " + (lengthCheck ? "PASS" : "FAIL"));
        System.out.println("1.2: Passwords should not be empty - " + (!emptyCheck ? "PASS" : "FAIL"));

        if (emptyCheck) {
            return CheckStatus.FAIL;
        }

        if (lengthCheck) {
            return CheckStatus.PASS; 
        } else {
            return CheckStatus.FAIL; 
        }
​
This code defines a check() method that evaluates a password against specific criteria. The method overrides an existing implementation and returns a CheckStatus indicating the outcome of the validation. Below is an explanation of the methods used:
 check()method first checks if the password is null. If it is, the method returns INCOMPLETE, signaling that the validation cannot proceed due to missing input. 
isEmpty() method determines if the password is empty, which would result in a FAIL.
 isLengthValid()method ensures the password meets the minimum length requirement, crucial for security.
The results of these checks are printed to the console, providing feedback on whether each requirement is met.
If the password is null, the method returns the status INCOMPLETE.
The method then checks two conditions: whether the password is empty and whether it meets the minimum length requirement. The results of these checks are printed to the console. If the password is empty, the method returns FAIL. If the password meets the length requirement, it returns PASS; otherwise, it returns FAIL.
Requirement 2: Complexity Requirements (link to GitHub)
Requirement implementation 
The PasswordComplexity class is a specialized implementation of the Requirement class designed to ensure that passwords meet specific complexity criteria. 
The PasswordComplexity class is designed with a set of methods, each precisely aligned with distinct criteria for password complexity. These methods enforce specific requirements, including the presence of at least one uppercase letter, one lowercase letter, one digit, and one special character in the password. By mapping each method directly to an individual complexity requirement, the class facilitates a clear and maintainable approach to validating password security. This structure not only enhances code readability but also ensures that each security criterion is robustly enforced within the system.
Requirement 2.1.1: One uppercase letter (A-Z) requirement is implemented through method hasUppercase()
  private boolean hasUppercase() {
        return password.chars().anyMatch(Character::isUpperCase);
​
private boolean hasLowercase() {
        return password.chars().anyMatch(Character::isLowerCase);
    }
​
Requirement 2.1.2: One lowercase letter (a-z) requirement is implemented through method hasLowercase()
private boolean hasDigit() {
        return password.chars().anyMatch(Character::isDigit);
    }
​
Requirement 2.1.3: One digit (0-9) requirement is implemented through method hasDigit()
private boolean hasSpecialCharacter() {
        return password.chars().anyMatch(ch -> "!@#$%^&*".indexOf(ch) >= 0);
    }
​
Requirement 2.1.4: One special character (e.g., !@#$%^&*) requirement is implemented through  method hasSpecialCharacter()
Requirement verification
The check() method in the PasswordComplexity class performs verification of the password. It ensures the password is not empty and meets the requirements for including uppercase letters, lowercase letters, digits, and special characters. Based on these checks, it returns an appropriate CheckStatus value (INCOMPLETE, PASS, or FAIL), providing clear feedback on the password's validity according to the defined security criteria.
@Override
    public CheckStatus check() {
        if (password == null) {
            return CheckStatus.INCOMPLETE; // Return INCOMPLETE if the password is null
        }

        boolean uppercaseCheck = hasUppercase();
        boolean lowercaseCheck = hasLowercase();
        boolean digitCheck = hasDigit();
        boolean specialCharacterCheck = hasSpecialCharacter();

        // Print the results of each check
        System.out.println("2.1.1: One uppercase letter (A-Z) - " + (uppercaseCheck ? "PASS" : "FAIL"));
        System.out.println("2.1.2: One lowercase letter (a-z) - " + (lowercaseCheck ? "PASS" : "FAIL"));
        System.out.println("2.1.3: One digit (0-9) - " + (digitCheck ? "PASS" : "FAIL"));
        System.out.println("2.1.4: One special character (!@#$%^&*) - " + (specialCharacterCheck ? "PASS" : "FAIL"));

        if (uppercaseCheck && lowercaseCheck && digitCheck && specialCharacterCheck) {
            return CheckStatus.PASS; // Return PASS if all complexity checks are passed
        } else {
            return CheckStatus.FAIL; // Return FAIL if any complexity check fails
        }
    }
}
​
The check() method starts by checking if the password is null. If it null, the method returns CheckStatus.INCOMPLETE, indicating that validation cannot proceed due to the absence of a password.
Then check() method performs four specific checks on the password:
Uppercase Check (hasUppercase()): Verifies if the password contains at least one uppercase letter (A-Z).
Lowercase Check (hasLowercase()): Ensures the password includes at least one lowercase letter (a-z).
Digit Check (hasDigit()): Checks for the presence of at least one digit (0-9).
Special Character Check (hasSpecialCharacter()): Confirms that the password contains at least one special character (e.g., !@#$%^&*).
Each check is stored in a boolean variable (uppercaseCheck, lowercaseCheck, digitCheck, specialCharacterCheck).
The results of each individual check are printed to the console, indicating whether the password passed or failed each specific criterion.
The check() method then evaluates the combined results of the complexity checks:
If all four checks (uppercaseCheck, lowercaseCheck, digitCheck, and specialCharacterCheck) pass, the method returns CheckStatus.PASS, meaning the password meets all the complexity requirements.
If any of the checks fail, the method returns CheckStatus.FAIL, indicating that the password does not meet the necessary criteria
Requirements 1 & 2 implementation and verification
Overall concept description (link to GitHub)
To ensure that passwords are not only sufficiently long but also complex enough to meet security standards the new CombinedRequirement class integrates the list of requirement. 
public abstract class CombinedRequirements extends Requirement {

    @Override
    public CheckStatus check() {
        // Get all attributes of type Requirement
        List<Requirement> requirements = getRequirements();

        // Iterate over all requirements and check them
        for (Requirement req : requirements) {
            CheckStatus status = req.check();
            if (status != CheckStatus.PASS) {
                return status;  // Return the first non-passing status
            }
        }
        return CheckStatus.PASS;  // If all requirements pass, return PASS
    }

    // Abstract method that must return a list of requirements
    protected abstract List<Requirement> getRequirements();
}
​
The CombinedRequirements class is an abstract class that extends the Requirement class and provides a way to combine multiple individual requirements into a single composite requirement. The class is designed to evaluate a collection of requirements as a group. It includes:
Check Method: Overrides the check() method to evaluate a list of requirements. It returns the first non-passing status (e.g., FAIL or INCOMPLETE). If all requirements pass, it returns PASS.
Abstract Method: getRequirements() is an abstract method that subclasses must implement to provide the specific list of requirements to check.
Requirement 1 and Requirement 2 verification (link to GitHub)
And then the next step is to verify both Requirement 1 and Requirement 2. The class MyCombinedReq streamlines the management and verification of Requirement 1 and Requirement 2 by consolidating them into a single, cohesive unit. By allowing the dynamic composition of requirements through its constructor, the class facilitates the customization of validation logic, thereby enhancing its flexibility and reusability across diverse scenarios. This design not only promotes modularity but also ensures consistency in the enforcement of complex conditions within a software system.
public class PasswordPolicy extends CombinedRequirements {

    private final List<Requirement> requirements;

    // Constructor that accepts a list of requirements
    public PasswordPolicy(Requirement... requirements) {
        this.requirements = Arrays.asList(requirements);
    }

    @Override
    protected List<Requirement> getRequirements() {
        return requirements;
    }
}
​
How to run password requirement verification (link to GitHub)
The Main class contains a main method as the entry point for running the password verification program. This class reads a password from the user, checks it against the combined password requirements, and outputs the validation status. Here's how to run and understand the code step by step.
public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to capture user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a password
        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Create instances of requirements with the user-provided password
        Requirement R1 = new PasswordMinimumLength(password);
        Requirement R2 = new PasswordComplexity(password);

        // Create an instance of MyCombinedReq that combines the requirements
        MyCombinedReq myReq = new MyCombinedReq(R1, R2);

        // Perform the check and print the detailed result
        System.out.println("Requirement 1: Minimum Length");
        R1.check();
        System.out.println("Requirement 2: Complexity Requirements");
        R2.check();

        // Determine the final status
        Checkable.CheckStatus status = myReq.check();
        System.out.println("Final Status: " + status);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
​
This Main class captures a user-provided password, evaluates it against two requirements (minimum length and complexity), and combines these checks using MyCombinedReq. It then performs the verification, prints the results of each requirement, and outputs the final status, ensuring a structured and comprehensive assessment of the password's strength.
Example Output
For PASS output:
Enter Password: P@ssword123456!
1.1: Passwords must be at least 8 characters long - PASS
1.2: Passwords should not be empty - PASS
Requirement 2: Complexity Requirements
2.1.1: One uppercase letter (A-Z) - PASS
2.1.2: One lowercase letter (a-z) - PASS
2.1.3: One digit (0-9) - PASS
2.1.4: One special character (!@#$%^&*) - PASS
Final Aggregate Status: PASS
​
For FAIL output:
Enter Password: password
1.1: Passwords must be at least 8 characters long - FAIL
1.2: Passwords should not be empty - PASS
Requirement 2: Complexity Requirements
2.1.1: One uppercase letter (A-Z) - FAIL
2.1.2: One lowercase letter (a-z) - PASS
2.1.3: One digit (0-9) - FAIL
2.1.4: One special character (!@#$%^&*) - FAIL
Final Aggregate Status: FAIL