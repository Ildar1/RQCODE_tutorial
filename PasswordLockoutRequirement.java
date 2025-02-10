import java.util.HashMap;
import java.util.Map;

public class PasswordLockoutRequirement extends Requirement {
    private static final int MAX_FAILED_ATTEMPTS = 5;
    private final String username;
    private final Map<String, Integer> failedAttempts = new HashMap<>();

    public PasswordLockoutRequirement(String username) {
        this.username = username;
    }

    public void recordFailedAttempt() {
        int currentAttempts = failedAttempts.getOrDefault(username, 0);
        failedAttempts.put(username, currentAttempts + 1);
    }

    public void resetFailedAttempts() {
        failedAttempts.remove(username);
    }

    @Override
    public CheckStatus check() {
        int attempts = failedAttempts.getOrDefault(username, 0);

        if (attempts >= MAX_FAILED_ATTEMPTS) {
            System.out.println("The account is locked due to too many failed login attempts.");
            return CheckStatus.FAIL;
        } else {
            int attemptsLeft = MAX_FAILED_ATTEMPTS - attempts;
            System.out.println("The account is open. After " + attemptsLeft + " failed attempts it will become locked");
            return CheckStatus.PASS;
        }
    }
}