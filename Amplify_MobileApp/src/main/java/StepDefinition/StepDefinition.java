package StepDefinition;

import org.junit.Assert;

import Base.Base;
import PageObject.MainPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends Base{


	MainPage mainpage;


	
	@Given("^Launch the General-Store\\.apk in an emulator$")
	public void launch_the_General_Store_apk_in_an_emulator() throws Throwable {
		setup();
	}

	@When("^Select the country \"([^\"]*)\"$")
	public void select_the_country(String coun)  {
		mainpage=new MainPage();
		mainpage.Selectcountry(coun);
	}

	@When("^Enter  \"([^\"]*)\" in name field$")
	public void enter_in_name_field(String Name){
		mainpage=new MainPage();
		mainpage.name(Name);
	}

	@Then("^Select gender: female$")
	public void select_gender_female()  {
		mainpage=new MainPage();
		mainpage.gender();
	}

	@Then("^Press the Let’s Shop button$")
	public void press_the_Let_s_Shop_button() {
		mainpage=new MainPage();
		mainpage.letsShop();
	}


	@Then("^Select the first two items in the list:$")
	public void select_the_first_two_items_in_the_list() {
		mainpage=new MainPage();
		mainpage.Addproduct();
	}


	@Then("^Tap the shopping cart icon$")
	public void tap_the_shopping_cart_icon()  {
		mainpage=new MainPage();
		mainpage.cart();
		
	}

	@Then("^Validate that the Total Purchase Amount is equal to the two prices added together\\.$")
	public void validate_that_the_Total_Purchase_Amount_is_equal_to_the_two_prices_added_together() throws InterruptedException {
		mainpage=new MainPage();
		
		double sumOfPrice=mainpage.SumOfPrice();
		double totalPrice=mainpage.totalPrice();
		Assert.assertEquals(sumOfPrice,totalPrice, 0);
		
		
	}










}
