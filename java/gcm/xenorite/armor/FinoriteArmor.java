package gcm.xenorite.armor;

import gcm.xenorite.XenoriteMain;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class FinoriteArmor extends ItemArmor {

	private String[] armourTypes = new String[] { "helmetfinorite",
			"chestplatefinorite", "leggingsfinorite", "bootsfinorite" };

	public FinoriteArmor(ArmorMaterial armorMaterial, int renderIndex,
			int armorType) {
		super(armorMaterial, renderIndex, armorType);
		this.setCreativeTab(gcm.xenorite.XenoriteMain.XenoriteTab);
		this.setMaxStackSize(1);
	}

	@Override
	public void registerIcons(IIconRegister reg) {
		if (this == XenoriteMain.finoriteHelmet)
			this.itemIcon = reg.registerIcon("xenorite:helmetFinorite");
		if (this == XenoriteMain.finoriteChestplate)
			this.itemIcon = reg.registerIcon("xenorite:chestplateFinorite");
		if (this == XenoriteMain.finoriteLeggings)
			this.itemIcon = reg.registerIcon("xenorite:leggingsFinorite");
		if (this == XenoriteMain.finoriteBoots)
			this.itemIcon = reg.registerIcon("xenorite:bootsFinorite");
	}

	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
			String type) {
		if (stack.getItem() == XenoriteMain.finoriteHelmet
				|| stack.getItem() == XenoriteMain.finoriteChestplate
				|| stack.getItem() == XenoriteMain.finoriteBoots) {
			return XenoriteMain.MODID
					+ ":textures/models/armor/finorite_layer_1.png";
		}
		if (stack.getItem() == XenoriteMain.finoriteLeggings) {
			return XenoriteMain.MODID
					+ ":textures/models/armor/finorite_layer_2.png";
		} else {
			return null;
		}
	}
}