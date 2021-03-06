package popsugar.selenium.testCase;

//import com.popsugar.selenium.base.DriverBase;
import org.testng.annotations.AfterClass;
import popsugar.selenium.business.CreateGalleryDelPicPro;
import popsugar.selenium.util.HandleCookie;
import popsugar.selenium.util.ProUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestCreateGalleryDelPic extends CaseBase{
	
	public WebDriver driver;
	public CreateGalleryDelPicPro createGDelPicP;
	public ProUtil pro;
	public HandleCookie handleCookie;
	
	@BeforeClass
	public void beforeClass() throws IOException, InterruptedException {
		this.driver = getDriver("chrome");
		createGDelPicP = new CreateGalleryDelPicPro(driver);
		handleCookie = new HandleCookie(driver);
		pro = new ProUtil("src/test/resources/CreateGalleryData.properties");
//		driver.get("https://popsugar.dev10.onsugar.com");
		driver.get(pro.getPro("URL"));
		driver.manage().window().maximize();
		handleCookie.setCookie();
		Thread.sleep(3000);
//		driver.get("https://popsugar.dev4.onsugar.com/manage");
		driver.get(pro.getPro("CreateGalleryURL"));
		Thread.sleep(5000);
	}
	
	@Test
	public void createGalleryDelPicTest() throws IOException, InterruptedException {
		createGDelPicP.createGalleryDelPic(pro.getPro("Title"), pro.getPro("SeoTitle"), pro.getPro("Tags"),pro.getPro("photopath"));
		Thread.sleep(3000);
		createGDelPicP.assertCreateGallery();
	}
	
	//需要登录且设置管理员权限
	//进入 https://popsugar.dev4.onsugar.com/celebrity/manage/new/gallery

	@AfterClass
	public void close() {
		driver.close();
	}

}
