package com.telek.elec.protocal.apdu.action.response;

import com.telek.elec.protocal.apdu.ResTypeCodecAPDU;
import com.telek.elec.protocal.apdu.action.Action;
import com.telek.elec.protocal.apdu.model.action.ActionResponseData;
import com.telek.elec.protocal.constant.APDUResType;
import com.telek.elec.protocal.constant.APDUSequence;
import com.telek.elec.protocal.exeception.DecodeException;
import com.telek.elec.protocal.exeception.EncodeException;
import com.telek.elec.util.StringUtils;

import lombok.Data;

/**
 * 响应一个对象属性请求
 * 响应：87 01 05 00 10 01 00 00 00 00 00
 * 87 ——  [135] ACTION-Response
 * 01 ——  [1] ActionResponseNormal
 * 05 —— PIID-ACD
 * 00 10 01 00 —— OMD
 * 00 —— DAR，0成功
 * 00 —— Data OPTIONAL=0 表示没有数据
 * 00 —— FollowReport  OPTIONAL=0 表示没有上报信息
 * 00 —— 没有时间标签
 */
@Data
public class ActionResponseNormal extends ResTypeCodecAPDU implements Action {

    private ActionResponseData actionResponseData;
    /**
     * 标识是否有上报信息-1字节
     */
    private int followReport;
    /**
     * 时间标签-1字节
     */
    private int timeStamp;

    public ActionResponseNormal() {
        super(APDUResType.ACTION_NORMAL);
        this.apduSequence = APDUSequence.ACTION_RESPONSE;
    }

    @Override
    protected String encodeThisSpecialToHex() throws EncodeException {
        StringBuilder sb = new StringBuilder();
        if (actionResponseData != null) {
            sb.append(actionResponseData.encode());
        }
        sb.append(StringUtils.subLastNumStr(Integer.toHexString(followReport), 2));
        sb.append(StringUtils.subLastNumStr(Integer.toHexString(timeStamp), 2));
        return sb.toString();
    }

    @Override
    protected void decodeSpecialHexToThis(String hexString) throws DecodeException {
        int length = hexString.length();
        ActionResponseData actionResponseData = new ActionResponseData();
        actionResponseData.decode(hexString.substring(this.decodeHexExcludeCommonBeginIndex, length - 4));
        this.actionResponseData = actionResponseData;
        this.followReport = Integer.parseInt(hexString.substring(length - 4, length - 2), 16);
        this.timeStamp = Integer.parseInt(hexString.substring(length - 2, length), 16);
    }
}
