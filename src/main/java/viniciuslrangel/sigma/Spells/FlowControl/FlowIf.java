/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [26/02/2016, 14:48 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import vazkii.psi.api.spell.*;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "FlowIf", defaultTexture = false, group = NameList.GROUP_ADVANCED_FLOWCONTROL, group_main = true)
public class FlowIf extends FlowBase {

    CompiledSpell.Action action2;
    SpellPiece trick2;
    SpellParam output2;

    public FlowIf(Spell spell) {
        super(spell, false);
        addParam(output = new TrickParam(NameList.SPELL_PIECE1, SpellParam.CYAN, false));
        addParam(output2 = new TrickParam(NameList.SPELL_PIECE2, SpellParam.YELLOW, false));
        BoolParam.addParam(this);
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        super.execute(context);
        trick2 = spell.grid.getPieceAtSideSafely(x, y, paramSides.get(output2));
        if (trick2 != null) {
            CompiledSpell.Action action2 = context.cspell.actionMap.get(trick2);
            if (action2 != null)
                this.action2 = action2;
            context.cspell.actionMap.remove(trick2);
            context.cspell.actions.remove(action2);
        }
        if (BoolParam.getValue(context, this, 1))
            executeSpell(context, action, trick);
        else
            executeSpell(context, action2, trick2);
        return null;
    }

}
