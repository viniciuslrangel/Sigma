/**
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

public class BooleanTrue extends ConstantBase{

    public static String key = "booleanTrue";

    public BooleanTrue(Spell spell) {
        super(spell);
        constValue = Boolean.TRUE;
    }

    @Override
    public void drawAdditional() {
        Minecraft mc = Minecraft.getMinecraft();
        int color = 0x000000;

        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5f, 0.5f, 1F);
        GlStateManager.translate(5f,11f,0);
        mc.fontRendererObj.drawString("TRUE", 0, 0, color);
        GlStateManager.popMatrix();
    }
}
