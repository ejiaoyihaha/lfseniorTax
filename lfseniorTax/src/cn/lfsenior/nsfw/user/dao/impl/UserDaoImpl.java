package cn.lfsenior.nsfw.user.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;

import cn.lfsenior.core.dao.impl.BaseDaoImpl;
import cn.lfsenior.nsfw.user.dao.UserDao;
import cn.lfsenior.nsfw.user.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
	
	@Override
	public List<User> findUserByAccountAndId(String id, String account) {
		String HQL="FROM User WHERE account=?";
		if(StringUtils.isNotEmpty(id)){
			HQL+=" AND id !=?";
		}
		Query query = getSession().createQuery(HQL);
		query.setParameter(0, account);
		if(StringUtils.isNotEmpty(id)){
			query.setParameter(1, id);
		}
		return query.list();
	}
}
