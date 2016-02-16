/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 19:10 (UTC-3)]
 */
package viniciuslrangel.sigma;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import viniciuslrangel.sigma.Spells.SpellRegistry;

@Mod(modid = Sigma.MODID, version = Sigma.VERSION, dependencies = "required-after:Psi")
public class Sigma {

    public static final String MODID = "Sigma";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        SpellRegistry.init();
    }


}
