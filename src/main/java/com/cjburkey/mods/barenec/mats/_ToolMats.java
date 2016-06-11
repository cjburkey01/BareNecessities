package com.cjburkey.mods.barenec.mats;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class _ToolMats {
	
	public static ToolMaterial materialEmerald;
	
	public static final void preinit() {
		materialEmerald = EnumHelper.addToolMaterial("materialEmerald", 6, 3578, 15.0f, 13.0f, 25);
	}
	
}