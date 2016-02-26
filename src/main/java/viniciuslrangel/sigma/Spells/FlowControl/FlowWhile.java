/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [18/02/2016, 16:54 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import vazkii.psi.api.spell.*;
import vazkii.psi.common.core.handler.PlayerDataHandler;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;

@SpellSettings(value = "FlowControlWhile", defaultTexture = false)
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
                        context.caster.addChatComponentMessage(new ChatComponentTranslation(e.getMessage())
                                .setChatStyle(new ChatStyle().setColor(EnumChatFormatting.RED)));
                }
            }else
                executeSpell(context, action, trick);
        }
        return null;
    }

}
