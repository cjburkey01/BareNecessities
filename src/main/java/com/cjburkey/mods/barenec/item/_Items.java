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
import net.minecraftforge.oredict.OreDictionary;

public class _Items {
	
	private static final List<Item> items = new ArrayList<Item>();
	
	public static Item itemEmeraldSword;
	public static Item itemEmeraldPick;
	public static Item itemEmeraldAxe;
	public static Item itemEmeraldShovel;
	public static Item itemEmeraldHoe;
	
	public static Item itemBrittleDiamondSword;
	public static Item itemBrittleDiamondPick;
	public static Item itemBrittleDiamondAxe;
	public static Item itemBrittleDiamondShovel;
	public static Item itemBrittleDiamondHoe;
	
	public static Item itemGoldDiamond;
	public static Item itemBrittleDiamond;
	
	public static final void preinit() {
		registerItems();
	}
	
	public static final void registerRenders() {
		for(Item b : items) { registerRender(b); }
	}
	
	private static final void registerItems() {
		itemEmeraldSword = registerItem("itemEmeraldSword", new ItemBareSword(_ToolMats.materialEmerald));
		itemEmeraldPick = registerItem("itemEmeraldPick", new ItemBarePick(_ToolMats.materialEmerald));
		itemEmeraldAxe = registerItem("itemEmeraldAxe", new ItemBareAxe(_ToolMats.materialEmerald));
		itemEmeraldShovel = registerItem("itemEmeraldShovel", new ItemBareShovel(_ToolMats.materialEmerald));
		itemEmeraldHoe = registerItem("itemEmeraldHoe", new ItemBareHoe(_ToolMats.materialEmerald));
		
		itemBrittleDiamondSword = registerItem("itemBrittleDiamondSword", new ItemBareSword(_ToolMats.materialBrittleDiamond));
		itemBrittleDiamondPick = registerItem("itemBrittleDiamondPick", new ItemBarePick(_ToolMats.materialBrittleDiamond));
		itemBrittleDiamondAxe = registerItem("itemBrittleDiamondAxe", new ItemBareAxe(_ToolMats.materialBrittleDiamond));
		itemBrittleDiamondShovel = registerItem("itemBrittleDiamondShovel", new ItemBareShovel(_ToolMats.materialBrittleDiamond));
		itemBrittleDiamondHoe = registerItem("itemBrittleDiamondHoe", new ItemBareHoe(_ToolMats.materialBrittleDiamond));

		itemGoldDiamond = registerItem("itemGoldDiamond", new Item());
		itemBrittleDiamond = addOreDict(registerItem("itemBrittleDiamond", new Item()), "gemBrittleDiamond");
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
	
	private static final Item addOreDict(Item i, String ore) {
		OreDictionary.registerOre(ore, i);
		return i;
	}
	
}