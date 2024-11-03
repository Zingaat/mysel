package example.demo.steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class PurchaseFlightStep extends AbstractStep {

	public String execute(final WebDriver driver) {
		driver.findElement(By.xpath(val("app.purchase.purchase-btn.xpath"))).click();
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(d -> driver.findElement(By.xpath(val("app.purchase.confirmation-text-h1.xpath"))).isDisplayed());
		return driver.findElement(By.xpath(val("app.purchase.confirmation.number"))).getText();
	}

}
