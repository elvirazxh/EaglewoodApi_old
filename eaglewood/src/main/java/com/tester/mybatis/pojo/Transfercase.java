package com.tester.mybatis.pojo;

import java.util.Date;

public class Transfercase {
    private String id;

    private String paramjson;

    private String resultjson;

    private String except;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getParamjson() {
        return paramjson;
    }

    public void setParamjson(String paramjson) {
        this.paramjson = paramjson == null ? null : paramjson.trim();
    }

    public String getResultjson() {
        return resultjson;
    }

    public void setResultjson(String resultjson) {
        this.resultjson = resultjson == null ? null : resultjson.trim();
    }

    public String getExcept() {
        return except;
    }

    public void setExcept(String except) {
        this.except = except == null ? null : except.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}