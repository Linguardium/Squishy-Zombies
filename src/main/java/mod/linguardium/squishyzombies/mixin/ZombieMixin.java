package mod.linguardium.squishyzombies.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.mob.ZombieEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(ZombieEntity.class)
public class ZombieMixin {
    @WrapWithCondition(method="applyAttributeModifiers", at= @At(value = "INVOKE", target = "Lnet/minecraft/entity/attribute/EntityAttributeInstance;addPersistentModifier(Lnet/minecraft/entity/attribute/EntityAttributeModifier;)V", ordinal = 0), slice = @Slice(from = @At(value = "FIELD", target = "Lnet/minecraft/entity/attribute/EntityAttributes;GENERIC_MAX_HEALTH:Lnet/minecraft/entity/attribute/EntityAttribute;")))
    private boolean failToRollHighEnoughToMakeStrong(EntityAttributeInstance instance, EntityAttributeModifier modifier) {
        return false;
    }
}
