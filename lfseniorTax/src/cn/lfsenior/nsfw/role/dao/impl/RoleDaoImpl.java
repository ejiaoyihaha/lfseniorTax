package cn.lfsenior.nsfw.role.dao.impl;


import org.hibernate.Query;

import cn.lfsenior.core.dao.impl.BaseDaoImpl;
import cn.lfsenior.nsfw.role.dao.RoleDao;
import cn.lfsenior.nsfw.role.entity.Role;

public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao {

	@Override
	public void deleteRolePrivilegeByRoleId(String roleId) {
		Query query = getSession().createQuery("DELETE FROM RolePrivilege WHERE id.role.roleId=?");
		query.setParameter(0, roleId);
		query.executeUpdate();
	}
	
}
