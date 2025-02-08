import java.util.HashMap;
import java.util.Map;

public class PasswordLockoutRequirement extends Requirement {

    private final String username;
    public PasswordLockoutRequirement(String username) {
        this.username = username;
        userStatusMap.putIfAbsent(username, new UserLoginStatus());
    }

    private static final int FAILED_ATTEMPTS_LIMIT = 5;

    private static final long LOCK_MS = 1000 * 22; // lock time

    private final Map<String, UserLoginStatus> userStatusMap = new HashMap<>();


    @Override
    public Checkable.CheckStatus check() {
        UserLoginStatus status = userStatusMap.get(username);

        if (status.isLockedCheck()) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - status.getLockStartTime() > LOCK_MS) {
                status.resetLock();
                return Checkable.CheckStatus.PASS;
            }
            return Checkable.CheckStatus.FAIL;
        }

        return Checkable.CheckStatus.PASS;
    }

    private static class UserLoginStatus {
        private long lockStartTime = 0;
        private int failedAttemptsCount = 0;


        public void incrementFailedAttempts() {
            failedAttemptsCount++;
            if (failedAttemptsCount >= FAILED_ATTEMPTS_LIMIT) {
                lockStartTime = System.currentTimeMillis();
            }
        }
        public void resetFailedAttempts() {
            failedAttemptsCount = 0;
            lockStartTime = 0;
        }
        public boolean isLockedCheck() {
            return lockStartTime > 0;
        }
        public long getLockStartTime() {
            return lockStartTime;
        }
        public void resetLock() {
            lockStartTime = 0;
        }
    }

    public void recordFailedAttempt() {
        userStatusMap.get(username).incrementFailedAttempts();
    }
    public void resetFailedAttempts() {
        userStatusMap.get(username).resetFailedAttempts();
    }

}