public class PasswordLockoutRequirement extends Requirement{
    
    private String username;
    private CheckStatus status;
    private int attempts;

    @Override
    public CheckStatus check() {
        return status;
    }

    public PasswordLockoutRequirement(String username){
        super("Requirement lockout: Password Lockout After 5 failed attemps");
        this.username = username;
        this.status = CheckStatus.INCOMPLETE;
        this.attempts = 0;
    }

    public void countFail(){
        if (attempts >= 5) {
            status = CheckStatus.FAIL;
            System.out.println("6+ attempts failed: " + username);
            return;
        }
        ++attempts;
    }

    public void resetFail(){
        attempts = 0;
        status = CheckStatus.INCOMPLETE;
    }
}
