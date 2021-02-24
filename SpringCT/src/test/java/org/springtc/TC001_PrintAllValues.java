package org.springtc;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springtc.pages.Homepage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC001_PrintAllValues extends Base {
	private String url = "http://tutorialsninja.com/demo/index.php";
	Homepage home = new Homepage();
	private String username = "sctqatest@grr.la";
	private String password = "Spring123$";

	@BeforeTest
	private void setUP() {
		InvokeBrowser();
		setUrl(this.url);

	}

	@Test
	private void loginAndGetAllValues() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.findElement(home.MyAccount).click();
		System.out.println("Clicked on My Account button Successfully!");
		driver.findElement(home.loginLabel).click();
		System.out.println("Clicked on Login button Successfully!");
		driver.findElement(home.userName).sendKeys(this.username);
		System.out.println("Entered the username '" + home.userName + "' Successfully!");
		driver.findElement(home.password).sendKeys(this.password);
		System.out.println("Entered the password '" + home.password + "' Successfully!");
		driver.findElement(home.SubmitButton).click();
		System.out.println("Clicked on Sign In button Successfully!");
		driver.findElement(home.HomeButton).click();
		System.out.println("Clicked on Home button Successfully!");
		Map<String, String> productandprice = new HashedMap<String, String>();
		List<WebElement> pName = driver.findElements(home.ProdectNames);
		List<WebElement> pPrice = driver.findElements(home.ProdectPrice);
		for (WebElement names : pName) {

			String name = names.getText();
			String price = null;
			for (WebElement ele : pPrice) {
				price = ele.getText();
			}
			productandprice.put(name, price);
		}
		for (Map.Entry<String, String> entry : productandprice.entrySet()) {
			System.out.println(entry.getKey() + "  ==>  " + entry.getValue());
		}

		driver.findElement(home.LaptopsANDnotebooks).click();
		driver.findElement(home.AllLaptopsANDnotebooks).click();
		WebElement selectSort = driver.findElement(home.SortBy);
		Select select = new Select(selectSort);
		select.selectByVisibleText("Price (High > Low)");
		driver.findElement(home.MackBookPro).click();
		String unitPrice=getText(home.UnitPrice);
		driver.findElement(home.QtyTextBox).clear();
		driver.findElement(home.QtyTextBox).sendKeys("2");
		driver.findElement(home.btnAddToCart).click();
		String text = driver.findElement(home.cartButtonOnTop).getText();

		softAssert.assertEquals(text, " 0 item(s) - $0.00",
				"Product successfully added to Cart and price is => " + text);
		click(home.cartButtonOnTop);
		
		getText(home.productNameInCart);
		softAssert.assertEquals(getText(home.productNameInCart), "MacBook Pro");
		
		softAssert.assertEquals(getText(home.productPriceInCart), " 2 item(s) - $4,000.00");
		//Quantity
		softAssert.assertEquals(getText(home.Quantitys), "x 2");
		//total price
		//	Print all values (Quantity, Unit Price, Model, Product Name, Total product cost, Total cost of Cart) on the console.
		System.out.println("**********Product Details***************");
		System.out.println("Quantity => "+getText(home.Quantitys)+"\nUnit Price => "+unitPrice+"\nProduct Name => "+getText(home.productNameInCart));
		System.out.println("Total Price =>"+getText(home.TotalPriceInCart));
		
		Assert.assertEquals(getText(home.TotalPriceInCart), "$4,000.00");

		Thread.sleep(5000);
	}

	@AfterClass
	public void EndTest() {
		driver.quit();
	}

}
