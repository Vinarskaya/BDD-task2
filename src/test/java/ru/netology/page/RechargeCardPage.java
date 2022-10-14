package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RechargeCardPage {
    private SelenideElement amountField = $("[data-test-id=amount] .input__inner");
    private SelenideElement fromField = $("[data-test-id=from] .input__control");
    private SelenideElement actionTransferButton = $("[data-test-id=action-transfer] .button__content");

    public DashboardPage transferMoneyToFirstCard(int amount, int cardNumber) {
        amountField.setValue(String.valueOf(amount));
        fromField.setValue(String.valueOf(cardNumber));
        actionTransferButton.click();
        return new DashboardPage();
    }
}

