package com.IMC.ynov.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class CompanionBlockGoal extends MoveToBlockGoal {
   private boolean passed = true;
   private int breakTicks = 0;
   private int requiredBreakTicks = 10* 15;

   public CompanionBlockGoal(CompanionEntity mob, double pSpeedModifier) {
      super(mob, pSpeedModifier, 16);
   }

   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */
   public void stop() {
      super.stop();
   }

   public int getMiningDuration() {
      return requiredBreakTicks;
   }

   public void tick() {
      super.tick();

      this.breakTicks++;
      if (this.breakTicks >= getMiningDuration()) {
         //finish
         if (mob.level instanceof ServerLevel level) {
            //Get Block drops
            List<ItemStack> drops = Block.getDrops(mob.level.getBlockState(blockPos), level, this.blockPos, null, this.mob, new ItemStack(Items.NETHERITE_PICKAXE));
            AtomicBoolean hasAddedItem = new AtomicBoolean(false);
            //Try to add each drop to the inventory
            //mob.setBreaking(false);

         }
      } else {
         if (mob.level instanceof ServerLevel) {
            //mob.setBreaking(true);
         }
         float breakProgression = ((Integer) this.breakTicks).floatValue() / ((Integer) getMiningDuration()).floatValue() * 10F;
         this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, Math.min(10, Math.round(breakProgression - 1)));
      }
   }

   @Override
   protected void moveMobToBlock() {
      this.mob.getNavigation().moveTo((double)((float)this.blockPos.getX()) + 0.5D, (double)(this.blockPos.getY()), (double)((float)this.blockPos.getZ()) + 0.5D, this.speedModifier);
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
}