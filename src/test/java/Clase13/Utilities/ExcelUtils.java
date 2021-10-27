package Clase13.Utilities;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {

    public static void getCellData() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook("dataloader/sample.xlsx");
        XSSFSheet hoja1 = workbook.getSheet("Hoja1");

        for (int fila = 0; fila < 9; fila++){
            String persona = "";
            for (int col = 0; col <8; col++){
                try {
                persona += hoja1.getRow(fila).getCell(col).getStringCellValue() + ";";
                //System.out.println( fila + " " + col + " " + persona);
                } catch (Exception ex){
                    double edad = hoja1.getRow(fila).getCell(col).getNumericCellValue();
                    persona += String.valueOf(edad) + ";" ;
                    //System.out.println( fila + " " + col + " " + persona);
                }
            }
            System.out.println("--->" + persona);
        }
    }
}
