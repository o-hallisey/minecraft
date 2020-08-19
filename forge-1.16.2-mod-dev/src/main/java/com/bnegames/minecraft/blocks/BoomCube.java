package com.bnegames.minecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
	
public class BoomCube extends Block
{
	private static final Block.Properties PROPERTIES = Block.Properties
			.create(Material.IRON)
			.hardnessAndResistance(5.0f,6.0f)
			.sound(SoundType.METAL)
			.harvestLevel(4)
			.harvestTool(ToolType.PICKAXE);

	public BoomCube() {
		super(PROPERTIES);
	}

}
