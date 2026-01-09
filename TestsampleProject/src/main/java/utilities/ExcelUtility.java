package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtility {
	static FileInputStream f;// to access the file from a given path
	static XSSFWorkbook w;// to make changes/to access a workbook from the file (predefined class)
	static XSSFSheet sh;// to access the particular sheet from the workbook

	public static String getStringData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(a);// xssfrow class to do modification in row
		XSSFCell c = r.getCell(b);// xssfcell class to do modification in cell
		return (c.getStringCellValue());// to retrieve string value from a cell
	}

	public static String getTntegerData(int a, int b, String sheet) throws IOException {
		f = new FileInputStream(Constants.TESTDATAFILE);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(a);
		XSSFCell c = r.getCell(b);
		int x = (int) c.getNumericCellValue();// typecast to convert string to integer
		return String.valueOf(x);

	}
}
