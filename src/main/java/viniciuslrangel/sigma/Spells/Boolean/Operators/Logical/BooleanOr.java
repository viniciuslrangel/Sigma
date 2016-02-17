/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [17/02/2016, 17:14 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Operators.Logical;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellRuntimeException;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;

@SpellSettings(value = "booleanOperatorOr", defaultTexture = false)
public class BooleanOr extends OperatorBase {

    public BooleanOr(Spell spell) {
        super(spell);
        BoolParam.addParam(this);
        BoolParam.addParam(this);
        BoolParam.addParam(this, true);
    }

    @Override
    public Class<?> getEvaluationType() {
        return Boolean.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        boolean v1 = BoolParam.getValue(context, this, 0);
        boolean v2 = BoolParam.getValue(context, this, 1);
        Boolean v3 = BoolParam.getValue(context, this, 2);
        if(v3 != null)
            v2 = v2 || v3;
        return v1 || v2;
    }
}
