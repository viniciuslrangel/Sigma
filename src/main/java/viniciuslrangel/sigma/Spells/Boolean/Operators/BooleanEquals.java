/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [16/02/2016, 20:17 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Operators;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamAny;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;

import static viniciuslrangel.sigma.Spells.NameList.*;

@SpellSettings(value = "booleanOperatorEquals", defaultTexture = false)
public class BooleanEquals extends OperatorBase{

    SpellParam obj1;
    SpellParam obj2;
    SpellParam obj3;

    public BooleanEquals(Spell spell) {
        super(spell);
        addParam(obj1 = new ParamAny(GENERIC_NAME_OBJECT1, SpellParam.RED, false));
        addParam(obj2 = new ParamAny(GENERIC_NAME_OBJECT2, SpellParam.GREEN, false));
        addParam(obj3 = new ParamAny(GENERIC_NAME_OBJECT3, SpellParam.BLUE, true));
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        Object o1 = getParamValue(context, obj1);
        boolean value = o1.equals(getParamValue(context, obj2));
        if(paramSides.get(obj3).isEnabled())
            value = value && o1.equals(getParamValue(context, obj3));
        return value;
    }

    @Override
    public Class<?> getEvaluationType() {
        return Boolean.class;
    }

}
