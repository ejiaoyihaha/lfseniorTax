package cn.lfsenior.nsfw.user.dao;

import java.util.List;

import cn.lfsenior.core.dao.BaseDao;
import cn.lfsenior.nsfw.user.entity.User;

public interface UserDao extends BaseDao<User>{

	/**
	 * 验证数据唯一性
	 * @param id
	 * @param account
	 * @return
	 */
	List<User> findUserByAccountAndId(String id, String account);

}
