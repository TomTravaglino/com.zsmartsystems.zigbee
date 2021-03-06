/**
 * Copyright (c) 2016-2019 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.zcl.clusters.basic;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

/**
 * Enumeration of Basic attribute PowerSource options.
 * <p>
 * Code is auto-generated. Modifications may be overwritten!
 *
 * @author Chris Jackson
 */
@Generated(value = "com.zsmartsystems.zigbee.autocode.ZclProtocolCodeGenerator", date = "2018-03-31T12:00:43Z")
public enum PowerSourceEnum {
    UNKNOWN(0x0000),
    MAINS_SINGLE_PHASE(0x0001),
    MAINS_THREE_PHASE(0x0002),
    BATTERY(0x0003),
    DC_SOURCE(0x0004),
    EMERGENCY_MAINS_CONSTANT(0x0005),
    EMERGENCY_MAINS_CHANGEOVER(0x0006);

    /**
     * A mapping between the integer code and its corresponding PowerSourceEnum type to facilitate lookup by value.
     */
    private static Map<Integer, PowerSourceEnum> idMap;

    static {
        idMap = new HashMap<Integer, PowerSourceEnum>();
        for (PowerSourceEnum enumValue : values()) {
            idMap.put(enumValue.key, enumValue);
        }
    }

    private final int key;

    PowerSourceEnum(final int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public static PowerSourceEnum getByValue(final int value) {
        return idMap.get(value);
    }
}
