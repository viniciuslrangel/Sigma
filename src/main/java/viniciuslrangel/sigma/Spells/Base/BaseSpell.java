/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [16/02/2016, 00:14 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Base;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellPiece;
import vazkii.psi.common.lib.LibPieceGroups;

public abstract class BaseSpell extends SpellPiece {

    public static String key = "";
    public static boolean defaultTexture = true;
    public static String group = LibPieceGroups.TUTORIAL_1;
    public static boolean group_main = false;

    public static void setDefaults(){};

    public BaseSpell(Spell spell) {
        super(spell);
    }

}
