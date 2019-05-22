package com.gemall.library.bean.requestbean;

/**
 * @auther g-emall
 * @date 2019/4/16 14:02
 */
public class CheckCodeParam {
    private String mobile;
    private int type;//验证码类型（必填，1：注册 2：重置密码 3：绑定银行卡 4：绑定手机 5：手机验证码快捷登录）

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
