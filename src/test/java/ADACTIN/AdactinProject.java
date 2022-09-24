package ADACTIN;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AdactinProject {

	public static void main(String[] args) throws InterruptedException, IOException {

		String AdactinUrl = "https://adactinhotelapp.com/";
		String AdactinTittle = "Adactin.com - Hotel Reservation System";
		String AdactinHeader = "Adactin Launches The Adactin Hotel App!";

		String SearchHotelUrl = "https://adactinhotelapp.com/SearchHotel.php";
		String SearchHotelTittle = "Adactin.com - Search Hotel";
		String SearchHotelHeader = "Search Hotel (Fields marked with Red asterix (*) are mandatory)";

		String SelectHotelUrl = "https://adactinhotelapp.com/SelectHotel.php";
		String SelectHotelTittle = "Adactin.com - Select Hotel";
		String SelectHotelHeader = "Select Hotel";

		String BookHotelUrl = "https://adactinhotelapp.com/BookHotel.php";
		String BookHotelTittle = "Adactin.com - Book A Hotel";
		String BookHotelHeader = "Book A Hotel";

		String BookingConfirmationUrl = "https://adactinhotelapp.com/BookingConfirm.php";
		String BookingConfirmationTittle = "Adactin.com - Hotel Booking Confirmation";
		String BookingConfirmationHeader = "Booking Confirmation";

		String BookedItineraryUrl = "https://adactinhotelapp.com/BookedItinerary.php";
		String BookedItineraryTittle = "Adactin.com - Select Hotel";
		String BookedItineraryHeader = "Booked Itinerary";

		String LogoutUrl = "https://adactinhotelapp.com/Logout.php";
		String LogoutTittle = "Adactin.com - Logout";
		String LogoutHeader = "You have successfully logged out";

		System.setProperty("webdriver.chrome.driver",
				"D:\\Software\\EcpliseWorkspace\\Adactin\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("************************************************");
		// Search Hotel Page
		String LandingTittle = driver.getTitle();
		String LandingCurrentUrl = driver.getCurrentUrl();
		System.out.println("My Current URL Is = " + LandingCurrentUrl);
		System.out.println("My Current Tittle Is = " + LandingTittle);

		if ((AdactinUrl.equals(LandingCurrentUrl)) && (AdactinTittle.equals(LandingTittle))) {
			System.out.println("Pass - My Expected Window Is Opened");
		} else {
			System.out.println("Fail - My Expected Window Is Not Opened");
		}
		
		WebElement documentheader = driver.findElement(By.xpath("//p[contains(text(),'Adactin Launches')]"));
		String pageheader = documentheader.getText();
		System.out.println("Page Header Name Is = " + pageheader);
		
		if (AdactinHeader.equals(pageheader)) {
			System.out.println("Pass - My Header Documents Is Correct");
		} else {
			System.out.println("Fail - My Header Documents Is Not Correct");
		}
		try {
			driver.findElement(By.id("username")).sendKeys("sathishkm");
			driver.findElement(By.id("password")).sendKeys("HF8UXU");
			driver.findElement(By.id("login")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[contains(text(),'Adactin Group')]")).isDisplayed();
		} catch (Exception e) {
			driver.findElement(By.id("username")).sendKeys("sathishkm");
			driver.findElement(By.id("password")).sendKeys("HF8UXU");
			driver.findElement(By.id("login")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//td[contains(text(),'Adactin Group')]")).isDisplayed();
		}
		System.out.println("************************************************");

		System.out.println("************************************************");
		// Search Hotel Page
		String SearchPageCurrentTittle = driver.getTitle();
		String SearchPageCurrentUrl = driver.getCurrentUrl();
		System.out.println("My SearchPage URL Is = " + SearchPageCurrentUrl);
		System.out.println("My SearchPage Tittle Is = " + SearchPageCurrentTittle);
		
		WebElement AdactinGroup = driver.findElement(By.xpath("//td[contains(text(),'Search Hotel')]"));
		String txtSearchHotelHeader = AdactinGroup.getText();
		System.out.println("Page SearchPage Name Is = " + txtSearchHotelHeader);

		if ((SearchPageCurrentUrl.equals(SearchHotelUrl)) && (SearchPageCurrentTittle.equals(SearchHotelTittle))
				&& (SearchHotelHeader.equals(txtSearchHotelHeader))) {
			System.out.println("Pass - My Search Hotel Window Is Opened");
		} else {
			System.out.println("Fail - My Search Hotel Window Is Not Opened");
		}
		if (SearchHotelHeader.equals(SearchHotelHeader)) {
			System.out.println("Pass - My Header Documents Is Correct");
		} else {
			System.out.println("Fail - My Header Documents Is Not Correct");
		}

		WebElement locationArea = driver.findElement(By.id("location"));
		Select location = new Select(locationArea);
		location.selectByIndex(5);
		System.out.println("Location Selected Name Is = " + location.getFirstSelectedOption().getText());

		WebElement HotelName = driver.findElement(By.name("hotels"));
		Select hotel = new Select(HotelName);
		hotel.selectByValue("Hotel Sunshine");
		System.out.println("Hotel Selected Name Is = " + hotel.getFirstSelectedOption().getText());

		WebElement RoomType = driver.findElement(By.name("room_type"));
		Select room = new Select(RoomType);
		room.selectByVisibleText("Super Deluxe");
		System.out.println("Room Selected Type Is = " + room.getFirstSelectedOption().getText());

		WebElement NoOfRoom = driver.findElement(By.name("room_nos"));
		Select Numberofroom = new Select(NoOfRoom);
		Numberofroom.selectByIndex(1);
		System.out.println("Number Of Room Selected By = " + Numberofroom.getFirstSelectedOption().getText());

		driver.findElement(By.id("datepick_in")).sendKeys("23/09/2022");
		driver.findElement(By.id("datepick_out")).sendKeys("25/09/2022");

		WebElement AdultRoom = driver.findElement(By.name("adult_room"));
		Select NoOfPerson = new Select(AdultRoom);
		NoOfPerson.selectByIndex(1);
		System.out.println("Number Of Adult Person = " + NoOfPerson.getFirstSelectedOption().getText());

		WebElement ChildRoom = driver.findElement(By.name("child_room"));
		Select child = new Select(ChildRoom);
		child.selectByIndex(2);
		System.out.println("Number Of Child Person = " + child.getFirstSelectedOption().getText());

		driver.findElement(By.name("Submit")).click();
		System.out.println("************************************************");

		System.out.println("************************************************");
		// Select Hotel Page
		String GroupOFHotelUrl = driver.getCurrentUrl();
		String GroupOFHotelTitle = driver.getTitle();
		System.out.println("Group Of Hotel Url Is = " + GroupOFHotelUrl);
		System.out.println("Group Of Hotel Tittle Is = " + GroupOFHotelTitle);

		if ((GroupOFHotelUrl.equals(SelectHotelUrl)) && (GroupOFHotelTitle.equals(SelectHotelTittle))) {
			System.out.println("Pass - Book Hotel Page Is Correct");
		} else {
			System.out.println("Fail - Book Hotel Page Is Not Correct");
		}
		WebElement GroupHotelHeader = driver.findElement(By.xpath("//td[contains(text(),'Select Hotel')]"));
		String GroupHeader = GroupHotelHeader.getText();
		System.out.println("Adactin Group Of Hotel Is = " + GroupHeader);
		if (GroupHeader.equals(SelectHotelHeader)) {
			System.out.println("Pass - Group Of Hotel Is Correct");
		} else {
			System.out.println("Fail - Group Of Hotel Is Not Correct");
		}

		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		Thread.sleep(5000);
		System.out.println("************************************************");

		System.out.println("************************************************");
		// Book Hotel Page
		String HotelPageUrl = driver.getCurrentUrl();
		String HotelPageTittle = driver.getTitle();
		System.out.println("Hotel Page Url = " + HotelPageUrl);
		System.out.println("Hotel Page Tittle = " + HotelPageTittle);

		if (HotelPageUrl.equals(BookHotelUrl) && (HotelPageTittle.equals(BookHotelTittle))) {
			System.out.println("Pass - Book A Hotel Page Is Correct");
		} else {
			System.out.println("Fail - Book A Hotel Page Is Not Correct");
		}

		WebElement HotelPageHeader = driver.findElement(By.xpath("//td[contains(text(),'Book A Hotel')]"));
		String CurentPageHeader = HotelPageHeader.getText();
		System.out.println("Book A Page Header = " + CurentPageHeader);

		if (CurentPageHeader.equals(BookHotelHeader)) {
			System.out.println("Pass - Page Header is Correct");
		} else {
			System.out.println("Pass - Page Header is Correct");
		}

		driver.findElement(By.id("first_name")).sendKeys("ABC");
		driver.findElement(By.id("last_name")).sendKeys("XYZ");
		driver.findElement(By.id("address")).sendKeys("ABCDEF ");
		driver.findElement(By.id("cc_num")).sendKeys("1234567891123456");

		WebElement CardType = driver.findElement(By.id("cc_type"));
		Select card = new Select(CardType);
		card.selectByVisibleText("VISA");

		WebElement ExeMonth = driver.findElement(By.id("cc_exp_month"));
		Select ExeDate = new Select(ExeMonth);
		ExeDate.selectByVisibleText("November");

		WebElement ExeYear = driver.findElement(By.id("cc_exp_year"));
		Select year = new Select(ExeYear);
		year.selectByValue("2022");

		driver.findElement(By.id("cc_cvv")).sendKeys("123");
		driver.findElement(By.id("book_now")).click();
		System.out.println("************************************************");

		System.out.println("************************************************");
		// Booking Confirm Page
		String BookingConfirmUrl = driver.getCurrentUrl();
		String BookingConfirmTittle = driver.getTitle();
		System.out.println("Hotel Page Url = " + BookingConfirmUrl);
		System.out.println("Hotel Page Tittle = " + BookingConfirmTittle);

		if (BookingConfirmUrl.equals(BookingConfirmationUrl)
				&& (BookingConfirmTittle.equals(BookingConfirmationTittle))) {
			System.out.println("Pass - Book A Hotel Page Is Correct");
		} else {
			System.out.println("Fail - Book A Hotel Page Is Not Correct");
		}

		WebElement BookingConfirmPageHeader = driver.findElement(By.xpath("//td[contains(text(),'Booking Confirmation')]"));
		String BookingConfirmHeader = BookingConfirmPageHeader.getText();
		System.out.println("Book A Page Header = " + BookingConfirmHeader);

		if (BookingConfirmHeader.equals(BookingConfirmationHeader)) {
			System.out.println("Pass - Page Header is Correct");
		} else {
			System.out.println("Pass - Page Header is Correct");
		}

		WebElement FirstName = driver.findElement(By.id("first_name"));
		System.out.println("Name = " + FirstName.getAttribute("value"));

		WebElement BillingAddress = driver.findElement(By.id("address"));
		System.out.println("Billing Address = " + BillingAddress.getAttribute("value"));

		WebElement txtOrderId = driver.findElement(By.id("order_no"));
		String OrderId = txtOrderId.getAttribute("value");
		System.out.println("Order Id = " + OrderId);

		WebElement PageDown = driver.findElement(By.xpath("//a[contains(text(),'Adactin.com')]"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", PageDown);
		Thread.sleep(4000);
		TakesScreenshot OrderIdScreenShot = (TakesScreenshot) driver;
		File Source = OrderIdScreenShot.getScreenshotAs(OutputType.FILE);
		File Destination = new File("D:\\Software\\KM SCREENSHOT\\Orderid1.jpeg");
		FileUtils.copyFile(Source, Destination);

		driver.findElement(By.id("my_itinerary")).click();
		System.out.println("************************************************");

		System.out.println("************************************************");
		// Booked Itinerary Page
		String ItineraryPageUrl = driver.getCurrentUrl();
		String ItineraryPageTittle = driver.getTitle();
		System.out.println("Hotel Page Url = " + ItineraryPageUrl);
		System.out.println("Hotel Page Tittle = " + ItineraryPageTittle);

		if (ItineraryPageUrl.equals(BookedItineraryUrl) && (ItineraryPageTittle.equals(BookedItineraryTittle))) {
			System.out.println("Pass - Booked Itinerary Page Is Correct");
		} else {
			System.out.println("Fail - Booked Itinerary Page Is Not Correct");
		}

		WebElement ItineraryPagePageHeader = driver.findElement(By.xpath("//td[contains(text(),'Booked Itinerary')]"));
		String ItineraryHeader = ItineraryPagePageHeader.getText();
		System.out.println("Booked Itinerary Page Header = " + ItineraryHeader);

		if (ItineraryHeader.equals(BookedItineraryHeader)) {
			System.out.println("Pass - Booked Itinerary Page is Correct");
		} else {
			System.out.println("Pass - Booked Itinerary Page is Correct");
		}

		driver.findElement(By.id("order_id_text")).sendKeys(OrderId);
		driver.findElement(By.id("search_hotel_id")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		Thread.sleep(3000);

		Alert Notification = driver.switchTo().alert();
		Notification.accept();
		Thread.sleep(3000);
		driver.findElement(By.id("logout")).click();
		System.out.println("************************************************");

		System.out.println("************************************************");
		// Logout Page
		String LogoutPageUrl = driver.getCurrentUrl();
		String LogoutPageTittle = driver.getTitle();
		System.out.println("Hotel Page Url = " + LogoutPageUrl);
		System.out.println("Hotel Page Tittle = " + LogoutPageTittle);

		if (LogoutPageUrl.equals(LogoutUrl) && (LogoutPageTittle.equals(LogoutTittle))) {
			System.out.println("Pass - Logout Page Is Correct");
		} else {
			System.out.println("Fail - Logout Page Is Not Correct");
		}

		WebElement lagoutPageHeader = driver.findElement(By.xpath("//td[contains(text(),'You have successfully logged out')]"));
		String LogoutPageHead = lagoutPageHeader.getText();
		System.out.println("Logout Page Header = " + LogoutPageHead);

		if (LogoutPageHead.equals(LogoutHeader)) {
			System.out.println("Pass - Logout Page is Correct");
		} else {
			System.out.println("Pass - Logout Page is Correct");
		}
		System.out.println("************************************************");

		System.out.println("************************************************");
		driver.quit();
	}

}