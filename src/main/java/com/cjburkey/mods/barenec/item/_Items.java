package com.cjburkey.mods.barenec.item;

import java.util.ArrayList;
import java.util.List;
import com.cjburkey.mods.barenec.ModInfo;
import com.cjburkey.mods.barenec.mats._ToolMats;
import com.cjburkey.mods.barenec.tab._Tabs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class _Items {
	
	private static final List<Item> items = new ArrayList<Item>();
	
	public static Item itemEmeraldSword;
	public static Item itemEmeraldPick;
	public static Item itemEmeraldAxe;
	public static Item itemEmeraldShovel;
	public static Item itemEmeraldHoe;
	
	public static final void preinit() {
		registerItems();
	}
	
	public static final void registerRenders() {
		for(Item b : items) { registerRender(b); }
	}
	
	private static final void registerItems() {
		itemEmeraldSword = registerItem("itemEmeraldSword", new ItemEmeraldSword(_ToolMats.materialEmerald));
		itemEmeraldPick = registerItem("itemEmeraldPick", new ItemEmeraldPick(_ToolMats.materialEmerald));
		itemEmeraldAxe = registerItem("itemEmeraldAxe", new ItemEmeraldAxe(_ToolMats.materialEmerald));
		itemEmeraldShovel = registerItem("itemEmeraldShovel", new ItemEmeraldShovel(_ToolMats.materialEmerald));
		itemEmeraldHoe = registerItem("itemEmeraldHoe", new ItemEmeraldHoe(_ToolMats.materialEmerald));
	}
	
	private static final void registerRender(Item i) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(i, 0,
				new ModelResourceLocation(ModInfo.id + ":" + i.getRegistryName().getResourcePath(), "inventory"));
	}
	
	private static final Item registerItem(String name, Item i) {
		GameRegistry.register(i.setUnlocalizedName(name).setCreativeTab(_Tabs.tabItems).setRegistryName(new ResourceLocation(ModInfo.id, name)));
		items.add(i);
		return i;
	}
	
}