package com.telek.elec.protocal.service;

import com.telek.elec.protocal.apdu.action.request.ActionRequestNormal;
import com.telek.elec.protocal.apdu.model.ActionRequestData;
import com.telek.elec.protocal.apdu.model.DataInfo;
import com.telek.elec.protocal.apdu.read.request.GetRequestNormal;
import com.telek.elec.protocal.data.model.basic.Null;
import com.telek.elec.protocal.data.model.complex.OAD;
import com.telek.elec.protocal.data.model.complex.OMD;

public class RequestFactory {

    /**
     * 根据omd获取操作请求
     * @param omd
     * @return
     */
    public static ActionRequestNormal getActionRequestNormal(OMD omd) {
        ActionRequestNormal actionRequestNormal = new ActionRequestNormal();
        actionRequestNormal.setTimeStamp(0);

        ActionRequestData requestData = new ActionRequestData();
        requestData.setOmd(omd);
        requestData.setData(new DataInfo(new Null()));
        actionRequestNormal.setActionRequestData(requestData);
        return actionRequestNormal;
    }

    /**
     * 根据oad获取
     * @param oad
     * @return
     */
    public static GetRequestNormal getRequestNormal(OAD oad) {
        return new GetRequestNormal(oad, 0);
    }

}