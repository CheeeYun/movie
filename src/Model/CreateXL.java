package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

 public class CreateXL {
	String outputFile ="/Users/ericch/Desktop/NetFli+.xls";
	static HSSFSheet sheet=null;
	HSSFWorkbook excelbook=new HSSFWorkbook();
public void createExcel() {
	try {
		sheet=excelbook.createSheet("NetFli+");
		HSSFRow row=sheet.createRow((short)0);
		HSSFCell monadism =row.createCell((short)0);
		monadism.setCellType(HSSFCell.CELL_TYPE_STRING);
		monadism.setCellValue("帳號");
		row.createCell((short)(1)).setCellValue("電影");
		row.createCell((short)(2)).setCellValue("影廳");
		row.createCell((short)(3)).setCellValue("時間");
		row.createCell((short)(4)).setCellValue("座位");
		FileOutputStream out =new FileOutputStream(outputFile);
		excelbook.write(out);
		out.flush();
		out.close();
		System.out.println("檔案建立成功！");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
public void insertvalue(String username,String movie,String place,String round,String seat)
{
	try 
	{
		excelbook =new HSSFWorkbook(new FileInputStream(outputFile));
		HSSFSheet sheet =excelbook.getSheet("NetFli+");
		int count =sheet.getPhysicalNumberOfRows();
		HSSFRow row =sheet.createRow((short)count);
		row.createCell((short)0).setCellValue(username);
		row.createCell((short)1).setCellValue(movie);
		row.createCell((short)2).setCellValue(place);
		row.createCell((short)3).setCellValue(round);
		row.createCell((short)4).setCellValue(seat);
		FileOutputStream out;
		out =new FileOutputStream(outputFile);
		excelbook.write(out);
		out.flush();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
//	
