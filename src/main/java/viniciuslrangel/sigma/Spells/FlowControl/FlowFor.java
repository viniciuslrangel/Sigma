/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [21/02/2016, 01:35 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import vazkii.psi.api.spell.Spell;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;

public class FlowFor extends FlowBase {

    public FlowFor(Spell spell) {
        super(spell);
        BoolParam.addParam(this);
        BoolParam.addParam(this);
        BoolParam.addParam(this, true);
    }

}
