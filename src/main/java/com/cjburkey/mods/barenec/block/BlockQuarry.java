package com.cjburkey.mods.barenec.block;

import com.cjburkey.mods.barenec.block.tile.TileEntityQuarry;
import com.cjburkey.mods.barenec.item._Items;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockQuarry extends Block implements ITileEntityProvider {
	
	private static final ItemStack[] fuels = {
		new ItemStack(Items.COAL), new ItemStack(_Items.itemBrittleDiamond), new ItemStack(Blocks.PLANKS), new ItemStack(Blocks.LOG), new ItemStack(Blocks.LOG2),
	};
	private static final int[] fuelAmt = { 51, 750, 23, 45, 45 };
	
	public BlockQuarry() {
		super(Material.IRON);
		this.setHardness(3.0f);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityQuarry();
	}
	
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		super.breakBlock(world, pos, state);
		world.removeTileEntity(pos);
	}
	
	public boolean onBlockActivated(World w, BlockPos pos, IBlockState s, EntityPlayer p, EnumHand h, ItemStack held, EnumFacing side, float x, float y, float z) {
		if(!w.isRemote) {
			TileEntityQuarry te = (TileEntityQuarry) w.getTileEntity(pos);
			if(held != null) {
				for(int i = 0; i < fuels.length; i ++) {
					Item item = fuels[i].getItem();
					if(item.equals(held.getItem()) && te.energy < te.maxEnergy) {
						te.energy += fuelAmt[i];
						if(te.energy > te.maxEnergy) te.energy = te.maxEnergy;
						held.stackSize --;
						break;
					}
				}
			}
			p.addChatComponentMessage(new TextComponentString("Energy: " + te.energy + "/" + te.maxEnergy));
		}
		return true;
	}
	
}