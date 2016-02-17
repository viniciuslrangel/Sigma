/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 23:15 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Base;

import vazkii.psi.api.spell.*;

public class ConstantBase extends SpellPiece {

    public Object constValue;

    public ConstantBase(Spell spell, Object constValue) {
        super(spell);
        this.constValue = constValue;
    }

    @Override
    public EnumPieceType getPieceType() {
        return EnumPieceType.CONSTANT;
    }

    @Override
    public Class<?> getEvaluationType() {
        return constValue.getClass();
    }

    @Override
    public Object evaluate() {
        return constValue;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        return evaluate();
    }
}
