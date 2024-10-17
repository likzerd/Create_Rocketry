package net.likzerd.create_rocketry.mixinduck.minecraft;

import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public interface EntityDuck {
    void unsetRemoved();

    void setLevel(Level world);
}
