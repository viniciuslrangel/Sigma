/*
 * This class was created by <viniciuslrangel>.
 * File Created @ [16/02/2016, 18:58 (UTC-3)]
 */
package viniciuslrangel.sigma.Spells.Base;

import vazkii.psi.common.lib.LibPieceGroups;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SpellSettings {

    String value();
    boolean defaultTexture() default true;
    String group() default LibPieceGroups.TUTORIAL_1;
    boolean group_main() default false;

}
