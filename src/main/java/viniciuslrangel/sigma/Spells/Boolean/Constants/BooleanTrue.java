/*
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 22:05 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Boolean.Constants;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import vazkii.psi.api.spell.Spell;
import viniciuslrangel.sigma.Spells.Base.ConstantBase;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.NameList;

@SpellSettings(value = "booleanTrue", group = NameList.GROUP_BOOLEAN)
public class BooleanTrue extends ConstantBase{

    public BooleanTrue(Spell spell) {
        super(spell, Boolean.TRUE);
    }

    @Override
    public void drawAdditional() {
        Minecraft mc = Minecraft.getMinecraft();
        int color = 0xFFFFFF;

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5f, 0.5f, 1F);
        GlStateManager.translate(5f,12f,0);
        mc.fontRendererObj.drawString("TRUE", 0, 0, color);
        GlStateManager.popMatrix();
    }
}
