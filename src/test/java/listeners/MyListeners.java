package listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class MyListeners implements ITestListener {

    public void onStart(ITestContext context) {
        System.out.println("Execution of Project Started");
    }
    public void onTestSuccess(ITestResult result) {
        String testName=result.getName();
        System.out.println(testName+" Got Successfully Executed ");
    }
    public void onTestFailure(ITestResult result) {
        String testName=result.getName();
        System.out.println(testName+" Got Failed ");
        System.out.println(result.getThrowable());
    }
    public void onTestSkipped(ITestResult result) {
        String testName=result.getName();
        System.out.println(testName+" Got Skipped ");
        System.out.println(result.getThrowable());
    }
    public void onFinish(ITestContext context) {
        System.out.println("Finished Executing Project");
    }
}
