/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [16/02/2016, 20:17 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Operators.Relational;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamNumber;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "booleanOperatorGreaterThanOrEquals", defaultTexture = false, group = NameList.GROUP_BOOLEAN)
public class BooleanGreaterThanOrEquals extends OperatorBase {

    SpellParam param1;
    SpellParam param2;

    public BooleanGreaterThanOrEquals(Spell spell) {
        super(spell);
        addParam(param1 = new ParamNumber(SpellParam.GENERIC_NAME_NUMBER1, SpellParam.RED, false, false));
        addParam(param2 = new ParamNumber(SpellParam.GENERIC_NAME_NUMBER2, SpellParam.GREEN, false, false));
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        return this.<Double>getParamValue(context, param1) >= this.<Double>getParamValue(context, param2);
    }

    @Override
    public Class<?> getEvaluationType() {
        return Boolean.class;
    }

}
