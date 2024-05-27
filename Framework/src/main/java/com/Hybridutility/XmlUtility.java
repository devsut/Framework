package com.Hybridutility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XmlUtility {
	
	public static String readexcel(String no,String heading,int index)  {
		String value = null;
		Workbook w=null;
		try {
			File f = new File("./XLData/TestData.xlsx");
			FileInputStream fs = new FileInputStream(f);
			 w = new XSSFWorkbook(fs);
			Sheet s = w.getSheetAt(index);
			int rows = s.getPhysicalNumberOfRows();
		//	Row r = s.getRow(2);
			for(int i=1;i<rows;i++) {
				String no1 = s.getRow(i).getCell(0).toString();
				if(no1.equals(no)) {
					System.out.println(no1);
					switch(heading) {
					case "User":
						value = s.getRow(i).getCell(1).toString();
						System.out.println(value);
						break;
					case "Pass":
						value = s.getRow(i).getCell(2).toString();
						System.out.println(value);
						break;
					default:
						value = s.getRow(i).getCell(3).toString();
						System.out.println(value);
						break;
					}				
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				w.close();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		return value;

	}


}
