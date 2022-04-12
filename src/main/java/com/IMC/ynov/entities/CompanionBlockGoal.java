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
   private boolean passed = true;
   private int breakTicks = 0;
   private int requiredBreakTicks = 10* 15;

   private PathfinderMob mob;
   public double speedModifier;
   protected BlockPos blockPos = BlockPos.ZERO;


   public CompanionBlockGoal(CompanionEntity mob, double pSpeedModifier) {
      this.mob = mob;
      this.speedModifier = pSpeedModifier;

   }

   protected int nextStartTick(PathfinderMob pCreature) {
      return reducedTickDelay(200 + pCreature.getRandom().nextInt(200));
   }

   public boolean canUse() {
      return findClosestBlock(10,5);
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
      this.passed = true;
      this.breakTicks = 0;
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
                        this.blockPos = blockpos$mutableblockpos;
                        return true;
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
   public void stop() {
      this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, -1);
      reset();
   }


   public int getMiningDuration() {
      return requiredBreakTicks;
   }


@Override
   public void tick() {

      if(reached(this.blockPos)){
         this.mob.level.destroyBlock(this.blockPos, true);
      }
//         if (this.breakTicks >= getMiningDuration()) {
//            //finish
//            if (mob.level instanceof ServerLevel level) {
//               //Get Block drops
//               List<ItemStack> drops = Block.getDrops(mob.level.getBlockState(blockPos), level, this.blockPos, null, this.mob, new ItemStack(Items.NETHERITE_PICKAXE));
//               AtomicBoolean hasAddedItem = new AtomicBoolean(false);
//            }
//            this.mob.level.destroyBlock(this.blockPos, true);
//         } else {
//            float breakProgression = ((Integer) this.breakTicks).floatValue() / ((Integer) getMiningDuration()).floatValue() * 10F;
//            this.mob.level.destroyBlockProgress(this.mob.getId(), this.blockPos, Math.min(10, Math.round(breakProgression - 1)));
//         }
   }


   @Override
   public boolean requiresUpdateEveryTick() {
      return true;
   }


   protected void moveMobToBlock() {
      if(!(blockPos == BlockPos.ZERO)){
         this.mob.getNavigation().moveTo((double)((float)this.blockPos.getX()), (double)(this.blockPos.getY()), (double)((float)this.blockPos.getZ()), this.speedModifier);
      }
   }

   protected boolean reached(BlockPos pPos){
//      Path path = this.mob.getNavigation().createPath(pPos, 1);
//      if (path == null) {
//         return false;
//      } else {
//         if (path.getNodeCount() < 3) {
//            return true;
//         }
//      }
//      return false;

      double i = pPos.getX() - this.mob.getX();
      double l = pPos.getY() - this.mob.getY();
      double j = pPos.getZ() - this.mob.getZ();
      if((double)(i * i  + j * j)<= 2.25D && ( l >= -1.5D && l <= 4)){
         return true;
      }
      return false;

   }
   /**
    * Return true to set given position as destination
    */
   protected boolean isValidTarget(LevelReader pLevel, BlockPos pPos) {
      BlockState blockstate = pLevel.getBlockState(pPos);
      if( blockstate.is(Tags.Blocks.ORES)) {
         BlockState blockstateA = pLevel.getBlockState(pPos.above());
         BlockState blockstateB = pLevel.getBlockState(pPos.below());
         BlockState blockstateE = pLevel.getBlockState(pPos.east());
         BlockState blockstateW = pLevel.getBlockState(pPos.west());
         BlockState blockstateN = pLevel.getBlockState(pPos.west());
         BlockState blockstateS = pLevel.getBlockState(pPos.west());

         if (blockstateA.isAir() || blockstateB.isAir() || blockstateE.isAir() || blockstateW.isAir() || blockstateN.isAir() || blockstateS.isAir() ){
//            Path path = this.mob.getNavigation().createPath(pPos, 3);
//            if (path == null) {
//               return false;
//            } else {
//               Node node = path.getEndNode();
//               if (node == null) {
//                  return false;
//               } else {
//
//                  return false;
//               }
//            }

            double i = pPos.getX() - this.mob.getX();
            double l = pPos.getY() - this.mob.getY();
            double j = pPos.getZ() - this.mob.getZ();
            System.out.println("x: "+i+" y: "+l+" z: "+j+" x + z : "+i * i  + j * j);
            if((double)(i * i  + j * j)<= 10D && ( l >= -1.5D && l <= 4)){
               return true;
            }
         }
      }
      return false;
   }


}