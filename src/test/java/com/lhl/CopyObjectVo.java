package com.lhl;

/**
 * Created by lenovo on 2016/3/26.
 */
public class CopyObjectVo {
    private long id;
    private String username;
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 复制copy.
     *
     * @param copyObject 被copy对象
     * @return 返回copy 对象
     */
    public CopyObjectVo getCopy(CopyObject copyObject) {
        this.setId(copyObject.getId());
        this.setUsername(copyObject.getUsername());
        this.setPassword(copyObject.getPassword());
        return this;
    }
}
