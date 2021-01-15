package net.mcreator.memedimensionmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;

import net.mcreator.memedimensionmod.block.HeavenGrassBlock;
import net.mcreator.memedimensionmod.block.HeavenDirtBlock;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;
import net.mcreator.memedimensionmod.MemeDimensionModMod;

import java.util.Map;

@MemeDimensionModModElements.ModElement.Tag
public class HeavenGrassBlockAddedProcedure extends MemeDimensionModModElements.ModElement {
	public HeavenGrassBlockAddedProcedure(MemeDimensionModModElements instance) {
		super(instance, 32);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency x for procedure HeavenGrassBlockAdded!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency y for procedure HeavenGrassBlockAdded!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency z for procedure HeavenGrassBlockAdded!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency world for procedure HeavenGrassBlockAdded!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.isAirBlock(new BlockPos((int) x, (int) (y + 1), (int) z)))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HeavenGrassBlock.block.getDefaultState(), 3);
		} else {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), HeavenDirtBlock.block.getDefaultState(), 3);
		}
	}
}
