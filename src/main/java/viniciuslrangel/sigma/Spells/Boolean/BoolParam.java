/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [16/02/2016, 20:17 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean;

import vazkii.psi.api.spell.SpellContext;
import vazkii.psi.api.spell.SpellParam;
import vazkii.psi.api.spell.SpellPiece;
import vazkii.psi.api.spell.param.ParamSpecific;
import static viniciuslrangel.sigma.Spells.NameList.*;

import java.util.Map;

public class BoolParam extends ParamSpecific {

    public BoolParam(String name, int color, boolean canDisable, boolean constant) {
        super(name, color, canDisable, constant);
    }

    public static void addParam(SpellPiece spell) {
        addParam(spell, false);
    }

    public static void addParam(SpellPiece spell, boolean canDisable) {
        addParam(spell, canDisable, false);
    }

    public static void addParam(SpellPiece spell, boolean canDisable, boolean constant) {
        Map<String, SpellParam> params = spell.params;
        if (params.containsKey(GENERIC_NAME_BOOLEAN1))
            if (params.containsKey(GENERIC_NAME_BOOLEAN2))
                if (params.containsKey(GENERIC_NAME_BOOLEAN3))
                    throw new IllegalArgumentException(String.format("Already have 3 inputs in spell '%s'", spell.registryKey));
                else
                    spell.addParam(new BoolParam(GENERIC_NAME_BOOLEAN3, SpellParam.BLUE, canDisable, constant));
            else
                spell.addParam(new BoolParam(GENERIC_NAME_BOOLEAN2, SpellParam.GREEN, canDisable, constant));
        else
            spell.addParam(new BoolParam(GENERIC_NAME_BOOLEAN1, SpellParam.RED, canDisable, constant));


    }

    public static Boolean getValue(SpellContext context, SpellPiece spell, int index) {
        SpellParam param = null;
        switch (index) {
            case 0:
                param = spell.params.get(GENERIC_NAME_BOOLEAN1);
                break;
            case 1:
                param = spell.params.get(GENERIC_NAME_BOOLEAN2);
                break;
            case 2:
                param = spell.params.get(GENERIC_NAME_BOOLEAN3);
                break;
        }
        if(!spell.paramSides.get(param).isEnabled())
            return null;
        return spell.getParamValue(context, param);
    }


    @Override
    protected Class<?> getRequiredType() {
        return Boolean.class;
    }

}
