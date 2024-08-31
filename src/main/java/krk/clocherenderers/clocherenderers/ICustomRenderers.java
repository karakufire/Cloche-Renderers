package krk.clocherenderers.clocherenderers;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import net.minecraft.world.level.block.Block;

public interface ICustomRenderers<E extends ICustomRenderers<E>> {

    String getRenderID();

    ClocheRenderFunction.ClocheRenderFunctionFactory getFactory();

    default ClocheRenderFunction.ClocheRenderReference reference(Block block) {
        return new ClocheRenderFunction.ClocheRenderReference(this.getRenderID(), block);
    }
}
