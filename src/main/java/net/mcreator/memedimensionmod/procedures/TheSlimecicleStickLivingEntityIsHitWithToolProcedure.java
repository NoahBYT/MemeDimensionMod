package net.mcreator.memedimensionmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import net.mcreator.memedimensionmod.block.SlimecicleBlockBlock;
import net.mcreator.memedimensionmod.MemeDimensionModModElements;
import net.mcreator.memedimensionmod.MemeDimensionModMod;

import java.util.Map;

@MemeDimensionModModElements.ModElement.Tag
public class TheSlimecicleStickLivingEntityIsHitWithToolProcedure extends MemeDimensionModModElements.ModElement {
	public TheSlimecicleStickLivingEntityIsHitWithToolProcedure(MemeDimensionModModElements instance) {
		super(instance, 11);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency entity for procedure TheSlimecicleStickLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MemeDimensionModMod.LOGGER.warn("Failed to load dependency world for procedure TheSlimecicleStickLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(
					Vector3d.copyCenteredHorizontally(new BlockPos((int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
		world.setBlockState(new BlockPos((int) (entity.getPosX()), (int) ((entity.getPosY()) - 1), (int) (entity.getPosZ())),
				SlimecicleBlockBlock.block.getDefaultState(), 3);
	}
}
