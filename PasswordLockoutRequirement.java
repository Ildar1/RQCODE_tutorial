public class PasswordLockoutRequirement extends Requirement{
    private String _username;
    private int _attempts;
    private CheckStatus _status;


    public PasswordLockoutRequirement(String username){
        this._username = username;
        this._attempts = 0;
        this._status = CheckStatus.INCOMPLETE;
    }

    public void recordFailedAttempt(){
        if (_attempts < 5){_attempts++;}
        else {
            _status = CheckStatus.FAIL;
            System.out.println("Too many attempts.");
        }
    }

    public void resetFailedAttempts(){
        _attempts = 0;
        _status = CheckStatus.INCOMPLETE;
    }

    @Override
    public CheckStatus check() {

        return _status;
    }
}
