/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [18/02/2016, 16:54 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.FlowControl;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.EnumChatFormatting;
import vazkii.psi.api.spell.*;
import viniciuslrangel.sigma.Spells.Base.FlowBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.BoolParam;

@SpellSettings("FlowControlWhile")
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
        while (true) {

            if (count++ > 300)
                throw new SpellRuntimeException("Loop limit!");
            if (!BoolParam.getValue(context, this, 0))
                break;
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
