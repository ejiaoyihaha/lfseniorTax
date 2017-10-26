package cn.lfsenior.core.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.lfsenior.nsfw.user.entity.User;

public class ExcelUtil {
	/**
	 * 导出文件
	 * @param userList
	 * @param outputStream
	 */
	public static void exportExcel(List<User> userList, ServletOutputStream outputStream) {
		try {
			/*
			 * 创建工作铺
			 */
			HSSFWorkbook workbook = new HSSFWorkbook();
			/*
			 * 创建合并单元格对象
			 */
			CellRangeAddress cellRange = new CellRangeAddress(0, 0, 0, 4);
			HSSFCellStyle titleStyle = createCellStyle(workbook,(short)16);
			HSSFCellStyle headStyle = createCellStyle(workbook, (short)13);
			/*
			 * 创建工作空间
			 */
			HSSFSheet sheet = workbook.createSheet("用户列表");
			sheet.addMergedRegion(cellRange);
			sheet.setDefaultColumnWidth(25);
			/*
			 * 标题行
			 */
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(titleStyle);
			cell.setCellValue("用户列表");
			
			/*
			 * 头列表行
			 */
			HSSFRow row1 = sheet.createRow(1);
			String[] headers={"用户名","账号","所属部门","性别","电子邮箱"};
			for(int i=0;i<headers.length;i++){
				HSSFCell cell1 = row1.createCell(i);
				cell1.setCellStyle(headStyle);
				cell1.setCellValue(headers[i]);
			}
			if(userList!=null){
				for(int j=0;j<userList.size();j++){
					HSSFRow row3 = sheet.createRow(j+2);
					HSSFCell cell30 = row3.createCell(0);
					cell30.setCellValue(userList.get(j).getName());
					HSSFCell cell31 = row3.createCell(1);
					cell31.setCellValue(userList.get(j).getAccount());
					HSSFCell cell32 = row3.createCell(2);
					cell32.setCellValue(userList.get(j).getDept());
					HSSFCell cell33 = row3.createCell(3);
					cell33.setCellValue(userList.get(j).isGender()?"男":"女");
					HSSFCell cell34 = row3.createCell(4);
					cell34.setCellValue(userList.get(j).getEmail());
				}
			}
			workbook.write(outputStream);
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 创建单元格样式
	 * @param workbook
	 * @param fontSize
	 * @return
	 */
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook,short fontSize) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		font.setFontHeightInPoints(fontSize);
		style.setFont(font);
		return style;
	}
}
