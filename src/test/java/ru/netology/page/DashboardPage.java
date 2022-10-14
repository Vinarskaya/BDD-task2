package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.CollectionElement;
import lombok.val;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement personalPage = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item div");
    private ElementsCollection buttons = $$(".list__item div button");
    private SelenideElement updateButton = $("[data-test-id=action-reload] .button__text");

    public DashboardPage() {
    }

    public RechargeCardPage RechargeFirstCard() {
        buttons.first().click();
        return new RechargeCardPage();
    }

    public DashboardPage UpdateInfo() {
        updateButton.click();
        return new DashboardPage();
    }

    public void checkBalanceOfFirstCard(String amount) {
        UpdateInfo();
        cards.first().shouldHave(Condition.text(amount));
    }

    public void verifyIsDashboardPage() {
        personalPage.shouldBe(Condition.visible);
    }
}
