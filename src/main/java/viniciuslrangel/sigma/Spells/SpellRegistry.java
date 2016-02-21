/**
 * This class was created by <viniciuslrangel>.
 * Source code:
 * https://github.com/viniciuslrangel/Sigma
 * File Created @ [15/02/2016, 20:44 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells;

import net.minecraft.util.ResourceLocation;
import vazkii.psi.api.PsiAPI;
import vazkii.psi.api.spell.SpellPiece;
import viniciuslrangel.sigma.Sigma;
import viniciuslrangel.sigma.Spells.Base.SpellSettings;
import viniciuslrangel.sigma.Spells.Boolean.Constants.BooleanFalse;
import viniciuslrangel.sigma.Spells.Boolean.Constants.BooleanTrue;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanAnd;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanNot;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanOr;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Logical.BooleanTernary;
import viniciuslrangel.sigma.Spells.Boolean.Operators.Relational.*;
import viniciuslrangel.sigma.Spells.Cast.CastToBoolean;
import viniciuslrangel.sigma.Spells.Cast.CastToNumber;
import viniciuslrangel.sigma.Spells.FlowControl.FlowWhile;

import java.io.File;
import java.io.IOException;
import java.lang.instrument.IllegalClassFormatException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class SpellRegistry {

    private static boolean init = false;

    public static void init() {
        if (init)
            return;
        init = true;

        /**addPackageFromBase("Boolean.Constants");
         addPackageFromBase("Boolean.Operators.Logical");
         addPackageFromBase("Boolean.Operators.Relational");
         addPackageFromBase("Cast");
         */
        register(
                BooleanTrue.class,
                BooleanFalse.class,
                BooleanAnd.class,
                BooleanNot.class,
                BooleanOr.class,
                BooleanTernary.class,
                BooleanEquals.class,
                BooleanGreaterThan.class,
                BooleanGreaterThanOrEquals.class,
                BooleanLessThan.class,
                BooleanLessThanOrEquals.class,
                BooleanNotEquals.class,
                CastToNumber.class,
                CastToBoolean.class,
                FlowWhile.class
        );

    }

    private static void addPackageFromBase(String packagePath) {
        addPackage("viniciuslrangel.sigma.Spells." + packagePath);
    }

    public static void addPackage(String packString) {//TODO wip

        String path = packString.replaceAll("\\.", "/").replaceAll("//", "/");

        URL jar_file = Sigma.class.getProtectionDomain().getCodeSource().getLocation();

        List<Class<? extends SpellPiece>> cls = new ArrayList<>();
        try {
            if (new File(jar_file.getPath()).isFile()) {
                try {
                    ZipInputStream zis = new ZipInputStream(jar_file.openStream());
                    ZipEntry e;
                    while ((e = zis.getNextEntry()) != null) {
                        if (e.getName().startsWith(path)) {
                            if (!e.getName().matches(".*\\$\\d+\\.class") && e.getName().endsWith(".class"))
                                try {
                                    Class cl = Class.forName(packString + "." + e.getName().substring(0, e.getName().lastIndexOf(".class")));
                                    if (cl.isAnnotationPresent(SpellSettings.class))
                                        cls.add(cl);
                                } catch (ClassNotFoundException e2) {
                                    e2.printStackTrace();
                                }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                File dir = null;
                try {
                    dir = new File(String.valueOf(new URL("\\" + path)));
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                File[] files = dir.listFiles();
                for (File clFile : files)
                    if (!clFile.getName().matches(".*\\$\\d+\\.class") && clFile.getName().endsWith(".class"))
                        try {
                            Class cl = Class.forName(packString + "." + clFile.getName().substring(0, clFile.getName().lastIndexOf(".class")));
                            if (cl.isAnnotationPresent(SpellSettings.class))
                                cls.add(cl);
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Class<? extends SpellPiece> cl : cls)
            register(cl);
    }

    private static void register(Class<? extends SpellPiece>... typeArray) {
        for (Class<? extends SpellPiece> type : typeArray)
            try {
                if (!type.isAnnotationPresent(SpellSettings.class))
                    throw new IllegalClassFormatException("Class need SpellSettings annotation");
                SpellSettings spellSettings = type.getAnnotation(SpellSettings.class);
                String key = spellSettings.value();
                String texture = spellSettings.defaultTexture() ? "default" : key;
                String group = spellSettings.group();
                boolean main = spellSettings.group_main();
                PsiAPI.spellPieceRegistry.putObject(key, type);
                PsiAPI.simpleSpellTextures.put(key, new ResourceLocation(Sigma.MODID, String.format("textures/spell/" + texture + ".png")));
                PsiAPI.addPieceToGroup(type, group, main);

            } catch (IllegalClassFormatException e) {
                e.printStackTrace();
            }
    }


}
