/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [17/02/2016, 18:24 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Cast;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamAny;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "castOperatorToBoolean", defaultTexture = false)
public class CastToBoolean extends OperatorBase {

    SpellParam param;

    public CastToBoolean(Spell spell) {
        super(spell);
        addParam(param = new ParamAny(NameList.GENERIC_NAME_OBJECT1, SpellParam.RED, false));
    }

    @Override
    public Class<?> getEvaluationType() {
        return Boolean.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        Object value = getParamValue(context, param);
        if (Number.class.isAssignableFrom(value.getClass()))
            if (((Double)value) == 0)
                return false;
            else
                return true;
        if(value != null)
            return true;
        return false;
    }
}
