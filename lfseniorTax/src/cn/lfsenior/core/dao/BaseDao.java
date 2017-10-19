package cn.lfsenior.core.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 所有持久层的基础接口
 * @author LF.zero
 *
 * @param <T>
 */
public interface BaseDao<T> extends Serializable {
	/**
	 * 增
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 删
	 * @param id
	 */
	public void delete(Serializable id);
	
	/**
	 * 改
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 查
	 * @param id
	 * @return
	 */
	public T findObjectById(Serializable id);
	
	
	/**
	 * 查所有
	 * @return
	 */
	public List<T> findObjects();
}
