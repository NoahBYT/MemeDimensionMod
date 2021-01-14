
package net.mcreator.memedimensionmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;

import net.mcreator.memedimensionmod.procedures.TheSlimecicleStickLivingEntityIsHitWithToolProcedure;
import net.mcreator.memedimensionmod.itemgroup.SlimecicleItemGroup;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;

import java.util.Map;
import java.util.HashMap;

@MemeDimensionModModElements.ModElement.Tag
public class TheSlimecicleStickItem extends MemeDimensionModModElements.ModElement {
	@ObjectHolder("meme_dimension_mod:the_slimecicle_stick")
	public static final Item block = null;
	public TheSlimecicleStickItem(MemeDimensionModModElements instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
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
				return Ingredient.EMPTY;
			}
		}, 3, -2.5f, new Item.Properties().group(SlimecicleItemGroup.tab)) {
			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("world", world);
					TheSlimecicleStickLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("the_slimecicle_stick"));
	}
}
