package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;


public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    private static Properties prop = new Properties();
    private static String dateTime;
    public static String  testreportpath;

    public static void setExtent() {
        dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"));

        testreportpath = System.getProperty("user.dir") +"/testreports/Test_Report_"+ dateTime + ".html";
        htmlReporter= new ExtentHtmlReporter(testreportpath);
        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+prop.getProperty("extentconfigXml"));

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("HostName", "local");
        extent.setSystemInfo("ProjectName", "LexisNexisTest");
        extent.setSystemInfo("OS", "Win10");
        extent.setSystemInfo("Browser", "Chrome");
    }

    public static void endReport() {
        extent.flush();
    }
}
