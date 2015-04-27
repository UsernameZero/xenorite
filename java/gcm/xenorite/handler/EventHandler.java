package gcm.xenorite.handler;

import gcm.xenorite.blocks.BlockHeavenlyGlintOre;
import gcm.xenorite.tools.XenoritePickaxe;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.world.BlockEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;

public class EventHandler
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		if (UpdateHandler.show)
			event.player.addChatMessage(new ChatComponentText(UpdateHandler.updateStatus));
	}

	@SubscribeEvent
	public void onBlockBroken(BlockEvent.BreakEvent event)
	{
		if (event.block instanceof BlockHeavenlyGlintOre && !(event.getPlayer().inventory.getCurrentItem().getItem() instanceof XenoritePickaxe))
		{
			event.setCanceled(true);
		}
	}
}