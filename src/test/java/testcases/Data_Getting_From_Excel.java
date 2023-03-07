package testcases;
import base.Base;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Data_Getting_From_Excel extends Base {

    public static WebDriver driver;
    @Test
    public void test_registration_excel() throws IOException {
        driver=openBrowser("Chrome");
        driver.get("https://online.roboform.com/site/signup");
        FileInputStream fis=new FileInputStream("C:\\Users\\amin.al\\IdeaProjects\\SeleniumJavaTestNGHybrid\\src\\test\\resources\\AA.xlsx");
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet("Sheet8");
        int rowCount=sheet.getLastRowNum();
        int colCount=sheet.getRow(1).getLastCellNum();
        System.out.println("rowCount:"+rowCount+"\n"+"colCount:"+colCount);
        for(int i=1;i<=rowCount;i++)
        {
            XSSFRow celldata=sheet.getRow(i);
            String mail=celldata.getCell(0).getStringCellValue();
            String createPass=celldata.getCell(1).getStringCellValue();
            String confirmPass=celldata.getCell(2).getStringCellValue();
            String FullName=celldata.getCell(3).getStringCellValue();
            System.out.println("Mail:"+ mail +" CreatePass:"+ createPass +" ConfirmPass:"+ confirmPass +" FullName:"+ FullName );
        }

    }
}
