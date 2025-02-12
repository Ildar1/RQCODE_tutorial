public class PasswordLockoutRequirement extends Requirement {
    private static final int FAILED_MAX = 5;
    private static final int BEFORE_FAILING = 0;
    private Integer failedAttempts;
    private String uname;
    
    public PasswordLockoutRequirement(String uname) {
        super("Requirement 2: System must lock account after " + FAILED_MAX + " failed attempts.");
        this.failedAttempts = BEFORE_FAILING;
        this.uname = uname;
    }

    public void recordFailedAttempt() {
        failedAttempts += 1;
    }

    public void resetFailedAttempts() {
        failedAttempts = BEFORE_FAILING;
    }

    private boolean isMaxFailedAttemptsReached() {
        return failedAttempts >= FAILED_MAX;
    }

    @Override
    public Checkable.CheckStatus check() {
        if (uname == null || failedAttempts == null) {
            return CheckStatus.INCOMPLETE;
        }

        boolean failedAttemptsCheck = isMaxFailedAttemptsReached();

        System.out.println("2: Amount of failed attempts exceeds " + FAILED_MAX + " - " + (failedAttemptsCheck ? "PASS" : "FAIL"));

        return failedAttemptsCheck ? CheckStatus.PASS : CheckStatus.FAIL;
    }
}