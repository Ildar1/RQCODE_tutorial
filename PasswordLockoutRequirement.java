public class PasswordLockoutRequirement extends Requirement {

    private int failedAttempts;

    @Override
    public Checkable.CheckStatus check() {
        if (failedAttempts >= 5) {
            return CheckStatus.PASS;
        } else {
            return CheckStatus.FAIL;
        }
    }
    
    public PasswordLockoutRequirement(String username) {
        failedAttempts = 0;
    }

    public void recordFailedAttempt() {
        failedAttempts += 1;
    }

    public void resetFailedAttempts() {
        failedAttempts = 0;
    }
}
