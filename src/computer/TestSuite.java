package computer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Createthepackagenamecomputer 1. Create class “TestSuite”
 * Write the following Test: 1.Test name verifyProductArrangeInAlphaBaticalOrder()
 * 1.1 Click on Computer Menu. 1.2 Click on Desktop 1.3 Select Sort By position "Name: Z to A"
 * 1.4 Verify the Product will arrange in Descending order.
 * 2. Test name verifyProductAddedToShoppingCartSuccessFully() 2.1 Click on Computer Menu.
 * 2.2 Click on Desktop 2.3 Select Sort By position "Name: A to Z" 2.4 Click on "Add To Cart"
 * 2.5 Verify the Text "Build your own computer" 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
 * 2.7.Select "8GB [+$60.00]" using Select class. 2.8 Select HDD radio "400 GB [+$100.00]"
 * 2.9 Select OS radio "Vista Premium [+$60.00]" 2.10 Check Two Check boxes "Microsoft Office [+$50.00]"
 * and "Total Commander [+$5.00]"
 * 2.11 Verify the price "$1,475.00" 2.12 Click on "ADD TO CARD" Button.
 * 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After
 * that close the bar clicking on the cross button. 2.14 Then MouseHover on "Shopping cart" and Click
 * on "GO TO CART" button. 2.15 Verify the message "Shopping cart"
 * 2.16 Change the Qty to "2" and Click on "Update shopping cart" 2.17 Verify the Total"$2,950.00"
 * 2.18 click on checkbox “I agree with the terms of service” 2.19 Click on “CHECKOUT”
 * 2.20 Verify the Text “Welcome, Please Sign In!” 2.21Click on “CHECKOUT AS GUEST” Tab
 * 2.22 Fill the all mandatory field 2.23 Click on “CONTINUE” 2.24 Click on Radio Button “Next Day Air($0.00)”
 * 2.25 Click on “CONTINUE” 2.26 Select Radio Button “Credit Card”
 * <p>
 * 2.27 Select “Master card” From Select credit card dropdown 2.28 Fill all the details
 * 2.29 Click on “CONTINUE” 2.30 Verify “Payment Method” is “Credit Card”
 * 2.32 Verify “Shipping Method” is “Next Day Air” 2.33 Verify Total is “$2,950.00” 2.34 Click on “CONFIRM”
 * 2.35 Verify the Text “Thank You” 2.36 Verify the message “Your order has been successfully processed!”
 * 2.37 Click on “CONTINUE” 2.37 Verify the text “Welcome to our store”
 */
public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    //Before annotation run in the beginning of each tests
    @Before
    //Browser set-up method
    public void setUp() {
        openBrowser(baseUrl);
    }

    //After annotation method run at the end of each tests
    @After
    //Browser closing method
    public void tearDown() {
        closeBrowser();
    }

    //Test annotation to execute method
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        mouseHover(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2 Click on desktop
        mouseHoverAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");
        //1.4 Verify the Product will arrange in Descending order.
        verifyElements("error", "Name: Z to A", By.xpath("//select[@id='products-orderby']/option[text()='Name: Z to A']"));
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu.
        clickOnElement(By.xpath("//a[@href='/computers']"));
        //2.2 Click on Desktop
        clickOnElement(By.xpath("//img[@alt='Picture for category Desktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.name("products-orderby"), "Name: A to Z");
        //2.4 Click on "Add To Cart"
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@type='button' and  @class='button-2 product-box-add-to-cart-button']"));
        //2.5 Verify the Text "Build your own computer"
        verifyElements("messged not displayed", "Build your own computer", By.xpath("//h1[contains(text(),'Build your own computer')]"));
        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByVisibleTextFromDropDown(By.id("product_attribute_1"), "2.2 GHz Intel Pentium Dual-Core E2200");
        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByVisibleTextFromDropDown(By.id("product_attribute_2"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));
        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander//[+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        verifyElements("error", "$1,475.00", By.id("price-value-1"));
        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        verifyElements("error", "The product has been added to your shopping cart", By.xpath("//p[@class='content']"));
        //close popup
        clickOnElement(By.xpath("//span[@title='Close']"));
        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[@class='cart-label']"));
        //2.15 Verify the message "Shopping cart"
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        Thread.sleep(2000);
        //2.15 Verify the message "Shopping cart"
        verifyElements("error", "Shopping cart", By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(2000);
        //2.16 Change the Qty to "2" and
        clearAndSendTextToElement(By.className("qty-input"), "2");
        Thread.sleep(2000);
        //Click on "Update shopping cart"
        clickOnElement(By.id("updatecart"));
        //2.17 Verify the Total"$2,950.00"
        verifyElements("error", "$2,950.00", By.xpath("//span[@class='value-summary']//strong[text()='$2,950.00']"));
        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // 2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));
        //2.20 Verify the Text “Welcome, Please Sign In!”
        verifyElements("error", "Welcome, Please Sign In!", By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));
        //2.22 Fill the all mandatory field
        sendTextToElement(By.id("BillingNewAddress_FirstName"), "MEGHA");
        sendTextToElement(By.id("BillingNewAddress_LastName"), "VIJ");
        sendTextToElement(By.id("BillingNewAddress_Email"), "megha123@gmail.com");
        sendTextToElement(By.id("BillingNewAddress_Company"), "ABC");
        selectByVisibleTextFromDropDown(By.id("BillingNewAddress_CountryId"), "United Kingdom");
        sendTextToElement(By.id("BillingNewAddress_City"), "London");
        sendTextToElement(By.id("BillingNewAddress_Address1"), "Lewes road");
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "N129nh");
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "+447782839999");
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));
        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.id("shippingoption_1"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));
        Thread.sleep(2000);
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        Thread.sleep(2000);
        //2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        //2.28 Fill all the details
        selectByVisibleTextFromDropDown(By.id("CreditCardType"), "Master card");
        sendTextToElement(By.id("CardholderName"), "Pari Patel");
        sendTextToElement(By.id("CardNumber"), "5431 1111 1111 1111");
        selectByVisibleTextFromDropDown(By.id("ExpireMonth"), "07");
        selectByVisibleTextFromDropDown(By.id("ExpireYear"), "2025");
        sendTextToElement(By.id("CardCode"), "544");
        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("(//button[@class='button-1 payment-info-next-step-button'])[1]"));
        //2.30 Verify “Payment Method” is “Credit Card”
        verifyElements("error", "Credit Card", By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.32 Verify “Shipping Method” is “Next Day Air”
        verifyElements("error", "Next Day Air", By.xpath("//span[contains(text(),'Next Day Air')]"));
        //2.33 Verify Total is “$2,950.00”
        verifyElements("error", "$2,950.00", By.xpath("//span[@class='value-summary']/strong[text()='$2,950.00']"));
        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        verifyElements("error", "Thank you", By.xpath("//h1[contains(text(),'Thank you')]"));
        //2.36 Verify the message “Your order has been successfully processed!”
        verifyElements("error", "Your order has been successfully processed!", By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));
        //2.37 Verify the text “Welcome to our store”
        verifyElements("error", "Welcome to our store", By.xpath("//h2[contains(text(),'Welcome to our store')]"));

    }

}
