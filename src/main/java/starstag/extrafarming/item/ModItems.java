package starstag.extrafarming.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import starstag.extrafarming.ExtraFarming;

public class ModItems {

    public static final Item SWEET_POTATO = registerItem("sweet_potato", new Item(new Item.Settings().food(FoodComponents.POTATO)));

    public static final Item FARMING_SACK = registerItem("farming_sack", new Item(new Item.Settings().maxCount(1)));

    public static final Item COMPOST = registerItem("COMPOST", new Item(new Item.Settings()))


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(ExtraFarming.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ExtraFarming.LOGGER.info("Registering Mod Items for " + ExtraFarming.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
           // entries.add();
           // entries.add();
        //});


    }
}
