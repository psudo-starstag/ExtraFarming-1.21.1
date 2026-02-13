package starstag.extrafarming.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import starstag.extrafarming.ExtraFarming;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> FARMING_CROPS =
                TagKey.of(
                        RegistryKeys.ITEM,
                        Identifier.of(ExtraFarming.MOD_ID, "farming_crops")
                );
    }
}