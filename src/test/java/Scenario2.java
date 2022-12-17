import com.afw.pages.Scenario1Page;
import com.afw.pages.Scenario2Page;
import org.testng.annotations.Test;

public class Scenario2 extends BaseTest{

    @Test
    public static void test1() {
        Scenario2Page sc = new Scenario2Page();
        Scenario1Page h = new Scenario1Page();
        h.clickMenuItems("Multiple-choice mode");
        sc.multiSelection();
        sc.deletingSelection();
        sc.checkForDeletedItems();

    }

    @Test
    public static void test2(){
        Scenario2Page sc = new Scenario2Page();
        sc.stopApp("com.mobeta.android.demodslv");
        sc.startApp("com.wdiodemoapp");
        sc.checkThatTheSecondAppIsRunning("com.wdiodemoapp");
    }
}
