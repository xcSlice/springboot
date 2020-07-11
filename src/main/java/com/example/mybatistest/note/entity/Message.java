package com.example.mybatistest.note.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 留言表
 * </p>
 *
 * @author xusi
 * @since 2020-07-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("note_message")
@ApiModel(value="Message对象", description="留言表")
public class Message implements Serializable {

    private static final long serialVersionUID=1L;
    @ApiModelProperty(value = "消息id",example = "1")
    private Integer id;
    @ApiModelProperty(value = "留言用户id",example = "1")
    private Integer userId;

    @ApiModelProperty(value = "留言用户名")
    private String userName;

    @ApiModelProperty(value = "留言文本")
    private String msg;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime gmtCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime gmtModified;


}
