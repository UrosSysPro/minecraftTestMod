package org.systempro.testmod.entities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.core.manager.InstancedAnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class FlyingMobEntity extends AnimalEntity implements IAnimatable {
    public AnimationFactory factory= GeckoLibUtil.createFactory(this);

    public FlyingMobEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return AnimalEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH,20)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,0)
            .add(EntityAttributes.GENERIC_ATTACK_SPEED,2)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.3);
    }
    @Override
    protected void initGoals() {
        this.goalSelector.add(0,new SwimGoal(this));
        this.goalSelector.add(1,new WanderAroundPointOfInterestGoal(this,0.75,false));
        this.goalSelector.add(2,new WanderAroundFarGoal(this,0.75,1));
        this.goalSelector.add(3,new LookAroundGoal(this));
        this.goalSelector.add(4,new LookAtEntityGoal(this, PlayerEntity.class,8f));
    }

    public <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event){
        if(event.isMoving()){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.walk"));
            return PlayState.CONTINUE;
        }
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.still"));
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(
            new AnimationController(
                this,
                "controller",
                0,
                this::predicate)
        );
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
