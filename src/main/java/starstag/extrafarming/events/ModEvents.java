package starstag.extrafarming.events;

import starstag.extrafarming.item.ModItems;
import starstag.extrafarming.util.ModTags;
import starstag.extrafarming.util.SackUtil;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

import java.util.List;

public class ModEvents {

    public static void registerEvents() {

        ServerTickEvents.END_WORLD_TICK.register(world -> {

            if (!(world instanceof ServerWorld serverWorld)) return;

            for (PlayerEntity player : serverWorld.getPlayers()) {

                List<ItemEntity> nearbyItems = serverWorld.getEntitiesByClass(
                        ItemEntity.class,
                        player.getBoundingBox().expand(1.25),
                        itemEntity -> itemEntity.isAlive()
                );

                for (ItemEntity itemEntity : nearbyItems) {

                    ItemStack dropped = itemEntity.getStack();

                    System.out.println("Found item near player: " + dropped.getItem());

                    if (!dropped.isIn(ModTags.Items.FARMING_CROPS)) {
                        System.out.println("Item is NOT in farming_crops tag");
                        continue;
                    }

                    System.out.println("Item IS a farming crop");

                    for (int i = 0; i < player.getInventory().size(); i++) {

                        ItemStack stack = player.getInventory().getStack(i);

                        if (stack.getItem() == ModItems.FARMING_SACK) {

                            System.out.println("Found farming sack in inventory");

                            boolean fullyInserted = SackUtil.insert(stack, dropped);

                            System.out.println("Insert result: " + fullyInserted);

                            if (fullyInserted) {
                                itemEntity.discard();
                                System.out.println("Item entity discarded");
                            }

                            break;
                        }
                    }
                }

            }
        });
    }
}