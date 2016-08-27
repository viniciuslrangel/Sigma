/*
 * This class was created by <viniciuslrangel>.
 * File Created @ [26/02/2016, 12:58 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Var.Tricks;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellRuntimeException;
import vazkii.psi.api.spell.param.ParamAny;
import vazkii.psi.api.spell.param.ParamNumber;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Base.TrickBase;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "VariableSet", defaultTexture = false, group = NameList.GROUP_VARIABLES, group_main = true)
public class VariableSet extends TrickBase {

    private SpellParam index;
    private SpellParam object;

    public VariableSet(Spell spell) {
        super(spell);
        addParam(index = new ParamNumber(SpellParam.GENERIC_NAME_NUMBER1, SpellParam.RED, false, false));
        addParam(object = new ParamAny(NameList.GENERIC_NAME_OBJECT1, SpellParam.BLUE, false));
    }

    @Override
    public Class<?> getEvaluationType() {
        return null;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        String name = "sigmaVar_+" + getParamValue(context, index);
        Object obj = getParamValue(context, object);
        if (context.customData.containsKey(name))
            if (obj == null)
                context.customData.remove(name);
            else
                context.customData.replace(name, obj);
        else
            context.customData.put(name, obj);

        return null;
    }
}
