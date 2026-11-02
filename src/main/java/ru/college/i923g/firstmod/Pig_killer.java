package ru.college.i923g.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pig_killer implements ModInitializer {

	public static final String MOD_ID = "pig_killer";

	public static final Logger LOGGER =
			LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
				.register(entries -> {
					entries.add(ModItems.PIG_KILLER);
				});

		UseItemCallback.EVENT.register((player, world, hand) -> {
			ItemStack stack = player.getStackInHand(hand);

			if (player.isSpectator()) {
				return TypedActionResult.pass(stack);
			}

			if (hand != Hand.MAIN_HAND) {
				return TypedActionResult.pass(stack);
			}

			if (!stack.isOf(ModItems.PIG_KILLER)) {
				return TypedActionResult.pass(stack);
			}

			if (!world.isClient()) {
				player.sendMessage(
						Text.literal("Свинокол готов к бою!"),
						false
				);
			}

			return TypedActionResult.success(stack);
		});

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}