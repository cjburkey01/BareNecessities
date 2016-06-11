package com.cjburkey.mods.barenec;

import com.cjburkey.mods.barenec.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(name = ModInfo.name, version = ModInfo.version, modid = ModInfo.id)
public class BareNec {
	
	@Instance
	public BareNec instance;
	
	@SidedProxy(clientSide = ModInfo.proxyBase + ".ClientProxy", serverSide = ModInfo.proxyBase + ".ServerProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent e) { proxy.preinit(e); }

	@EventHandler
	public void init(FMLInitializationEvent e) { proxy.init(e); }

	@EventHandler
	public void postinit(FMLPostInitializationEvent e) { proxy.postinit(e); }
	
}