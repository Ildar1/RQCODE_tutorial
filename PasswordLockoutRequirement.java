public class PasswordLockoutRequirement extends Requirement {
    private String username;
    private Integer failedAttemptNumber;
    private CheckStatus status;

    public PasswordLockoutRequirement(String username) {
        this.username = username;
        this.failedAttemptNumber = 0;
        this.status = CheckStatus.INCOMPLETE;
    }

    public void recordFailedAttempt() {
        if (this.failedAttemptNumber < 5) {
            this.failedAttemptNumber++;
            System.out.println("\nNumber of failed attempts is " + this.failedAttemptNumber);
        } else {
            System.out.println("\nNumber of attempts exceeded (5)." +
                    "\nYour account " + this.username + " is blocked." +
                    "\nPlease reset failed attempts.");
            this.status = CheckStatus.PASS;
        }
    }

    public void resetFailedAttempts() {
        this.failedAttemptNumber = 0;
        this.status = CheckStatus.FAIL;
    }

    @Override
    public CheckStatus check() {
        return this.status;
    }
}
