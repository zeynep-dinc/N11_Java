package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.time.Duration.ofSeconds;

public class ActionList extends Mesajlar implements IActionList {
    protected WebDriver driver = base.Driver.getDriver();

    protected WebDriverWait driverWait = new WebDriverWait(driver, ofSeconds(10));
    protected Actions actions = new Actions(driver);

    public void waitFor(int second){
        try {
            Thread.sleep(second*1000L);
        }
        catch (Exception ex)
        {
            ex.getMessage();
        }
    }

    @Override
    public void elementToBeClickable(WebElement clickElement) {
        try {
            if(clickElement.isDisplayed()) {
                driverWait.until(ExpectedConditions.elementToBeClickable(clickElement));
                clickElement.click();
                postiveMessages(clickElement.toString(), "tıklama");
                waitFor(1);
            }
            else{
                negativeMessages("The element isn't display",clickElement.toString(),"There isn't element.");
            }
        } catch (TimeoutException timeoutException) {
            negativeMessages("Time Out", clickElement.toString(), " tıklama için 10 saniye beklendi.\n" + timeoutException.getMessage());
        } catch (NoSuchElementException noSuchElementException) {
            negativeMessages("No Such Element", clickElement.toString(), noSuchElementException.getMessage());
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            negativeMessages("Element Click Intercepted ", clickElement.toString(), elementClickInterceptedException.getMessage());
        } catch (Exception exception) {
            negativeMessages("Belirsiz", clickElement.toString(), exception.getMessage());
        }
    }

    @Override
    public void sendKeysFunction(WebElement sendKeysElement, String value) {
        try {
            elementToBeClickable(sendKeysElement);
            driverWait.until(ExpectedConditions.visibilityOf(sendKeysElement));
            sendKeysElement.clear();
            sendKeysElement.sendKeys(value);
            postiveMessages(sendKeysElement.toString(), value + " değerini yazma");
            waitFor(1);
        } catch (TimeoutException timeoutException) {
            negativeMessages("Time Out", sendKeysElement.toString(), " tıklama için 10 saniye beklendi.\n" + timeoutException.getMessage());
        } catch (NoSuchElementException noSuchElementException) {
            negativeMessages("No Such Element", sendKeysElement.toString(), noSuchElementException.getMessage());
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            negativeMessages("Element Click Intercepted ", sendKeysElement.toString(), elementClickInterceptedException.getMessage());
        } catch (Exception exception) {
            negativeMessages("Belirsiz", sendKeysElement.toString(), exception.getMessage());
        }
    }

    @Override
    public void sendKeysWithActionMethod(Keys keys) {
        try {
            actions.sendKeys(keys).build().perform();
            postiveMessages(keys.toString(), "tuşuna basma");
            waitFor(1);
        } catch (Exception ex) {
            negativeMessages("Belirsiz",keys.toString(),ex.getMessage());
        }
    }


    @Override
    public void selectFromSelectBox(WebElement selectBoxElement, String optionValue) {
        try {
            waitFor(2);
            elementToBeClickable(selectBoxElement);
            waitFor(2);
            WebElement optionValueTextElement = driver.findElement(By.xpath("//option[contains(text(),'" + optionValue + "')]"));
            waitFor(2);
            elementToBeClickable(optionValueTextElement);
            waitFor(2);
            postiveMessages(selectBoxElement.toString(), selectBoxElement.getText() + " listesinde " + optionValue + " elementini seçme");
        } catch (TimeoutException timeoutException) {
            negativeMessages("Time Out", selectBoxElement.toString(), " tıklama için 10 saniye beklendi.\n" + timeoutException.getMessage());
        } catch (NoSuchElementException noSuchElementException) {
            negativeMessages("No Such Element", selectBoxElement.toString(), noSuchElementException.getMessage());
        } catch (ElementClickInterceptedException elementClickInterceptedException) {
            negativeMessages("Element Click Intercepted ", selectBoxElement.toString(), elementClickInterceptedException.getMessage());
        } catch (Exception exception) {
            negativeMessages("Belirsiz", selectBoxElement.toString(), exception.getMessage());
        }
    }


    @Override
    public final void screenShot() {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
            FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/assertion_screen/"+myDateObj.format(myFormatObj)+".png"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void elementDisplayControl(WebElement element){
        try {
            if(element.isDisplayed()){
                postiveMessages(element.toString()," display");
            }
        }catch (TimeoutException timeoutException) {
            negativeMessages("Time Out", element.toString(), " tıklama için 10 saniye beklendi.\n" + timeoutException.getMessage());
        } catch (NoSuchElementException noSuchElementException) {
            negativeMessages("No Such Element", element.toString(), noSuchElementException.getMessage());
        } catch (Exception exception) {
            negativeMessages("Belirsiz", element.toString(), exception.getMessage());
        }
    }

    public void elementTextControl(WebElement element,String text){
        try {
            Assert.assertTrue(element.getText().contains(text));
        }catch (TimeoutException timeoutException) {
            negativeMessages("Time Out", element.toString(), " tıklama için 10 saniye beklendi.\n" + timeoutException.getMessage());
        } catch (NoSuchElementException noSuchElementException) {
            negativeMessages("No Such Element", element.toString(), noSuchElementException.getMessage());
        } catch (Exception exception) {
            negativeMessages("Belirsiz", element.toString(), exception.getMessage());
        }
    }

}
