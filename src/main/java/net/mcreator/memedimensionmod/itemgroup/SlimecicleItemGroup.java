
package net.mcreator.memedimensionmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.memedimensionmod.item.TheSlimecicleStickItem;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;

@MemeDimensionModModElements.ModElement.Tag
public class SlimecicleItemGroup extends MemeDimensionModModElements.ModElement {
	public SlimecicleItemGroup(MemeDimensionModModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabslimecicle") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(TheSlimecicleStickItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
