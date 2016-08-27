/*
 * This class was created by <viniciuslrangel>.
 * File Created @ [17/02/2016, 17:14 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Operators.Logical;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamAny;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "booleanOperatorTernary", defaultTexture = false, group = NameList.GROUP_BOOLEAN, group_main = true)
public class BooleanTernary extends OperatorBase {

    private SpellParam obj1;
    private SpellParam obj2;

    public BooleanTernary(Spell spell) {
        super(spell);
        BoolParam.addParam(this);
        addParam(obj1 = new ParamAny(NameList.GENERIC_NAME_OBJECT1, SpellParam.GREEN, false));
        addParam(obj2 = new ParamAny(NameList.GENERIC_NAME_OBJECT2, SpellParam.BLUE, false));
    }

    @Override
    public Class<?> getEvaluationType() {
        return Object.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        if(BoolParam.getValue(context, this, 0))
            return getParamValue(context, obj1);
        return getParamValue(context, obj2);
    }

}
