package com.hd.mutismart.search.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.hd.mutismart.base.param.BasePageParam;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Document(indexName = "mutiSmart", type = "user")
@Data
public class EsUser extends BasePageParam {

    public static String  indexType  = "user";
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "ID", dataType = "Long", name = "ID", example = "")
    private Long          id;
    @ApiModelProperty(value = "名称", dataType = "String", name = "name", example = "001")
    @NotBlank(message = "名称不能为空")
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
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
        return new ToStringBuilder(this).append("id",
                                                getId()).append("name",
                                                                getName()).append("birthday",
                                                                                  getBirthday()).append("sex",
                                                                                                        getSex()).toString();
    }
}
