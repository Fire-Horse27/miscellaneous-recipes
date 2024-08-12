package net.fire_horse27.misc.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.CHAIN,4)
                .pattern("#")
                .pattern("I")
                .pattern("#")
                .input('#', Items.IRON_NUGGET)
                .input('I', Items.IRON_INGOT)
                .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.REDSTONE, Items.REDSTONE_TORCH,4)
                .pattern("#")
                .pattern("S")
                .input('#', Items.REDSTONE)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.SANDSTONE,2)
                .pattern("##")
                .pattern("##")
                .input('#', Items.SAND)
                .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.RED_SANDSTONE,2)
                .pattern("##")
                .pattern("##")
                .input('#', Items.RED_SANDSTONE)
                .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.NETHER_WART_BLOCK)
                .pattern("##")
                .pattern("##")
                .input('#', Items.NETHER_WART)
                .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.ICE,9)
                .input(Items.PACKED_ICE)
                .criterion(hasItem(Items.PACKED_ICE), conditionsFromItem(Items.PACKED_ICE))
                .offerTo(exporter, "misc:ice");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.PACKED_ICE,9)
                .input(Items.BLUE_ICE)
                .criterion(hasItem(Items.BLUE_ICE), conditionsFromItem(Items.BLUE_ICE))
                .offerTo(exporter, "misc:packed_ice");
    }
}
