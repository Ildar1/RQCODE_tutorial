import java.util.HashMap;
import java.util.Map;

public class PasswordLockoutRequirement extends Requirement {
    private final String user;
    private final Map<String, UserStatus> users = new HashMap<>();
    
    private static final long LOCK_TIME = 12 * 1 * 1000; // 12 minutes
    private static final int MAX_ATTEMPTS = 5;

    public PasswordLockoutRequirement(String user) {
        this.user = user;
        users.putIfAbsent(user, new UserStatus());
    }

    public void recordFailedAttempt() {
        users.get(user).increaseFailedAttempts();
    }

    public void resetFailedAttempts() {
        users.get(user).clearAttempts();
    }

    @Override
    public Checkable.CheckStatus check() {
        UserStatus status = users.get(user);
        if (status.isLocked()) {
            if (System.currentTimeMillis() - status.getLockoutStartTime() > LOCK_TIME) {
                status.clearLock();
                return Checkable.CheckStatus.PASS;
            } else {
                return Checkable.CheckStatus.FAIL;
            }
        }
        return Checkable.CheckStatus.INCOMPLETE;
    }

    private static class UserStatus {
        private int failedAttempts = 0;
        private long lockStart = 0;

        public long getLockoutStartTime() {
            return lockStart;
        }

        public void increaseFailedAttempts() {
            failedAttempts++;
            if (failedAttempts >= MAX_ATTEMPTS) {
                lockStart = System.currentTimeMillis();
            }
        }

        public void clearAttempts() {
            failedAttempts = 0;
            lockStart = 0;
        }

        public boolean isLocked() {
            return lockStart > 0;
        }

        public void clearLock() {
            lockStart = 0;
        }
    }
}
