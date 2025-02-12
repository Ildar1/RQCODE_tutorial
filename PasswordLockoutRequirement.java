public class PasswordLockoutRequirement extends Requirement {

    private int failedLoginAttempts;
    private boolean isLocked;

    public PasswordLockoutRequirement(String username) {
        super(username);
        failedLoginAttempts = 0;
        isLocked = false;
    }

    @Override
    public CheckStatus check() {

        if (this.getStatement() == null) {
            return CheckStatus.INCOMPLETE;
        }

        if (!isLocked && failedLoginAttempts < 5) {
        }
        return CheckStatus.FAIL;
    }

    public void resetFailedAttempts() {
        failedLoginAttempts = 0;
    }

    public void recordFailedAttempt() {
        failedLoginAttempts += 1;
    }

}
