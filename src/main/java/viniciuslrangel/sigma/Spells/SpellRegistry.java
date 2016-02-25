/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 20:44 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells;

import net.minecraft.util.ResourceLocation;
import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.spell.SpellPiece;
import viniciuslrangel.sigma.Sigma;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.Constants.BooleanFalse;
import viniciuslrangel.sigma.Spells.Boolean.Constants.BooleanTrue;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanAnd;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanNot;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanOr;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanTernary;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Relational.*;
import viniciuslrangel.sigma.Spells.Cast.CastToBoolean;
import viniciuslrangel.sigma.Spells.Cast.CastToNumber;
import viniciuslrangel.sigma.Spells.FlowControl.FlowFor;
import viniciuslrangel.sigma.Spells.FlowControl.FlowWhile;

import java.lang.instrument.IllegalClassFormatException;

public class SpellRegistry {

    private static boolean init = false;

    public static void init() {
        if (init)
            return;
        init = true;

        /**addPackageFromBase("Boolean.Constants");
         addPackageFromBase("Boolean.Operators.Logical");
         addPackageFromBase("Boolean.Operators.Relational");
         addPackageFromBase("Cast");
         */
        register(
                BooleanTrue.class,
                BooleanFalse.class,
                BooleanAnd.class,
                BooleanNot.class,
                BooleanOr.class,
                BooleanTernary.class,
                BooleanEquals.class,
                BooleanGreaterThan.class,
                BooleanGreaterThanOrEquals.class,
                BooleanLessThan.class,
                BooleanLessThanOrEquals.class,
                BooleanNotEquals.class,
                CastToNumber.class,
                CastToBoolean.class,
                FlowWhile.class,
                FlowFor.class
        );

    }

    private static void register(Class<? extends SpellPiece>... typeArray) {
        for (Class<? extends SpellPiece> type : typeArray)
            try {
                if (!type.isAnnotationPresent(SpellSettings.class))
                    throw new IllegalClassFormatException("Class need SpellSettings annotation");
                SpellSettings spellSettings = type.getAnnotation(SpellSettings.class);
                String key = spellSettings.value();
                String texture = spellSettings.defaultTexture() ? "default" : key;
                String group = spellSettings.group();
                boolean main = spellSettings.group_main();
                PsiAPI.spellPieceRegistry.putObject(key, type);
                PsiAPI.pieceMods.put(type, Sigma.MODID);
                PsiAPI.simpleSpellTextures.put(key, new ResourceLocation(Sigma.MODID, String.format("textures/spell/" + texture + ".png")));
                PsiAPI.addPieceToGroup(type, group, main);

            } catch (IllegalClassFormatException e) {
                e.printStackTrace();
            }
    }


}
