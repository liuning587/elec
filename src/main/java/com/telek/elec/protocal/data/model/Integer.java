package com.telek.elec.protocal.data.model;

import com.telek.elec.protocal.constant.DataType;
import com.telek.elec.util.StringUtils;

import lombok.Data;

/**
 * 整数
 */
@Data
public class Integer extends AbsBasicData {
    /**
     * 1字节
     */
    private int value;

    public Integer() {
        super(DataType.INTEGER);
    }

    @Override
    protected int calculateSpecialCharLength() {
        return 2;
    }

    @Override
    protected String encodeSpecial() {
        return StringUtils.subLastNumStr(java.lang.Integer.toHexString(value), 2);
    }

    @Override
    protected int decodeSpecial(String hexExcludeDataType) {
        this.value = java.lang.Integer.parseInt(hexExcludeDataType.substring(0, 2), 16);
        return 2;
    }
}
