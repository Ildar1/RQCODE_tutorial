
import rqcode.concepts.Requirement;

import java.time.LocalDate;
import java.time.Period;


public class PasswordUpdate extends Requirement {

    private LocalDate lastPasswordUpdateDate;

    public void PasswordUpdateEveryYear(LocalDate lastPasswordUpdateDate) {
        this.lastPasswordUpdateDate = lastPasswordUpdateDate;
    }

    public PasswordUpdate(LocalDate lastPasswordUpdateDate) {
        this.lastPasswordUpdateDate = lastPasswordUpdateDate;
    }

    @Override
    public CheckStatus check() {
        if (passwordLastUpdatedMoreThanOneYearAgo()) {
            return CheckStatus.FAIL;
        }
        return CheckStatus.PASS;
    }

    private boolean passwordLastUpdatedMoreThanOneYearAgo() {
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(lastPasswordUpdateDate, currentDate);
        return period.getYears() >= 1;
    }
}
