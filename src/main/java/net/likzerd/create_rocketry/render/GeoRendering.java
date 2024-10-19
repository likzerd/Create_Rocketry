package net.likzerd.create_rocketry.render;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.simibubi.create.foundation.utility.Color;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class GeoRendering {
    public static void renderTest(PoseStack poseStack, Camera camera) {
        poseStack.pushPose();
        Vec3 cameraPos = camera.getPosition().reverse();

        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder vBuffer = tesselator.getBuilder();

        RenderSystem.enableDepthTest();
        RenderSystem.depthFunc(GL11.GL_LEQUAL);
        RenderSystem.depthMask(true);
        RenderSystem.setShader(GameRenderer::getPositionColorShader);
        RenderSystem.enableBlend();

        vBuffer.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_COLOR);
        renderCube(vBuffer, poseStack, cameraPos.add(100, 100, 200), 30, 100, Color.GREEN);

        tesselator.end();

        poseStack.popPose();
    }
    public static void renderCube(VertexConsumer vertexBuilder, PoseStack matrixStack, Vec3 offset, int packedLight, float size, Color color) {
        float halfSize = size / 2.0F;

        //define vertices
        Vec3 v0 = new Vec3(-halfSize, -halfSize, -halfSize).add(offset);
        Vec3 v1 = new Vec3(halfSize, -halfSize, -halfSize).add(offset);
        Vec3 v3 = new Vec3(-halfSize, halfSize, -halfSize).add(offset);
        Vec3 v2 = new Vec3(halfSize, halfSize, -halfSize).add(offset);
        Vec3 v4 = new Vec3(-halfSize, -halfSize, halfSize).add(offset);
        Vec3 v5 = new Vec3(halfSize, -halfSize, halfSize).add(offset);
        Vec3 v7 = new Vec3(-halfSize, halfSize, halfSize).add(offset);
        Vec3 v6 = new Vec3(halfSize, halfSize, halfSize).add(offset);

        // six faces
        List<Vec3> face1 = List.of(v0, v3, v2, v1);
        List<Vec3> face2 = List.of(v5, v6, v7, v4);
        List<Vec3> face3 = List.of(v1, v2, v6, v5);
        List<Vec3> face4 = List.of(v4, v7, v3, v0);
        List<Vec3> face5 = List.of(v3, v7, v6, v2);
        List<Vec3> face6 = List.of(v0, v1, v5, v4);

        PoseStack.Pose entry = matrixStack.last();
        renderPoly(face1, vertexBuilder, entry, packedLight, color);
        renderPoly(face2, vertexBuilder, entry, packedLight, color);
        renderPoly(face3, vertexBuilder, entry, packedLight, color);
        renderPoly(face4, vertexBuilder, entry, packedLight, color);
        renderPoly(face5, vertexBuilder, entry, packedLight, color);
        renderPoly(face6, vertexBuilder, entry, packedLight, color);
    }

    public static void renderPoly(List<Vec3> pos, VertexConsumer vertexBuilder, PoseStack.Pose entry, int packedLight, Color color) {
        Vec3 centerPos = new Vec3(0, 0, 0);
        for (Vec3 coord : pos) {
            centerPos = centerPos.add(coord);
        }
        centerPos = centerPos.multiply(1d / pos.size(), 1d / pos.size(), 1d / pos.size());
        for (Vec3 coord : pos) {
            Vec3 normal = coord.subtract(centerPos);
            vertexBuilder.vertex(entry.pose(), (float) coord.x, (float) coord.y, (float) coord.z)
                    .color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha())
                    .uv(0, 0)
                    .overlayCoords(OverlayTexture.NO_OVERLAY)
                    .uv2(packedLight)
                    .normal(entry.normal(), (float) normal.x, (float) normal.y, (float) normal.z)
                    .endVertex();
        }
    }

    public static void renderPolyTex(List<Vec3> pos, List<Vec2> uvVector, VertexConsumer vertexBuilder, PoseStack.Pose entry, int packedLight) {
        Vec3 centerPos = new Vec3(0, 0, 0);
        for (Vec3 coord : pos) {
            centerPos = centerPos.add(coord);
        }
        centerPos = centerPos.multiply(1d / pos.size(), 1d / pos.size(), 1d / pos.size());
        for (int i = 0; i < pos.size(); i++) {
            Vec3 coord = pos.get(i);
            Vec2 uv = uvVector.get(i);
            Vec3 normal = coord.subtract(centerPos);
            vertexBuilder.vertex(entry.pose(), (float) coord.x, (float) coord.y, (float) coord.z)
                    .color(255, 255, 255, 255)
                    .uv(uv.x, uv.y)
                    .overlayCoords(OverlayTexture.NO_OVERLAY)
                    .uv2(packedLight)
                    .normal(entry.normal(), (float) normal.x, (float) normal.y, (float) normal.z)
                    .endVertex();
        }
    }
}
