import com.afw.pages.Scenario3Page;
import org.testng.annotations.Test;

public class Scenario3 extends BaseTest{

    @Test
    public static void test1(){
        Scenario3Page sc = new Scenario3Page();
        System.out.println("O/P"+sc.internetConnectivity("enable"));
        sc.developerOption("1");
        sc.bluetooth("1");
        sc.notificationSettings("0");
        sc.orientation("1");
        sc.killApps("com.mobeta.android.demodslv");
        System.out.println("Bluetooth status is "+sc.checkForBluetooth());

//        sc.internetConnectivity();
    }
}
