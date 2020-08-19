package com.bnegames.minecraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bnegames.minecraft.util.RegistryHandler;

@Mod("bnegames")
public class MinecraftMod 
{
    public static final String MOD_ID = "bnegames";
    public static Item sword;

    private static final Logger LOGGER = LogManager.getLogger();
    
    public MinecraftMod()
    {
    	// Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        
        RegistryHandler.init();
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM Avery Hallisey");
        LOGGER.info("DIRT BLOCK >> {}", net.minecraft.block.Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    public static final ItemGroup BNEGAMES_TAB = new ItemGroup("bnegamesTab") {

		@Override
		public ItemStack createIcon() {
			return new ItemStack(RegistryHandler.BOOMSTICK.get());
		}
    	
    };
}
