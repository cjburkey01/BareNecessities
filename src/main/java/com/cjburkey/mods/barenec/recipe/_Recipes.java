package com.cjburkey.mods.barenec.recipe;

import com.cjburkey.mods.barenec.item._Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class _Recipes {
	
	public static final void init() {
		registerCrafting();
		registerSmelting();
	}
	
	private static final void registerCrafting() {
		addRecipe(new ItemStack(_Items.itemEmeraldSword, 1), new Object[] {
			"x", "x", "y", Character.valueOf('x'), "gemEmerald", Character.valueOf('y'), "stickWood",
		});
		
		addRecipe(new ItemStack(_Items.itemEmeraldPick, 1), new Object[] {
			"xxx", " y ", " y ", Character.valueOf('x'), "gemEmerald", Character.valueOf('y'), "stickWood",
		});
		
		addRecipe(new ItemStack(_Items.itemEmeraldAxe, 1), new Object[] {
			"xx", "xy", " y", Character.valueOf('x'), "gemEmerald", Character.valueOf('y'), "stickWood",
		});
		
		addRecipe(new ItemStack(_Items.itemEmeraldShovel, 1), new Object[] {
			"x", "y", "y", Character.valueOf('x'), "gemEmerald", Character.valueOf('y'), "stickWood",
		});
		
		addRecipe(new ItemStack(_Items.itemEmeraldHoe, 1), new Object[] {
			"xx", " y", " y", Character.valueOf('x'), "gemEmerald", Character.valueOf('y'), "stickWood",
		});
	}
	
	private static final void registerSmelting() {
		
	}
	
	private static final void addRecipe(ItemStack out, Object[] in) {
		GameRegistry.addRecipe(new ShapedOreRecipe(out, in));
	}
	
}