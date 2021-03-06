package com.telek.elec.protocal.apdu.factory;

import com.telek.elec.protocal.data.model.OAD;
import com.telek.elec.protocal.data.model.OI;
import com.telek.elec.protocal.data.model.OMD;

/**
 * 路灯oad/omd工厂类
 */
public class StreetLampOADFactory {

    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int AUTO_CONTROL_ON = 1;
    public static final int AUTO_CONTROL_OFF = 0;

    public static final OI OI = new OI(0x4310);

    /**
     * 控制状态
     * 属性2
     * @return enum
     */
    public static OAD controlState() {
        return new OAD(OI, 2, 0);
    }

    /**
     * 自动控制状态
     * 属性3
     * @return enum
     */
    public static OAD autoControlState() {
        return new OAD(OI, 3, 0);
    }

    /**
     * 自动控制时段
     * 属性4
     * @return  array::structure
     *          {
     *              起始小时 unsigned，
     *              起始分钟 unsigned，
     *              结束小时 unsigned，
     *              结束分钟 unsigned
     *          }
     */
    public static OAD autoControlPeriod() {
        return new OAD(OI, 4, 0);
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
     * 打开自动控制
     * 方法129
     * @return null
     */
    public static OMD onAutoControl() {
        return new OMD(OI, 129, 0);
    }

    /**
     * 关闭自动控制
     * 方法130
     * @return null
     */
    public static OMD offAutoControl() {
        return new OMD(OI, 130, 0);
    }

}
