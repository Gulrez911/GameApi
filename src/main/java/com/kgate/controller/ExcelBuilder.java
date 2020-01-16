package com.kgate.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.kgate.entity.User;
import com.kgate.entity.UserGame;

/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * 
 * @author www.codejava.net
 *
 */
public class ExcelBuilder extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		@SuppressWarnings("unchecked")
		List<UserGame> listGame = (List<UserGame>) model.get("listGame");
		HSSFSheet sheet2 = (HSSFSheet) workbook.createSheet("Summary");
		HSSFSheet sheet3 = (HSSFSheet) workbook.createSheet("Detailed");
		// Create row object

		int rowCount = 2;
		HSSFRow header = sheet2.createRow(0);
		header.createCell(0).setCellValue("Player Information Report");
		HSSFRow header1 = sheet2.createRow(1);
		header1.createCell(0).setCellValue("Phone Number");
		header1.createCell(1).setCellValue("Attempt");
		header1.createCell(2).setCellValue("Star Points");
		header1.createCell(3).setCellValue("Date");
		header1.createCell(4).setCellValue("Score");
		header1.createCell(5).setCellValue("Feedback");
		for (UserGame userGame : listGame) {
			HSSFRow aRow = sheet2.createRow(rowCount++);
			aRow.createCell(0).setCellValue(userGame.getMobile());
			aRow.createCell(1).setCellValue(userGame.getAttemptcount());
			aRow.createCell(2).setCellValue(userGame.getStarPoints());
			aRow.createCell(3).setCellValue(userGame.getDateTime());
			aRow.createCell(4).setCellValue(userGame.getPercentage() + "%");
			aRow.createCell(5).setCellValue(userGame.getFeedback2());
		}
//		second sheet
		HSSFRow header2 = sheet3.createRow(0);
		header2.createCell(0).setCellValue("Player Information Report");
		HSSFRow hssfRow = sheet3.createRow(1);
		HSSFRow hssfRow2 = sheet3.createRow(2);
		hssfRow2.createCell(0).setCellValue("Phone Number");
		hssfRow2.createCell(1);
		hssfRow2.createCell(2);
		hssfRow2.createCell(3).setCellValue("Detailed");
		int rowCount2 = 3;
		for (UserGame userGame : listGame) {
			HSSFRow aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(0).setCellValue(userGame.getMobile());
			aRow.createCell(1).setCellValue("Answer");
			aRow.createCell(2).setCellValue("Q Number");
			aRow.createCell(3).setCellValue("Attempts");
			aRow = sheet3.createRow(rowCount2++);
//			aRow.createCell(0);
//			aRow.createCell(1);
//			aRow.createCell(2);
			aRow.createCell(3).setCellValue("Attempts " + userGame.getAttemptcount() + ": StarPoints: "
					+ userGame.getStarPoints() + " | Date: " + userGame.getDateTime() + " | Score: "
					+ userGame.getPercentage() + "% | Feedback: " + userGame.getFeedback2());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo1());
			aRow.createCell(3).setCellValue("Question 01: " + userGame.getQ1());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult1());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa1());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo2());
			aRow.createCell(3).setCellValue("Question 02: " + userGame.getQ2());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult2());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa2());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo3());
			aRow.createCell(3).setCellValue("Question 03: " + userGame.getQ3());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult3());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa3());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo4());
			aRow.createCell(3).setCellValue("Question 04: " + userGame.getQ4());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult4());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa4());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo5());
			aRow.createCell(3).setCellValue("Question 05: " + userGame.getQ5());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult5());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa5());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo6());
			aRow.createCell(3).setCellValue("Question 06: " + userGame.getQ6());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult6());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa6());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo7());
			aRow.createCell(3).setCellValue("Question 07: " + userGame.getQ7());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult7());
			aRow.createCell(3).setCellValue("Selected Option: "+userGame.getQa7());

			aRow = sheet3.createRow(rowCount2++);
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(2).setCellValue("Q." + userGame.getqNo8());
			aRow.createCell(3).setCellValue("Question 08: " + userGame.getQ8());
			aRow = sheet3.createRow(rowCount2++);
			aRow.createCell(1).setCellValue(userGame.getRestult8());
			aRow.createCell(3).setCellValue(userGame.getQa8());
			aRow = sheet3.createRow(rowCount2++);
		}

		System.out.println("Writesheet.xlsx written successfully");
	}

}