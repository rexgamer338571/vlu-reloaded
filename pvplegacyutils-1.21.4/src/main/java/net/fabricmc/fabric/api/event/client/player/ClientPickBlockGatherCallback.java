package net.fabricmc.fabric.api.event.client.player;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.HitResult;

// Compat
public interface ClientPickBlockGatherCallback {
    Event<ClientPickBlockGatherCallback> EVENT = EventFactory.createArrayBacked(ClientPickBlockGatherCallback.class,
            (listeners) -> (player, result) -> {
                for (ClientPickBlockGatherCallback event : listeners) {
                    ItemStack stack = event.pick(player, result);

                    if (stack != ItemStack.EMPTY && !stack.isEmpty()) {
                        return stack;
                    }
                }

                return ItemStack.EMPTY;
            }
    );

    ItemStack pick(PlayerEntity player, HitResult result);
}
