package com.nextbase.pages;

import com.nextbase.utilities.BrowserUtils;
import com.nextbase.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    public DashBoardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Message')]")
    public WebElement messageTab;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageIframe;

    @FindBy(xpath = "//body")
    public WebElement messageIframeBody;

    @FindBy(xpath = "//button[@id='blog-submit-button-save']")
    public WebElement sendMessageButton;

    @FindBy(xpath = "//button[@id='blog-submit-button-cancel']")
    public WebElement cancelSendingMessageButton;

    @FindBy(xpath = "//span[contains(@id,'feed-post-more')]")
    public WebElement moreButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    public WebElement deleteMessageButton;

    @FindBy(xpath = "//span[contains(text(),'The post has been deleted.')]")
    public WebElement messageDeletedText;

    @FindBy(xpath = "//span[@title='Link']")
    public WebElement addLinkButton;

    @FindBy(xpath = "//input[contains(@placeholder,'Link text')]")
    public WebElement addLinkTextBox;

    @FindBy(xpath = "//input[contains(@placeholder,'Link URL')]")
    public WebElement addLinkURLBox;

    @FindBy(xpath = "//input[@id='undefined']")
    public WebElement saveLinkButton;



    public WebElement getSentMessage(String message) {
        try {
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[contains(@id, 'blog_post_body') and contains(.,'" + message + "')] "))));
            return Driver.getDriver().findElement(By.xpath("//div[contains(@id, 'blog_post_body') and contains(.,'" + message + "')] "));
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't find the message!");
            return null;
        }
    }

    public WebElement getSentMessage(String message, String linkText) {
        try {
            wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//div[contains(@id, 'blog_post_body') and contains(.,'" + message + "')] "))));
            return Driver.getDriver().findElement(By.xpath("//div[contains(@id, 'blog_post_body') and contains(.,'" + message + linkText + "')] "));
        } catch (StaleElementReferenceException e) {
            System.out.println("Couldn't find the message!");
            return null;
        }
    }


    public void sendMessage(String message) {
        messageTab.click();
        BrowserUtils.switchToIframe(messageIframe);
        messageIframeBody.sendKeys(message);
        BrowserUtils.switchToDefaultContent();
        sendMessageButton.click();
    }

    public void sendMessage(String message, String linkText, String linkURL) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        messageTab.click();
        BrowserUtils.switchToIframe(messageIframe);
        messageIframeBody.sendKeys(message);
        BrowserUtils.switchToDefaultContent();
        addLinkButton.click();
        wait.until(ExpectedConditions.visibilityOf(addLinkTextBox));
        addLinkTextBox.sendKeys(linkText);
        addLinkURLBox.sendKeys(linkURL);
        saveLinkButton.click();
        wait.until(ExpectedConditions.visibilityOf(sendMessageButton));
        sendMessageButton.click();
    }

    public void deleteMessage() {
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
            wait.until(ExpectedConditions.visibilityOf(moreButton));
            moreButton.click();
            deleteMessageButton.click();
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
            wait.until(ExpectedConditions.visibilityOf(messageDeletedText));

        } catch (StaleElementReferenceException e) {
            System.out.println("Stale Element Exception caught!");
        }
    }


}
