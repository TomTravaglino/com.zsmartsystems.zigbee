package com.zsmartsystems.zigbee.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.zsmartsystems.zigbee.IeeeAddress;
import com.zsmartsystems.zigbee.ZigBeeNode;
import com.zsmartsystems.zigbee.zdo.descriptors.PowerDescriptor;
import com.zsmartsystems.zigbee.zdo.descriptors.PowerDescriptor.PowerLevelType;
import com.zsmartsystems.zigbee.zdo.descriptors.PowerDescriptor.PowerSourceType;

public class ZigBeeNodeTest {
    @Test
    public void testSetIeeeAddress() {
        ZigBeeNode node = new ZigBeeNode();
        node.setIeeeAddress(new IeeeAddress("17880100dc880b"));
        assertEquals(new IeeeAddress("17880100dc880b"), node.getIeeeAddress());
    }

    @Test
    public void testSetPowerDescriptor() {
        PowerDescriptor descriptor = new PowerDescriptor(1, 2, 4, 0xc0);
        ZigBeeNode node = new ZigBeeNode();
        node.setPowerDescriptor(descriptor);
        assertEquals(1, node.getPowerDescriptor().getCurrentPowerMode());
        assertEquals(PowerSourceType.DisposableBattery, node.getPowerDescriptor().getCurrentPowerSource());
        assertEquals(PowerLevelType.Full, node.getPowerDescriptor().getPowerLevel());
    }

}