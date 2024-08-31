package krk.clocherenderers.clocherenderers;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.mojang.math.Transformation;
import com.mojang.math.Vector3f;
import defeatedcrow.hac.api.crop.CropGrowType;
import defeatedcrow.hac.api.crop.IClimateCrop;
import defeatedcrow.hac.api.util.DCState;
import krk.clocherenderers.ClocheRenderers;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.Collection;
import java.util.List;

public enum HaCCropRenderers implements ICustomRenderers<HaCCropRenderers> {

    HAC_CROP_SINGLE(RenderHaCCropSingle::new),
    HAC_CROP_DOUBLE(RenderHaCCropDouble::new),
    HAC_CROP_VINE(RenderHaCCropVine::new),
    ;

    private final ClocheRenderFunction.ClocheRenderFunctionFactory factory;

    HaCCropRenderers(ClocheRenderFunction.ClocheRenderFunctionFactory factory) {
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

    private static abstract class AbstractRenderHaCCrop implements ClocheRenderFunction {
        protected final Block block;
        protected final IClimateCrop alias;
        protected int maxStage;
        protected IntegerProperty stageProperty = DCState.STAGE5;

        public AbstractRenderHaCCrop(Block block, CropGrowType growType) {
            this(block, growType, true);
        }

        public AbstractRenderHaCCrop(Block block, CropGrowType growType, boolean verbose) {
            if (!(block instanceof IClimateCrop))
                throw new IllegalArgumentException(String.format("Block %s is not HaC crops.", block.getDescriptionId()));
            this.block = block;
            this.alias = (IClimateCrop) this.block;
            if (this.alias.getGrowType(this.alias.getTier()) != growType && verbose)
                ClocheRenderers.LOGGER.warn(String.format("Block %s grow type is not %s, thus may not be displayed correctly.", block.getDescriptionId(), growType.toString()));
            this.maxStage = this.alias.getGrownState().getValue(DCState.STAGE5);
        }

        protected int age(float growth) {
            return Math.min(this.maxStage, Math.round(this.maxStage * growth));
        }
    }

    public static class RenderHaCCropSingle extends AbstractRenderHaCCrop {

        public RenderHaCCropSingle(Block block) {
            super(block, CropGrowType.SINGLE, false);
        }

        @Override
        public float getScale(ItemStack seed, float growth) {
            return 0.75f;
        }

        @Override
        public Collection<Pair<BlockState, Transformation>> getBlocks(ItemStack stack, float growth) {
            return ImmutableList.of(Pair.of(
                    this.block.defaultBlockState().setValue(DCState.STAGE5, this.age(growth)),
                    new Transformation(null)
            ));
        }
    }

    public static class RenderHaCCropDouble extends AbstractRenderHaCCrop {

        public RenderHaCCropDouble(Block block) {
            super(block, CropGrowType.DOUBLE);
        }

        @Override
        public float getScale(ItemStack seed, float growth) {
            return 0.6875f;
        }

        @Override
        public Collection<Pair<BlockState, Transformation>> getBlocks(ItemStack stack, float growth) {
            int age = this.age(growth);
            if (age > 1) {
                return ImmutableList.of(
                        Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age),
                                new Transformation(null)),
                        Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age).setValue(DCState.DOUBLE, true),
                                new Transformation(new Vector3f(0, 1, 0), null, null, null))
                );
            }
            return ImmutableList.of(Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age), new Transformation(null)));
        }
    }

    public static class RenderHaCCropVine extends AbstractRenderHaCCrop {

        public RenderHaCCropVine(Block block) {
            super(block, CropGrowType.VINE);
        }

        @Override
        public float getScale(ItemStack seed, float growth) {
            return 0.6875f;
        }

        @Override
        public Collection<Pair<BlockState, Transformation>> getBlocks(ItemStack stack, float growth) {
            var age = this.age(growth);
            return List.of(
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, 0).setValue(DCState.EAST, true),
                            new Transformation(new Vector3f(-0.875f, 0, 0), null, null, null)),
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, 0).setValue(DCState.WEST, true),
                            new Transformation(new Vector3f(0.875f, 0, 0), null, null, null)),
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, 0).setValue(DCState.SOUTH, true),
                            new Transformation(new Vector3f(0, 0, -0.875f), null, null, null)),
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, 0).setValue(DCState.NORTH, true),
                            new Transformation(new Vector3f(0, 0, 0.875f), null, null, null)),

                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age).setValue(DCState.EAST, true),
                            new Transformation(new Vector3f(-0.875f, 1, 0), null, null, null)),
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age).setValue(DCState.WEST, true),
                            new Transformation(new Vector3f(0.875f, 1, 0), null, null, null)),
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age).setValue(DCState.SOUTH, true),
                            new Transformation(new Vector3f(0, 1, -0.875f), null, null, null)),
                    Pair.of(this.block.defaultBlockState().setValue(DCState.STAGE5, age).setValue(DCState.NORTH, true),
                            new Transformation(new Vector3f(0, 1, 0.875f), null, null, null))
            );
        }
    }
}
