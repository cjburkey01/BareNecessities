package com.cjburkey.mods.barenec.block;

import java.util.ArrayList;
import java.util.List;
import com.cjburkey.mods.barenec.ModInfo;
import com.cjburkey.mods.barenec.block.tile.TileEntityQuarry;
import com.cjburkey.mods.barenec.item._Items;
import com.cjburkey.mods.barenec.tab._Tabs;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class _Blocks {
	
	private static final List<Block> blocks = new ArrayList<Block>();
	
	public static Block blockQuarry;
	
	public static final void preinit() {
		registerBlocks();
		registerTileEntities();
	}
	
	public static final void registerRenders() {
		for(Block b : blocks) { _Items.registerRender(Item.getItemFromBlock(b)); }
	}
	
	private static final void registerBlocks() {
		blockQuarry = registerBlock("blockQuarry", new BlockQuarry());
	}
	
	private static final void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityQuarry.class, ModInfo.id + "_tileEntityQuarry");
	}
	
	private static final Block registerBlock(String name, Block b) {
		ResourceLocation r = new ResourceLocation(ModInfo.id, name);
		GameRegistry.register(b.setUnlocalizedName(name).setCreativeTab(_Tabs.tabBlocks).setRegistryName(r));
		GameRegistry.register(new ItemBlock(b).setUnlocalizedName(name).setRegistryName(r));
		blocks.add(b);
		return b;
	}
	
}