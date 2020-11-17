package draylar.trashit;

import draylar.trashit.block.TrashCanBlock;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TrashIt implements ModInitializer {

    public static final Block TRASH_CAN = Registry.register(Registry.BLOCK, id("trash_can"), new TrashCanBlock());
    public static final Item TRASH_CAN_ITEM = Registry.register(Registry.ITEM, id("trash_can"), new BlockItem(TRASH_CAN, new Item.Settings().group(ItemGroup.MISC)));

    @Override
    public void onInitialize() {

    }

    public static Identifier id(String name) {
        return new Identifier("trash-it", name);
    }
}
