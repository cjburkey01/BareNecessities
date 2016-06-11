package com.cjburkey.mods.barenec.tab;

import com.cjburkey.mods.barenec.item._Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class _Tabs {
	
	public static CreativeTabs tabItems, tabBlocks;
	
	public static final void preinit() {
		tabItems = new CreativeTabs("tabBarenecItems") { public Item getTabIconItem() { return _Items.itemEmeraldHoe; } };
		tabBlocks = new CreativeTabs("tabBarenecBlocks") { public Item getTabIconItem() { return Item.getItemFromBlock(Blocks.GRAVEL); } };
	}
	
}