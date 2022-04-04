package com.IMC.ynov.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.RemoveBlockGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompanionBlockGoal extends RemoveBlockGoal {
   private boolean passed = true;
   private int breakTicks = 0;
   private int requiredBreakTicks = 10* 15;

   public CompanionBlockGoal(Block pblock, CompanionEntity mob, double pSpeedModifier) {
      super(pblock,mob, pSpeedModifier, 16);
   }


   public boolean canUse() {
      super.canUse();
      if(!this.canReach(blockPos)){return false;}
      return true;
   }
         private void reset() {
      this.blockPos = BlockPos.ZERO;
      this.passed = true;
      this.breakTicks = 0;
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void stop() {
      this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, -1);
      reset();
   }

   public int getMiningDuration() {
      return requiredBreakTicks;
   }
@Override
   public void tick() {
      this.breakTicks++;
      if (this.breakTicks >= getMiningDuration()) {
         //finish
         if (mob.level instanceof ServerLevel level) {
            //Get Block drops
            List<ItemStack> drops = Block.getDrops(mob.level.getBlockState(blockPos), level, this.blockPos, null, this.mob, new ItemStack(Items.NETHERITE_PICKAXE));
            AtomicBoolean hasAddedItem = new AtomicBoolean(false);
         }
         this.mob.level.destroyBlock(this.blockPos, true);
      } else {
         float breakProgression = ((Integer) this.breakTicks).floatValue() / ((Integer) getMiningDuration()).floatValue() * 10F;
         this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, Math.min(10, Math.round(breakProgression - 1)));
      }
   }

   /*@Override
   protected void moveMobToBlock() {
      this.mob.getNavigation().moveTo((double)((float)this.blockPos.getX()) + 3D, (double)(this.blockPos.getY()), (double)((float)this.blockPos.getZ()) + 0.5D, this.speedModifier);
   }*/

   @Override
   public boolean requiresUpdateEveryTick() {
      return true;
   }

   /**
    * Return true to set given position as destination
    */
   protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
      if (!pLevel.isEmptyBlock(pPos.above())) {
         return false;
      } else {
         BlockState blockstate = pLevel.getBlockState(pPos);
         return blockstate.is(Blocks.COAL_ORE);
      }
   }
   private boolean isValidBlock(BlockPos pos) {
      if (pos.equals(mob.blockPosition().below())) return false; //Prevent the Miner from mining down
      return Tags.Blocks.ORES_COAL.contains(mob.level.getBlockState(pos).getBlock());
   }

   private boolean canReach(BlockPos pTarget) {
      Path path = this.mob.getNavigation().createPath(pTarget, 0);
      if (path == null) {
         return false;
      } else {
         Node node = path.getEndNode();
         if (node == null) {
            return false;
         } else {
            int i = node.x - pTarget.getX();
            int j = node.z - pTarget.getZ();
            return (double)(i * i + j * j) <= 2.25D;
         }
      }
   }
}