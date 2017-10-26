package cn.lfsenior.nsfw.user.service;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletOutputStream;

import cn.lfsenior.nsfw.user.entity.User;

public interface UserService {
	/**
	 * 增
	 * @param entity
	 */
	public void save(User entity);
	
	/**
	 * 删
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 改
	 * @param entity
	 */
	public void update(User entity);
	
	/**
	 * 查
	 * @param id
	 * @return
	 */
	public User findObjectById(Serializable id);
	
	
	/**
	 * 查所有
	 * @return
	 */
	public List<User> findObjects();

	/**
	 * 导出用户列表
	 * @param userList
	 * @param outputStream
	 */
	public void exportExcel(List<User> userList, ServletOutputStream outputStream);

	/**
	 * 导入用户列表 
	 * @param userExcel
	 * @param userExcelFileName
	 */
	public void importExcel(File userExcel, String userExcelFileName);

	/**
	 * 验证数据唯一性
	 * @param id
	 * @param account
	 * @return
	 */
	public List<User> findUserByAccountAndId(String id, String account);
}
