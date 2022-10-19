package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement personalPage = $("[data-test-id=dashboard]");
    private final ElementsCollection cards = $$(".list__item div");
    private final ElementsCollection buttons = $$(".list__item div button");
    private final SelenideElement updateButton = $("[data-test-id=action-reload] .button__text");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";

    public DashboardPage() {
    }

    public RechargeCardPage rechargeCardPage() {
        buttons.first().click();
        return new RechargeCardPage();
    }

    public void updateInfo() {
        updateButton.click();
    }

    public void checkBalanceOfFirstCard(String amount) {
        updateInfo();
        cards.first().shouldHave(Condition.text(amount));
    }

    public void verifyIsDashboardPage() {
        personalPage.shouldBe(Condition.visible);
    }
}
