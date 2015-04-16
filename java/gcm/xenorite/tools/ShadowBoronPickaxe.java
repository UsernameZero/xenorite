package gcm.xenorite.tools;

import gcm.xenorite.crativetab.CreativeTabTools;
import gcm.xenorite.handler.ConfigurationHandler;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ShadowBoronPickaxe extends ItemPickaxe
{
	public ShadowBoronPickaxe(ToolMaterial material)
	{
		super(material);
		this.setCreativeTab(CreativeTabTools.Xenoritetools);
		this.setMaxStackSize(1);
		this.setTextureName("xenorite:pickaxeShadowBoron");
		this.setUnlocalizedName("ShadowBoron Pickaxe");

	}

	@Override
	public ItemStack onItemRightClick(ItemStack ItemStack, World World, EntityPlayer EntityPlayer)
	{

		if (EntityPlayer.isSneaking())
		{
			return ItemStack;
		}

		if (ItemStack.stackTagCompound == null)
		{
			ItemStack.setTagCompound(new NBTTagCompound());
		}

		NBTTagCompound tag = ItemStack.stackTagCompound;
		tag.setBoolean("isActive", !(tag.getBoolean("isActive")));

		if (tag.getBoolean("isActive"))
		{
			ItemStack.setItemDamage(1);
			EntityPlayer.addPotionEffect((new PotionEffect(ConfigurationHandler.pickaxeShadowBoronEffect1, 0, 0)));
		}

		return ItemStack;
	}

	@Override
	public void onUpdate(ItemStack ItemStack, World World, Entity Entity, int par1, boolean par2)
	{
		if (!(Entity instanceof EntityPlayer))
		{
			return;
		}

		EntityPlayer par3EntityPlayer = (EntityPlayer) Entity;

		if (ItemStack.stackTagCompound == null)
		{
			ItemStack.setTagCompound(new NBTTagCompound());
		}

		if (!World.isDaytime() && ItemStack.stackTagCompound.getBoolean("isActive"))
		{
			par3EntityPlayer.addPotionEffect((new PotionEffect(ConfigurationHandler.pickaxeShadowBoronEffect1, 0, 0)));
		}

		return;
	}

	@Override
	public void addInformation(ItemStack ItemStack, EntityPlayer EntityPlayer, List List, boolean par4)
	{

		if (!(ItemStack.getTagCompound() == null))
		{
			if (ItemStack.getTagCompound().getBoolean("isActive"))
			{
				List.add(String.format("�b�o�lShadow Pickaxe Activated"));
			}
			else
			{
				List.add(String.format("�b�o�lShadow Pickaxe Not Activated"));
			}
		}
	}
}