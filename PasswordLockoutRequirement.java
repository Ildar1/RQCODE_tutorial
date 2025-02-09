import java.util.HashMap;
import java.util.Map;

public class PasswordLockoutRequirement extends Requirement {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private final String username;
    private static final Map<String, Integer> failedAttempts = new HashMap<>();

    public PasswordLockoutRequirement(String username) {
        this.username = username;
    }

    public void recordFailedAttempt() {
        failedAttempts.put(username, failedAttempts.getOrDefault(username, 0) + 1);
    }

    public void resetFailedAttempts() {
        failedAttempts.put(username, 0);
    }

    @Override
    public CheckStatus check() {
        int attempts = failedAttempts.getOrDefault(username, 0);
        
        if (attempts >= MAX_FAILED_ATTEMPTS) {
            System.out.println("Account is locked due to too many failed login attempts.");
            return CheckStatus.FAIL;
        } else {
            System.out.println("Account is not locked. Failed attempts: " + attempts);
            return CheckStatus.PASS;
        }
    }
}
