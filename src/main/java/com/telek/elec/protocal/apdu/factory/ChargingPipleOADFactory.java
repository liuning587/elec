package com.telek.elec.protocal.apdu.factory;

import com.telek.elec.protocal.data.model.OAD;
import com.telek.elec.protocal.data.model.OI;
import com.telek.elec.protocal.data.model.OMD;

/**
 * 充电桩oad/omd工厂类
 */
public class ChargingPipleOADFactory {

    public static final OI OI = new OI(0x4312);

    /**
     * 状态
     * 属性2
     * @return enum{关闭（0），打开（1）
     */
    public static OAD state() {
        return new OAD(OI, 2, 0);
    }

    /**
     * 负荷控制状态
     * 属性3
     * @return =enum{未打开负荷控制（0），打开负荷控制（1）
     */
    public static OAD loadControlState() {
        return new OAD(OI, 3, 0);
    }

    /**
     * 预约时间控制
     * 属性4
     * @return enum{未打开时间控制（0），打开时间控制（1）
     */
    public static OAD appointControlPeriod() {
        return new OAD(OI, 4, 0);
    }

    /**
     * 负荷控制阈值
     * 属性5
     * @return 有功功率
     */
    public static OAD loadControlThreshold() {
        return new OAD(OI, 5, 0);
    }

    /**
     * 自动控制时段
     * 属性6
     * @return 有功功率
     */
    public static OAD autoControlPeriod() {
        return new OAD(OI, 6, 0);
    }

    /**
     * 打开
     * 方法127
     * @return null
     */
    public static OMD on() {
        return new OMD(OI, 127, 0);
    }

    /**
     * 关闭
     * 方法128
     * @return null
     */
    public static OMD off() {
        return new OMD(OI, 128, 0);
    }

    /**
     * 打开负荷控制
     * 方法129
     * @return null
     */
    public static OMD onLoadControl() {
        return new OMD(OI, 129, 0);
    }

    /**
     * 关闭负荷控制
     * 方法130
     * @return null
     */
    public static OMD offLoadControl() {
        return new OMD(OI, 130, 0);
    }

    /**
     * 打开预约时段
     * 方法131
     * @return null
     */
    public static OMD onAppointPeriod() {
        return new OMD(OI, 131, 0);
    }

    /**
     * 关闭预约时段
     * 方法132
     * @return null
     */
    public static OMD offAppointPeriod() {
        return new OMD(OI, 132, 0);
    }

}
