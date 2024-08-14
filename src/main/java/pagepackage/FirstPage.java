package pagepackage;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

public class FirstPage {
	private AppiumDriver driver;

    // Constructor
    public FirstPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Define MobileElements using @AndroidFindBy annotation

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Access'ibility\"]")
    WebElement Accessibilitylink;
    
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Accessibility Node Provider\"]")
    WebElement AccessibilityNodeProviderlink;
    
    public void visitPage() {
    	Accessibilitylink.click();
    	AccessibilityNodeProviderlink.click();
    }
}
