public class PasswordLockoutRequirement extends Requirement {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private int consecutiveFailedAttempts;
    private boolean locked;
    private final String username;

    /**
     * Constructor for the PasswordLockoutRequirement
     * @param username
     */
    public PasswordLockoutRequirement(String username) {
        super("Lock out user after 5 consecutive failed login attempts");
        this.username = username;
        this.consecutiveFailedAttempts = 0;
        this.locked = false;
    }

    public void recordFailedAttempt() {
        if (!locked) {
            consecutiveFailedAttempts++;
            System.out.println("[" + username + "] Failed attempts: " + consecutiveFailedAttempts);
            if (consecutiveFailedAttempts >= MAX_FAILED_ATTEMPTS) {
                locked = true;
                System.out.println("[" + username + "] Account has been locked due to too many failed attempts!");
            }
        } else {
            System.out.println("[" + username + "] This account is already locked.");
        }
    }

    public void resetFailedAttempts() {
        consecutiveFailedAttempts = 0;
        locked = false;
        System.out.println("[" + username + "] Failed attempts have been reset, and account is unlocked.");
    }

    /**
     * Checks the lockout status of the account.
     * @return PASS if the account is not locked, FAIL if it is locked.
     */
    @Override
    public CheckStatus check() {
        if (locked) {
            System.out.println("[" + username + "] Account is locked.");
            return CheckStatus.FAIL;
        } else {
            System.out.println("[" + username + "] Account is not locked.");
            return CheckStatus.PASS;
        }
    }
}
