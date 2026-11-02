package ru.college.i923g.firstmod;

import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item PIG_KILLER = Registry.register(
            Registries.ITEM,
            Identifier.of("pig_killer", "pig_killer"),
            new SwordItem(
                    ToolMaterials.IRON,
                    new Item.Settings()
                            .maxCount(1)
                            .attributeModifiers(
                                    SwordItem.createAttributeModifiers(
                                            ToolMaterials.IRON,
                                            3,
                                            -2.4f
                                    )
                            )
            )
    );

    public static void initialize() {
    }
}