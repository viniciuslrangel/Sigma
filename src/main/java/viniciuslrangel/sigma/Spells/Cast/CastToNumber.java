/*
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

@SpellSettings(value = "castOperatorToNumber", defaultTexture = false, group = NameList.GROUP_ADVANCED_FLOWCONTROL)
public class CastToNumber extends OperatorBase {

    private SpellParam param;

    public CastToNumber(Spell spell) {
        super(spell);
        addParam(param = new ParamAny(NameList.GENERIC_NAME_OBJECT1, SpellParam.RED, false));
    }

    @Override
    public Class<?> getEvaluationType() {
        return Double.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        try {
            Object obj = getParamValue(context, param);
            if(obj == null)
                return 0d;
            return Double.valueOf(obj.toString());
        }catch(NumberFormatException nfe){
            throw new SpellRuntimeException(NameList.EXCEPTION_NUMBERFORMAT);
        }
    }
}
