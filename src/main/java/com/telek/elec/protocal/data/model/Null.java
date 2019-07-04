package com.telek.elec.protocal.data.model;

import com.telek.elec.protocal.constant.DataType;

import lombok.Data;

@Data
public class Null extends IData {

    public Null() {
        super(DataType.NULL);
    }

    @Override
    protected int calculateSpecialCharLength() {
        return 0;
    }

    @Override
    protected String encodeSpecial() {
        return null;
    }

    @Override
    protected int decodeSpecial(String hexExcludeDataType) {
        return 0;
    }
}
