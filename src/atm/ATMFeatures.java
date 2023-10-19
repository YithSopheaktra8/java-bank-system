package atm;

import card.Card;

public interface ATMFeatures {
    void boot(String username, String password);
    void shutdown(String username, String password);
    void plugInCard(Card card);
    void plugOutCard();
    void doWithdraw();
    void doDeposit();
}
