package au.gov.border.oa.steps;

import com.neotys.selenium.proxies.NLWebDriver;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CommonSteps
{
   // private WebDriver driver = Serenity.getWebdriverManager().getWebdriver();

    @Step
    public void verifyTextInPage(String text, boolean exactMatch, NLWebDriver driver)
    {
        boolean result = false;
        int retry = 10;
        for (int i = 0; i < retry; i++)
        {
            String bodyText = driver.findElement(By.tagName("body")).getAttribute("innerText");
            // ignore case sensitive
            if (!exactMatch)
            {
                bodyText = bodyText.toLowerCase();
                text = text.toLowerCase();
            }
            if (bodyText.contains(text))
            {
                result = true;
                break;
            }
            else
            {
                sleep(100);
            }
        }

        assertThat("Text \"" + text + "\" is NOT displayed", result, is(true));

    }

    public void sleep(long milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

}
