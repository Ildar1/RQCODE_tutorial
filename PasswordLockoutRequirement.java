package rqcode.tutorial.tutorial_new;


public class PasswordLockoutRequirement extends Requirement {
    /**
     * TODO Track and increment the count of failed login attempts for a specific user.
     * TODO Determine whether an account is locked after 5 consecutive failed login attempts.
     * TODO Provide a way to reset failed login attempts after a successful login or manual reset.
     * TODO Evaluate whether the lockout condition has been met and return the appropriate status using the check() method.
     */


    private int failedAttempts;
    private boolean isLocked;

    public PasswordLockoutRequirement(String username) {
        super(username);
        failedAttempts = 0;
        isLocked = false;
    }

    @Override
    public CheckStatus check() {

        if (this.getStatement() == null) { //check that the username is not null and was properly initialized.
            return CheckStatus.INCOMPLETE;
        }


        if (!isLocked && failedAttempts < 5) { //check that the account is locked and there have been 5 consecutive failed attempts
            return CheckStatus.PASS;
        }
        return CheckStatus.FAIL;
    }


    public void resetFailedAttempts() {
        failedAttempts = 0; //reset failed login attempts
    }


    public void recordFailedAttempt() {
        failedAttempts += 1;
    }



}
