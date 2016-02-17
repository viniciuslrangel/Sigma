/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [16/02/2016, 19:50 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Base;

import vazkii.psi.api.spell.*;
import vazkii.psi.api.spell.piece.PieceOperator;

public abstract class OperatorBase extends PieceOperator {

    public OperatorBase(Spell spell) {
        super(spell);
    }

    @Override
    public EnumPieceType getPieceType() {
        return EnumPieceType.OPERATOR;
    }

    @Override
    public Object evaluate() {
        return null;
    }

    @Override
    public abstract Object execute(SpellContext context) throws SpellRuntimeException;
}
