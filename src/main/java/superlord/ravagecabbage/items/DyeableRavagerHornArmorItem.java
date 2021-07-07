package superlord.ravagecabbage.items;

import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class DyeableRavagerHornArmorItem extends RavagerHornArmorItem implements IDyeableArmorItem {

    public DyeableRavagerHornArmorItem(int armorValue, int attackDamageBonus, String p_i50047_2_, Item.Properties builder) {
        super(armorValue, attackDamageBonus, p_i50047_2_, builder, ArmorMaterial.LEATHER);
    }
    public DyeableRavagerHornArmorItem(int armorValue, int attackDamageBonus, net.minecraft.util.ResourceLocation texture, Item.Properties builder) {
        super(armorValue, attackDamageBonus, texture, builder, ArmorMaterial.LEATHER);
    }

}
