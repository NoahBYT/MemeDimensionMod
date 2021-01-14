
package net.mcreator.memedimensionmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.block.BlockState;

import net.mcreator.memedimensionmod.procedures.TheSlickBlockDestroyedWithToolProcedure;
import net.mcreator.memedimensionmod.itemgroup.SlimecicleItemGroup;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;

import java.util.Map;
import java.util.HashMap;

@MemeDimensionModModElements.ModElement.Tag
public class TheSlickItem extends MemeDimensionModModElements.ModElement {
	@ObjectHolder("meme_dimension_mod:the_slick")
	public static final Item block = null;
	public TheSlickItem(MemeDimensionModModElements instance) {
		super(instance, 14);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 0.5f;
			}

			public float getAttackDamage() {
				return 2f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SlimecicleBallItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(SlimecicleItemGroup.tab)) {
			@Override
			public boolean onBlockDestroyed(ItemStack itemstack, World world, BlockState bl, BlockPos pos, LivingEntity entity) {
				boolean retval = super.onBlockDestroyed(itemstack, world, bl, pos, entity);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					TheSlickBlockDestroyedWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("the_slick"));
	}
}
