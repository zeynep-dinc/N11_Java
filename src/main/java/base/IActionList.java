package base;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface IActionList {
    void elementToBeClickable(WebElement clickElement);
    void sendKeysFunction(WebElement sendKeyElement,String value);
    void sendKeysWithActionMethod(Keys keys);
    void screenShot();
    void selectFromSelectBox(WebElement selectElement, String optionText);
    void elementDisplayControl(WebElement element);
    void elementTextControl(WebElement element,String text);
}
