package com.example.mybatistest.note.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 作品表
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("note_work")
@ApiModel(value="Work对象", description="作品表")
public class Work implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "作品标题")
    private String title;

    @ApiModelProperty(value = "图片地址")
    private String imagesUrl;

    @ApiModelProperty(value = "详细描述")
    private String descript;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
