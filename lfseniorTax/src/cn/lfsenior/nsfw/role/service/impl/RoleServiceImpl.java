package cn.lfsenior.nsfw.role.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.lfsenior.nsfw.role.dao.RoleDao;
import cn.lfsenior.nsfw.role.entity.Role;
import cn.lfsenior.nsfw.role.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;
	
	@Override
	public void save(Role entity) {
		// TODO Auto-generated method stub
		roleDao.save(entity);
	}

	@Override
	public void delete(Serializable id) {
		// TODO Auto-generated method stub
		roleDao.delete(id);
	}

	@Override
	public void update(Role entity) {
		// TODO Auto-generated method stub
		//1、删除该角色对于的所有权限
		roleDao.deleteRolePrivilegeByRoleId(entity.getRoleId());
		roleDao.update(entity);
	}

	@Override
	public Role findObjectById(Serializable id) {
		// TODO Auto-generated method stub
		return roleDao.findObjectById(id);
	}

	@Override
	public List<Role> findObjects() {
		// TODO Auto-generated method stub
		return roleDao.findObjects();
	}

}
