package superlord.ravagecabbage.init;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import superlord.ravagecabbage.RavageAndCabbage;
import superlord.ravagecabbage.items.*;

public class RCItems {
	
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, RavageAndCabbage.MOD_ID);

    public static final RegistryObject<Item> CABBAGE = REGISTER.register("cabbage", () -> new Item(new Item.Properties().group(RavageAndCabbage.GROUP).food(new Food.Builder().hunger(3).saturation(0.3F).build())));
    public static final RegistryObject<Item> CABBAGE_SEEDS = REGISTER.register("cabbage_seeds", () -> new BlockNamedItem(RCBlocks.CABBAGE_CROP.get(), new Item.Properties().group(RavageAndCabbage.GROUP)));
    public static final RegistryObject<Item> RAVAGER_MILK = REGISTER.register("ravager_milk", () -> new RavagerMilkItem(new Item.Properties().group(RavageAndCabbage.GROUP).maxStackSize(1)));
    public static final RegistryObject<Item> CABBAGE_THROWABLE = REGISTER.register("throwable_cabbage", () -> new ThrowableCabbageItem(new Item.Properties().maxStackSize(1)));
    public static final RegistryObject<Item> LEATHER_HORN_ARMOR = REGISTER.register("leather_horn_armor", () -> new DyeableRavagerHornArmorItem(2, 1, "leather", new Item.Properties().group(RavageAndCabbage.GROUP).maxDamage(45)));
    public static final RegistryObject<Item> GOLDEN_HORN_ARMOR = REGISTER.register("golden_horn_armor", () -> new RavagerHornArmorItem(3, 1, "golden", new Item.Properties().group(RavageAndCabbage.GROUP).maxDamage(50), ArmorMaterial.GOLD));
    public static final RegistryObject<Item> IRON_HORN_ARMOR = REGISTER.register("iron_horn_armor", () -> new RavagerHornArmorItem(4, 2, "iron", new Item.Properties().group(RavageAndCabbage.GROUP).maxDamage(75), ArmorMaterial.IRON));
    public static final RegistryObject<Item> DIAMOND_HORN_ARMOR = REGISTER.register("diamond_horn_armor", () -> new RavagerHornArmorItem(6, 3, "diamond", new Item.Properties().group(RavageAndCabbage.GROUP).maxDamage(100), ArmorMaterial.DIAMOND));
    public static final RegistryObject<Item> NETHERITE_HORN_ARMOR = REGISTER.register("netherite_horn_armor", () -> new RavagerHornArmorItem(8, 4, "netherite", new Item.Properties().group(RavageAndCabbage.GROUP).maxDamage(150).isImmuneToFire(), ArmorMaterial.NETHERITE));

    // Spawn Eggs
    public static final RegistryObject<Item> CABBAGER_SPAWN_EGG = REGISTER.register("cabbager_spawn_egg", () -> new RavageAndCabbageSpawnEggItem(RCEntities.CABBAGER, 0x959B9B, 0x708438, new Item.Properties().group(RavageAndCabbage.GROUP)));
    public static final RegistryObject<Item> RAVAGER_SPAWN_EGG = REGISTER.register("ravager_spawn_egg", () -> new RavageAndCabbageSpawnEggItem(RCEntities.RAVAGER, 0x454040, 0x6a6965, new Item.Properties().group(RavageAndCabbage.GROUP)));

}
