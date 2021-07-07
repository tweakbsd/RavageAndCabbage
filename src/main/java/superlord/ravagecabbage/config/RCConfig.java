package superlord.ravagecabbage.config;

import net.minecraftforge.fml.config.ModConfig;
import superlord.ravagecabbage.RavageAndCabbage;

public class RCConfig {

    public static double adultRavagerHealth = 160.0D;
    public static double babyRavagerHealth = 80.0D;

    public static int adultRavagerBaseAttack = 8;
    public static int babyRavagerBaseAttack = 6;

    public static void bake(ModConfig config) {
        try {
            adultRavagerHealth = ConfigHolder.COMMON.adultRavagerHealth.get();
            babyRavagerHealth = ConfigHolder.COMMON.babyRavagerHealth.get();

            adultRavagerBaseAttack = ConfigHolder.COMMON.adultRavagerBaseAttack.get();
            babyRavagerBaseAttack = ConfigHolder.COMMON.babyRavagerBaseAttack.get();

        } catch (Exception e) {
            RavageAndCabbage.LOGGER.warn("An exception was caused trying to load the config for Ravage & Cabbage.");
            e.printStackTrace();
        }

}
