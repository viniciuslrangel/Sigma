/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 20:44 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells;

import net.minecraft.util.ResourceLocation;
import vazkii.psi.api.PsiAPI;
import viniciuslrangel.sigma.Sigma;
import viniciuslrangel.sigma.Spells.Base.BaseSpell;
import viniciuslrangel.sigma.Spells.Boolean.Constants.BooleanTrue;

public class SpellRegistry {

    private static boolean init = false;

    public static void init() {
        if (init)
            return;
        init = true;

        register(BooleanTrue.class);

    }

    private static void register(Class<? extends BaseSpell> type) {
        try {
            String key = (String) type.getField("key").get(null);
            String texture = (Boolean) type.getField("defaultTexture").get(null) ? "default" : key;
            String group = (String) type.getField("group").get(null);
            boolean main = (Boolean) type.getField("group_main").get(null);
            PsiAPI.spellPieceRegistry.putObject(key, type);
            PsiAPI.simpleSpellTextures.put(key, new ResourceLocation(Sigma.MODID, String.format("textures/spell/" + texture + ".png")));
            PsiAPI.addPieceToGroup(type, group, main);

        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


}
