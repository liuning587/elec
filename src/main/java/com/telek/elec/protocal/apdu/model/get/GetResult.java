package com.telek.elec.protocal.apdu.model.get;

import com.telek.elec.protocal.apdu.model.AbsDataModel;
import com.telek.elec.protocal.apdu.model.DAR;
import com.telek.elec.protocal.apdu.model.constant.DataResultType;
import com.telek.elec.protocal.data.Datas;
import com.telek.elec.protocal.data.HexToDataConvertor;
import com.telek.elec.protocal.data.model.AbsData;
import com.telek.elec.protocal.exeception.DecodeException;
import com.telek.elec.protocal.exeception.EncodeException;
import com.telek.elec.util.StringUtils;

import lombok.Data;

/**
 * get得到的结果
 * 01 —— Data/dar
 * 09 —— octet-string
 * 06 —— SIZE(6)
 * 12 34 56 78 90 12 —— 通信地址：123456789012
 */
@Data
public class GetResult extends AbsDataModel {
    /**
     * 响应的数据类型-1字节，如果为data则表示有数据
     */
    private DataResultType getResultType;
    /**
     * 正确返回数据
     */
    private Datas data;
    /**
     * 错误信息
     */
    private DAR dar;


    @Override
    protected String encodeSpecial() throws EncodeException {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtils.subLastNumStr(Integer.toHexString(getResultType.getCode()), 2));
        if (DataResultType.DAR.equals(getResultType)) {
            sb.append(dar.encode());
        } else if (DataResultType.DATA.equals(getResultType)) {
            sb.append(data.encode());
        }
        return sb.toString();
    }

    @Override
    protected int decodeSpecial(String hexString) throws DecodeException {
        // 数据类型
        int resultType = Integer.parseInt(hexString.substring(0, 2), 16);
        /*for (DataResultType value : DataResultType.values()) {
            if (resultType == value.getCode()) {
                this.getResultType = value;
                break;
            }
        }*/
        this.getResultType = DataResultType.getByCode(resultType);

        // 解码数据
        String hex = hexString.substring(2);
        if (DataResultType.DATA.equals(this.getResultType)) {
            AbsData absData = HexToDataConvertor.hexToData(hex);
            this.data = new Datas(absData);
            return absData.getCharLength() + 2;
        } else if (DataResultType.DAR.equals(this.getResultType)) {
            DAR resultDAR = new DAR();
            int charLength = resultDAR.decode(hex);
            this.dar = resultDAR;
            return charLength + 2;
        } else {
            return 0;
        }
    }
}
