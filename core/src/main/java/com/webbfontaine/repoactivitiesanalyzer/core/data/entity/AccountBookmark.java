package com.webbfontaine.repoactivitiesanalyzer.core.data.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "account_bookmark")
public class AccountBookmark extends AbstractUidAwareDomainEntity {
    @ManyToOne
    @JoinColumn(name = "account")
    private Account account;

    @OneToOne
    @JoinColumn(name = "bookmark")
    private Bookmark bookmark;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Bookmark getBookmark() {
        return bookmark;
    }

    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        AccountBookmark ab = (AccountBookmark) obj;
        return new EqualsBuilder()
                .appendSuper(super.equals(obj))
                .append(this.account, ab.account)
                .append(this.bookmark, ab.bookmark)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(account)
                .append(bookmark)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append("account", account)
                .append("bookmark", bookmark)
                .toString();
    }
}
