package com.aiopr;

import java.util.HashSet;

/**
 * @author liguoqing6@jd.com
 * @ClassName: ReturnStatusEnum
 * @Description:返回状态枚举类
 * @date 2018年7月10日
 */
public enum ReturnStatusEnum {

    SERVICE_SUCCESS(200, "成功"),
    /**
     * 参数部分
     ****/
    PARAM_ERROR(3000, "参数错误,%s"),
    /**
     * 数据库部分
     ****/
    SERVER_ERROR(4000, "服务器错误"),
    DATA_EXCEPTION(4010, "数据库异常"),
    MIDDLEWARE_ERROR(4100, "中间件错误"),
    /**
     * 系统部分
     ****/
    NETWORK_ERROR(5000, "网络异常"),
    UNKNOWN_ERROR(5100, "未知错误"),
    SERVICE_ERROR(5200, "接口调用错误"),
    PARTITION_ERROR(5300, "部分操作错误"),
    PENDING(5400, "请求处理中，请稍后"),
    /**
     * 业务部分
     ****/
    RECORD_NOT_EXIST(6000, "记录不存在"),
    UNAUTHORIZED_ERROR(6100, "未授权访问错误"),
    LOGIN_ERROR(6200, "用户名或密码错误"),
    /**
     * 上传文件
     **/
    UPLOAD_MOBAN_ERROR(7004, "excel不匹配"),
    /**
     * 批量导入schema
     **/
    SCHEMA_SAVE_ERROR(7105, "批量导入Schema失败"),
    SCHEMA_SAVE_SUCCESS(7104, "批量导入Schema成功"),
    RECORD__EXIST(6200, "记录已存在"),
    RECORD__EXIST_SORTNAME(6300, "修改后的规则名称对应的记录己存在"),

    /**
     * ES返回结果
     ***/
    NO_INDEX(7000, "没有对应的索引"),
    JSON_TRANSITION_ERROR(7100, "JSON转换错误"),
    HTTPREQUEST_ERROR(7200, "请求ES接口返回出错"),
    EMPTY_RESULT(7300, "ES请求结果为空"),
    DATABASE_SEARCH_ERROR(7400, "数据库查询出错"),
    /**
     * Speech接口部分
     **/
    SPEECH_NAME_EXIST(8001, "所属的品类,词性名称已存在!"),
    SPEECH_NAME_VALUE_EXIST(8002, "所属的品类、词性名称,词性值已存在!"),
    SPEECH_VALUE_SAVE_FAILD(8004, "词性值所属品类不存在或数据已删除"),
    SPEECH_NAME_VALUE_NOT_SAME(8004, "添加词性值输入词性名称与speech表不一致"),
    UPLOAD_ERROR(8003, "上传文件失败");


    private final int value;
    private final String desc;

    private ReturnStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    public String getDesc4Log() {
        return "ERROR_CODE:" + value + "\t" + desc + "\t";
    }

    private static HashSet<Integer> hashSet;

    static {
        hashSet = new HashSet<Integer>();
        hashSet.clear();
        for (ReturnStatusEnum returnStatus : ReturnStatusEnum.values()) {
            hashSet.add(returnStatus.getValue());
        }
    }

    public static boolean isDefined(int value) {
        if (hashSet.contains(value)) {
            return true;
        }
        return false;
    }

    public static ReturnStatusEnum get(int value) {
        for (ReturnStatusEnum o : ReturnStatusEnum.values()) {
            if (value == o.getValue()) {
                return o;
            }
        }
        return null;
    }
}
