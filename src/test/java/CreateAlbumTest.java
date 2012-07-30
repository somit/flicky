import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.web.Album;

public class CreateAlbumTest {

	AlbumManager db;

	@Before
	public void setUp() {

		db = new AlbumManager();

	}

	@Test
	public void tesCreateAlbum() {
        Album album = db.createAlbum("Somit", "description");
        Assert.assertEquals(album,db.getAlbum(album.getUid()));
	}

}
