package com.cjburkey.mods.barenec.proxy;

import com.cjburkey.mods.barenec.item._Items;
import com.cjburkey.mods.barenec.mats._ToolMats;
import com.cjburkey.mods.barenec.recipe._Recipes;
import com.cjburkey.mods.barenec.tab._Tabs;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
	
	public void preinit(FMLPreInitializationEvent e) {
		_Tabs.preinit();
		_ToolMats.preinit();
		_Items.preinit();
	}
	public void init(FMLInitializationEvent e) {
		_Recipes.init();
	}
	public void postinit(FMLPostInitializationEvent e) {  }
	
}