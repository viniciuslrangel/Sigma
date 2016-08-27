/*
 * This class was created by <viniciuslrangel>.
 * File Created @ [18/02/2016, 16:54 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import vazkii.psi.api.spell.*;
import vazkii.psi.common.core.handler.PlayerDataHandler;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "flowControlWhile", defaultTexture = false, group = NameList.GROUP_ADVANCED_FLOWCONTROL)
public class FlowWhile extends FlowBase {

    public FlowWhile(Spell spell) {
        super(spell);
        BoolParam.addParam(this);
        BoolParam.addParam(this, true);
    }

    @Override
    public Object execute(SpellContext context) throws SpellRuntimeException {
        super.execute(context);
        int count = 0;
        Boolean useTry = BoolParam.getValue(context, this, 1);
        SpellMetadata meta = new SpellMetadata();
        try {
            trick.addToMetadata(meta);
        } catch (SpellCompilationException e) {
            meta.addStat(EnumSpellStat.COST, 20);
        }
        while (BoolParam.getValue(context, this, 0)) {
            if (count++ > 500)
                throw new SpellRuntimeException("Loop limit!");

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
