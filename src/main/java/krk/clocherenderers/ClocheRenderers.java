package krk.clocherenderers;

import blusunrize.immersiveengineering.api.crafting.ClocheRenderFunction;
import com.mojang.logging.LogUtils;
import krk.clocherenderers.clocherenderers.HaCCropRenderers;
import krk.clocherenderers.clocherenderers.ThermalRenderers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import org.slf4j.Logger;

@Mod(ClocheRenderers.MODID)
public class ClocheRenderers {
    public static final String MODID = "cloche_renderers";
    public static final Logger LOGGER = LogUtils.getLogger();

    public ClocheRenderers() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        initRenders();
    }

    private static void initRenders() {
        for (var modInfo : LoadingModList.get().getMods().stream().map(ModInfo::getModId).toList()) {
            switch (modInfo) {
                case "dcs_climate" -> {
                    LOGGER.info("Register IE Cloche render functions for HaC compat");
                    for (var r : HaCCropRenderers.values()) {
                        ClocheRenderFunction.RENDER_FUNCTION_FACTORIES.put(r.getRenderID(), r.getFactory());
                    }
                }
                case "thermal_cultivation" -> {
                    LOGGER.info("Register IE Cloche render functions for Thermal Cultivation compat");
                    for (var r : ThermalRenderers.values()) {
                        ClocheRenderFunction.RENDER_FUNCTION_FACTORIES.put(r.getRenderID(), r.getFactory());
                    }
                }
            }
        }
    }
}
