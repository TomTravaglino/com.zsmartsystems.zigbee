/**
 * Copyright (c) 2016-2018 by the respective copyright holders.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.command;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.EzspFrameRequest;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.serializer.EzspSerializer;
import com.zsmartsystems.zigbee.dongle.ember.internal.ezsp.structure.EmberKeyData;

/**
 * Class to implement the Ember EZSP command <b>addTransientLinkKey</b>.
 * <p>
 * This is a function to add a temporary link key for a joining device. The key will get timed out
 * after a defined timeout period if the device does not update its link key with the Trust
 * Center.
 * <p>
 * This class provides methods for processing EZSP commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class EzspAddTransientLinkKeyRequest extends EzspFrameRequest {
    public static final int FRAME_ID = 0xAF;

    /**
     * This is the IEEE address of the partner that the device successfully established a key with.
     * This value is all zeros on a failure.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     */
    private IeeeAddress partner;

    /**
     * The transient key data for the joining device.
     * <p>
     * EZSP type is <i>EmberKeyData</i> - Java type is {@link EmberKeyData}
     */
    private EmberKeyData transientKey;

    /**
     * Serialiser used to seialise to binary line data
     */
    private EzspSerializer serializer;

    /**
     * Request constructor
     */
    public EzspAddTransientLinkKeyRequest() {
        frameId = FRAME_ID;
        serializer = new EzspSerializer();
    }

    /**
     * This is the IEEE address of the partner that the device successfully established a key with.
     * This value is all zeros on a failure.
     * <p>
     * EZSP type is <i>EmberEUI64</i> - Java type is {@link IeeeAddress}
     *
     * @return the current partner as {@link IeeeAddress}
     */
    public IeeeAddress getPartner() {
        return partner;
    }

    /**
     * This is the IEEE address of the partner that the device successfully established a key with.
     * This value is all zeros on a failure.
     *
     * @param partner the partner to set as {@link IeeeAddress}
     */
    public void setPartner(IeeeAddress partner) {
        this.partner = partner;
    }

    /**
     * The transient key data for the joining device.
     * <p>
     * EZSP type is <i>EmberKeyData</i> - Java type is {@link EmberKeyData}
     *
     * @return the current transientKey as {@link EmberKeyData}
     */
    public EmberKeyData getTransientKey() {
        return transientKey;
    }

    /**
     * The transient key data for the joining device.
     *
     * @param transientKey the transientKey to set as {@link EmberKeyData}
     */
    public void setTransientKey(EmberKeyData transientKey) {
        this.transientKey = transientKey;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(serializer);

        // Serialize the fields
        serializer.serializeEmberEui64(partner);
        serializer.serializeEmberKeyData(transientKey);
        return serializer.getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder(83);
        builder.append("EzspAddTransientLinkKeyRequest [partner=");
        builder.append(partner);
        builder.append(", transientKey=");
        builder.append(transientKey);
        builder.append(']');
        return builder.toString();
    }
}
