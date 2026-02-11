package starstag.extrafarming.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import starstag.extrafarming.ExtraFarming;

public class ModItemGroups {
    public static final ItemGroup EXTRA_FARMING_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(ExtraFarming.MOD_ID, "extra_farming_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.FARMING_SACK))
                    .displayName(Text.translatable("itemgroup.extrafarming.extra_farming_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SWEET_POTATO);
                        entries.add(ModItems.FARMING_SACK);
                        entries.add(ModItems.COMPOST);
                    }).build());


    public static void registerItemGroups() {
        ExtraFarming.LOGGER.info("Registering Item Groups for " + ExtraFarming.MOD_ID);
    }
}
