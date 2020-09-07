package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class MainPage extends Base{




	public MainPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="android:id/text1")
	WebElement country;

	@FindBy(id="com.androidsample.generalstore:id/nameField")
	WebElement name;

	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	WebElement gender;
	
	@FindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	WebElement letsShop;
	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	WebElement cart;


	public void Selectcountry(String str){
		country.click();
		boolean condition = true;
		while(condition == true) {

			List<MobileElement> list = driver.findElements(By.className("android.widget.TextView"));


			for(int i=0; i<list.size(); i++) {

				if(list.get(i).getText().contains("str")) {

					list.get(i).click();
					condition=false;
					break;
				}

			}
			scroll(driver, 0.5, 0.8, 0.5, 0.2);
		}
	}
	public static void scroll(AppiumDriver<MobileElement>driver, double start_xd, double start_yd, double end_xd,double end_yd) {
		Dimension dim=driver.manage().window().getSize();
		int start_x= (int) (dim.width*start_xd);
		int start_y=(int) (dim.height*start_yd);

		int end_x= (int) (dim.width*end_xd);
		int end_y=(int) (dim.height*end_yd);

		TouchAction touch=new TouchAction(driver);
		touch.press(PointOption.point(start_x, start_y))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(end_x, end_y)).release().perform();

	}




	public void name(String nam){
		name.sendKeys(nam);
	}

	public void gender(){
		gender.click();
	}
	public void letsShop(){
		letsShop.click();
	}
	
	public void Addproduct() {
		List<MobileElement> products= driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
	      
		products.get(0).click();
		products.get(1).click();
		
	}
	
	public void cart(){
		cart.click();
	}
	
	public double SumOfPrice() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);
	
		List<WebElement> price=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.androidsample.generalstore:id/productPrice")));
		double sum=0;
		for(int i=0; i<price.size();i++) {

		String productprice=price.get(i).getText().substring(1).trim();
		
		sum=sum+Double.parseDouble(productprice);
		}
		return sum;
	}
	public double totalPrice() {
		String total=  driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1).trim();
	
	return Double.parseDouble(total);
	}
}
