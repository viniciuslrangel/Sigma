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
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "booleanOperatorNot", defaultTexture = false, group = NameList.GROUP_BOOLEAN)
public class BooleanNot extends OperatorBase {

    public BooleanNot(Spell spell) {
        super(spell);
        BoolParam.addParam(this);
    }

    @Override
    public Class<?> getEvaluationType() {
        return Boolean.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        return !BoolParam.getValue(context, this, 0);
    }

}
