package superlord.ravagecabbage.config;


import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class CommonConfig {

    public final ForgeConfigSpec.DoubleValue adultRavagerHealth;
    public final ForgeConfigSpec.DoubleValue babyRavagerHealth;

    public final ForgeConfigSpec.IntValue adultRavagerBaseAttack;
    public final ForgeConfigSpec.IntValue babyRavagerBaseAttack;


    public CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        adultRavagerHealth = buildDouble(builder, "adultRavagerHealth", "general", RCConfig.adultRavagerHealth, 0, Double.MAX_VALUE, "Default HP of an adult Ravager");
        babyRavagerHealth = buildDouble(builder, "babyRavagerHealth", "general", RCConfig.babyRavagerHealth, 0, Double.MAX_VALUE, "Default HP of a baby Ravager");

        adultRavagerBaseAttack = buildInt(builder, "adultRavagerBaseAttack", "general", RCConfig.adultRavagerBaseAttack, 0, Integer.MAX_VALUE, "Base Attack Damage of am adult Ravager");
        babyRavagerBaseAttack = buildInt(builder, "babyRavagerBaseAttack", "general", RCConfig.babyRavagerBaseAttack, 0, Integer.MAX_VALUE, "Base Attack Damage of a baby Ravager");
    }

    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(name).define(name, defaultValue);
    }

    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment) {
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }

    private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String name, String catagory, double defaultValue, double min, double max, String comment) {
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }
}
