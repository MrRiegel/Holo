package mrriegel.detectors.gui.block;

import mrriegel.detectors.gui.AbstractContainer;
import mrriegel.detectors.tile.TileBase;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ContainerBlockDetector extends AbstractContainer {

	public ContainerBlockDetector(final TileBase tile, InventoryPlayer playerInv) {
		super(tile, playerInv);
		IInventory inv = new InventoryBasic(null, false, 1);
		inv.setInventorySlotContents(0, tile.getStack());
		Slot x = new Slot(inv, 0, 70, 45) {

			@Override
			public void onSlotChanged() {
				super.onSlotChanged();
				tile.setStack(getStack());
				tile.syncWithClient();
			}

			@Override
			public int getSlotStackLimit() {
				return 1;
			}

			@Override
			public boolean isItemValid(ItemStack stack) {
				return stack != null && stack.getItem() instanceof ItemBlock;
			}
		};
		this.addSlotToContainer(x);
	}

}
