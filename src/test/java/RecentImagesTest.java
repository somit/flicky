import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.web.Album;



public class RecentImagesTest {

	ImageManager dbi;
	AlbumManager db;
	//ImageController imageControl;

	@Before
	public void setUpBeforeClass() {
		dbi = new ImageManager();
		db = new AlbumManager();
//		imageControl = new ImageController();
	}

	@Test
	public void testGetPreviousNext() {
		Album album = db.createAlbum("Somit", "description");
		dbi.createImage(album, "1.jpg", "1test description");
		dbi.createImage(album, "2.jpg", "2test description");
		dbi.createImage(album, "3.jpg", "3test description");
		dbi.createImage(album, "4.jpg", "4test description");
		int size = dbi.getRecentImages().size();
	    Assert.assertEquals(size,4);
	    dbi.createImage(album, "5.jpg", "5test description");  
		 size = dbi.getRecentImages().size();
		Assert.assertEquals(size, 4);
	    
	}

}
