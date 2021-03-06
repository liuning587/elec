package com.telek.elec.protocal.apdu.connection;

import com.telek.elec.protocal.apdu.CodecAPDU;
import com.telek.elec.protocal.constant.APDUSequence;
import com.telek.elec.util.StringUtils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 服务端断开链接响应:
 */
@Data
@Slf4j
public class ReleaseResponse extends CodecAPDU implements Release {

    /**
     * 是否成功-1字节
     */
    private int success;

    public ReleaseResponse() {
        this.apduSequence = APDUSequence.RELEASE_RESPONSE;
    }

    @Override
    public void decodeSpecialHexToThis(String hexString) {
        int index = this.decodeHexExcludeCommonBeginIndex;
        this.success = Integer.parseInt(hexString.substring(index, index += 2), 16);
    }

    @Override
    protected String encodeThisSpecialToHex() {
        return StringUtils.subLastNumStr(Integer.toHexString(success), 2);
    }
}
