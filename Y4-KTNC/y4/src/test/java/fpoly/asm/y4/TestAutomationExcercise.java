package fpoly.asm.y4;



import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;



public class TestAutomationExcercise {
    WebDriver driver;
    String baseUrl = "https://automationexercise.com";
    String email = "test" + UUID.randomUUID().toString().substring(0, 5) + "@mail.com";
    String password = "Test1234";

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testRegister() throws InterruptedException {
        driver.get(baseUrl);
        Thread.sleep(2000);
        driver.findElement(By.linkText("Signup / Login")).click();

        Thread.sleep(2000);
        driver.findElement(By.name("name")).sendKeys("Thinh Test");
        driver.findElement(By.cssSelector("input[data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.xpath("//button[text()='Signup']")).click();

        Thread.sleep(2000);
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("days")).sendKeys("1");
        driver.findElement(By.id("months")).sendKeys("January");
        driver.findElement(By.id("years")).sendKeys("2000");
        driver.findElement(By.id("first_name")).sendKeys("Pham");
        driver.findElement(By.id("last_name")).sendKeys("Thinh");
        driver.findElement(By.id("company")).sendKeys("ABC");
        driver.findElement(By.id("address1")).sendKeys("Sài gòn");
        driver.findElement(By.id("address2")).sendKeys("Đồng Tháp");
        Select countrySelect = new Select(driver.findElement(By.id("country")));
        countrySelect.selectByVisibleText("United States");
        driver.findElement(By.id("state")).sendKeys("California");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zipcode")).sendKeys("90001");
        driver.findElement(By.id("mobile_number")).sendKeys("1234567890");

        WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));
((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);
Thread.sleep(500); 
button.click();

        
        Thread.sleep(2000);
        WebElement successMsg = driver.findElement(By.xpath("//b[text()='Account Created!']"));
        Assert.assertTrue(successMsg.isDisplayed());

        Thread.sleep(1000);
        driver.findElement(By.linkText("Continue")).click();
    }

    @Test(priority = 2)
    public void testLogin() throws InterruptedException {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("a[href='/logout']")).click();

        Thread.sleep(2000);
        driver.findElement(By.linkText("Signup / Login")).click();

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(email);
        driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        Thread.sleep(2000);
        WebElement loggedIn = driver.findElement(By.xpath("//a[contains(text(),'Logged in as')]"));
        Assert.assertTrue(loggedIn.isDisplayed());
    }

    @Test(priority = 3)
    public void testAddToCartAndRemove() throws InterruptedException {
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/products']")).click();

        Thread.sleep(3000);
        WebElement button1 = driver.findElement(By.xpath("(//a[text()='Add to cart'])[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button1);
        Thread.sleep(500);
        button1.click();
        

        Thread.sleep(2000);
        WebElement viewCartInModal = driver.findElement(By.cssSelector("#cartModal a[href='/view_cart']"));
        viewCartInModal.click();

        Thread.sleep(2000);
        WebElement cartItem = driver.findElement(By.className("cart_description"));
        Assert.assertTrue(cartItem.isDisplayed());

        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

        driver.findElement(By.className("cart_quantity_delete")).click();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
