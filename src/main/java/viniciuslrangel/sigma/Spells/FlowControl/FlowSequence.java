/*
 * This class was created by <viniciuslrangel>.
 * File Created @ [26/02/2016, 14:22 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import vazkii.psi.api.spell.*;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "flowSequence", defaultTexture = false, group = NameList.GROUP_ADVANCED_FLOWCONTROL)
public class FlowSequence extends FlowBase {

    private CompiledSpell.Action action2;
    private SpellParam output2;

    public FlowSequence(Spell spell) {
        super(spell);
        addParam(output = new TrickParam(NameList.SPELL_PIECE1, SpellParam.CYAN, false));
        addParam(output2 = new TrickParam(NameList.SPELL_PIECE2, SpellParam.YELLOW, false));
        paramSides.replace(output, SpellParam.Side.RIGHT);
        paramSides.replace(output2, SpellParam.Side.BOTTOM);
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        super.execute(context);
        SpellPiece trick2 = spell.grid.getPieceAtSideSafely(x, y, paramSides.get(output2));
        if (trick2 != null) {
            CompiledSpell.Action action2 = context.cspell.actionMap.get(trick2);
            if (action2 != null)
                this.action2 = action2;
            context.cspell.actionMap.remove(trick2);
            context.cspell.actions.remove(action2);
        }
        executeSpell(context, action, trick);
        executeSpell(context, action2, trick2);
        return null;
    }
}
