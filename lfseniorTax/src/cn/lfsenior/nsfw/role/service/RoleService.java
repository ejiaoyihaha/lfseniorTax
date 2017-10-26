package cn.lfsenior.nsfw.role.service;

import java.io.Serializable;
import java.util.List;

import cn.lfsenior.nsfw.role.entity.Role;

public interface RoleService {
	/**
	 * 增
	 * @param entity
	 */
	public void save(Role entity);
	
	/**
	 * 删
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 改
	 * @param entity
	 */
	public void update(Role entity);
	
	/**
	 * 查
	 * @param id
	 * @return
	 */
	public Role findObjectById(Serializable id);
	
	
	/**
	 * 查所有
	 * @return
	 */
	public List<Role> findObjects();
}
