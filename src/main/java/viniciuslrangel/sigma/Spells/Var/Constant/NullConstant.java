/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [26/02/2016, 13:27 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Var.Constant;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import vazkii.psi.api.spell.Spell;
import viniciuslrangel.sigma.Spells.Base.ConstantBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;

@SpellSettings("ConstantNull")
public class NullConstant extends ConstantBase {

    public NullConstant(Spell spell) {
        super(spell, null);
    }

    @Override
    public Class<?> getEvaluationType() {
        return Null.class;
    }

    @Override
    public void drawAdditional() {
        Minecraft mc = Minecraft.getMinecraft();
        int color = 0xFFFFFF;

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5f, 0.5f, 1F);
        GlStateManager.translate(4f,12f,0);
        mc.fontRendererObj.drawString("NULL", 0, 0, color);
        GlStateManager.popMatrix();
    }

}
