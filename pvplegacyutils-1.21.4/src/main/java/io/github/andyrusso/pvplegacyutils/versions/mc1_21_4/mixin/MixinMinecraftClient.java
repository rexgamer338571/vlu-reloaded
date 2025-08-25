package io.github.andyrusso.pvplegacyutils.versions.mc1_21_4.mixin;

import net.fabricmc.fabric.api.event.client.player.ClientPickBlockGatherCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {

    @Inject(method = "doItemPick", at = @At("HEAD"))
    void doItemPick_event(CallbackInfo ci) {
        MinecraftClient client = (MinecraftClient) (Object) this;

        ClientPickBlockGatherCallback.EVENT.invoker().pick(client.player, client.crosshairTarget);
    }

}
