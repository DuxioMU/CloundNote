package cn.tedu.cloudnote.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Notebook implements Serializable{
	private static final long serialVersionUID = -8341731366267651270L;
	
	private String id;
	private String name;
	private String typeId;
	private String userId;
	private String desc;
	private Timestamp createtime;
	
	public Notebook() {
	}

	public Notebook(String id, String name, String typeId, String userId, String desc, Timestamp createtime) {
		super();
		this.id = id;
		this.name = name;
		this.typeId = typeId;
		this.userId = userId;
		this.desc = desc;
		this.createtime = createtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Notebook [id=" + id + ", name=" + name + ", typeId=" + typeId + ", userId=" + userId + ", desc=" + desc
				+ ", createtime=" + createtime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notebook other = (Notebook) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
