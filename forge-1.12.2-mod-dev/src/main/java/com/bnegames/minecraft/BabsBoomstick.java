package com.bnegames.minecraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;

public class BabsBoomstick extends ItemSword {

	private static final int HARVEST = 4;
	private static final int MAX_USES = 10000;
	private static final float DAMAGE = 20;
	private static final float EFFICIENCY = 100;
	private static final int ENCHANTMENT = 20;
	private static final ToolMaterial MATERIAL = EnumHelper.addToolMaterial("shiny", HARVEST, MAX_USES, EFFICIENCY, DAMAGE, ENCHANTMENT);

	public BabsBoomstick() {
		super(MATERIAL);
		this.setRegistryName("boomstick");
		this.setUnlocalizedName("boomstick");
		this.setCreativeTab(CreativeTabs.COMBAT);
	}

}
