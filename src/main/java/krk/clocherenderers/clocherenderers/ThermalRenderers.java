package krk.clocherenderers.clocherenderers;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import cofh.lib.block.CropBlockTall;
import cofh.lib.util.constants.BlockStatePropertiesCoFH;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Transformation;
import com.mojang.math.Vector3f;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;

public enum ThermalRenderers implements ICustomRenderers<ThermalRenderers> {
    THERMAL_CROP_TALL(ThermalCropTall::new);
    private final ClocheRenderFunction.ClocheRenderFunctionFactory factory;

    ThermalRenderers(ClocheRenderFunction.ClocheRenderFunctionFactory factory) {
        this.factory = factory;
    }

    @Override
    public String getRenderID() {
        return this.name().toLowerCase();
    }

    @Override
    public ClocheRenderFunction.ClocheRenderFunctionFactory getFactory() {
        return this.factory;
    }

    public static class ThermalCropTall implements ClocheRenderFunction {
        private final CropBlockTall block;
        private int maxAge;

        public ThermalCropTall(Block block) {
            if (!(block instanceof CropBlockTall))
                throw new IllegalArgumentException(String.format("Block %s is not tall crops of CoFH", block.getDescriptionId()));

            this.block = (CropBlockTall) block;
            this.maxAge = this.block.getMaxAge();
        }

        @Override
        public float getScale(ItemStack seed, float growth) {
            return 0.6875f;
        }

        @Override
        public Collection<Pair<BlockState, Transformation>> getBlocks(ItemStack stack, float growth) {
            return ImmutableList.of(
                    Pair.of(
                            this.block.defaultBlockState().setValue(BlockStatePropertiesCoFH.TOP, false).setValue(block.getAgeProperty(), age(growth)),
                            new Transformation(null)
                    ),
                    Pair.of(
                            this.block.defaultBlockState().setValue(BlockStatePropertiesCoFH.TOP, true).setValue(block.getAgeProperty(), age(growth)),
                            new Transformation(new Vector3f(0, 1, 0), null, null, null)
                    )
            );
        }

        protected int age(float growth) {
            return Math.min(this.maxAge, Math.round(this.maxAge * growth));
        }

    }
}
