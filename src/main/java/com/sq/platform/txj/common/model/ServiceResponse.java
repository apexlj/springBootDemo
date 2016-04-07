package com.sq.platform.txj.common.model;


import java.io.Serializable;

/**
 * @author lijiang
 * @version 1.0
 * @date 创建时间：2015年3月11日 下午4:51:51
 */
public class ServiceResponse implements Serializable {

    private static final long serialVersionUID = -8671304624172861791L;
    /**
     * 实体
     */
    private Object entity;

    /**
     * 状态码
     */
    private String status;

    /**
     * 消息
     */
    private String msg;

    public ServiceResponse() {
    }

    private ServiceResponse(ServiceResponseBuilder builder) {
        entity = builder.entity;
        status = builder.status;
        msg = builder.msg;
    }

    public static ServiceResponseBuilder ok() {
        return status("200");
    }

    public static ServiceResponseBuilder ok(Object entity) {
        if (entity == null)
            return ok();
        return status("200").entity(entity);
    }

    public static ServiceResponseBuilder status(String statusCode) {
        ServiceResponseBuilder responseBuilder = new ServiceResponseBuilder();
        return responseBuilder.status(statusCode);
    }

    /**
     * 构造器
     */
    public static class ServiceResponseBuilder {
        private Object entity;
        private String status;
        private String msg;

        public ServiceResponseBuilder status(String statusCode) {
            this.status = statusCode;
            return this;
        }

        public ServiceResponseBuilder entity(Object entity) {
            this.entity = entity;
            return this;
        }

        public ServiceResponseBuilder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ServiceResponse build() {
            return new ServiceResponse(this);
        }
    }

    /**
     * @return the entity
     */
    public Object getEntity() {
        return entity;
    }

    /**
     * @param entity the entity to set
     */
    public void setEntity(Object entity) {
        this.entity = entity;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
