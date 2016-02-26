/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [26/02/2016, 13:33 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Var.Operators;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamNumber;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;

@SpellSettings(value = "VariableGet", defaultTexture = false)
public class VariableGet extends OperatorBase {

    SpellParam index;

    public VariableGet(Spell spell) {
        super(spell);
        addParam(index = new ParamNumber(SpellParam.GENERIC_NAME_NUMBER1, SpellParam.RED, false, false));
    }

    @Override
    public Class<?> getEvaluationType() {
        return Object.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        String name = "sigmaVar_+" + getParamValue(context, index);
        if(context.customData.containsKey(name))
            return context.customData.get(name);
        return null;
    }
}
