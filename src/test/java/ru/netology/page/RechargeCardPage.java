package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RechargeCardPage {
    private final SelenideElement amountField = $("[data-test-id=amount] .input__inner");
    private final SelenideElement fromField = $("[data-test-id=from] .input__control");
    private final SelenideElement actionTransferButton = $("[data-test-id=action-transfer] .button__content");

    public DashboardPage transferMoneyToFirstCard(String amount, String cardNumber) {
        amountField.setValue(amount);
        fromField.setValue(cardNumber);
        actionTransferButton.click();
        return new DashboardPage();
    }
}

