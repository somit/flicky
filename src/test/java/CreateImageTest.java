
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hashedin.flicky.hibernate.HibernateDao;
import com.hashedin.flicky.hibernate.IDataAccessObject;
import com.hashedin.flicky.manager.AlbumManager;
import com.hashedin.flicky.manager.ImageManager;
import com.hashedin.flicky.model.Album;
import com.hashedin.flicky.model.Image;


public class CreateImageTest {
	
	ImageManager dbi;
	AlbumManager db;
	IDataAccessObject dao;

	@Before
	public void setUp() throws Exception {
			dbi = new ImageManager();
			db = new AlbumManager();
			dao = new HibernateDao();
	}

	@Test
	public void testCreateImage() {

        Album album = db.createAlbum("Leh", "description");
        dao.saveOrUpdate(album);
        dao.flush();
        Image image = dbi.createImage(album, "1.jpg", "test description");
        dao.saveOrUpdate(image);
        dao.flush();
        Assert.assertEquals(image,dbi.getImage(image.getId()));
        dao.delete(image);
        dao.delete(album);
        dao.flush();
	}

}
