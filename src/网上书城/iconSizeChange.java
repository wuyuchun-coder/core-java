package 网上书城;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



    
// TODO: Auto-generated Javadoc
/**
 * The Class iconSizeChange.
 *
 * @author wuyuchun
 * @version  v1.0
 * @date 2020年7月3日
 */
public class iconSizeChange {
		
		/**
		 * Size change.
		 *
		 * @param filePath the file path
		 * @param length the length
		 * @param width the width
		 * @return the image icon
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public ImageIcon sizeChange(String filePath,int length,int width) throws IOException {
			
				Image inputImage=ImageIO.read(new File(filePath));
				BufferedImage image=new BufferedImage(length,width,BufferedImage.TYPE_3BYTE_BGR);
				image.getGraphics().drawImage(inputImage,0,0,length,width,null);
				Image realImage=image;
				ImageIcon img=new ImageIcon(realImage);
				return img;
		}
}
