package com.kgate.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.kgate.entity.User;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * 
 * @author www.codejava.net
 *
 */
public class ExcelBuilder2 extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) model.get("listUser");
		HSSFSheet sheet1 = (HSSFSheet) workbook.createSheet("Sheet 1");
		HSSFSheet sheet2 = (HSSFSheet) workbook.createSheet("Sheet 2");
		CreationHelper createHelper = workbook.getCreationHelper();
		// Create row object
		HSSFCellStyle cellStyle = (HSSFCellStyle) workbook.createCellStyle();
		Font font = workbook.createFont();
		HSSFColorPredefined ss = HSSFColor.HSSFColorPredefined.BLUE;
//		font.setColor(ss);
		HSSFFont hlinkfont = (HSSFFont) workbook.createFont();
		hlinkfont.setUnderline(HSSFFont.U_SINGLE);
		hlinkfont.setColor(HSSFFont.COLOR_RED);
		cellStyle.setFont(hlinkfont);
//		change font
		HSSFCellStyle cellStyle2 = (HSSFCellStyle) workbook.createCellStyle();
		font.setColor(HSSFColor.HSSFColorPredefined.RED.getIndex());
		int rowCount2 = 1;
		HSSFRow header2 = sheet1.createRow(0);
		header2.createCell(0).setCellValue("Phone Number");
		header2.createCell(1).setCellValue("URL");
		HSSFCell cell1 =header2.createCell(0);
		cell1.setCellValue("Phone Number");
		HSSFCell cell2 =header2.createCell(1);
		cell2.setCellValue("URL");
		for (User user : listUser) {
			HSSFRow aRow = sheet1.createRow(rowCount2++);
			aRow.createCell(0).setCellValue(user.getMobile());
			HSSFCell cell =aRow.createCell(1); 
			cell.setCellValue("http://159.65.148.176:88/build_2/K/index.html?" + user.getMobile());
			HSSFHyperlink link = (HSSFHyperlink) createHelper.createHyperlink(HyperlinkType.URL);
			link.setAddress("http://159.65.148.176:88/build_2/K/index.html?" + user.getMobile());
			cell.setHyperlink((HSSFHyperlink) link);
//			cell.setCellStyle(cellStyle);
//			link.setAddress("http://www.tutorialspoint.com/");
		}

		System.out.println("Writesheet.xlsx written successfully");
	}

}