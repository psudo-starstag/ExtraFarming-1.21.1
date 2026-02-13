package starstag.extrafarming.item.custom;

import starstag.extrafarming.data.items.SackData;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;

import java.util.List;

import static starstag.extrafarming.data.items.SackData.MAX_PER_CROP;

public class FarmingSackItem extends Item {


    public FarmingSackItem(Settings settings) {
        super(settings);
    }

    private String formatNumber(long number) {
        if (number >= 1_000_000)
            return String.format("%.1fM", number / 1_000_000.0);
        if (number >= 1_000)
            return String.format("%.1fK", number / 1_000.0);
        return String.valueOf(number);
    }


    @Override
    public void appendTooltip(ItemStack stack,
                              TooltipContext context,
                              List<Text> tooltip,
                              TooltipType type) {

        NbtComponent component = stack.get(DataComponentTypes.CUSTOM_DATA);
        if (component == null) {
            tooltip.add(Text.literal("Empty"));
            return;
        }

        NbtCompound root = component.copyNbt();

        if (!root.contains(SackData.NBT_KEY)) {
            tooltip.add(Text.literal("Empty"));
            return;
        }

        NbtCompound data = root.getCompound(SackData.NBT_KEY);

        if (data.isEmpty()) {
            tooltip.add(Text.literal("Empty"));
            return;
        }

        long total = 0;

        tooltip.add(Text.literal("Contents:"));

        for (String key : data.getKeys()) {

            long amount = data.getLong(key);
            total += amount;

            var item = net.minecraft.registry.Registries.ITEM.get(
                    net.minecraft.util.Identifier.of(key)
            );

            tooltip.add(
                    Text.literal("- ")
                            .append(item.getName())
                            .append(Text.literal(": " + formatNumber(amount)  + " / " + formatNumber(MAX_PER_CROP)))
            );
        }

        tooltip.add(Text.literal(""));
        tooltip.add(Text.literal(
                "Total: " + formatNumber(total)
        ));
    }
}
