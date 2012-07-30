
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.web.Album;
import com.hashedin.flicky.web.Image;


public class CreateImageTest {
	
	ImageManager dbi;
	AlbumManager db;

	@Before
	public void setUp() throws Exception {
			dbi = new ImageManager();
			db = new AlbumManager();
	}

	@Test
	public void testCreateImage() {

        Album album = db.createAlbum("Leh", "description");
        Image image = dbi.createImage(album, "1.jpg", "test description");
        Assert.assertEquals(image,dbi.getImage(image.getId()));
	}

}
