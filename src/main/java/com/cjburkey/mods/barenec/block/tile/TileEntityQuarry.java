package com.cjburkey.mods.barenec.block.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class TileEntityQuarry extends TileEntity implements ITickable {
	
	int time = 0;
	public int energy = 0;
	public int maxEnergy = 0;
	private final List<BlockPos> blocks = new ArrayList<BlockPos>();
	private ListIterator<BlockPos> it;
	boolean first = true;
	private final int radius = 3;
	
	private void loadBlocksIntoList() {
		int bx = this.getPos().getX();
		int by = this.getPos().getY();
		int bz = this.getPos().getZ();
		System.out.println("Placed at: " + this.getPos());
		for(int y = by - 1; y > 1; y --) {
			for(int x = bx - radius; x < bx + radius + 1; x ++) {
				for(int z = bz - radius; z < bz + radius + 1; z ++) {
					BlockPos p = new BlockPos(x, y, z);
					IBlockState s = this.getWorld().getBlockState(p);
					if(!s.getBlock().isAir(s, this.getWorld(), p) && !(s.getBlockHardness(this.getWorld(), p) < 0)) {
						blocks.add(p);
					}
				}
			}
		}
		
		TileEntity atPos = this.getWorld().getTileEntity(new BlockPos(bx, by + 1, bz));
		if(atPos != null && atPos instanceof TileEntityChest) {
			TileEntityChest chest = (TileEntityChest) atPos;
		}
		
		it = blocks.listIterator();
		
		System.out.println("Loaded " + blocks.size() + " blocks for breaking.");
		maxEnergy = blocks.size();
	}
	
	private boolean isDone() {
		return !it.hasNext();
	}
	
	private boolean isServer() {
		return !this.getWorld().isRemote;
	}
	
	public void update() {
		int pickupRadius = 5;
		
		if(isServer()) {
			if(first) {
				first = false;
				loadBlocksIntoList();
			}
			
			if(!isDone() && canWork()) {
				if(time >= 8) {
					time = 0;
					energy --;
					BlockPos pos = it.next();
					this.getWorld().destroyBlock(pos, true);
					float x = this.getPos().getX() + 0.5f, y = this.getPos().getY() + 2, z = this.getPos().getZ() + 0.5f;
					List<EntityItem> itemList = this.getWorld().getEntitiesWithinAABB(EntityItem.class,
							new AxisAlignedBB(pos.getX() - pickupRadius, pos.getY() - pickupRadius, pos.getZ() - pickupRadius, pos.getX() + pickupRadius,
									pos.getY() + pickupRadius, pos.getZ() + pickupRadius));
					
					for(EntityItem e : itemList) {
						e.setPosition(x, y, z);
					}
					return;
				}
				time ++;
			}
		} else {
			first = false;
		}
	}
	
	public NBTTagCompound writeToNBT(NBTTagCompound comp) {
		super.writeToNBT(comp);
		comp.setInteger("quarry_currentEnergy", this.energy);
		return comp;
	}
	
	public void readFromNBT(NBTTagCompound comp) {
		super.readFromNBT(comp);
		this.energy = comp.getInteger("quarry_currentEnergy");
	}
	
	private boolean canWork() {
		return energy > 0 && isGettingRedstoned();
	}
	
	private Entity getEntAtPos(int x, int y, int z) {
		for(Entity e : this.getWorld().loadedEntityList) {
			if((int) e.posX == x && (int) e.posY == y && (int) e.posZ == z) {
				return e;
			}
		}
		return null;
	}
	
	private boolean isGettingRedstoned() {
		return this.worldObj.isBlockIndirectlyGettingPowered(this.pos) > 0;
	}
	
}