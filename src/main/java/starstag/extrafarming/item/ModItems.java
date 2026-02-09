package starstag.extrafarming.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import starstag.extrafarming.ExtraFarming;

public class ModItems {

    public static final Item SWEET_POTATO = registerItem("sweet_potato", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExtraFarming.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExtraFarming.LOGGER.info("Registering Mod Items for " ExtraFarming.MOD_ID);


    }
}
