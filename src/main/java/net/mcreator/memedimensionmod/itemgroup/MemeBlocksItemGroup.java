
package net.mcreator.memedimensionmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.block.Blocks;

import net.mcreator.memedimensionmod.MemeDimensionModModElements;

@MemeDimensionModModElements.ModElement.Tag
public class MemeBlocksItemGroup extends MemeDimensionModModElements.ModElement {
	public MemeBlocksItemGroup(MemeDimensionModModElements instance) {
		super(instance, 26);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmeme_blocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Blocks.MAGMA_BLOCK, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
