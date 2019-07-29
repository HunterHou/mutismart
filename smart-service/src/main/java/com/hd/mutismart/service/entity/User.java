package com.hd.mutismart.service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.hd.mutismart.base.param.BasePageParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author hunter
 */
@Data
@ApiModel
public class User extends BasePageParam {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "ID", dataType = "Long", name = "ID", example = "")
    private Long          id;
    @ApiModelProperty(value = "名称", dataType = "String", name = "name", example = "001")
    @NotBlank(message = "名称不能为空")
    private String        name;
    private Boolean       deleteFlag = false;
    @ApiModelProperty(value = "生日", dataType = "Date", name = "birthday", example = "")
    private LocalDate     birthday;
    @ApiModelProperty(value = "性别", dataType = "String", name = "sex", example = "男")
    private String        sex;
    @ApiModelProperty(value = "创建日期", dataType = "Date", name = "createTime", example = "不用天")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "删除日期", dataType = "Date", name = "createTime", example = "不用天")
    private LocalDateTime deleteTime;
    @Version
    @ApiModelProperty(value = "版本", dataType = "Date", name = "createTime", example = "不用天")
    private Long          version;

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
