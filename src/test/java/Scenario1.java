import com.afw.pages.Scenario1Page;
import org.testng.annotations.Test;

public class Scenario1 extends BaseTest{

//    @Test(dataProvider = "getData")
//    public static void test() throws DeviceNotFoundException, IOException {
//        //public static void test() throws DeviceNotFoundException, IOException {
//
//        new HomePage().clickMenuItems("Accessibility");
//    }

    @Test
    public static void test2() throws InterruptedException {
        //getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
        Scenario1Page h = new Scenario1Page();
        h.clickMenuItems("Warp");
        h.selection("Nigeria");
        h.dragAndDrop("Nigeria","Afghanistan");
        h.removeCountry("Afghanistan");
        h.assertionForCountryRemoved("Afghanistan");
        h.assertionForCountryIndex("Nigeria");


    }


//    @Test
//    public static void test3(){
//        //getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]")).click();
//        h.clickMenuItems("App");
//    }
//
//    @DataProvider(parallel = true)
//    public Object[] getData(){
//        Map<String, String> map = new HashMap<>();
//        map.put("device", "Samsung Galaxy S22");
//        map.put("os_version", "12.0");
//
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("device", "Google Pixel 5");
//        map1.put("os_version", "12.0");
//
//        List<Map<String,String>> list = new ArrayList<>();
//        list.add(map);
//        list.add(map1);
//
//        return list.toArray();
//
//    }
}
