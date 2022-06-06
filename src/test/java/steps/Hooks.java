package steps;

import base.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Hooks {
    private String url = Driver.readToDriverProperties("url");
    private Scenario scenario;

    private WebDriver driver;

    @Before
    public void beforeTest(Scenario scenario) {
        driver=Driver.getDriver();
        this.scenario = scenario;
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @After
    public void afterTest(Scenario scenario){
        try {
            if(scenario.getStatus()!= Status.PASSED){
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                LocalDateTime myDateObj = LocalDateTime.now();
                System.out.println("Before formatting: " + myDateObj);
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/fail_scenario_screenshots/"+myDateObj.format(myFormatObj)+".png"), true);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
         //   driver=Driver.closeDriver();
        }
    }
}
