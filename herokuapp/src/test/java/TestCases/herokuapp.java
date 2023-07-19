package TestCases;

import java.time.Duration;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class herokuapp {
	WebDriver driver;
	
	@Test(priority = 1)
	public void testBrokenImages() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url= "http://the-internet.herokuapp.com/broken_images";
		driver.get(url);
		
		WebElement image1 = driver.findElement(By.xpath("(//img)[2]"));
		CloseableHttpClient httpClient1 = HttpClientBuilder.create().build();
        String imageURL1 = image1.getAttribute("src");
        HttpGet request1 = new HttpGet(imageURL1);
        try {
            HttpResponse response1 = httpClient1.execute(request1);

            int statusCode = response1.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                System.out.println("Broken image found: " + imageURL1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        WebElement image2 = driver.findElement(By.xpath("(//img)[3]"));
		CloseableHttpClient httpClient2 = HttpClientBuilder.create().build();
        String imageURL2 = image2.getAttribute("src");
        HttpGet request2 = new HttpGet(imageURL2);
        try {
            HttpResponse response2 = httpClient2.execute(request2);

            int statusCode = response2.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                System.out.println("Broken image found: " + imageURL2);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        WebElement image3 = driver.findElement(By.xpath("(//img)[4]"));
		CloseableHttpClient httpClient3 = HttpClientBuilder.create().build();
        String imageURL3 = image3.getAttribute("src");
        HttpGet request3 = new HttpGet(imageURL3);
        try {
            HttpResponse response3 = httpClient3.execute(request3);

            int statusCode = response3.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                System.out.println("Broken image found: " + imageURL3);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
		driver.close();
	}
	
	@Test(priority = 2)
	public void uploadingAnyFile() {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url= "http://the-internet.herokuapp.com/upload";
		driver.get(url);
		try {
			driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\nandan\\hack2skill\\herokuapp\\extent.properties");
		} catch (Exception e) {
			System.out.println(e);
		}
		driver.findElement(By.id("file-submit")).click();
		driver.close();
	}

}
