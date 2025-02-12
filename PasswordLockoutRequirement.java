public class PasswordLockoutRequirement extends Requirement {
    private String username;
    private int MAX_ATTEMPTS_COUNT = 5;
    private int attemptsCount;
    private boolean isLocked;

    public PasswordLockoutRequirement(String username) {
        super("Requirement 3: Password Lockout Requirement");
        this.username = username;
        this.attemptsCount = 0;
        this.isLocked = false;
    }


    @Override
    public CheckStatus check() {
        if (this.isLocked) {
            System.out.println("Account is locked.");
        } else {
            System.out.println("Account is unlocked.");
        }
        return (((this.attemptsCount==MAX_ATTEMPTS_COUNT) && this.isLocked) || ((this.attemptsCount<MAX_ATTEMPTS_COUNT) && !this.isLocked)) ? CheckStatus.PASS : CheckStatus.FAIL;
    }


    public void recordFailedAttempt() {
        if (!this.isLocked) {
            ++this.attemptsCount;
            System.out.println("Login Attempt Status: FAIL    Failed Attempts Count: "+this.attemptsCount);
            if (this.attemptsCount >= MAX_ATTEMPTS_COUNT) {
                this.lockAccount();
            }
        } else {
            this.lockAccount();
        }
    }

    public void recordSuccessfullAttempt() {
        if (!this.isLocked) {
            System.out.println("Login Attempt Status: PASS    Failed Attempts Count: "+this.attemptsCount);
            resetFailedAttempts();
        } else {
            this.lockAccount();
        }
    }

    private void lockAccount() {
        this.isLocked = true;
        System.out.println("FATAL: Account is locked! Please, reset your password.");
    }

    public boolean resetFailedAttempts() {
        this.attemptsCount = 0;
        this.isLocked = false;
        System.out.println("Failed attempt count was reset!    Failed Attempts Count: "+this.attemptsCount);
        return true;
    }


}