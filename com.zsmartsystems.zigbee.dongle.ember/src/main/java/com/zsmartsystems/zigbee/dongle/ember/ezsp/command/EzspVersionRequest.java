/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.ezsp.serializer.EzspSerializer;

/**
 * Class to implement the Ember EZSP command <b>version</b>.
 * <p>
 * The command allows the Host to specify the desired EZSP version and must be sent before any
 * other command. This document describes EZSP version 4 and stack type 2 (mesh). The response
 * provides information about the firmware running on the NCP.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspVersionRequest extends EzspFrameRequest {
    public static int FRAME_ID = 0x00;

    /**
     * The EZSP version the Host wishes to use. To successfully set the version and allow other
     * commands.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     */
    private int desiredProtocolVersion;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspVersionRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * The EZSP version the Host wishes to use. To successfully set the version and allow other
     * commands.
     * <p>
     * EZSP type is <i>uint8_t</i> - Java type is {@link int}
     *
     * @return the current desiredProtocolVersion as {@link int}
     */
    public int getDesiredProtocolVersion() {
        return desiredProtocolVersion;
    }

    /**
     * The EZSP version the Host wishes to use. To successfully set the version and allow other
     * commands.
     *
     * @param desiredProtocolVersion the desiredProtocolVersion to set as {@link int}
     */
    public void setDesiredProtocolVersion(int desiredProtocolVersion) {
        this.desiredProtocolVersion = desiredProtocolVersion;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeUInt8(desiredProtocolVersion);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(46);
        builder.append("EzspVersionRequest [desiredProtocolVersion=");
        builder.append(desiredProtocolVersion);
        builder.append(']');
        return builder.toString();
    }
}
