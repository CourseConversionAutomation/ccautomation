import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	
	public static void readXLSFile() throws IOException, InvalidFormatException
	{
		InputStream ExcelFileToRead = new FileInputStream("D:/country.xls");
		Workbook wb = WorkbookFactory.create(ExcelFileToRead);
		Sheet sheet=wb.getSheetAt(0);
		Row row; 
		Cell cell;

		Iterator rows = sheet.rowIterator();

		while (rows.hasNext())
		{
			row=(Row) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext())
			{
				cell=(Cell) cells.next();
		
				if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				{
					System.out.print(cell.getStringCellValue()+" ");
				}
				else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
				{
					System.out.print(cell.getNumericCellValue()+" ");
				}
				else
				{
					//U Can Handel Boolean, Formula, Errors
				}
			}
			System.out.println();
		}
	
	}

	public static void main(String[] args) throws IOException {
		try {
			readXLSFile();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
