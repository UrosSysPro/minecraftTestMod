package org.systempro.testmod.entities;

import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.AmbientEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.systempro.testmod.items.Hammer;
import org.systempro.testmod.items.ItemInitializer;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class FlyingHammerEntity extends AmbientEntity implements IAnimatable {

    public AnimationFactory factory= GeckoLibUtil.createFactory(this);

    public void set(double x,double y,double z, float pitch,float yaw,float roll){
        float f = -MathHelper.sin(yaw * ((float)Math.PI / 180)) * MathHelper.cos(pitch * ((float)Math.PI / 180));
        float g = -MathHelper.sin((pitch + roll) * ((float)Math.PI / 180));
        float h = MathHelper.cos(yaw * ((float)Math.PI / 180)) * MathHelper.cos(pitch * ((float)Math.PI / 180));
        Vec3d speed=new Vec3d(f,g,h);
        Vec3d position=new Vec3d(x,y,z).add(speed).add(speed);
        setVelocity(speed);
        setPosition(position);

        setRotation(yaw,pitch);
    }
    public void set(PlayerEntity player){
        set(player.getX(),player.getY(),player.getZ(),player.getPitch(),player.getHeadYaw(),player.getRoll());
    }

    public FlyingHammerEntity(EntityType<? extends AmbientEntity> entityType, World world) {
        super(EntityInitializer.FLYING_HAMMER_ENTITY, world);
    }


    @Override
    public void onPlayerCollision(PlayerEntity player) {
        player.sendMessage(Text.literal("pick up"));

        super.onPlayerCollision(player);
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canTakeDamage() {
        return false;
    }

    @Override
    protected void onBlockCollision(BlockState state) {

        super.onBlockCollision(state);
    }

    public static DefaultAttributeContainer.Builder setAttributes(){
        return AnimalEntity.createMobAttributes()
            .add(EntityAttributes.GENERIC_MAX_HEALTH,20)
            .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,0)
            .add(EntityAttributes.GENERIC_ATTACK_SPEED,2)
            .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.3);
    }

    @Override
    public void registerControllers(AnimationData animationData) {

    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }


}
