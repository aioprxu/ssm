package com.aiopr;



/**
 * @ClassName: Result
 * @Description: 返回结果封装
 * @author liguoqing6@jd.com
 * @date 2018年7月10日
 */
public class Result {
    /**
     * 返回码的值
     */
    private Integer status = ReturnStatusEnum.SERVICE_SUCCESS.getValue();
    /**
     * 返回码的描述
     */
    private String message = ReturnStatusEnum.SERVICE_SUCCESS.getDesc();
    /**
     * 返回的数据
     */
    private Object data;
    /**
     * 耗时
     */
    private Long timeCost;

    private Integer count;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Long timeCost) {
        this.timeCost = timeCost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}