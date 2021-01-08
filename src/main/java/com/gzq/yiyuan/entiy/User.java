package com.gzq.yiyuan.entiy;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户状态:0=正常,1=禁用
     */
    private Boolean state;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像图片地址
     */
    private String headImgUrl;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码加盐
     */
    private String salt;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 创建时间
     */

    private Date createtime;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date editetime;

    /**
     * 修改人
     */
    private String editor;

    /**
     * 逻辑删除:0=未删除,1=已删除
     */
    private Boolean deleted;

    private static final long serialVersionUID = 1L;
}