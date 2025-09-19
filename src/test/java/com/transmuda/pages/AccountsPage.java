package com.transmuda.pages;

import com.transmuda.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class AccountsPage extends BasePage {

    public AccountsPage() { PageFactory.initElements(Driver.getDriver(), this); }

    // ===== Menü =====
    @FindBy(xpath = "//span[normalize-space()='Customers' or normalize-space()='Müşteriler']")
    public WebElement customersMenu;

    @FindBy(xpath = "//span[normalize-space()='Accounts' or normalize-space()='Hesaplar']")
    public WebElement accountsSubmenu;

    // ===== Filters butonu: GLOBAL (toolbar’a bağlı değil)
    @FindBy(css = "a[title='Filters'], a[data-original-title='Filters'], a[aria-label='Filters']")
    public WebElement filtersButton;

    private final WebDriverWait shortWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(6));
    private final JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    private void waitLoaderGone() {
        By loader = By.cssSelector("div.loader-mask.shown");
        try {
            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(8))
                    .until(d -> d.findElements(loader).isEmpty());
        } catch (Exception ignored) {}
    }

    /** Customers → Accounts geçişi */
    public void goToAccounts() {
        waitLoaderGone();
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(customersMenu)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", customersMenu);
        }
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(accountsSubmenu)).click();
        } catch (Exception e) {
            try { new Actions(Driver.getDriver()).moveToElement(customersMenu).pause(Duration.ofMillis(150)).perform(); }
            catch (Exception ignored) {}
            js.executeScript("arguments[0].click();", accountsSubmenu);
        }
        waitLoaderGone();
        shortWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("body")));
        try { js.executeScript("window.scrollTo(0,0);"); } catch (Exception ignored) {}
    }

    // ===== ÜST BAR (Manage filters şeridi) için kesin lokatörler =====
    private static final By TOP_FILTER_BAR = By.xpath(
            "//*[contains(@class,'filter') and contains(@class,'clearfix')][.//text()[contains(.,'Manage filters')]]"
    );

    // Bar içindeki chip’ler (':' içerenler)
    private static final By BAR_CHIPS_REL = By.xpath(
            ".//*[self::a or self::button or self::span or self::*[contains(@class,'dropdown')]]" +
                    "[contains(normalize-space(.),':')]"
    );

    /** Filters kapalıysa 'pressed' olana kadar aç (idempotent) */
    private void ensureFiltersOpen() {
        try { js.executeScript("window.scrollTo(0,0);"); } catch (Exception ignored) {}
        try {
            String cls = filtersButton.getAttribute("class");
            if (cls != null && cls.contains("pressed")) return;
        } catch (Exception ignored) {}
        try {
            shortWait.until(ExpectedConditions.elementToBeClickable(filtersButton)).click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", filtersButton);
        }
        try {
            shortWait.until(ExpectedConditions.attributeContains(filtersButton, "class", "pressed"));
        } catch (Exception ignored) {}
    }

    /** Şeritte “Manage filters” geçen barı bul (gerekiyorsa fallback ile bekleyerek) */
    private WebElement locateTopBar() {
        try { js.executeScript("window.scrollTo(0,0);"); } catch (Exception ignored) {}
        try {
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(TOP_FILTER_BAR));
        } catch (TimeoutException e) {
            // bazen geç render → filtreyi açıp tekrar dene
            ensureFiltersOpen();
            return shortWait.until(ExpectedConditions.visibilityOfElementLocated(TOP_FILTER_BAR));
        }
    }

    /** Üst şeritten filtre isimlerini oku (en doğru ve hızlı yol) */
    public List<String> getFilterNamesSmart() {
        ensureFiltersOpen();
        WebElement bar = locateTopBar();

        List<WebElement> chips = bar.findElements(BAR_CHIPS_REL);

        LinkedHashSet<String> names = new LinkedHashSet<>();
        for (WebElement chip : chips) {
            String t = chip.getText();
            if (t == null || t.isBlank()) t = chip.getAttribute("title");
            if (t == null || t.isBlank()) continue;

            t = t.replace('\n',' ').replaceAll("\\s+"," ").trim();
            if (t.toLowerCase().contains("manage filters")) continue; // butonun kendisi değil
            int i = t.indexOf(':');
            if (i <= 0) continue; // ": All" vb. yok say
            String name = t.substring(0,i).trim();
            if (!name.isEmpty()) names.add(name);
        }
        return new ArrayList<>(names); // sıra korunur, tekrarlar elenir
    }
}
