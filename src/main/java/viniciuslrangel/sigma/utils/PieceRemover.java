/**
 * This class was created by <viniciuslrangel>.
 * File Created @ [03/03/2016, 18:49 (UTC-3)]
 */
package viniciuslrangel.sigma.utils;

import net.minecraft.util.RegistryNamespaced;
import net.minecraft.util.RegistrySimple;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLLog;
import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.spell.SpellPiece;
import viniciuslrangel.sigma.Sigma;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

public class PieceRemover {

    private static String[] pieces;

    public static void load() throws NoSuchFieldException, IllegalAccessException {
        Configuration config = Sigma.configFile;

        pieces = config.getStringList("pieceToRemove", "Piece Remover", new String[0], "Remove spell pieces from game\nRegistered pieces: " + Arrays.toString(PsiAPI.spellPieceRegistry.getKeys().toArray()));

        if (config.hasChanged())
            config.save();

        Field inverseObjectRegistryField = RegistryNamespaced.class.getDeclaredField("inverseObjectRegistry");
        inverseObjectRegistryField.setAccessible(true);
        Field registryObjectsField = RegistrySimple.class.getDeclaredField("registryObjects");
        registryObjectsField.setAccessible(true);

        Map<Class<? extends SpellPiece>, String> inverseObjectRegistry = (Map<Class<? extends SpellPiece>, String>) inverseObjectRegistryField.get(PsiAPI.spellPieceRegistry);
        Map<String, Class<? extends SpellPiece>> registryObjects = (Map<String, Class<? extends SpellPiece>>) registryObjectsField.get(PsiAPI.spellPieceRegistry);


        for (String piece : pieces) {
            Class<? extends SpellPiece> spellPiece = PsiAPI.spellPieceRegistry.getObject(piece);
            if (spellPiece != null) {
                String k = inverseObjectRegistry.get(spellPiece);
                inverseObjectRegistry.remove(spellPiece);
                registryObjects.remove(k);
                PsiAPI.groupsForPiece.remove(spellPiece);
                PsiAPI.pieceMods.remove(spellPiece);
            }else
                FMLLog.warning("Invalid piece in Sigma Remover config");
        }

    }
}
