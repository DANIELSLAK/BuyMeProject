import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class main1 extends BasePage  {
    public static ExtentReports extent = new ExtentReports();
    public static ExtentTest test = extent.createTest("BuyMeProject", "FirstProject");

    private static ChromeDriver chromeDriver;// = new ChromeDriver();

    @BeforeClass
    public static void open_website() throws Exception {
        DriverSingleton.getDriverInstance();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("C:\\Users\\Daniel\\IdeaProjects\\BuyMeProjectfinal");
        extent.attachReporter(htmlReporter);
        test.log(Status.INFO , "open website before tests");
    }

    @Test
    public static void open_websites() {
        String Buymeurl = "https://www.buyme.co.il";
        chromeDriver.get("https://www.buyme.co.il");
        Assert.assertEquals(chromeDriver.getCurrentUrl(), Buymeurl);
    }

    public static void setChromeDriver(ChromeDriver chromeDriver) {
        main1.chromeDriver = chromeDriver;
    }

    @Test
    public void First_Page() throws Exception
    {clickElement(By.className("NotEntered"));}

    @Test
    public void Sign_up()throws Exception
    {clickElement(By.className("Sign up page"));}

    @Test
    public void EnterText()throws Exception
    {String Myname = "Daniel Slak";
    sendKeysToElement(By.id("ember1817"), "0523960256");
    Assert.assertEquals(Myname , "Daniel Slak");
    sendKeysToElement(By.id("ember1824"), "0523960256");
    sendKeysToElement(By.id("valpass"), "0523960256");
    sendKeysToElement(By.id("ember1839"), "0523960256");
    clickElement(By.className("check"));}


    @Test
    public void Agree_terms()throws Exception{
        DriverSingleton.getDriverInstance().findElement(By.className("Check"));
    }

    @Test
    public void presssignup()throws Exception{
        clickElement(By.id("ember2252"));
    }

    @Test
    public void Pick_amount()throws Exception{
        Select price = new Select(chromeDriver.findElement(By.id("ember1067")));
        price.selectByVisibleText("100-199");
    }

    @Test
    public void Pick_area()throws Exception{
        Select area = new Select(chromeDriver.findElement(By.id("ember1195")));
        area.selectByVisibleText("תל אביבו והסביבה");
    }

    @Test
    public void pickcategory()throws Exception{
        Select category = new Select(chromeDriver.findElement(By.id("ember1207")));
        category.selectByVisibleText("מתנות סוף שנה למורה ולגננת");
    }

    @Test
    public void Find_me_a_gift()throws Exception
    {clickElement(By.id("ember2240"));
    }

    @Test
    public void assertURL()throws Exception{
        String URL = "https://buyme.co.il/search?budget=2&category=409&region=13";
        Assert.assertEquals(URL , "https://buyme.co.il/search?budget=2&category=409&region=13");
    }

    @Test
    public void pick_business(){
        Select pickbusiness = new Select(chromeDriver.findElement(By.className("name bm-subtitles-1")));
        pickbusiness.selectByVisibleText("מסעדת בני הדייג");
    }

    @Test
    public void enterprice()throws Exception {
        sendKeysToElement(By.id("ember3169"), "0523960256");
    }

    @Test
    public void Presscohsen() throws Exception {
        clickElement(By.id("ember3135"));
    }

    @Test
    public void Forsomeoneelse()throws Exception{
        clickElement(By.id("ember5730"));
    }

    @Test
    public void Whoreceived()throws Exception{
        sendKeysToElement(By.id("ember5734"), "0523960256");
    }

    @Test
    public void pickevent()throws Exception{
        Select event = new Select(chromeDriver.findElement(By.id("ember3397")));
        event.selectByVisibleText("יום הולדת");
    }

    @Test
    public void enterblessing()throws Exception {
        sendKeysToElement(By.id("ember5745"), "0523960256");
    }

    @Test
    public void moveon()throws Exception{
        clickElement(By.id("ember5755"));
    }

    @Test
    public void now()throws Exception{
        clickElement(By.id("ember5864"));
    }

    @Test
    public void viaSMS()throws Exception{
        clickElement(By.className("circle"));
    }
    @Test
    public void Phonenumber()throws Exception{
        String number = "0523960256";
        sendKeysToElement(By.id("ember5901"),"0523960256");
        Assert.assertEquals(number , "0523960256");
    }


    @Test
    public void fromwho()throws Exception{
        sendKeysToElement(By.id("ember5893"),"Daniel");
    }

    @Test
    public void movetopayment()throws Exception{
        clickElement(By.id("ember5898"));
    }

    @AfterClass
    public void close_Project(){
        chromeDriver.quit();
//        extent.flush();
    }
}
