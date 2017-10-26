package cn.lfsenior.nsfw.role.entity;

public class RolePrivilege {
	private  RolePrivilegeId id;
	
	public RolePrivilege() {
	}

	public RolePrivilege(RolePrivilegeId id) {
		this.id = id;
	}

	public RolePrivilegeId getId() {
		return id;
	}

	public void setId(RolePrivilegeId id) {
		this.id = id;
	}
	
}
