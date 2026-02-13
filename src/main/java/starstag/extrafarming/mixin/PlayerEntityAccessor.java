package starstag.extrafarming.mixin;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PlayerEntity.class)
public interface PlayerEntityAccessor {

    @Invoker("createPlayerAttributes")
    static DefaultAttributeContainer.Builder extrafarming$createAttributes() {
        throw new AssertionError();
    }
}
