package cn.lfsenior.nsfw.user.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

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

}
