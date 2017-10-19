package cn.lfsenior.nsfw.user.service;

import java.io.Serializable;
import java.util.List;

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
}
