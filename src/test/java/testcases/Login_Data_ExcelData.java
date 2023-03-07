package testcases;

import base.Base;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.ReadExcelFile;

public class Login_Data_ExcelData extends Base {
    public static WebDriver driver;
    @Test(dataProvider = "LoginDataProvider")
    public void testLogin(String email,String password,String username) throws InterruptedException {
        driver=openBrowser("Edge");
        driver.get("http://www.tutorialsninja.com/demo/");

        System.out.println(email);
        System.out.println(password);
        System.out.println(username);

    }
    @DataProvider(name = "LoginDataProvider")
    public String[][] LoginDataProvider()
    {
        String fileName=System.getProperty("user.dir") + "\\TestData\\Excel.xlsx";

        int ttlRows= ReadExcelFile.getRowCount(fileName,"Login_data");
        int ttlColums=ReadExcelFile.getColCount(fileName,"Login_data");

        String data[][]=new String[ttlRows-1][ttlColums];
        for(int i=1;i<ttlRows;i++)
        {
            for(int j=0;j<ttlColums;j++)
            {
                data[i-1][j]=ReadExcelFile.getCellValue(fileName,"Login_data",i,j);
            }
        }

        return data;
    }



}
