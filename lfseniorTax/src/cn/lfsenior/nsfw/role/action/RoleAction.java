package cn.lfsenior.nsfw.role.action;

import java.util.HashSet;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.core.ApplicationContext;

import com.opensymphony.xwork2.ActionContext;

import cn.lfsenior.core.action.BaseAction;
import cn.lfsenior.core.constant.Constant;
import cn.lfsenior.nsfw.role.entity.Role;
import cn.lfsenior.nsfw.role.entity.RolePrivilege;
import cn.lfsenior.nsfw.role.entity.RolePrivilegeId;
import cn.lfsenior.nsfw.role.service.RoleService;

public class RoleAction extends BaseAction {
	@Resource
	private RoleService roleService;
	private List<Role> roleList;
	private Role role;
	private String[] privilegeIds;

	/**
	 * 列表页面
	 * 
	 * @return
	 */
	public String listUI() {
		// 加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		roleList = roleService.findObjects();
		return "listUI";
	}

	/**
	 * 添加页面
	 * 
	 * @return
	 */
	public String addUI() {
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		return "addUI";
	}

	/**
	 * 增加用户
	 * 
	 * @return 重定向到listUI
	 */
	public String add() {
		if (role != null) {
			if (privilegeIds != null && privilegeIds.length > 0) {
				HashSet<RolePrivilege> set = new HashSet<RolePrivilege>();
				for (int i = 0; i < privilegeIds.length; i++) {
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
				role.setRolePrivileges(set);
				roleService.save(role);
			}
		}
		return "list";
	}

	/**
	 * 编辑用户
	 * 
	 * @return
	 */
	public String edit() {
		if(role!=null){
			//处理权限保存
			if(privilegeIds!=null){
				HashSet<RolePrivilege> set=new HashSet<RolePrivilege>();
				for(int i=0;i<privilegeIds.length;i++){
					set.add(new RolePrivilege(new RolePrivilegeId(role, privilegeIds[i])));
				}
				role.setRolePrivileges(set);
			}
			roleService.update(role);
		}
		return "list";
	}

	/**
	 * 编辑页面
	 * 
	 * @return
	 */
	public String editUI() {
		// 加载权限集合
		ActionContext.getContext().getContextMap().put("privilegeMap", Constant.PRIVILEGE_MAP);
		if (role != null && role.getRoleId() != null) {
			role = roleService.findObjectById(role.getRoleId());
			//处理权限回显
			if(role.getRolePrivileges() != null){
				privilegeIds = new String[role.getRolePrivileges().size()];
				int i = 0;
				for(RolePrivilege rp: role.getRolePrivileges()){
					privilegeIds[i++] = rp.getId().getCode();
				}
			}
		}
		return "editUI";
	}

	/**
	 * 删除用户
	 * 
	 * @return
	 */
	public String delete() {
		if (role != null && role.getRoleId() != null) {
			roleService.delete(role.getRoleId());
		}
		return "list";
	}

	public String deleteSelected() {
		if (selectedRow != null) {
			for (String id : selectedRow) {
				roleService.delete(id);
			}
		}
		return "list";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public String[] getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(String[] selectedRow) {
		this.selectedRow = selectedRow;
	}

	public String[] getPrivilegeIds() {
		return privilegeIds;
	}

	public void setPrivilegeIds(String[] privilegeIds) {
		this.privilegeIds = privilegeIds;
	}

}
