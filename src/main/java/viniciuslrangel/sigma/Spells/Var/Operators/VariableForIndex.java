/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [25/02/2016, 20:37 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Var.Operators;

import vazkii.psi.api.spell.Spell;
import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellRuntimeException;
import viniciuslrangel.sigma.Spells.Base.OperatorBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "VariableForLoopIndex", defaultTexture = false, group = NameList.GROUP_VARIABLES)
public class VariableForIndex extends OperatorBase {

    public VariableForIndex(Spell spell) {
        super(spell);
    }

    @Override
    public Class<?> getEvaluationType() {
        return Integer.class;
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        return context.customData.containsKey("loopForIndex") ? ((Integer)context.customData.get("loopForIndex")).doubleValue() : 0;
    }
}
