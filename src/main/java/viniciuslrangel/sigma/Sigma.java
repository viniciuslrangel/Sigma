/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 19:10 (UTC-3)]
 */
package viniciuslrangel.sigma;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import vazkii.psi.api.PsiAPI;
import vazkii.psi.common.lib.LibPieceGroups;
import viniciuslrangel.sigma.Spells.NameList;
import viniciuslrangel.sigma.Spells.SpellRegistry;
import viniciuslrangel.sigma.utils.PieceRemover;

@Mod(modid = Sigma.MODID, version = Sigma.VERSION, dependencies = "required-after:Psi")
public class Sigma {

    public static final String MODID = "Sigma";
    public static final String VERSION = "1.0";

    public static Configuration configFile;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configFile = new Configuration(event.getSuggestedConfigurationFile());
        configFile.load();
        SpellRegistry.init();
        PsiAPI.setGroupRequirements(NameList.GROUP_BOOLEAN, 20, LibPieceGroups.TRIGNOMETRY);
        PsiAPI.setGroupRequirements(NameList.GROUP_ADVANCED_FLOWCONTROL, 22, LibPieceGroups.FLOW_CONTROL);
        PsiAPI.setGroupRequirements(NameList.GROUP_VARIABLES, 22, NameList.GROUP_ADVANCED_FLOWCONTROL);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        try {
            PieceRemover.load();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            FMLLog.bigWarning("Error removing spell pieces! Shall incompatible PSI version");
            e.printStackTrace();
        }
    }


}
