package mods.eln.node.six;

import mods.eln.misc.Direction;
import mods.eln.misc.UtilsClient;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.lwjgl.opengl.GL11;

public class SixNodeRender extends TileEntitySpecialRenderer {

    @Override
    public void renderTileEntityAt(TileEntity entity, double x, double y,
                                   double z, float var8, int stage) {
        Minecraft.getMinecraft().mcProfiler.startSection("SixNode");

        SixNodeEntity tileEntity = (SixNodeEntity) entity;


        GL11.glPushMatrix();
        GL11.glTranslatef((float) x + .5F, (float) y + .5F, (float) z + .5F);
        /*if(tileEntity.sixNodeCacheMapId >= 0)
		{
			if(SixNodeCacheItem.map[tileEntity.sixNodeCacheMapId] != null)
			{
				UtilsClient.glDefaultColor();
				SixNodeCacheItem.map[tileEntity.sixNodeCacheMapId].draw(entity.getWorld(),entity.xCoord,entity.yCoord,entity.zCoord);
			}
		}*/

        int idx = 0;
        for (SixNodeElementRender render : tileEntity.elementRenderList) {
            if (render != null) {
                UtilsClient.glDefaultColor();
                GL11.glPushMatrix();
                Direction.fromInt(idx).glRotateXnRef();
                GL11.glTranslatef(-0.5F, 0f, 0f);
                render.draw();
                GL11.glPopMatrix();
            }
            idx++;
        }
        GL11.glPopMatrix();
        //Utils.glDefaultColor();
        Minecraft.getMinecraft().mcProfiler.endSection();

    }


}
