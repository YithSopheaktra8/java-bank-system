import atm.ATMFeatures;
import atm.BankATM;
import card.Card;
import card.CreditCard;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        ATMFeatures bankATM = new BankATM();
        Card card = new CreditCard();
        bankATM.boot("admin","password");
        card.setPin(1234);
        card.setIssueAt(LocalDate.now());
        card.setThruAt(card.getIssueAt().plusYears(2));
        card.setLimitExpense(100);

        bankATM.plugInCard(card);
        bankATM.doDeposit();



    }
}
