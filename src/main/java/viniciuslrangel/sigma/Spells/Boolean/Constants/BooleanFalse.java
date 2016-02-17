/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [16/02/2016, 19:15 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Constants;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import vazkii.psi.api.spell.Spell;
import viniciuslrangel.sigma.Spells.Base.ConstantBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;

@SpellSettings("booleanFalse")
public class BooleanFalse extends ConstantBase{

    public BooleanFalse(Spell spell) {
        super(spell, Boolean.FALSE);
    }

    @Override
    public void drawAdditional() {
        Minecraft mc = Minecraft.getMinecraft();
        int color = 0xFFFFFF;

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5f, 0.5f, 1F);
        GlStateManager.translate(2f,12f,0);
        mc.fontRendererObj.drawString("FALSE", 0, 0, color);
        GlStateManager.popMatrix();
    }
}
