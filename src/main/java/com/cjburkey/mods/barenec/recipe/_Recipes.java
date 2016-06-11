package com.cjburkey.mods.barenec.recipe;

import com.cjburkey.mods.barenec.item._Items;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class _Recipes {
	
	public static final void init() {
		registerCrafting();
		registerSmelting();
	}
	
	private static final void registerCrafting() {
		addRecipesForTools(_Items.itemEmeraldSword, _Items.itemEmeraldPick, _Items.itemEmeraldAxe, _Items.itemEmeraldShovel, _Items.itemEmeraldHoe, "gemEmerald", "stickWood");
		addRecipesForTools(_Items.itemBrittleDiamondSword, _Items.itemBrittleDiamondPick, _Items.itemBrittleDiamondAxe, _Items.itemBrittleDiamondShovel, _Items.itemBrittleDiamondHoe, "gemBrittleDiamond", "stickWood");
		
		addShapeless(new ItemStack(_Items.itemGoldDiamond, 1),
				Items.GOLD_INGOT, Items.GOLD_INGOT, Items.DIAMOND, Items.DIAMOND, Items.DIAMOND, Items.IRON_INGOT);
	}
	
	private static final void addRecipesForTools(Item sword, Item pick, Item axe, Item spade, Item hoe, String material, String stick) {
		addRecipe(new ItemStack(sword, 1), new Object[] {
			"x", "x", "y", Character.valueOf('x'), material, Character.valueOf('y'), stick,
		});
		
		addRecipe(new ItemStack(pick, 1), new Object[] {
			"xxx", " y ", " y ", Character.valueOf('x'), material, Character.valueOf('y'), stick,
		});
		
		addRecipe(new ItemStack(axe, 1), new Object[] {
			"xx", "xy", " y", Character.valueOf('x'), material, Character.valueOf('y'), stick,
		});
		
		addRecipe(new ItemStack(spade, 1), new Object[] {
			"x", "y", "y", Character.valueOf('x'), material, Character.valueOf('y'), stick,
		});
		
		addRecipe(new ItemStack(hoe, 1), new Object[] {
			"xx", " y", " y", Character.valueOf('x'), material, Character.valueOf('y'), stick,
		});
	}
	
	private static final void registerSmelting() {
		addSmelting(new ItemStack(_Items.itemBrittleDiamond, 1), new ItemStack(_Items.itemGoldDiamond, 1), 1.5f);
	}
	
	private static final void addSmelting(ItemStack out, ItemStack in, float xp) {
		GameRegistry.addSmelting(in, out, xp);
	}
	
	private static final void addRecipe(ItemStack out, Object[] in) {
		GameRegistry.addRecipe(new ShapedOreRecipe(out, in));
	}
	
	private static final void addShapeless(ItemStack out, Object... in) {
		GameRegistry.addRecipe(new ShapelessOreRecipe(out, in));
	}
	
}