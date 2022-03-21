package com.frozerain.externalview;

import com.frozerain.externalview.event.ExternalViewEvent;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExternalView.MODID, name = ExternalView.NAME, version = ExternalView.VERSION, clientSideOnly = true, serverSideOnly = false)
public class ExternalView
{
    public static final String MODID = "externalview";
    public static final String NAME = "External View Mod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        ExternalViewEvent.preInitialize(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        // some example code
        //logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
