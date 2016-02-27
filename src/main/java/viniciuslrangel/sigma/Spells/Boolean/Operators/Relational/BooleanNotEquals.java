/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [16/02/2016, 22:11 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Operators.Relational;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellRuntimeException;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "booleanOperatorNotEquals", defaultTexture = false, group = NameList.GROUP_BOOLEAN)
public class BooleanNotEquals extends BooleanEquals {

    public BooleanNotEquals(Spell spell) {
        super(spell);
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        Object o1 = getParamValue(context, obj1);
        Object o2 = getParamValue(context, obj2);
        Object o3 = getParamValue(context, obj3);
        boolean value;
        if(paramSides.get(obj3).isEnabled())
            value = !o1.equals(o2) || !o1.equals(o3);
        else
            value = !o1.equals(o2);
        return value;
    }

}
