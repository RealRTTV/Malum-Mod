package com.kittykitcatcat.malum.blocks.utility.spiritstorage;

import com.kittykitcatcat.malum.blocks.utility.BasicTileEntity;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntityType;

import static com.kittykitcatcat.malum.SpiritDataHelper.countNBT;
import static com.kittykitcatcat.malum.SpiritDataHelper.typeNBT;

public class SpiritStoringTileEntity extends BasicTileEntity
{
    public String type;
    public int count;
    public SpiritStoringTileEntity(TileEntityType<? extends SpiritStoringTileEntity> tileEntityType)
    {
        super(tileEntityType);
    }
    @Override
    public CompoundNBT write(CompoundNBT compound)
    {
        super.write(compound);
        if (type != null)
        {
            compound.putString(typeNBT, type);
        }
        if (count != 0)
        {
            compound.putInt(countNBT, count);
        }
        return compound;
    }

    @Override
    public void read(BlockState state, CompoundNBT compound)
    {
        super.read(state,compound);
        if (compound.contains(typeNBT))
        {
            type = compound.getString(typeNBT);
        }
        if (compound.contains(countNBT))
        {
            count = compound.getInt(countNBT);
        }
    }
}