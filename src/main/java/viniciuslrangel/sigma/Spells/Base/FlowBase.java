/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [18/02/2016, 16:59 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Base;

import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.internal.IPlayerData;
import vazkii.psi.api.spell.*;
import viniciuslrangel.sigma.Spells.NameList;

public abstract class FlowBase extends OperatorBase {

    protected SpellParam output;

    public FlowBase(Spell spell) {
        super(spell);
        addParam(output = new TrickParam(NameList.SPELL_PIECE1, SpellParam.GRAY, false));
    }

    @Override
    public EnumPieceType getPieceType() {
        return EnumPieceType.TRICK;
    }

    @Override
    public Class<?> getEvaluationType() {
        return null;
    }

    public CompiledSpell.Action action;
    public SpellPiece trick;

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException{
        trick = spell.grid.getPieceAtSideSafely(x, y, paramSides.get(output));
        if (trick != null) {
            CompiledSpell.Action action2 = context.cspell.actionMap.get(trick);
            if (action2 != null)
                action = action2;
            context.cspell.actionMap.remove(trick);
            context.cspell.actions.remove(action);
        }
        return null;
    };

    public void executeSpell(SpellContext context, CompiledSpell.Action action, SpellPiece trick) throws SpellRuntimeException {
        IPlayerData data = PsiAPI.internalHandler.getDataForPlayer(context.caster);
        updateSpell(context, trick);
        action.execute(data, context);
    }

    public void updateSpell(SpellContext context, SpellPiece piece) throws SpellRuntimeException {
        for(SpellParam.Side side : piece.paramSides.values()){
            if(side.isEnabled()){
                updateSpell(context, spell.grid.getPieceAtSideSafely(piece.x, piece.y, side));
            }
        }
        context.evaluatedObjects[piece.x][piece.y] = piece.execute(context);
    }

    public class TrickParam extends SpellParam{

        public TrickParam(String name, int color, boolean canDisable) {
            super(name, color, canDisable);
        }

        @Override
        protected Class<?> getRequiredType() {
            return Null.class;
        }

        @Override
        public boolean canAccept(SpellPiece piece) {
            SpellPiece connected = piece.spell.grid.getPieceAtSideSafely(x, y, paramSides.get(this));
            if(connected == null)
                return false;
            return connected.getPieceType() == EnumPieceType.TRICK && (paramSides.get(this) == Side.RIGHT || paramSides.get(this) == Side.BOTTOM);
        }

    }


}
