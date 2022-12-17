import com.afw.driver.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.util.Map;

public class BaseTest {

    @BeforeSuite
    public static void before() throws IOException {
        Driver.initDriver();

    }

//    @BeforeMethod
//    public static void beforeMethod(Object[] data) throws DeviceNotFoundException, IOException {
//        Map map = (Map<String,String>)data[0];
//        Driver.initDriver(map);
//    }

    @AfterSuite
    public static void afterSuite(){
        Driver.quitDriver();
      //  System.out.println("Tear Down Called");
    }

}
