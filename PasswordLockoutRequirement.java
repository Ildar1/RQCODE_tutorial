public class PasswordLockoutRequirement extends Requirement {
    private final Map<String, int> username2attempts = new HashMap<>();
    private static final int MAX_ATTEMPTS = 5;
    private String username;

    public PasswordLockoutRequirement(String username) {
        super("Requirement: Password Lockout Requirement");
        this.username = username;
        if (this.username2attempts.get(username) == null) {
            this.username2attempts[username] = 0;
        }
    }

    public void recordFailedAttempt() {
        this.username2attempts[username] = this.username2attempts[username] + 1;
    }

    public void resetFailedAttempts() {
        this.username2attempts[username] = 0;
    }

    @Override
    public CheckStatus check() {
        if (this.username == null) {
            return CheckStatus.INCOMPLETE;
        }
        if (this.username2attempts[username] > this.MAX_ATTEMPTS) {
            System.out.println("Account is locked");
            return CheckStatus.FAIL;
        }
        return CheckStatus.PASS;
    }
}
