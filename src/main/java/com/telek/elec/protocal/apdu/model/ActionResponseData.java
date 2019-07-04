package com.telek.elec.protocal.apdu.model;

import com.telek.elec.protocal.constant.DARType;
import com.telek.elec.protocal.exeception.DecodeException;
import com.telek.elec.protocal.exeception.EncodeException;
import com.telek.elec.util.StringUtils;

import lombok.Data;

/**
 * 00 10 01 00 —— OMD
 * 00 —— DAR，0成功
 * 00 —— Data OPTIONAL=0 表示没有数据
 */
@Data
public class ActionResponseData extends IResult {

    private OMD omd;
    /**
     * 结果-1字节
     */
    private DARType dar;
    /**
     * 2字节
     */
    private DataInfo data;

    @Override
    protected String encodeSpecial() throws EncodeException {
        StringBuilder sb = new StringBuilder();
        sb.append(omd.encode());
        sb.append(StringUtils.subLastNumStr(Integer.toHexString(dar.getCode()), 2));
        sb.append(data.encode());
        return sb.toString();
    }

    @Override
    protected int decodeSpecial(String hexString) throws DecodeException {
        int index = 0;
        OMD omd = new OMD();
        omd.decode(hexString.substring(index, index += 8));
        this.omd = omd;
        int dar = Integer.parseInt(hexString.substring(index, index += 2), 16);
        for (DARType value : DARType.values()) {
            if (dar == value.getCode()) {
                this.dar = value;
                break;
            }
        }
        DataInfo dataInfo = new DataInfo();
        dataInfo.decode(hexString.substring(index));
        this.data = dataInfo;
        return 8 + 2 + 2;
    }
}
