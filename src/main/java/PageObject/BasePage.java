package PageObject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public abstract class BasePage {
    protected final AppiumDriver driver;
    protected enum Swipe_directions {
        TOP, BOTTOM, LEFT, RIGHT
    }
    public BasePage(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public MobileElement findElementWithTimeout(By by, int timeOutInSeconds) {
        return (MobileElement)(new WebDriverWait(driver, timeOutInSeconds)).until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitForElement(MobileElement element){
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElements(List<MobileElement> elements){
        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.visibilityOfAllElements(castMobileElementsToWebElements(elements)));
    }

    /**
     * Wrap WebElement in MobileElement *
     */
    private static List<MobileElement> castWebElementToMobileElement(List<WebElement> elements) {
        List list = new ArrayList(elements.size());
        for (WebElement element : elements) {
            list.add((MobileElement)element);
        }

        return list;
    }

    /**
     * Wrap List<MobileElement> in List<WebElement>
     */
    private static List<WebElement> castMobileElementsToWebElements(List<MobileElement> elements) {
        List list = new ArrayList(elements.size());
        for (MobileElement element : elements) {
            list.add((WebElement)element);
        }
        return list;
    }

    protected void takeScreenShot(){
        driver.getScreenshotAs(OutputType.BASE64);
    }
    private void back(){driver.navigate().back();}

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void swipe(Swipe_directions direction) throws IllegalArgumentException {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        switch(direction) {
            case TOP:
                driver.swipe(width / 4, (height * 20 / 100), width / 4,
                        (height * 80 / 100), 1000);
                break;
            case BOTTOM:
                driver.swipe(width / 4, (height * 80 / 100), width / 4,
                        (height * 20 / 100), 1000);
                break;
            case RIGHT:
                driver.swipe((width * 80 / 100), height / 4, (width * 20 / 100),
                        height / 4, 1000);
                break;
            case LEFT:
                driver.swipe((width * 20 / 100), height / 4, (width * 80 / 100),
                        height / 4, 1000);
                break;
            default:
                throw new IllegalArgumentException("Incorrect swipe direction");
        }
    }

    public String returnText(MobileElement element) {
        waitForElement(element);
        return element.getAttribute("text");
    }

    public void pressKey(int androidKeyCode) {
        try {
            AndroidDriver androidDriver = (AndroidDriver) driver;
            androidDriver.pressKeyCode(androidKeyCode);
            System.out.println("Key " + androidKeyCode + " clicked");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
