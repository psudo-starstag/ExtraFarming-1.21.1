package starstag.extrafarming.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import starstag.extrafarming.data.items.SackData;

public class SackUtil {

    public static boolean insert(ItemStack sack, ItemStack incoming) {
        if (!incoming.isIn(ModTags.Items.FARMING_CROPS)) return false;

        NbtComponent component = sack.getOrDefault(
                DataComponentTypes.CUSTOM_DATA,
                NbtComponent.DEFAULT
        );

        NbtCompound root = component.copyNbt();
        NbtCompound data = root.getCompound(SackData.NBT_KEY);

        String key = Registries.ITEM.getId(incoming.getItem()).toString();

        long stored = data.getLong(key);
        long space = SackData.MAX_PER_CROP - stored;

        if (space <= 0) return false;

        long inserted = Math.min(space, incoming.getCount());

        data.putLong(key, stored + inserted);
        incoming.decrement((int) inserted);

        root.put(SackData.NBT_KEY, data);

        sack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(root));

        return incoming.isEmpty();
    }

}
