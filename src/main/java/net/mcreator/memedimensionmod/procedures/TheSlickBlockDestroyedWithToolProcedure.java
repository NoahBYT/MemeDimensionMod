package net.mcreator.memedimensionmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;

import net.mcreator.memedimensionmod.MemeDimensionModModElements;
import net.mcreator.memedimensionmod.MemeDimensionModMod;

import java.util.Map;

@MemeDimensionModModElements.ModElement.Tag
public class TheSlickBlockDestroyedWithToolProcedure extends MemeDimensionModModElements.ModElement {
	public TheSlickBlockDestroyedWithToolProcedure(MemeDimensionModModElements instance) {
		super(instance, 14);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency entity for procedure TheSlickBlockDestroyedWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency world for procedure TheSlickBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.isRemote()) {
			((World) world).playSound(null, new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ())),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.place")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1);
		} else {
			((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
					(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.slime_block.place")),
					SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
		}
	}
}
