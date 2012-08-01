import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.model.Album;
import com.hashedin.flicky.model.Image;
import com.hashedin.flicky.web.ImageController;

public class GetPreviousNextImageTest {

	ImageManager dbi;
	AlbumManager db;
	ImageController imageControl;

	@Before
	public void setUpBeforeClass() {
		dbi = new ImageManager();
		db = new AlbumManager();
		imageControl = new ImageController();
	}

	@Test
	public void testGetPreviousNext() {
		Album album = db.createAlbum("Somit", "description");
		Image image1 = dbi.createImage(album, "1.jpg", "1test description");
		 dbi.createImage(album, "12.jpg", "2test description");
		Image image3 = dbi.createImage(album, "1.jpg", "3test description");
		Image imagePrev = imageControl.getPrevious(1, album.getListOfImages());
		Assert.assertEquals(imagePrev, image1);
	    Image imageNext = imageControl.getNext(1, album.getListOfImages());
	    Assert.assertEquals(imageNext, image3);
	}

}
