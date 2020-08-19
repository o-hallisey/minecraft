package com.bnegames.minecraft.blocks;

import com.bnegames.minecraft.MinecraftMod;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BNEBlockItem extends BlockItem
{
	public BNEBlockItem(Block blockIn, Properties builder) {
		super(blockIn, builder);
	}
	public BNEBlockItem(Block blockIn) {
		super(blockIn, new Item.Properties().group(MinecraftMod.BNEGAMES_TAB));
	}	
}
