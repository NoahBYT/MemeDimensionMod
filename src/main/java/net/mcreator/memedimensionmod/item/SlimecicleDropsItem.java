
package net.mcreator.memedimensionmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.memedimensionmod.itemgroup.SlimecicleItemGroup;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;

@MemeDimensionModModElements.ModElement.Tag
public class SlimecicleDropsItem extends MemeDimensionModModElements.ModElement {
	@ObjectHolder("meme_dimension_mod:slimecicle_drops")
	public static final Item block = null;
	public SlimecicleDropsItem(MemeDimensionModModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SlimecicleItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("slimecicle_drops");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
