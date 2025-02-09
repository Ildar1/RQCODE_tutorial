public class PasswordLockoutRequirement extends Requirement{
    private String username;
    private int numOfAttempts;
    private CheckStatus status;

    @Override
    public CheckStatus check() {
        return status;
    }

    public PasswordLockoutRequirement(String username){
        this.username = username;
        this.numOfAttempts = 0;
        this.status = CheckStatus.INCOMPLETE;
    }

    public void recordFailedAttempt(){
        if (numOfAttempts < 5){
            numOfAttempts = numOfAttempts + 1;
        }
        else {
            status = CheckStatus.FAIL;
            System.out.println("Too many attempts for user " + username);
        }
    }

    public void resetFailedAttempts(){
        numOfAttempts = 0;
        status = CheckStatus.INCOMPLETE;
    }
}