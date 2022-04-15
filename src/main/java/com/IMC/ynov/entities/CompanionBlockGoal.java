package com.IMC.ynov.entities;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
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

public class CompanionBlockGoal extends Goal {
   private int breakTicks = 0;
   private int requiredBreakTicks = 10* 5;

   private CompanionEntity mob;
   public double speedModifier;
   protected BlockPos blockPos = BlockPos.ZERO;
   protected BlockPos blockmove = BlockPos.ZERO;


   public CompanionBlockGoal(CompanionEntity mob, double pSpeedModifier) {
      this.mob = mob;
      this.speedModifier = pSpeedModifier;

   }

   public boolean canUse() {
      return findClosestBlock(6,5);
   }

   @Override
   public boolean canContinueToUse() {
      return super.canContinueToUse();
   }

   public void start() {
      this.moveMobToBlock();
   }

   private void reset() {
      this.blockPos = BlockPos.ZERO;
      this.blockmove = BlockPos.ZERO;

   }

   public void stop() {
      this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, -1);
      reset();
   }


   protected boolean findClosestBlock(int i, int j) {
         BlockPos blockpos = this.mob.blockPosition();
         BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
         for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < i; ++l) {
               for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                  for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                     blockpos$mutableblockpos.setWithOffset(blockpos, i1, k - 1, j1);
                     if (this.mob.isWithinRestriction(blockpos$mutableblockpos) && this.isValidTarget(this.mob.level, blockpos$mutableblockpos)) {
                        if(this.blockPos == BlockPos.ZERO) {
                           this.blockPos = blockpos$mutableblockpos;
                           return true;
                        }
                     }
                  }
               }
            }
         }
         return false;
   }



   /**
    * Reset the task's internal state. Called when this task is interrupted by another one
    */



   public int getMiningDuration() {
      return requiredBreakTicks;
   }


@Override
   public void tick() {
      if(reached(this.blockPos)){
         this.mob.getLookControl().setLookAt(this.blockPos.getX(),this.blockPos.getY(),this.blockPos.getZ());
         this.breakTicks++;

         if (this.breakTicks >= getMiningDuration()) {
            //finish
            if (mob.level instanceof ServerLevel level) {
               List<ItemStack> drops = Block.getDrops(mob.level.getBlockState(blockPos), level, this.blockPos, null, this.mob, new ItemStack(Items.NETHERITE_PICKAXE));
               AtomicBoolean hasAddedItem = new AtomicBoolean(false);
               drops.forEach(itemStack -> {
                  ItemStack remainingItems = itemStack.copy();
                  for (int i = 0; i < mob.getInventory().getSlots() || remainingItems == ItemStack.EMPTY; i++) {
                     if (mob.getInventory().insertItem(i, remainingItems, true) != ItemStack.EMPTY) {
                        ItemStack notAddedItems = mob.getInventory().insertItem(i, remainingItems, false);
                        if (notAddedItems.getCount() != remainingItems.getCount()) {
                           hasAddedItem.set(true);
                           remainingItems = notAddedItems;
                        }
                     } else {
                        mob.getInventory().insertItem(i, remainingItems, false);
                        hasAddedItem.set(true);
                        break;
                     }
                  }
               });
            }
            this.mob.level.destroyBlock(this.blockPos, false);

            this.blockPos = BlockPos.ZERO;
            this.blockmove = BlockPos.ZERO;
            this.breakTicks = 0;
         } else {
            float breakProgression = ((Integer) this.breakTicks).floatValue() / ((Integer) getMiningDuration()).floatValue() * 10F;
            this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, Math.min(10, Math.round(breakProgression - 1)));
         }

      }

   }


   @Override
   public boolean requiresUpdateEveryTick() {
      return true;
   }


   protected void moveMobToBlock() {
      if(!(blockmove == BlockPos.ZERO)){
         this.mob.getNavigation().moveTo((double)((float)this.blockmove.getX()), (double)(this.blockmove.getY()-1), (double)((float)this.blockmove.getZ()), this.speedModifier);
      }
   }

   protected boolean reached(BlockPos pPos){
      double i = pPos.getX() - this.mob.getX();
      double l = pPos.getY() - this.mob.getY();
      double j = pPos.getZ() - this.mob.getZ();
      if((double) i * i  <= 6D && j * j <= 6D && ( l >= -1.5D && l <= 3.5D)){
         return true;
      }
      return false;

   }
   /**
    * Return true to set given position as destination
    */

   protected boolean FindClosestMove(BlockPos pPos) {
      int i = 2;
      int j = 2;
      BlockPos blockpos = pPos;
      BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
      for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
         for(int l = 0; l < i; ++l) {
            for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
               for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                  blockpos$mutableblockpos.setWithOffset(blockpos, i1, k-1 , j1);
                  BlockState blockstate = this.mob.level.getBlockState(blockpos$mutableblockpos);
                  BlockState blockstateA = this.mob.level.getBlockState(blockpos$mutableblockpos.above());
                  BlockState blockstateB = this.mob.level.getBlockState(blockpos$mutableblockpos.below());
                  if (blockstate.isAir() && blockstateA.isAir() && !blockstateB.isAir()) {
                     double x = pPos.getX() - blockpos$mutableblockpos.getX();
                     double y = pPos.getY() - blockpos$mutableblockpos.getY();
                     double z = pPos.getZ() - blockpos$mutableblockpos.getZ();
                     if((double) x * x  <= 3D && z * z <= 3D && ( y >= -1.5D && y <= 3.5D)){
                        this.blockmove = blockpos$mutableblockpos;
                        return true;
                     }
                  }
               }
            }
         }
      }
      return false;
   }
   protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
      BlockState blockstate = pLevel.getBlockState(pPos);
      if( blockstate.is(Tags.Blocks.ORES)) {
         BlockState blockstateA = pLevel.getBlockState(pPos.above());
         BlockState blockstateB = pLevel.getBlockState(pPos.below());
         BlockState blockstateE = pLevel.getBlockState(pPos.east());
         BlockState blockstateW = pLevel.getBlockState(pPos.west());
         BlockState blockstateN = pLevel.getBlockState(pPos.north());
         BlockState blockstateS = pLevel.getBlockState(pPos.south());

         if (blockstateA.isAir() || blockstateB.isAir() || blockstateE.isAir() || blockstateW.isAir() || blockstateN.isAir() || blockstateS.isAir() ){
            if(FindClosestMove(pPos)){
               return true;
            }
         }
      }
      return false;
   }


}