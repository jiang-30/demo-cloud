package org.jiang.combo.admin.common.enums;

public enum EnabledEnum {
    ENABLED("1", "启用"),
    DISABLED("0", "禁用");

    private String code;
    private String label;

    EnabledEnum(String  code,  String  label) {
        this.code = code;
        this.label = label;
    }
}
