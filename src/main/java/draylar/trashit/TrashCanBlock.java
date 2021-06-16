package draylar.trashit;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class TrashCanBlock extends Block implements InventoryProvider {

    private static final VoxelShape SHAPE;

    static {
        VoxelShape first = Block.createCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 10.0D, 12.0D);
        VoxelShape second = Block.createCuboidShape(3.0D, 9.0D, 3.0D, 13.0D, 11.0D, 13.0D);
        SHAPE = VoxelShapes.union(first, second);
    }

    public TrashCanBlock() {
        super(FabricBlockSettings.of(Material.METAL).hardness(2.0f).nonOpaque());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public SidedInventory getInventory(BlockState state, WorldAccess world, BlockPos pos) {
        return new DummyInventory();
    }

    static class DummyInventory extends SimpleInventory implements SidedInventory {

        public DummyInventory() {
            super(1);
        }

        public int[] getAvailableSlots(Direction side) {
            return new int[1];
        }

        public boolean canInsert(int slot, ItemStack stack, Direction dir) {
            return true;
        }

        public boolean canExtract(int slot, ItemStack stack, Direction dir) {
            return false;
        }
    }
}
