package com.kittykitcatcat.malum.particles.spiritflame;

import com.kittykitcatcat.malum.MalumMod;
import com.kittykitcatcat.malum.particles.MalumParticle;
import com.kittykitcatcat.malum.particles.ParticlePhase;
import com.kittykitcatcat.malum.particles.ScalePhase;
import com.kittykitcatcat.malum.particles.skull.SkullParticle;
import com.kittykitcatcat.malum.particles.skull.SkullParticleData;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static com.kittykitcatcat.malum.MalumMod.*;

public class SpiritFlameParticle extends MalumParticle
{
    
    protected SpiritFlameParticle(ClientWorld world, double xSpeed, double ySpeed, double zSpeed, double x, double y, double z, float scale, IAnimatedSprite spriteSet)
    {
        super(world, xSpeed, ySpeed, zSpeed,x,y,z, spriteSet,
                new ParticlePhase(1,20, 0,1),
                new ParticlePhase(MathHelper.nextInt(MalumMod.random, 2,3),20, 20),
                new ScalePhase(MathHelper.nextInt(MalumMod.random, 2,3),20, 20, scale,false));
        //0-19 entrance
        //20-39 animation
    }
    
    
    @Override
    public void tick()
    {
        super.tick();
        motionX *= 0.9f;
        motionY *= 0.9f;
        motionZ *= 0.9f;
    }

    @Override
    public IParticleRenderType getRenderType()
    {
        return IParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public float getScale(float p_217561_1_)
    {
        return scale;
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<SpiritFlameParticleData>
    {
        private final IAnimatedSprite spriteSet;

        public Factory(IAnimatedSprite spriteSet)
        {
            this.spriteSet = spriteSet;
        }
        @Override
        public Particle makeParticle(SpiritFlameParticleData data, ClientWorld world, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed)
        {
            return new SpiritFlameParticle(world, xSpeed, ySpeed, zSpeed, x,y,z, data.scale, spriteSet);
        }
    }
}