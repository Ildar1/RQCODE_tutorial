public class PasswordLockoutRequirement extends Requirement {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private static final int STARTING_FAILED_ATTEMPTS = 0;
    private Integer failedAttempts;
    private String username;
    
    public PasswordLockoutRequirement(String username) {
        super("Requirement 2: Failed password attempts lockout Rquirement");
        this.failedAttempts = STARTING_FAILED_ATTEMPTS;
        this.username = username;
    }

    // Increment amount of failed attempts
    public void recordFailedAttempt() {
        failedAttempts += 1;
    }

    // Reset amount of failed attempts to zero
    public void resetFailedAttempts() {
        failedAttempts = STARTING_FAILED_ATTEMPTS;
    }

    // Check if the max amount of failed attempts reached
    private boolean isMaxFailedAttemptsReached() {
        return failedAttempts >= MAX_FAILED_ATTEMPTS;
    }

    @Override
    public Checkable.CheckStatus check() {
        if (username == null || failedAttempts == null) {
            return CheckStatus.INCOMPLETE; // return INCOMPLETE if the requirement was not initialized
        }

        boolean attemptCountCheck = isMaxFailedAttemptsReached();

        System.out.println("2: Amount of failed attempts exceeds " + MAX_FAILED_ATTEMPTS + " - " + (attemptCountCheck ? "PASS" : "FAIL"));

        if (attemptCountCheck) {
            return CheckStatus.PASS; // Return PASS if the amount of failed attempts exceeds the threshold for pass
        } else {
            return CheckStatus.FAIL; // Return FAIL if the lockout requirement failed
        }
    }
}
