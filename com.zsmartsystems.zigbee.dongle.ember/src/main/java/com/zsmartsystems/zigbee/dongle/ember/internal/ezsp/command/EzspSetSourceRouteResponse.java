/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameResponse;

/**
 * Class to implement the Ember EZSP command <b>setSourceRoute</b>.
 * <p>
 * Supply a source route for the next outgoing message.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspSetSourceRouteResponse extends EzspFrameResponse {
    public static final int FRAME_ID = 0x5A;

    /**
     * The destination of the source route.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     */
    private int destination;

    /**
     * The route record. Each relay in the list is an uint16_t node ID.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     */
    private int[] relayList;

    /**
     * Response and Handler constructor
     */
    public EzspSetSourceRouteResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        // Deserialize the fields
        destination = deserializer.deserializeUInt16();
        int relayCount = deserializer.deserializeUInt8();
        relayList= deserializer.deserializeUInt8Array(relayCount);
    }

    /**
     * The destination of the source route.
     * <p>
     * EZSP type is <i>EmberNodeId</i> - Java type is {@link int}
     *
     * @return the current destination as {@link int}
     */
    public int getDestination() {
        return destination;
    }

    /**
     * The destination of the source route.
     *
     * @param destination the destination to set as {@link int}
     */
    public void setDestination(int destination) {
        this.destination = destination;
    }

    /**
     * The route record. Each relay in the list is an uint16_t node ID.
     * <p>
     * EZSP type is <i>uint8_t[]</i> - Java type is {@link int[]}
     *
     * @return the current relayList as {@link int[]}
     */
    public int[] getRelayList() {
        return relayList;
    }

    /**
     * The route record. Each relay in the list is an uint16_t node ID.
     *
     * @param relayList the relayList to set as {@link int[]}
     */
    public void setRelayList(int[] relayList) {
        this.relayList = relayList;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(104);
        builder.append("EzspSetSourceRouteResponse [destination=");
        builder.append(destination);
        builder.append(", relayList=");
        for (int c = 0; c < relayList.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", relayList[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}
