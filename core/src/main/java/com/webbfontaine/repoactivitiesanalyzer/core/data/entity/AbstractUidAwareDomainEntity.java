package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.util.UUID;

@MappedSuperclass
public abstract class AbstractUidAwareDomainEntity extends AbstractDomainEntity {
	@Column(name = "uid")
	private String uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		AbstractUidAwareDomainEntity that = (AbstractUidAwareDomainEntity) o;

		return new EqualsBuilder()
			.append(getIdOrNull(this), getIdOrNull(that))
			.append(uid, that.uid)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.appendSuper(super.hashCode())
			.append(uid)
			.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append("uid", uid)
			.toString();
	}

	@PrePersist
	public void setUid() {
		uid = UUID.randomUUID().toString();
	}
}
