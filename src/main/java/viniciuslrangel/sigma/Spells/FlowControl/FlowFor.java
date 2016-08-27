/*
 * This class was created by <viniciuslrangel>.
 * File Created @ [21/02/2016, 01:35 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import vazkii.psi.api.spell.*;
import vazkii.psi.api.spell.param.ParamNumber;
import vazkii.psi.common.core.handler.PlayerDataHandler;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "flowControlFor", defaultTexture = false, group = NameList.GROUP_ADVANCED_FLOWCONTROL)
public class FlowFor extends FlowBase {

    private ParamNumber p_max;
    private ParamNumber p_step;

    public FlowFor(Spell spell) {
        super(spell);
        addParam(p_max = new ParamNumber(SpellParam.GENERIC_NAME_NUMBER1, SpellParam.RED, false, false));
        addParam(p_step = new ParamNumber(SpellParam.GENERIC_NAME_NUMBER2, SpellParam.GREEN, true, false));
        BoolParam.addParam(this, true);
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        super.execute(context);
        Double max = getParamValue(context, p_max);
        Double step = getParamValue(context, p_step);
        if (step == null)
            if (max > 0)
                step = 1d;
            else
                step = -1d;
        int count = 0;
        Boolean useTry = BoolParam.getValue(context, this, 3);
        SpellMetadata meta = new SpellMetadata();
        try {
            trick.addToMetadata(meta);
        } catch (SpellCompilationException e) {
            meta.addStat(EnumSpellStat.COST, 20);
        }
        for (int i = 0; step > 0 ? i < max : i > max; i += step) {
            if (count++ > 500)
                throw new SpellRuntimeException(NameList.EXCEPTION_INFINITYLOOP);
            if (context.customData.containsKey("loopForIndex"))
                context.customData.replace("loopForIndex", i);
            else
                context.customData.put("loopForIndex", i);
            PlayerDataHandler.get(context.caster).deductPsi(meta.stats.get(EnumSpellStat.COST), 3, true);
            if (useTry != null && !useTry) {
                try {
                    executeSpell(context, action, trick);
                } catch (SpellRuntimeException e) {
                    if (!context.caster.worldObj.isRemote && !context.shouldSuppressErrors())
                        context.caster.addChatComponentMessage(new TextComponentTranslation(e.getMessage())
                                .setStyle(new Style().setColor(TextFormatting.RED)));
                }
            } else
                executeSpell(context, action, trick);
        }

        return null;
    }
}
