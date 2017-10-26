package cn.lfsenior.nsfw.user.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import cn.lfsenior.core.util.ExcelUtil;
import cn.lfsenior.nsfw.user.dao.UserDao;
import cn.lfsenior.nsfw.user.entity.User;
import cn.lfsenior.nsfw.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	@Override
	public void save(User entity) {
		userDao.save(entity);
	}

	@Override
	public void delete(Serializable id) {
		userDao.delete(id);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public User findObjectById(Serializable id) {
		return userDao.findObjectById(id);
	}

	@Override
	public List<User> findObjects() {
		return userDao.findObjects();
	}

	@Override
	public void exportExcel(List<User> userList, ServletOutputStream outputStream) {
		ExcelUtil.exportExcel(userList, outputStream);
	}

	@Override
	public void importExcel(File userExcel, String userExcelFileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(userExcel);
			boolean is03Excel=userExcelFileName.matches("^.+\\.(?i)(xls)$");
			Workbook workbook=is03Excel?new HSSFWorkbook(fileInputStream):new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			if(sheet.getPhysicalNumberOfRows()>2){
				User user=null;
				for(int i=2;i<sheet.getPhysicalNumberOfRows();i++){
					Row row = sheet.getRow(i);
					user=new User();
					Cell cell0 = row.getCell(0);
					user.setName(cell0.getStringCellValue());
					Cell cell1 = row.getCell(1);
					user.setAccount(cell1.getStringCellValue());
					Cell cell2 = row.getCell(2);
					user.setDept(cell2.getStringCellValue());
					Cell cell3 = row.getCell(3);
					user.setGender(cell3.getStringCellValue().endsWith("男"));
					String mobile="";
					Cell cell4 = row.getCell(4);
					try {
						mobile=cell4.getStringCellValue();
					} catch (Exception e) {
						double dMobile = cell4.getNumericCellValue();
						mobile=BigDecimal.valueOf(dMobile).toString();
					}
					user.setMobile(mobile);
					Cell cell5 = row.getCell(5);
					user.setEmail(cell5.getStringCellValue());
					Cell cell6 = row.getCell(6);
					if(cell6.getDateCellValue()!=null){
						user.setBirthday(cell6.getDateCellValue());
					}
					user.setPassword("123456");
					user.setState(user.USER_STATE_VALID);
					save(user);
				}
			}
			workbook.close();
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		// TODO Auto-generated method stub
		return userDao.findUserByAccountAndId(id,account);
	}
}
