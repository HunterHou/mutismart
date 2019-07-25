package com.hd.mutismart.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.hd.mutismart.base.param.BasePageParam;
import lombok.Data;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author hunter
 */
@Data
public class User extends BasePageParam {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Boolean deleteFlag = false;
    private LocalDate birthday;
    private String sex;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
    @Version
    private Long version;

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("birthday",
                                                                                      birthday).append("sex",
                                                                                                       sex).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return new EqualsBuilder().appendSuper(super.equals(o)).append(getId(),
                                                                       user.getId()).append(getName(),
                                                                                            user.getName()).append(getDeleteFlag(),
                                                                                                                   user.getDeleteFlag()).append(getBirthday(),
                                                                                                                                                user.getBirthday()).append(getSex(),
                                                                                                                                                                           user.getSex()).append(getCreateTime(),
                                                                                                                                                                                                 user.getCreateTime()).append(getDeleteTime(),
                                                                                                                                                                                                                              user.getDeleteTime()).append(getVersion(),
                                                                                                                                                                                                                                                           user.getVersion()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17,
                                   37).appendSuper(super.hashCode()).append(getId()).append(getName()).append(getDeleteFlag()).append(getBirthday()).append(getSex()).append(getCreateTime()).append(getDeleteTime()).append(getVersion()).toHashCode();
    }
}
