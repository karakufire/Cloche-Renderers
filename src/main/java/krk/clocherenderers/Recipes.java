package krk.clocherenderers;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import blusunrize.immersiveengineering.api.crafting.builders.ClocheRecipeBuilder;
import cofh.thermal.core.ThermalCore;
import cofh.thermal.core.util.RegistrationHelper;
import cofh.thermal.cultivation.init.TCulIDs;
import defeatedcrow.hac.food.material.FoodInit;
import krk.clocherenderers.clocherenderers.HaCCropRenderers;
import krk.clocherenderers.clocherenderers.ThermalRenderers;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator datagen) {
        super(datagen);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> out) {
        for (var modInfo : LoadingModList.get().getMods().stream().map(ModInfo::getModId).toList()) {
            switch (modInfo) {
                case "dcs_climate" -> hacClocheRecipes(out);
                case "thermal_cultivation" -> tcClocheRecipes(out);
            }
        }

    }

    private void hacClocheRecipes(Consumer<FinishedRecipe> out) {
        // 野蒜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AL_WILD.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AL_WILD.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AL_WILD.get()))
                .build(out, rl("cloche", "hac", "allium_wild"));
        // 玉葱
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AL_ONION.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AL_ONION.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AL_ONION.get()))
                .build(out, rl("cloche", "hac", "allium_common"));
        // 大蒜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AL_GARLIC.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AL_GARLIC.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AL_GARLIC.get()))
                .build(out, rl("cloche", "hac", "allium_rare"));
        // 藜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AM_GOOSEFOOT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AM_GOOSEFOOT.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AM_GOOSEFOOT.get()))
                .build(out, rl("cloche", "hac", "amaranth_wild"));
        // 厚岸草
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AM_GLASSWORT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AM_GLASSWORT.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AM_GLASSWORT.get()))
                .build(out, rl("cloche", "hac", "amaranth_common"));
        // 菠薐草
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AM_SPINACH.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AM_SPINACH.get()))
                .addSoil(Blocks.DIRT).setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AM_SPINACH.get()))
                .build(out, rl("cloche", "hac", "amaranth_rare"));
        // 芹
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AP_CELERY.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AP_CELERY.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AP_CELERY.get()))
                .build(out, rl("cloche", "hac", "apium_wild"));
        // 茴香
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AP_FENNEL.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AP_FENNEL.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AP_FENNEL.get()))
                .build(out, rl("cloche", "hac", "apium_common"));
        // パースニップ
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AP_PARSNIP.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AP_PARSNIP.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AP_PARSNIP.get()))
                .build(out, rl("cloche", "hac", "apium_rare"));
        // 胡荽
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AP_CORIANDER.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AP_CORIANDER.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AP_CORIANDER.get()))
                .build(out, rl("cloche", "hac", "apium_epic"));
        // 蓬
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AS_ARTEMISIA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AS_ARTEMISIA.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AS_ARTEMISIA.get()))
                .build(out, rl("cloche", "hac", "aster_wild"));
        // 萵苣
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AS_LETTUCE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AS_LETTUCE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AS_LETTUCE.get()))
                .build(out, rl("cloche", "hac", "aster_common"));
        // 除虫菊
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AS_PYRETHRUM.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AS_PYRETHRUM.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AS_PYRETHRUM.get()))
                .build(out, rl("cloche", "hac", "aster_rare"));
        // 菊
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_AS_FLOWER.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_AS_FLOWER.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_AS_FLOWER.get()))
                .build(out, rl("cloche", "hac", "aster_epic"));
        // 菜花
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_BR_RAPESEED.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_BR_RAPESEED.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_BR_RAPESEED.get()))
                .build(out, rl("cloche", "hac", "brassica_wild"));
        // 青菜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_BR_GREEN.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_BR_GREEN.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_BR_GREEN.get()))
                .build(out, rl("cloche", "hac", "brassica_common"));
        // 甘藍
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_BR_CABBAGE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_BR_CABBAGE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_BR_CABBAGE.get()))
                .build(out, rl("cloche", "hac", "brassica_rare"));
        // 大根
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_BR_RADISH.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_BR_RAPESEED.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_BR_RADISH.get()))
                .build(out, rl("cloche", "hac", "brassica_epic"));
        // 唐辛子
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_CA_CHILI.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_CA_CHILI.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_CA_CHILI.get()))
                .build(out, rl("cloche", "hac", "capsicum_wild"));
        // ピーマン
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_CA_BELL.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_CA_BELL.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_CA_BELL.get()))
                .build(out, rl("cloche", "hac", "capsicum_common"));
        // パプリカ
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_CA_PAPRIKA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_CA_PAPRIKA.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_CA_PAPRIKA.get()))
                .build(out, rl("cloche", "hac", "capsicum_rare"));
        // 燕麦
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_CR_OAT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_CR_OAT.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_CR_OAT.get()))
                .build(out, rl("cloche", "hac", "cereals_wild"));
        // ライ麦
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_CR_RYE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_CR_RYE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_CR_RYE.get()))
                .build(out, rl("cloche", "hac", "cereals_common"));
        // 大麦
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_CR_BARLEY.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_CR_BARLEY.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_CR_BARLEY.get()))
                .build(out, rl("cloche", "hac", "cereals_rare"));
        // 生姜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GN_COMMON.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GN_COMMON.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_GN_COMMON.get()))
                .build(out, rl("cloche", "hac", "ginger_wild"));
        // カルダモン
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GN_CARDAMOM.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GN_CARDAMOM.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_GN_CARDAMOM.get()))
                .build(out, rl("cloche", "hac", "ginger_common"));
        // 鬱金
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GN_TURMERIC.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GN_TURMERIC.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_GN_TURMERIC.get()))
                .build(out, rl("cloche", "hac", "ginger_rare"));
        // 瓢箪
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GO_CALABASH.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GO_CALABASH.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_VINE.reference(FoodInit.BLOCK_GO_CALABASH.get()))
                .build(out, rl("cloche", "hac", "gourd_wild"));
        // 胡瓜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GO_CUCUMBER.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GO_CUCUMBER.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_VINE.reference(FoodInit.BLOCK_GO_CUCUMBER.get()))
                .build(out, rl("cloche", "hac", "gourd_common"));
        // 麝香甜瓜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GO_CANTALOUP.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GO_CANTALOUP.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_GO_CANTALOUP.get()))
                .build(out, rl("cloche", "hac", "gourd_rare"));
        // 山葡萄
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GR_WILD.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GR_WILD.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_VINE.reference(FoodInit.BLOCK_GR_WILD.get()))
                .build(out, rl("cloche", "hac", "grape_wild"));
        // 葡萄
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GR_COMMON.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GR_COMMON.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_VINE.reference(FoodInit.BLOCK_GR_COMMON.get()))
                .build(out, rl("cloche", "hac", "grape_common"));
        // 白葡萄
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_GR_WHITE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_GR_WHITE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_VINE.reference(FoodInit.BLOCK_GR_WHITE.get()))
                .build(out, rl("cloche", "hac", "grape_rare"));
        // 薄荷
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_HB_MINT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_HB_MINT.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_HB_MINT.get()))
                .build(out, rl("cloche", "hac", "herb_wild"));
        // バジル
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_HB_BASIL.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_HB_BASIL.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_HB_BASIL.get()))
                .build(out, rl("cloche", "hac", "herb_common"));
        // 紫蘇
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_HB_PERILLA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_HB_PERILLA.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_HB_PERILLA.get()))
                .build(out, rl("cloche", "hac", "herb_rare"));
        // ラベンダー
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_HB_LAVENDER.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_HB_LAVENDER.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_HB_LAVENDER.get()))
                .build(out, rl("cloche", "hac", "herb_epic"));
        // クロッカス
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_IR_CROCUS.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_IR_CROCUS.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_IR_CROCUS.get()))
                .build(out, rl("cloche", "hac", "iris_wild"));
        // サフラン
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_IR_SAFFRON.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_IR_SAFFRON.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_IR_SAFFRON.get()))
                .build(out, rl("cloche", "hac", "iris_common"));
        // 菖蒲
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_IR_IRIS.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_IR_IRIS.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_IR_IRIS.get()))
                .build(out, rl("cloche", "hac", "iris_rare"));
        // 蓚
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_KN_SORREL.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_KN_SORREL.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_KN_SORREL.get()))
                .build(out, rl("cloche", "hac", "knotweed_wild"));
        // 蕎麦
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_KN_BUCKWHEAT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_KN_BUCKWHEAT.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_KN_BUCKWHEAT.get()))
                .build(out, rl("cloche", "hac", "knotweed_common"));
        // 藍
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_KN_INDIGO.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_KN_INDIGO.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_KN_INDIGO.get()))
                .build(out, rl("cloche", "hac", "knotweed_rare"));
        // 綱麻
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_ML_JUTE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_ML_JUTE.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_ML_JUTE.get()))
                .build(out, rl("cloche", "hac", "mallow_wild"));
        // 木綿
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_ML_COTTON.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_ML_COTTON.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_ML_COTTON.get()))
                .build(out, rl("cloche", "hac", "mallow_common"));
        // ブルーマロウ
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_ML_BLUE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_ML_BLUE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_ML_BLUE.get()))
                .build(out, rl("cloche", "hac", "mallow_rare"));
        // ハイビスカス
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_ML_TROPICAL.get()))
                .addResult(new ItemStack(FoodInit.MALLOW_CALYCES.get()))
                .addInput(new ItemStack(FoodInit.BLOCK_ML_TROPICAL.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_ML_TROPICAL.get()))
                .build(out, rl("cloche", "hac", "mallow_epic"));
        // 浜昼顔
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_MO_BINDWEED.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_MO_BINDWEED.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_MO_BINDWEED.get()))
                .build(out, rl("cloche", "hac", "morningglory_wild"));
        // 空芯菜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_MO_WATER.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_MO_WATER.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_MO_WATER.get()))
                .build(out, rl("cloche", "hac", "morningglory_common"));
        // 甘藷
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_MO_POTATO.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_MO_POTATO.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_MO_POTATO.get()))
                .build(out, rl("cloche", "hac", "morningglory_rare"));
        // 朝顔
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_MO_FLOWER.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_MO_FLOWER.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_MO_FLOWER.get()))
                .build(out, rl("cloche", "hac", "morningglory_epic"));
        // 捩花
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_OR_SPIRANTHES.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_OR_SPIRANTHES.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_OR_SPIRANTHES.get()))
                .build(out, rl("cloche", "hac", "orchid_wild"));
        // シンビジウム
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_OR_CYMBIDIUM.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_OR_CYMBIDIUM.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_OR_CYMBIDIUM.get()))
                .build(out, rl("cloche", "hac", "orchid_common"));
        // バニラ
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_OR_VANILLA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_OR_VANILLA.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_OR_VANILLA.get()))
                .build(out, rl("cloche", "hac", "orchid_rare"));
        // カトレヤ
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_OR_CATTLEYA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_OR_CATTLEYA.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_OR_CATTLEYA.get()))
                .build(out, rl("cloche", "hac", "orchid_epic"));
        // ロジェリア
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PD_ROGERIA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PD_ROGERIA.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PD_ROGERIA.get()))
                .build(out, rl("cloche", "hac", "pedalia_wild"));
        // 胡麻
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PD_SESAMI.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PD_SESAMI.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PD_SESAMI.get()))
                .build(out, rl("cloche", "hac", "pedalia_common"));
        // 獅子殺し
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PD_DEVILSCLAW.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PD_DEVILSCLAW.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PD_DEVILSCLAW.get()))
                .build(out, rl("cloche", "hac", "pedalia_rare"));
        // 豌豆
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PE_GREEN.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PE_GREEN.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PE_GREEN.get()))
                .build(out, rl("cloche", "hac", "peas_wild"));
        // 雛豆
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PE_GARBANZO.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PE_GARBANZO.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PE_GARBANZO.get()))
                .build(out, rl("cloche", "hac", "peas_common"));
        // 大豆
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PE_SOY.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PE_SOY.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PE_SOY.get()))
                .build(out, rl("cloche", "hac", "peas_rare"));
        // 小豆
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_PE_ADZUKI.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_PE_ADZUKI.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_PE_ADZUKI.get()))
                .build(out, rl("cloche", "hac", "peas_epic"));
        // 二輪草
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RA_ANEMONE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RA_ANEMONE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_RA_ANEMONE.get()))
                .build(out, rl("cloche", "hac", "ranunculus_wild"));
        // 飛燕草
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RA_DELPHINIUM.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RA_DELPHINIUM.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_RA_DELPHINIUM.get()))
                .build(out, rl("cloche", "hac", "ranunculus_common"));
        // 風車
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RA_CLEMATIS.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RA_CLEMATIS.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_RA_CLEMATIS.get()))
                .build(out, rl("cloche", "hac", "ranunculus_rare"));
        // 鳥兜
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RA_MONKSHOOD.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RA_MONKSHOOD.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_SINGLE.reference(FoodInit.BLOCK_RA_MONKSHOOD.get()))
                .build(out, rl("cloche", "hac", "ranunculus_epic"));
        // 葦
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RE_COMMON.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RE_COMMON.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_RE_COMMON.get()))
                .build(out, rl("cloche", "hac", "reed_wild"));
        // 高黍
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RE_SORGHUM.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RE_SORGHUM.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.SAND))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_RE_SORGHUM.get()))
                .build(out, rl("cloche", "hac", "reed_common"));
        // 玉蜀黍
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RE_CORN.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RE_CORN.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_RE_CORN.get()))
                .build(out, rl("cloche", "hac", "reed_rare"));
        // 真菰
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RI_ZIZANIA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RI_ZIZANIA.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_RI_ZIZANIA.get()))
                .build(out, rl("cloche", "hac", "rice_wild"));
        // 稲
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RI_SHORT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RI_SHORT.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_RI_SHORT.get()))
                .build(out, rl("cloche", "hac", "rice_common"));
        // 香り米
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_RI_AROMA.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_RI_AROMA.get()))
                .addSoil(Ingredient.of(Blocks.DIRT, Blocks.MUD))
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_RI_AROMA.get()))
                .build(out, rl("cloche", "hac", "rice_rare"));
        // ナイトシェード
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_SL_NIGHTSHADE.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_SL_NIGHTSHADE.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_SL_NIGHTSHADE.get()))
                .build(out, rl("cloche", "hac", "nightshade_wild"));
        // 茄子
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_SL_EGGPLANT.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_SL_EGGPLANT.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_SL_EGGPLANT.get()))
                .build(out, rl("cloche", "hac", "nightshade_common"));
        // トマト
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_SL_TOMATO.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_SL_TOMATO.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_SL_TOMATO.get()))
                .build(out, rl("cloche", "hac", "nightshade_rare"));
        // 鬼灯
        ClocheRecipeBuilder.builder(new ItemStack(FoodInit.CROP_SL_LANTERN.get(), 2))
                .addInput(new ItemStack(FoodInit.BLOCK_SL_LANTERN.get()))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(HaCCropRenderers.HAC_CROP_DOUBLE.reference(FoodInit.BLOCK_SL_LANTERN.get()))
                .build(out, rl("cloche", "hac", "nightshade_epic"));

    }

    private void tcClocheRecipes(Consumer<FinishedRecipe> out) {
        // アマランサス
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_AMARANTH), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_AMARANTH))))
                .addSoil(Blocks.DIRT)
                .setTime(1200)
                .setRender(ThermalRenderers.THERMAL_CROP_TALL.reference(ThermalCore.BLOCKS.get(TCulIDs.ID_AMARANTH)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_AMARANTH));
        // 大麦
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_BARLEY), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_BARLEY))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_BARLEY)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_BARLEY));
        // 玉蜀黍
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_CORN), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_CORN))))
                .addSoil(Blocks.DIRT)
                .setTime(1200)
                .setRender(ThermalRenderers.THERMAL_CROP_TALL.reference(ThermalCore.BLOCKS.get(TCulIDs.ID_CORN)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_CORN));
        // 亜麻
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_FLAX), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_FLAX))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(ThermalRenderers.THERMAL_CROP_TALL.reference(ThermalCore.BLOCKS.get(TCulIDs.ID_FLAX)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_FLAX));
        // 玉葱
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_ONION), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_ONION))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_ONION)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_ONION));
        // ラディッシュ
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_RADISH), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_RADISH))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_RADISH)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_RADISH));
        // 米
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_RICE), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_RICE))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_RICE)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_RICE));
        // サディルート
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_SADIROOT), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_SADIROOT))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_SADIROOT)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_SADIROOT));
        // 菠薐草
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_SPINACH), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_SPINACH))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_SPINACH)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_SPINACH));
        // パプリカ
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_BELL_PEPPER), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_BELL_PEPPER))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_BELL_PEPPER)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_BELL_PEPPER));
        // 茄子
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_EGGPLANT), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_EGGPLANT))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_EGGPLANT)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_EGGPLANT));
        // 莢隠元
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_GREEN_BEAN), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_GREEN_BEAN))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_GREEN_BEAN)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_GREEN_BEAN));
        // 落花生
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_PEANUT), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_PEANUT))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_PEANUT)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_PEANUT));
        // 苺
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_STRAWBERRY), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_STRAWBERRY))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_STRAWBERRY)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_STRAWBERRY));
        // トマト
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_TOMATO), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_TOMATO))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_TOMATO)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_TOMATO));
        // 珈琲の実
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_COFFEE), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_COFFEE))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_COFFEE)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_COFFEE));
        // ホップ(1.19.2では未実装)
/*      ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_HOPS), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_HOPS))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_HOPS)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_HOPS)); // */
        // 茶葉
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_TEA), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_TEA))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_TEA)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_TEA));
        // ヨアカリタケ
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_GLOWSTONE_MUSHROOM)), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_GLOWSTONE_MUSHROOM))))
                .addSoil(Ingredient.of(Blocks.PODZOL, Blocks.MYCELIUM))
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_GLOWSTONE_MUSHROOM)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_GLOWSTONE_MUSHROOM));
        // ブームッシュルーム
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_GUNPOWDER_MUSHROOM)), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_GUNPOWDER_MUSHROOM))))
                .addSoil(Ingredient.of(Blocks.PODZOL, Blocks.MYCELIUM))
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_GUNPOWDER_MUSHROOM)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_GUNPOWDER_MUSHROOM));
        // フラックスハリタケ
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_REDSTONE_MUSHROOM)), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_REDSTONE_MUSHROOM))))
                .addSoil(Ingredient.of(Blocks.PODZOL, Blocks.MYCELIUM))
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_REDSTONE_MUSHROOM)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_REDSTONE_MUSHROOM));
        // スライタケ
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_SLIME_MUSHROOM)), 2))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.spores(TCulIDs.ID_SLIME_MUSHROOM))))
                .addSoil(Ingredient.of(Blocks.PODZOL, Blocks.MYCELIUM))
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("crop", ThermalCore.BLOCKS.get(TCulIDs.ID_SLIME_MUSHROOM)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_SLIME_MUSHROOM));
        // フロストメロン
        ClocheRecipeBuilder.builder(new ItemStack(ThermalCore.ITEMS.get(TCulIDs.ID_FROST_MELON), 1))
                .addInput(new ItemStack(ThermalCore.ITEMS.get(RegistrationHelper.seeds(TCulIDs.ID_FROST_MELON))))
                .addSoil(Blocks.DIRT)
                .setTime(800)
                .setRender(new ClocheRenderFunction.ClocheRenderReference("stem", ThermalCore.BLOCKS.get(TCulIDs.ID_FROST_MELON)))
                .build(out, rl("cloche", "thermal", TCulIDs.ID_FROST_MELON));
    }

    private static ResourceLocation rl(String... path) {
        return new ResourceLocation(ClocheRenderers.MODID, Arrays.stream(path).collect(Collectors.joining("/")));
    }
}
