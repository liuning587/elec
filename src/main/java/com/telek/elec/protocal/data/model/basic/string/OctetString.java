package com.telek.elec.protocal.data.model.basic.string;

import com.telek.elec.protocal.constant.DataType;

import lombok.Data;

/**
 * 字符串
 * 09 —— octet-string
 * 06 —— SIZE(6)
 * 12 34 56 78 90 12 —— 通信地址：123456789012
 */
@Data
public class OctetString extends AbsString {

    public OctetString() {
        this.dataType = DataType.OCTET_STRING;
    }

    public OctetString(byte[] value) {
        this();
        if (value == null) {
            this.size = 0;
        } else {
            this.value = value;
            this.size = value.length;
        }
    }
}