package com.frozerain.externalview.event;

import com.frozerain.externalview.event.init.ExternalViewKeys;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ExternalViewEvent {

    public static void preInitialize(FMLPreInitializationEvent event) {
        //As the mod uses "clientSideOnly = true", it will always run on the client side
        ExternalViewKeys.registerKeyBindings();
    }
}
