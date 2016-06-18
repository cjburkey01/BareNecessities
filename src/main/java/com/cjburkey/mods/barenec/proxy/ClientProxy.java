package com.cjburkey.mods.barenec.proxy;

import com.cjburkey.mods.barenec.block._Blocks;
import com.cjburkey.mods.barenec.item._Items;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public void preinit(FMLPreInitializationEvent e) { super.preinit(e); }
	public void init(FMLInitializationEvent e) {
		super.init(e);
		
		_Items.registerRenders();
		_Blocks.registerRenders();
	}
	public void postinit(FMLPostInitializationEvent e) { super.postinit(e); }
	
}