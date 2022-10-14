package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement personalPage = $("[data-test-id=dashboard]");
    private final ElementsCollection cards = $$(".list__item div");
    private final ElementsCollection buttons = $$(".list__item div button");
    private final SelenideElement updateButton = $("[data-test-id=action-reload] .button__text");

    public DashboardPage() {
    }

    public RechargeCardPage RechargeFirstCard() {
        buttons.first().click();
        return new RechargeCardPage();
    }

    public void UpdateInfo() {
        updateButton.click();
        new DashboardPage();
    }

    public void checkBalanceOfFirstCard(String amount) {
        UpdateInfo();
        cards.first().shouldHave(Condition.text(amount));
    }

    public void verifyIsDashboardPage() {
        personalPage.shouldBe(Condition.visible);
    }
}
