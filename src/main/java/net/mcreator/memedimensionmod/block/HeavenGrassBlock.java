
package net.mcreator.memedimensionmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.memedimensionmod.itemgroup.MemeBlocksItemGroup;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;

import java.util.List;
import java.util.Collections;

@MemeDimensionModModElements.ModElement.Tag
public class HeavenGrassBlock extends MemeDimensionModModElements.ModElement {
	@ObjectHolder("meme_dimension_mod:heaven_grass")
	public static final Block block = null;
	public HeavenGrassBlock(MemeDimensionModModElements instance) {
		super(instance, 29);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(MemeBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.WET_GRASS).hardnessAndResistance(1f, 10f).setLightLevel(s -> 0));
			setRegistryName("heaven_grass");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 1;
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(HeavenDirtBlock.block, (int) (1)));
		}
	}
}
