package cn.lfsenior.nsfw.role.dao;

import cn.lfsenior.core.dao.BaseDao;
import cn.lfsenior.nsfw.role.entity.Role;

public interface RoleDao extends BaseDao<Role>{
	/**
	 * 删除权限列表
	 * @param roleId
	 */
	public void deleteRolePrivilegeByRoleId(String roleId);
}
