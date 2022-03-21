package com.frozerain.externalview.event.impl;

import com.frozerain.externalview.ExternalView;
import com.frozerain.externalview.event.init.ExternalViewKeys;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = ExternalView.MODID, value = Side.CLIENT)
public class ExternalViewRender {

    private static float additionThirdPersonCameraDistance = 0.0F;

    @SubscribeEvent
    public static void onCameraSetup(EntityViewRenderEvent.CameraSetup event) {

        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayerSP player = mc.player;
        GameSettings gameSettings = mc.gameSettings;

        if (player != null && gameSettings.thirdPersonView == 1) {

            if (ExternalViewKeys.ZOOM_OUT.isKeyDown()) {
                additionThirdPersonCameraDistance += 1.0F;
                if (additionThirdPersonCameraDistance > 56) {
                    additionThirdPersonCameraDistance = 56.0F;
                }
            }

            if (ExternalViewKeys.ZOOM_IN.isKeyDown()) {
                additionThirdPersonCameraDistance -= 1.0F;
                if (additionThirdPersonCameraDistance < 0) {
                    additionThirdPersonCameraDistance = 0.0F;
                }
            }

            GlStateManager.translate(0.0F, 0.0F, -additionThirdPersonCameraDistance);
        } else
            additionThirdPersonCameraDistance = 0.0F;
    }
}
