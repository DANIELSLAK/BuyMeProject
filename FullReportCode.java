import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FullReportCode {
    private static ChromeDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    @BeforeClass
    public static void beforeClass(Object INFO, String CHROMEDRIVER_PATH, Object FAIL, Object PASS) throws Exception {
        String cwd = System.getProperty("user.dir");
        extent = new ExtentReports();
        test = extent.createTest("MyFirstTest", "Sample description");
        test.log((Status) INFO, "@Before class");

        try {
            System.setProperty("webdriver.chrome.driver", CHROMEDRIVER_PATH);
            driver = new ChromeDriver();
            Object Satus = null;
            test.log((Status) PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log((Status) FAIL, "Driver connection failed!" + e.getMessage());
            throw new Exception("Driver failed");
        }

        driver.get("https://www.buyme.co.il");
    }

    @Test
    public void numberExceptionTest(Object FAIL) {
        try {
            int a = 1 / 0;
        } catch (ArithmeticException e) {
            test.log((Status) FAIL, "numberException" + e.getMessage());
        }
    }

    @AfterClass
    public static void afterClass(Object INFO) {
        test.log((Status) INFO, "@After test" + "After test method");
        driver.quit();
        extent.flush();

    }


    static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return ImagesPath + ".png";
    }
}

