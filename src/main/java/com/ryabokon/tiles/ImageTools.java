package com.ryabokon.tiles;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageTools {

	public static BufferedImage getWallImage(Wall wall) {
		return getWallImage(wall.height, wall.width, wall.tiles);
	}

	public static BufferedImage getWallImage(Wall wall, int scale) {
		BufferedImage image = getWallImage(wall.height, wall.width, wall.tiles);
		image = scalingResizeImage(image, wall.height * scale, wall.width * scale);
		return image;
	}

	public static BufferedImage getWallImage(final int height, final int width, String[][] wall) {

		BufferedImage result = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				String tile = wall[y][x];

				Color color;
				switch (tile) {
				case "B":
					color = Color.GRAY;
					break;
				case "T":
					color = new Color(255, 204, 0);
					break;
				case "W":
					color = new Color(51, 153, 255);
					break;
				case "S":
					color = new Color(146, 208, 80);
					break;

				default:
					color = new Color(146, 208, 80);
					break;
				}
				result.setRGB(x, y, color.getRGB());
			}

		}
		return result;
	}

	public static BufferedImage scalingResizeImage(BufferedImage src, int newHeight, int newWidth) {
		final int oldHeight = src.getHeight();
		final int oldWidth = src.getWidth();

		double scaleY = (double) newHeight / oldHeight;
		double scaleX = (double) newWidth / oldWidth;

		BufferedImage dst = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = dst.createGraphics();
		AffineTransform at = AffineTransform.getScaleInstance(scaleX, scaleY);
		g.drawRenderedImage(src, at);

		return dst;
	}

	public static void saveImage(BufferedImage image, String name) throws Throwable {
		String folder = "images/";
		File dateFolderFile = new File(folder);
		if (!dateFolderFile.exists()) {
			dateFolderFile.mkdirs();
		}

		String targetPath = folder + "/" + name + ".png";
		File targetFile = new File(targetPath);
		ImageIO.write(image, "png", targetFile);
	}

	public static void saveImage(BufferedImage image) throws Throwable {
		saveImage(image, Integer.toHexString(image.hashCode()));
	}
}
