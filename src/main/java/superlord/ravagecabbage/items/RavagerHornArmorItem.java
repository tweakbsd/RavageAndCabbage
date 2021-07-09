package superlord.ravagecabbage.items;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ArmorMaterial;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import superlord.ravagecabbage.RavageAndCabbage;

import java.util.UUID;

public class RavagerHornArmorItem extends Item implements IRavagerHornArmorItem {

    private final UUID HORN_ARMOR_MODFIER = UUID.fromString("845DB27C-4711-495F-8C9F-6020A9A58B62");
    private final UUID HORN_ARMOR_TOUGHNESS_MODFIER = UUID.fromString("845DB27C-4711-495F-8C9F-6020A9A58B62");

    private final int armorValue;
    private final int attackDamageBonus;
    private final ResourceLocation tex;
    private final ArmorMaterial armorMaterial;

    public RavagerHornArmorItem(int armorValue, int attackDamageBonus, String tierArmor, Item.Properties builder, ArmorMaterial armorMaterial) {
        this(armorValue, attackDamageBonus, new ResourceLocation(RavageAndCabbage.MOD_ID, "textures/entity/ravager_equipment/" + tierArmor + "_horns.png"), builder, armorMaterial);
    }

    public RavagerHornArmorItem(int armorValue, int attackDamageBonus, ResourceLocation texture, Item.Properties builder, ArmorMaterial armorMaterial) {
        super(builder);
        this.armorMaterial = armorMaterial;
        this.attackDamageBonus = attackDamageBonus;
        this.armorValue = armorValue;

        this.tex = texture;
    }

    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        return equipmentSlot == EquipmentSlotType.HEAD ? this.bakeHornArmorModifiers() : super.getAttributeModifiers(equipmentSlot);
    }

    private Multimap<Attribute, AttributeModifier> hornArmorModifiers;
    private Multimap<Attribute, AttributeModifier> bakeHornArmorModifiers() {

        if(this.hornArmorModifiers == null) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeModifierMap = ImmutableMultimap.builder();

            attributeModifierMap.put(Attributes.ARMOR, new AttributeModifier(HORN_ARMOR_MODFIER, "Horn Armor modifier", this.getArmorValue(), AttributeModifier.Operation.ADDITION));
            attributeModifierMap.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(HORN_ARMOR_TOUGHNESS_MODFIER, "Horn Armor Toughness modifier", this.getArmorMaterial().getToughness(), AttributeModifier.Operation.ADDITION));
            attributeModifierMap.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Horn Attack modifier", (double)this.getAttackDamageBonus(), AttributeModifier.Operation.ADDITION));
            this.hornArmorModifiers = attributeModifierMap.build();
        }

        return this.hornArmorModifiers;
    }

    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getArmorTexture() {
        return tex;
    }

    public ArmorMaterial getArmorMaterial() {
        return this.armorMaterial;
    }

    public int getArmorValue() {
        return this.armorValue;
    }

    public int getAttackDamageBonus() { return this.attackDamageBonus; }
}
