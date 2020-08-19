package com.bnegames.minecraft.util;


import com.bnegames.minecraft.MinecraftMod;
import com.bnegames.minecraft.blocks.BNEBlockItem;
import com.bnegames.minecraft.blocks.BoomCube;
import com.bnegames.minecraft.items.Bling;
import com.bnegames.minecraft.items.Boomstick;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {
  public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MinecraftMod.MOD_ID);
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MinecraftMod.MOD_ID);
  
  //items
  public static final RegistryObject<Item> BLING = ITEMS.register("ruby",Bling::new);
  public static final RegistryObject<Item> BOOMSTICK = ITEMS.register("boomstick", Boomstick::new);

  //blocks
  public static final RegistryObject<Block> BOOMCUBE = BLOCKS.register("boomcube", BoomCube::new);
  public static final RegistryObject<Item> BOOMCUBE_ITEM = ITEMS.register("boomcube",  () -> new BNEBlockItem(BOOMCUBE.get()));
	
  public static void init()
  {
	  ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	  BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
  }
  
}
