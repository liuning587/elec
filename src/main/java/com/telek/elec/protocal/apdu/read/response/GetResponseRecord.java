package com.telek.elec.protocal.apdu.read.response;

import com.telek.elec.protocal.apdu.ResTypeCodecAPDU;
import com.telek.elec.protocal.apdu.model.GetRecord;
import com.telek.elec.protocal.apdu.read.Get;
import com.telek.elec.protocal.constant.APDUResType;
import com.telek.elec.protocal.constant.APDUSequence;
import com.telek.elec.protocal.exeception.DecodeException;
import com.telek.elec.protocal.exeception.EncodeException;

import lombok.Data;

/**
 * 响应： 85 03 03 50 04 02 00 02 00 20 21 02 00 00 00 10 02 00 01 01 1C 07 EO 01 14 00 00
 * 00 01 05 06 00 00 00 00 06 00 00 00 00 06 00 00 00 00 06 00 00 00 00 06 00 00 00 00 00 00
 * 85 —— [133] GET-Response
 * 03 —— [3] GeResponseRecord
 * 03 —— PIID-ACD
 * 50 04 02 00 —— OAD
 * 02 —— RCSD， SEQUENCE OF个数=2
 * 00 20 21 02 00 —— 第1列OAD
 * 00 00 10 02 00 —— 第2列OADQ/GDW 11778—2017
 * 201
 * 01 —— 记录数据
 * 01 —— M条记录， M=1
 * 1C 07 E0 01 14 00 00 00 —— 第1列数据Data
 * 01 —— 第2列数据Data
 * 05
 * 06 00 00 00 00
 * 06 00 00 00 00
 * 06 00 00 00 00
 * 06 00 00 00 00
 * 06 00 00 00 00
 * 00 —— FollowReport OPTIONAL=0 表示没有上报信息
 * 00 —— 没有时间标签
 */
@Data
public class GetResponseRecord extends ResTypeCodecAPDU implements Get {

    private GetRecord getRecord;

    public GetResponseRecord() {
        super(APDUResType.GET_RECORD);
        this.apduSequence = APDUSequence.GET_REQUEST;
    }

    @Override
    protected String encodeThisSpecialToHex() throws EncodeException {
        StringBuilder sb = new StringBuilder();
        sb.append(getRecord.encode());
        return sb.toString();
    }

    @Override
    protected void decodeSpecialHexToThis(String hexString) throws DecodeException {
        GetRecord getRecord = new GetRecord();
        getRecord.decode(hexString);
        this.getRecord = getRecord;
    }
}
