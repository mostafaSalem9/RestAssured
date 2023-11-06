package api.utilities;

import io.qameta.allure.Step;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class XLUtility {
    public static XSSFSheet sheet;
    private File file;

    public XLUtility(String fileName, String sheetName) throws IOException {
        file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook WB = new XSSFWorkbook(inputStream);
        sheet = WB.getSheet(sheetName);
    }

    public String getData(int RN, int CN) {
        DataFormatter formatter = new DataFormatter();
        String field = formatter.formatCellValue(sheet.getRow(RN).getCell(CN));
        return field;
    }
}


