public class PasswordLockoutRequirement extends Requirement {
    private String username;
    private int failedAttempts;
    private boolean isLocked;

    public PasswordLockoutRequirement(String username) {
        this.username = username;
        this.failedAttempts = 0;
        this.isLocked = false;
    }

    // Метод для записи неудачной попытки входа
    public void recordFailedAttempt() {
        if (!isLocked) {
            failedAttempts++;
            if (failedAttempts >= 5) {
                isLocked = true;
                System.out.println("Account " + username + " is locked due to 5 failed attempts.");
            } else {
                System.out.println("Failed attempt recorded. Total failed attempts: " + failedAttempts);
            }
        } else {
            System.out.println("Account " + username + " is already locked.");
        }
    }

    // Метод для сброса счетчика неудачных попыток
    public void resetFailedAttempts() {
        failedAttempts = 0;
        isLocked = false;
        System.out.println("Failed attempts reset for account " + username + ".");
    }

    // Метод для проверки статуса блокировки
    @Override
    public CheckStatus check() {
        if (isLocked) {
            return CheckStatus.PASS; // Учетная запись заблокирована
        } else {
            return CheckStatus.INCOMPLETE; // Учетная запись не заблокирована
        }
    }
}