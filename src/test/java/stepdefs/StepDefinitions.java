package stepdefs;

import java.lang.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by aanca on 21/01/2018.
 */

public class StepDefinitions {
    WebDriver driver = new ChromeDriver();

    @Given("^I am on the Home page$")
    public void navigateToHomePage() {
        driver.get("https://uk.rs-online.com");
    }

    @When("^I click on 'New products' link$")
    public void clickNewProductsLink() {
        driver.findElement(By.xpath("//a[contains(text(), 'New Products')]")).click();
    }

    @When("^I click on a product from the list$")
    public void i_click_on_a_product_from_the_list() {
        driver.findElement(By.xpath("//*[@id=\"featprd-id-1\"]/div/div[1]/div/div[1]/div/h2/a")).click();
    }

    @When("^I click on Add to basket after checking stock levels$")
    public void clickAddToBasketAfterStockLevelCheck() {
        driver.findElement(By.xpath("//*[contains(@id,'addToOrder')]")).click();
        driver.findElement(By.xpath("//*[contains(@id,'rtqLinkTop')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.xpath("//*[contains(@id,'rtqCheckButton')]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.xpath("//*[@id=\"rtqCheckerForm:addToOrder3\"]")).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.xpath("//*[@id=\"rtqCheckerForm:AddedToCartInlineMsgPanel\"]/span/a/span")).click();

    }
    @Then("^I should see Clear All products and Update buttons$")
    public void verifyClearAllAndUpdateButtons() {
        WebElement clearBasket = driver.findElement(By.xpath("//*[@id=\"clearBasketButton\"]"));
        Assert.assertTrue(clearBasket.isDisplayed());
    }

    @Then("^I Should see Checkout securely button$")
    public void verifyCheckoutSecurelyButton() {
        WebElement clearBasket = driver.findElement(By.xpath("//*[@id=\"checkoutSecurelyAndPuchBtn\"]"));
        Assert.assertTrue(clearBasket.isDisplayed());
    }

    @Then("^I Should see My basket form$")
    public void verifyMyBasketForm() {
        WebElement clearBasket = driver.findElement(By.xpath("//*[@id=\"shoppingBasketForm\"]"));
        Assert.assertTrue(clearBasket.isDisplayed());
    }

    @When("^I click on 'Our Brands' link$")
    public void clickOurBrandsLink() {
        driver.findElement(By.xpath("//a[contains(text(), 'Our Brands')]")).click();

    }

    @When("^I select a brand from the list$")
    public void selectBrandt() {
        driver.findElement(By.xpath("//a[@class='sprite sprite-brand-0']")).click();
    }

    @When("^I select a popular category$")
    public void selectProductCateogry() {
        driver.findElement(By.xpath("//*[@id=\"galleryPopularCategory\"]/li[1]/a")).click();

    }

    @When("^I select a product from the list and add it to basket$")
    public void selectProduct() {
        driver.findElement(By.xpath("//*[@id=\"atbBtn-1\"]")).click();
    }

    @When("^I click on View basket link$")
    public void clickViewBasketLink() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        driver.findElement(By.xpath("(//i[@class='icon-cart'])[2]")).click();

    }

    @When("^I click on Clear all products link$")
    public void clickClearAllProducts() {
        driver.findElement(By.xpath("//*[@id=\"clearBasketButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"confirmDeleteContinue\"]")).click();
    }

    @Then("^My Basket Should Be Empty$")
    public void verifyBasketIsEmpty() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        WebElement clearBasket = driver.findElement(By.xpath("//*[contains(text(),'You do not have any products in your basket')]"));
        Assert.assertTrue(clearBasket.isDisplayed());
    }

    @When("^I search for a product by brand$")
    public void searchForProductByBrand() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
        searchBox.sendKeys("ABB");
        driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();
    }


    @When("^I search for a product by Mfr\\. Part No\\.$")
    public void searchForProductByMfrPartNo() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
        searchBox.sendKeys("14003104");
        driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();

    }

    @When("^I search for a product by RS Stock No\\.$")
    public void searchForProductByRsStockNo() {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"searchTerm\"]"));
        searchBox.sendKeys("532-6852");
        driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();

    }

    @Then("^Products from the specified brand should be retrieved$")
    public void verifySearchResults() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        WebElement searchResults = driver.findElement(By.xpath("//*[@id=\"galleryPopularCategory\"]/li"));
        Assert.assertTrue(searchResults.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"galleryPopularCategory\"]/li[1]/a")).click();
        WebElement productBrand = driver.findElement(By.xpath("//a[contains(text(), 'ABB')]"));
        Assert.assertTrue(productBrand.isDisplayed());
    }

    @Then("^Product Details Page With The Specified Mfr\\. Part No\\. Should Be Opened$")
    public void verifiedDetailsPageForProductWithTheSpecifiedMfrPartNo() {
        WebElement rsStockNo = driver.findElement(By.xpath("//span[contains(text(), '532-6852')]"));
        WebElement productImage = driver.findElement(By.xpath("//*[@id=\"mainImage\"]"));
        Assert.assertTrue(rsStockNo.isDisplayed());
        Assert.assertTrue(productImage.isDisplayed());
    }

    @Then("^Product Details Page With The Specified RS Stock No\\. Should Be Opened$")
    public void verifiedDetailsPageForProductWithTheSpecifiedRsStockNo() {
        WebElement mfrPartNo = driver.findElement(By.xpath("//span[contains(text(), '14003104')]"));
        Assert.assertTrue(mfrPartNo.isDisplayed());
        WebElement productImage = driver.findElement(By.xpath("//*[@id=\"mainImage\"]"));
        Assert.assertTrue(productImage.isDisplayed());
    }

    public void closeBrowser(){
        driver.close();
    }
}